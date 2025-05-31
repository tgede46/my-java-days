package ma.enset.service.reponse;

public enum StatusResponse {
    SUCCESS("Success"),
    ERROR("Error");

    private final String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
