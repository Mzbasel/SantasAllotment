import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SquareTest {

    private Square square;
    @Mock
    private RandomAllocator randomAllocator;
    private String[][] actualSquare, expectedSquare;

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    public void should_return_an_empty_array_when_the_size_is_between_zero_and_two(int size){
        square = new Square(size, randomAllocator);
        expectedSquare = new String[][] {};

        actualSquare = square.plant();

        assertEquals(expectedSquare.length, actualSquare.length);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,-17,-3})
    public void should_throw_invalid_size_exception_when_the_size_is_less_than_zero(int size){
        assertThrows(InvalidSize.class, () -> new Square(size, randomAllocator));
    }

    @Test
    public void should_plant_three_trees_randomly_when_the_size_is_three(){
        int size = 3;
        square = new Square(size, randomAllocator);
        expectedSquare = new String[][] {{"O", "-", "-"}, {"-", "-", "O"}, {"-", "O", "-"}};
        List<Integer> allocatedSpace = List.of(0,2,1);

        given(randomAllocator.generate(size)).willReturn(allocatedSpace);

        actualSquare = square.plant();

        assertTrue(Arrays.equals(expectedSquare[0], actualSquare[0]));
        assertTrue(Arrays.equals(expectedSquare[1], actualSquare[1]));
        assertTrue(Arrays.equals(expectedSquare[2], actualSquare[2]));
    }

}