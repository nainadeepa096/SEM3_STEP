public class UserProfile {
    private final String username;
    private String email;
    private String statusMessage;

    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
        this.statusMessage = "Available";
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    public void setStatusMessage(String statusMessage) {
        if (statusMessage != null && statusMessage.length() <= 100) {
            this.statusMessage = statusMessage;
        }
    }
}