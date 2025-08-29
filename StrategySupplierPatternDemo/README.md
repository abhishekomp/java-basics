
# Java Lambda Deferred Strategy Pattern Example

This project demonstrates a powerful, modern Java pattern for passing custom operations (strategies) as lambdas using functional interfaces (like `Supplier<T>`)—replacing boilerplate interface coding and enabling highly reusable, declarative workflows.

## 🏆 What Does This Example Show?

- **Deferred execution**: The operation (lambda) is not executed until the workflow needs it.
- **Modern Strategy pattern**: You inject differing behaviors for registration (or any workflow) by just swapping lambdas.
- **Clear, illustrative usage** that’s directly analogous to enterprise Cucumber/test fixture or web-service orchestration.

> **Use-case:** This mirrors how Cucumber step-definitions or service layers often let you “inject” *What to do*, and the utility method orchestrates *How and When*.

## 💡 Preview Example

```java
RegistrationUtil.registerUser("alice", () -> {
    System.out.println("Calling real registration API for Alice...");
    return new User("id-alice", "REGULAR");
});
```

- The injected lambda can do anything—call an API, run a DB script, or just fake it!

## 🚀 How to Run

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourgithubname/java-lambda-deferred-strategy.git
    cd java-lambda-deferred-strategy
    ```

2. **Compile and run using the command line:**
    ```sh
    javac -d out src/main/java/com/example/strategypattern/*.java
    java -cp out com.example.strategypattern.Main
    ```

   Or, **import the project in IntelliJ**, right-click `Main.java`, and choose Run.

## 🧩 Project Structure

```
src/main/java/com/example/strategypattern/
├── Main.java                # Entry point: demo of strategies
├── RegistrationUtil.java    # Deferred execution/workflow-harness
└── User.java                # Simple POJO for demo user data
README.md
```

## 👨‍💻 Code Features

### **1. RegistrationUtil.java**
A helper that coordinates before/after logic for user registration, executing your injection (lambda strategy) only at the right time.

```java
public static User registerUser(String username, Supplier<User> registrationOperation) {
    // ...shared logic...
    User user = registrationOperation.get(); // Deferred: run the custom registration
    // ...more shared logic...
    return user;
}
```

### **2. Main.java**
Shows three ways to use the utility:
- Passes different registration flows as lambdas (Regular, Admin, Custom)
- Prints results and summarises all created users

## 🤔 Why Use This Pattern?

- **Decouples orchestration** from what actually happens (API, DB, fake, etc.)
- **Great for tests**, demos, and web/service routing.
- **Easily pluggable/customizable**—just swap your lambda for a new behavior!
- **Cleaner and less boilerplate** than classic interface subclassing.

## ⚡ How Does This Relate to the Strategy Pattern?

In classic Java:

```java
interface RegistrationStrategy { User register(); }
class AdminStrategy implements RegistrationStrategy { ... }
```

In modern Java:

```java
Supplier<User> adminStrategy = () -> { ... };
```

You **pass the appropriate lambda strategy** as needed, directly.

## 📚 Further Reading

- [Java 8 Lambdas (Oracle Tutorial)](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Strategy pattern (Wikipedia)](https://en.wikipedia.org/wiki/Strategy_pattern)
- [Supplier Functional Interface (JavaDoc)](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/Supplier.html)

## 📦 Output Example

Running the demo prints:

```
==== Starting registration process for user: alice
>> Performing REGULAR user registration logic (could call API/db here)
User registered with ID: id-alice and role: REGULAR
==== Finished registration process for user: alice

==== Starting registration process for user: bob
>> Performing ADMIN user registration logic (different API/db call)
User registered with ID: id-bob and role: ADMIN
==== Finished registration process for user: bob

==== Starting registration process for user: eve
>> Performing registration for role: CUSTOM_ROLE
User registered with ID: id-custom_role and role: CUSTOM_ROLE
==== Finished registration process for user: eve

Summary:
User: id-alice Role: REGULAR
User: id-bob Role: ADMIN
User: id-custom_role Role: CUSTOM_ROLE
```

## 🛠️ Extend or Contribute

- Fork this repo to play with new strategies or workflows.
- Try swapping the `Supplier` for `Runnable`, `Consumer<T>`, or `Function<T,R>` for other functional patterns.

---