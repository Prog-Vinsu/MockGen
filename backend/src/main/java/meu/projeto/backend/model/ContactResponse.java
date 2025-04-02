package meu.projeto.backend.model;

public class ContactResponse {
    private boolean success;
    private String message;

    // Constructor
    public ContactResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
