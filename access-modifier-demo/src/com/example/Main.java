import com.example.base.SamePackageClass;
import com.example.other.SubClass;
import com.example.other.OtherPackageClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("From same package:");
        new SamePackageClass().test();

        System.out.println("\nFrom subclass in other package:");
        new SubClass().test();

        System.out.println("\nFrom other class in other package:");
        new OtherPackageClass().test();
    }
}