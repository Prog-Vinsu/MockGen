export const formatData = (data, format, schema) => {
    switch (format) {
      case 'json':
        return formatAsJson(data);
      case 'csv':
        return formatAsCsv(data);
      case 'xml':
        return formatAsXml(data);
      case 'sql':
        return formatAsSql(data, schema);
      default:
        return JSON.stringify(data, null, 2);
    }
  };
  
  const formatAsJson = (data) => {
    return JSON.stringify(data, null, 2);
  };
  
  const formatAsCsv = (data) => {
    if (!Array.isArray(data)) return '';
    
    if (data.length === 0) return '';
    
    // Get headers
    const headers = Object.keys(data[0]);
    
    // Create CSV content
    let csv = headers.join(',') + '\n';
    
    data.forEach(item => {
      const row = headers.map(header => {
        let value = item[header];
        if (Array.isArray(value)) {
          value = value.join('; ');
        }
        // Escape quotes and wrap in quotes if contains comma
        value = String(value).replace(/"/g, '""');
        if (String(value).includes(',')) {
          value = `"${value}"`;
        }
        return value;
      });
      csv += row.join(',') + '\n';
    });
    
    return csv;
  };
  
  const formatAsXml = (data) => {
    if (Array.isArray(data)) {
      let xml = '<items>\n';
      data.forEach(item => {
        xml += '  <item>\n';
        Object.entries(item).forEach(([key, value]) => {
          xml += `    <${key}>${escapeXml(String(value))}</${key}>\n`;
        });
        xml += '  </item>\n';
      });
      xml += '</items>';
      return xml;
    }
    
    // Single object
    let xml = '<item>\n';
    Object.entries(data).forEach(([key, value]) => {
      xml += `  <${key}>${escapeXml(String(value))}</${key}>\n`;
    });
    xml += '</item>';
    return xml;
  };
  
  const escapeXml = (unsafe) => {
    return unsafe.replace(/[<>&'"]/g, (c) => {
      switch (c) {
        case '<': return '&lt;';
        case '>': return '&gt;';
        case '&': return '&amp;';
        case '\'': return '&apos;';
        case '"': return '&quot;';
        default: return c;
      }
    });
  };
  
  const formatAsSql = (data, schema) => {
    if (!Array.isArray(data) || data.length === 0) return '';
    
    const tableName = 'mock_data';
    const columns = Object.keys(data[0]);
    
    // Mapeamento de tipos do gerador para tipos SQL (atualizado)
    const typeMapping = {
      'text': 'TEXT',
      'number': 'NUMERIC',
      'date': 'DATE',
      'datetime': 'TIMESTAMP',
      'cpf': 'CHAR(11)',
      'cnpj': 'CHAR(14)',
      'cep': 'CHAR(8)',
      'name': 'VARCHAR(100)',
      'uuid': 'UUID',
      'email': 'VARCHAR(100)',
      'address': 'VARCHAR(200)',
      'phone': 'VARCHAR(20)',
      'color': 'VARCHAR(30)',
      'url': 'VARCHAR(255)'
    };
  
    // Gerar CREATE TABLE
    let sql = `-- SQL CREATE TABLE statement\n`;
    sql += `CREATE TABLE IF NOT EXISTS ${tableName} (\n`;
    sql += `  id SERIAL PRIMARY KEY,\n`;
    
    columns.forEach((col, index) => {
      // Obtém o tipo do schema ou usa TEXT como padrão
      const attributeType = schema[col]?.type || 'text';
      const sqlType = typeMapping[attributeType] || 'TEXT';
      
      // Trata casos especiais como colunas com espaços
      const columnName = col.includes(' ') ? `"${col}"` : col;
      
      sql += `  ${columnName} ${sqlType}`;
      sql += index < columns.length - 1 ? ',\n' : '\n';
    });
    
    sql += `);\n\n`;
    
    // Gerar INSERT statements
    sql += `-- SQL INSERT statements\n`;
    const columnNames = columns.map(col => col.includes(' ') ? `"${col}"` : col);
    sql += `INSERT INTO ${tableName} (${columnNames.join(', ')}) VALUES\n`;
    
    data.forEach((item, index) => {
      const values = columns.map(col => {
        const value = item[col];
        if (value === null || value === undefined) return 'NULL';
        if (typeof value === 'number') return value;
        
        // Formatação especial para alguns tipos
        const attributeType = schema[col]?.type;
        if (attributeType === 'date' || attributeType === 'datetime') {
          return `'${value}'::${typeMapping[attributeType]}`;
        }
        if (attributeType === 'cpf' || attributeType === 'cnpj' || attributeType === 'cep') {
          return `'${String(value).replace(/\D/g, '')}'`; // Remove não-dígitos
        }
        
        return `'${String(value).replace(/'/g, "''")}'`;
      });
      
      sql += `  (${values.join(', ')})`;
      sql += index < data.length - 1 ? ',\n' : ';\n';
    });
    
    return sql;
  };