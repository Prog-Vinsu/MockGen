
# MockGen - Gerador de Dados Mockados em JSON

O MockGen é uma ferramenta poderosa para geração de dados fictícios em formato JSON, perfeita para desenvolvimento, testes e prototipação.

## ✨ Recursos Principais

- ✅ Geração de documentos brasileiros válidos (CPF, CNPJ, CEP)
- 🌍 Suporte a múltiplos países (Brasil, EUA, França, Alemanha, Itália)
- 🛠 15+ tipos de dados diferentes (UUID, cores, URLs, datas, etc.)
- 🔄 Interface intuitiva com pré-visualização em tempo real
- 📋 Copiar JSON com um único clique

## 🚀 Como Usar

### Executando Localmente

#### Frontend (Vue.js)
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/mockgen.git
```

2. Instale as dependências:
```bash
cd mockgen/frontend
npm install
```

3. Inicie o servidor de desenvolvimento:
```bash
npm run dev
```

4. Acesse no navegador:
```
http://localhost:3000
```

#### Backend (Spring Boot)
1. Certifique-se de ter instalado:
   - Java JDK 17+
   - Maven 3.8+
   - Banco de dados (opcional, se estiver usando persistência)

2. Configure o backend:
```bash
cd mockgen/backend
```

3. Edite o arquivo `application.properties` conforme necessário:
```properties
# Exemplo de configuração básica
server.port=8080
spring.application.name=mockgen-api
```

4. Execute a aplicação:
```bash
mvn spring-boot:run
```

5. O servidor estará disponível em:
```
http://localhost:8080
```

6. Para construir o pacote:
```bash
mvn clean package
```

7. Para executar o JAR gerado:
```bash
java -jar target/mockgen-api-1.0.0.jar
```

## 🛠 Tecnologias Utilizadas

### Frontend
- Vue 3
- Tailwind CSS
- Axios (para comunicação com a API)

### Backend
- Spring Boot 3.x
- Java Faker (para geração de dados)
- Lombok (para redução de boilerplate)
- Spring Web (para endpoints REST)

## 📚 Documentação da API

A API do MockGen oferece os seguintes endpoints:

### POST /api/mock
Gera dados mockados conforme o schema fornecido

**Request Body:**
```json
{
  "quantityJson": 1,
  "attributes": {
    "nome": {
      "type": "name",
      "region": "pt-BR"
    },
    "cpf": {
      "type": "cpf"
    }
  }
}
```

**Response:**
```json
[
  {
    "nome": "João Silva",
    "cpf": "123.456.789-09"
  }
]
```



## 🤝 Como Contribuir

Contribuições são bem-vindas! Siga estes passos:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/incrivel`)
3. Commit suas mudanças (`git commit -m 'Adiciona feature incrível'`)
4. Push para a branch (`git push origin feature/incrivel`)
5. Abra um Pull Request

## 📬 Contato

- Desenvolvedor: [Vincenzo Tognere Polonini](https://github.com/Prog-Vinsu)
- Email: tognerepoloniniv@gmail.com
- LinkedIn: [Vincenzo Tognere Polonini](https://www.linkedin.com/in/vincenzo-tognere-polonini/)

