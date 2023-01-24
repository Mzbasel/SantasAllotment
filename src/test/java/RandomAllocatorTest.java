import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RandomAllocatorTest {

    private RandomAllocator randomAllocator;
    private List<Integer> notExpectedAllocation, actualAllocation, expectedAllocation;

    @BeforeEach
    public void setUp() {
        randomAllocator = new TestableRandomAllocator();
        notExpectedAllocation = new ArrayList<>();
        actualAllocation = new ArrayList<>();
        expectedAllocation = new ArrayList<>();
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_0_1_2_3() {
        notExpectedAllocation = List.of(0, 1, 2, 3);

        actualAllocation = randomAllocator.generate(4);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_0_1_3_2() {
        notExpectedAllocation = List.of(0, 1, 3, 2);

        actualAllocation = randomAllocator.generate(4);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }


    @Test
    void should_allocate_trees_in_a_size_4_square() {
        expectedAllocation = List.of(0,3,1,2);

        actualAllocation = randomAllocator.generate(4);

        assertEquals(expectedAllocation, actualAllocation);
    }
}