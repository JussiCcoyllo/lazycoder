package com.example.exceptions;

import com.example.models.entities.*;
import java.util.Arrays;

public class ShareException extends RuntimeException {

    public ShareException(String message) {
        super(message);
    }

    public ShareException notFound() {
        return new ShareException("Share not found");
    }

    public ShareException alreadyExists() {
        return new ShareException("Share already exists");
    }

    public ShareException requiredFields(String... fields) {
        return new ShareException("Required fields: " + Arrays.toString(fields));
    }

    public ShareException nullShareException() {
        return new ShareException("Share cannot be null");
    }

}
