package meu.projeto.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meu.projeto.backend.model.ContactRequest;
import meu.projeto.backend.model.ContactResponse;
import meu.projeto.backend.services.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ContactResponse sendContactMessage(@RequestBody ContactRequest request) {
        return contactService.processContactRequest(request);
    }
}
