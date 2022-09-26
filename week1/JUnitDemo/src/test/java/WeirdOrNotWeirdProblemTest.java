import com.revature.WeirdOrNotWeirdProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeirdOrNotWeirdProblemTest {

    public WeirdOrNotWeirdProblem obj;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating object...");
        obj = new WeirdOrNotWeirdProblem();
    }

    @Test
    public void test1() {
        // AAA
        // Arrange: set up any objects required
//        WeirdOrNotWeirdProblem obj = new WeirdOrNotWeirdProblem();

        // Act: execute the method you are testing
        String actual = obj.weirdOrNotWeird(10);

        // Assert: check whether the actual result is equal to the expected result
        String expected = "Weird";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // AAA

        // Arrange
//        WeirdOrNotWeirdProblem obj = new WeirdOrNotWeirdProblem();

        // Act
        String actual = obj.weirdOrNotWeird(22);

        // Assert
        String expected = "Not Weird";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        // AAA

        // Arrange
//        WeirdOrNotWeirdProblem obj = new WeirdOrNotWeirdProblem();

        // Act
        String actual = obj.weirdOrNotWeird(5);

        // Assert
        String expected = "Weird";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        // AAA

        // Arrange
//        WeirdOrNotWeirdProblem obj = new WeirdOrNotWeirdProblem();

        // Act
        String actual = obj.weirdOrNotWeird(2);

        // Assert
        String expected = "Not Weird";
        Assertions.assertEquals(expected, actual);
    }

}
