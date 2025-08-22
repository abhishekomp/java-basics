package com.example.other;

import com.example.base.BaseClass;

public class OtherPackageClass {
    public void test() {
        BaseClass base = new BaseClass();

        // base.privateMethod();     // ❌ Not allowed: private
        // base.protectedMethod();   // ❌ Not allowed: protected (cannot access on BaseClass instance outside package)
        // base.packagePrivateMethod(); // ❌ Not allowed: package-private, different package
        base.publicMethod();        // ✅ Allowed: public
    }
}