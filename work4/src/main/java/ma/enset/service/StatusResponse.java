package ma.enset.service;

public enum StatusResponse {
    SUCCESS ("Success"),
    ERROR ("Error");

    private String status;
    // constructors, getters
    StatusResponse(String status) {}

    public String getStatus() {
        return status;
    }
}