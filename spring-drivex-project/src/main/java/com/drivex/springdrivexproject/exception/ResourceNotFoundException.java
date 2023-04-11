// Package
package com.drivex.springdrivexproject.exception;

// Class
public class ResourceNotFoundException extends RuntimeException {
    // Methods
        // Exceptions with message
    public ResourceNotFoundException() {super("The resource was not found");}
        // Exception without message
    public ResourceNotFoundException(String message) {super(message);}
}
