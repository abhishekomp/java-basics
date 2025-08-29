package com.example.strategy;

import java.util.function.Supplier;

/**
 * Utility class demonstrating the deferred execution / lambda Strategy pattern.
 */
public class RegistrationUtil {

    /**
     * Registers a user using a strategy (deferred operation) provided as a lambda/Supplier.
     *
     * @param username              The user name, used for logging/example.
     * @param registrationOperation Lambda (Supplier) defining how to perform registration.
     * @return The registered User object.
     */
    public static User registerUser(String username, Supplier<User> registrationOperation) {
        // Common logic before registration
        System.out.println("==== Starting registration process for " + username);

        User user = null;

        // Only register if not already present (simulate for this example)
        boolean userExists = false; // Normally: lookup in DB
        if (!userExists) {
            // DO the registration now!
            // This is the "injected" strategy logic AND is executed only if needed
            // This is where the lambda gets executed, in this case it is the Supplier's get() method
            // The actual registration logic is deferred until this point.
            user = registrationOperation.get();
            System.out.println("User registered with ID: " + user.id);
        } else {
            System.out.println("User already exists.");
            // Fetch user from store...
        }

        // Common logic after registration
        System.out.println("==== Finished registration process for " + username);

        return user;
    }
}