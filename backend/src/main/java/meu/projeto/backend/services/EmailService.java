package meu.projeto.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import meu.projeto.backend.model.ContactRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Year;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${app.contact.email}")
    private String toEmail;

    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendContactEmail(ContactRequest request) {
        try {
            jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            
            // Configurações básicas do e-mail
            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject("Novo contato via MockGen: " + request.getSubject());
            
            // Processa o template Thymeleaf
            String emailContent = processTemplate(request);
            helper.setText(emailContent, true); // true = isHTML
            
            mailSender.send(mimeMessage);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException("Falha ao enviar e-mail", e);
        }
    }

    private String processTemplate(ContactRequest request) {
        Context context = new Context();
        
        // Adiciona variáveis ao contexto
        context.setVariable("name", request.getName());
        context.setVariable("email", request.getEmail());
        context.setVariable("subject", request.getSubject());
        context.setVariable("message", request.getMessage());
        context.setVariable("timestamp", 
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        context.setVariable("year", Year.now().getValue());
        
        // Processa o template (contact-email.html deve estar em resources/templates)
        return templateEngine.process("contact-email", context);
    }
}