//package RetryFailedTests;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
//import com.sun.net.httpserver.Authenticator;
//import org.testng.IAnnotationTransformer;
//import org.testng.annotations.ITestAnnotation;
//
//public class Annotation implements IAnnotationTransformer {
//    @Override
//    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        annotation.setRetryAnalyzer(Retry.class);
//    }
//}