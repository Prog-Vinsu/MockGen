package meu.projeto.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import meu.projeto.backend.utils.CEPGenerator;
import meu.projeto.backend.utils.CNPJGenerator;
import meu.projeto.backend.utils.CPFGenerator;

import java.time.ZoneId;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://mock-gen-frontend.vercel.app/")
public class MockController {

    @PostMapping("/mock")
    public List<Map<String, Object>> generateMockData(@RequestBody Map<String, Object> request) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        int quantityJson = 1;
        try {
            if (request.containsKey("quantityJson")) {
                Object qtyObj = request.get("quantityJson");
                if (qtyObj instanceof Number) {
                    quantityJson = ((Number) qtyObj).intValue();
                } else {
                    quantityJson = Integer.parseInt(qtyObj.toString());
                }

                quantityJson = Math.min(100, Math.max(1, quantityJson));
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar quantityJson, usando valor padrão 1");
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> attributes = (Map<String, Object>) request.get("attributes");

        if (attributes == null || attributes.isEmpty()) {
            return resultList;
        }
        
        for (int i = 0; i < quantityJson; i++) {
            Map<String, Object> singleResult = new HashMap<>();

            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (!(value instanceof Map)) {
                    singleResult.put(key, "Formato inválido para o atributo");
                    continue;
                }

                @SuppressWarnings("unchecked")
                Map<String, Object> attributeData = (Map<String, Object>) value;
                String valueType = (String) attributeData.get("type");

                String region = (String) attributeData.get("region");
                if (region == null || region.isEmpty()) {
                    region = "pt-BR";
                }

                String country = region.split("-")[1];

                int quantity = 1;
                if (attributeData.containsKey("quantity")) {
                    Object quantityObj = attributeData.get("quantity");
                    if (quantityObj instanceof Integer) {
                        quantity = (Integer) quantityObj;
                    } else if (quantityObj instanceof String) {
                        try {
                            quantity = Integer.parseInt(quantityObj.toString());
                        } catch (NumberFormatException e) {
                        }
                    } else if (quantityObj instanceof Double) {
                        quantity = ((Double) quantityObj).intValue();
                    }
                }

                Locale locale = Locale.forLanguageTag(region);
                Faker faker = new Faker(locale);

                if (quantity <= 1) {
                    singleResult.put(key, generateValueByType(valueType, faker, country));
                } else {
                    List<Object> values = new ArrayList<>();
                    for (int j = 0; j < quantity; j++) {
                        values.add(generateValueByType(valueType, faker, country));
                    }
                    singleResult.put(key, values);
                }
            }

            resultList.add(singleResult);
        }

        return resultList;
    }

    private Object generateValueByType(String valueType, Faker faker, String country) {
        switch (valueType.toLowerCase()) {
            case "name":
                return faker.name().fullName();
            case "email":
                return faker.internet().emailAddress();
            case "number":
                return faker.number().numberBetween(18, 80);
            case "date":
                return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                        .toString();
            case "address":
                return faker.address().fullAddress();
            case "phone":
                return faker.phoneNumber().phoneNumber();
            case "text":
                return faker.lorem().paragraph(1);
            case "cpf":
                if (country.equals("BR")) {
                    return CPFGenerator.generateCPF();
                } else {
                    return faker.idNumber().valid();
                }
            case "cnpj":
                if (country.equals("BR")) {
                    return CNPJGenerator.generateCNPJ();
                } else if (country.equals("US")) {
                    return faker.regexify("[0-9]{2}-[0-9]{7}");
                } else if (country.equals("FR")) {
                    return faker.regexify("[0-9]{14}");
                } else if (country.equals("DE")) {
                    return faker.regexify("[0-9]{11}");
                } else if (country.equals("IT")) {
                    return faker.regexify("[0-9]{11}");
                } else {
                    return faker.regexify("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}");
                }
            case "cep":
                if (country.equals("BR")) {
                    return CEPGenerator.generateCEP();
                } else if (country.equals("US")) {
                    return faker.regexify("[0-9]{5}-[0-9]{4}");
                } else if (country.equals("FR")) {
                    return faker.regexify("[0-9]{5}");
                } else if (country.equals("DE")) {
                    return faker.regexify("[0-9]{5}");
                } else if (country.equals("IT")) {
                    return faker.regexify("[0-9]{5}");
                } else {
                    return faker.address().zipCode();
                }
            case "uuid":
                return faker.internet().uuid();
            case "url":
                return faker.internet().url();
            case "color":
                return faker.color().name();
            case "datetime":
                return faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDateTime().toString();
            default:
                return "Tipo " + valueType + " não suportado";
        }
    }
}