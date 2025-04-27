import org.example.CompareLists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CompareListsTest {

    @Test
    void testAddOperation() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int iterations = 1000;

        CompareLists.testAdd(arrayList, iterations);
        CompareLists.testAdd(linkedList, iterations);

        assertEquals(iterations, arrayList.size());
        assertEquals(iterations, linkedList.size());
    }

    @Test
    void testDeleteOperation() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int iterations = 1000;

        CompareLists.testAdd(arrayList, iterations);
        CompareLists.testAdd(linkedList, iterations);

        CompareLists.testDelete(arrayList, iterations);
        CompareLists.testDelete(linkedList, iterations);

        assertEquals(0, arrayList.size());
        assertEquals(0, linkedList.size());
    }
}
