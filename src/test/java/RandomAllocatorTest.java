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
    private List<Integer> notExpectedAllocation;

    @BeforeEach
    public void setUp(){
        randomAllocator = new RandomAllocator();
        notExpectedAllocation = new ArrayList<>();
    }

   @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_0_0_0(){
        int size = 3;
        notExpectedAllocation = List.of(0,0,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

       assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_0_1_0(){
        int size = 3;
        notExpectedAllocation = List.of(0,1,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_0_2_0(){
        int size = 3;
        notExpectedAllocation = List.of(0,2,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_0_0_1(){
        int size = 3;
        notExpectedAllocation = List.of(0,0,1);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_1_0_0(){
        int size = 3;
        notExpectedAllocation = List.of(1,0,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_in_the_same_horizontal_line_2_0_0(){
        int size = 3;
        notExpectedAllocation = List.of(2,0,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_0_1_2_3(){
        int size = 4;
        notExpectedAllocation = List.of(0,1,2,3);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_0_1_3_2(){
        int size = 4;
        notExpectedAllocation = List.of(0,1,3,2);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_0_2_3_1(){
        int size = 4;
        notExpectedAllocation = List.of(0,2,3,1);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

    @Test
    public void should_not_allocate_trees_diagonally_left_to_right_2_1_3_0(){
        int size = 4;
        notExpectedAllocation = List.of(2,1,3,0);

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertNotEquals(notExpectedAllocation, actualAllocation);
    }

}