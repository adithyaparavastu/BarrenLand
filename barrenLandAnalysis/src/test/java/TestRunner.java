/**
 * Created by adithya_paravastu on 1/12/18.
 */
import org.junit.runner.JUnitCore;
        import org.junit.runner.Result;
        import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(Junit.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("Tests failed. " + failure.toString());
        }

        System.out.println("Tests were successful! " + result.wasSuccessful());
    }

}