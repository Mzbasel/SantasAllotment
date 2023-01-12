import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RandomAllocatorTest {

    private RandomAllocator randomAllocator;


    @BeforeEach
    public void setUp(){
        randomAllocator = new RandomAllocator();
    }

    public static Stream<Arguments> listOfNotExpectedAllocationsHorizontal() {
        return Stream.of(
                Arguments.of(List.of(0,0,0)),
                Arguments.of(List.of(0,1,0)),
                Arguments.of(List.of(0,2,0)),
                Arguments.of(List.of(0,0,1))
        );
    }


    @ParameterizedTest
    @MethodSource("listOfNotExpectedAllocationsHorizontal")
    public void should_not_allocate_trees_in_the_same_horizontal_line(List<Integer> notExpectedAllocation){
        int size = 3;

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertFalse(notExpectedAllocation.equals(actualAllocation));
    }

    public static Stream<Arguments> listOfNotExpectedAllocationsDiagonalLeftToRight() {
        return Stream.of(
                Arguments.of(List.of(0,1,2,3)),
                Arguments.of(List.of(0,1,3,2)),
                Arguments.of(List.of(0,2,3,1)),
                Arguments.of(List.of(2,1,3,0))
        );
    }


    @ParameterizedTest
    @MethodSource("listOfNotExpectedAllocationsDiagonalLeftToRight")
    public void should_not_allocate_trees_diagonally_left_to_right(List<Integer> notExpectedAllocation){
        int size = 4;

        List<Integer> actualAllocation = randomAllocator.generate(size);

        assertFalse(notExpectedAllocation.equals(actualAllocation));
    }

}