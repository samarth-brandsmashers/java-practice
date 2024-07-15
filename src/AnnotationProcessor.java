import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Processing the custom annotation
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
}

// Using the custom annotation
class MyClass {
    @MyAnnotation(value = "example")
    public void annotatedMethod() {
        System.out.println("This method is annotated with @MyAnnotation");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        MyClass obj = new MyClass();
        Method method = obj.getClass().getMethod("annotatedMethod");

        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation value: " + annotation.value());
            obj.annotatedMethod();
        }
    }
}
