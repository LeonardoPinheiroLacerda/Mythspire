package br.com.leonardo.service.loader;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourcePath) {
        super(String.format("Resource on %s not found.", resourcePath));
    }

    public ResourceNotFoundException(String resourcePath, Throwable cause) {
        super(String.format("Resource on %s not found.", resourcePath), cause);
    }
}
