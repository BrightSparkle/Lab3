import org.example.CompareLists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CompareListsTest {

    @Test
    void testAddOperation() {
        // Arrange
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int iterations = 1000;

        // Act
        CompareLists.testAdd(arrayList, iterations);
        CompareLists.testAdd(linkedList, iterations);

        // Assert
        assertEquals(iterations, arrayList.size());
        assertEquals(iterations, linkedList.size());
    }


}
