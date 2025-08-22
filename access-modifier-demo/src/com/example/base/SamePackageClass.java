package com.example.base;

public class SamePackageClass {
    public void test() {
        BaseClass base = new BaseClass();

        // base.privateMethod(); // ❌ Not allowed: private
        base.protectedMethod();     // ✅ Allowed: protected, same package
        base.packagePrivateMethod(); // ✅ Allowed: package-private, same package
        base.publicMethod();        // ✅ Allowed: public
    }
}