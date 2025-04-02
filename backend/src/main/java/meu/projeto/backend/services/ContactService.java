package meu.projeto.backend.services;

import org.springframework.stereotype.Service;

import meu.projeto.backend.model.ContactRequest;
import meu.projeto.backend.model.ContactResponse;

@Service
public class ContactService {
    private final EmailService emailService;

    public ContactService(EmailService emailService) {
        this.emailService = emailService;
    }

    public ContactResponse processContactRequest(ContactRequest request) {
        try {
            emailService.sendContactEmail(request);
            return new ContactResponse(true, "Mensagem enviada com sucesso!");
        } catch (Exception e) {
            return new ContactResponse(false, "Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
