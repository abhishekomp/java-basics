package com.example.base;

// This is the parent class exposing methods with different access modifiers
public class BaseClass {

    private void privateMethod() {
        System.out.println("privateMethod: Only BaseClass can access this.");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod: Accessible in BaseClass, subclasses, and same package.");
    }

    void packagePrivateMethod() { // no modifier means package-private
        System.out.println("packagePrivateMethod: Accessible in same package only.");
    }

    public void publicMethod() {
        System.out.println("publicMethod: Accessible anywhere.");
    }

    public void tryAll() {
        // Can call all its own methods
        privateMethod();
        protectedMethod();
        packagePrivateMethod();
        publicMethod();
    }
}