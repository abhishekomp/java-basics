package com.example.other;

import com.example.base.BaseClass;

public class SubClass extends BaseClass {
    public void test() {
        // privateMethod();       // ❌ Not allowed: private
        protectedMethod();         // ✅ Allowed: protected, via inheritance
        // packagePrivateMethod(); // ❌ Not allowed: package-private, different package
        publicMethod();            // ✅ Allowed: public
    }
}