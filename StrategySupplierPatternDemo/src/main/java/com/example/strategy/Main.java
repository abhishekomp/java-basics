package com.example.strategy;

import java.util.function.Supplier;

/**
 * Demo for the deferred execution / lambda Strategy pattern.
 */
public class Main {
    public static void main(String[] args) {
        // DEMO: Register a REGULAR user by passing custom strategy via lambda
        User alice = RegistrationUtil.registerUser("alice", () -> {
            System.out.println(">> Performing REGULAR user registration logic (could call API/db here)");
            return new User("id-alice", "REGULAR");
        });

        // DEMO: Register an ADMIN user, using a different injected logic
        User bob = RegistrationUtil.registerUser("bob", () -> {
            System.out.println(">> Performing ADMIN user registration logic (different API/db call)");
            return new User("id-bob", "ADMIN");
        });

        // DEMO: Register a user with special custom logic
        User custom = RegistrationUtil.registerUser("eve", customUserStrategy("CUSTOM_ROLE"));

        // (Showcase all users created in the demo)
        System.out.println("Summary:");
        System.out.println("User: " + alice.id + " Role: " + alice.role);
        System.out.println("User: " + bob.id + " Role: " + bob.role);
        System.out.println("User: " + custom.id + " Role: " + custom.role);
    }

    /**
     * Example of returning a Supplier (lambda) from a method—for parameterized strategies.
     */
    private static Supplier<User> customUserStrategy(String role) {
        return () -> {
            System.out.println(">> Performing registration for role: " + role);
            return new User("id-" + role.toLowerCase(), role);
        };
    }
}