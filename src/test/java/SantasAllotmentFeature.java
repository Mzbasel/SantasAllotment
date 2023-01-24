import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SantasAllotmentFeature {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    public void should_return_an_empty_square_when_the_size_of_the_square_is_not_big_enough(int size){
        RandomAllocator randomAllocator = new RandomAllocator();
        Square square = new Square(size, randomAllocator);
        ArrayConverter arrayConverter = new ArrayConverter();
        SantasAllotment santasAllotment = new SantasAllotment(square, arrayConverter);
        String expectedSquare = "[]";
        String actualSquare = santasAllotment.execute();

        assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void should_align_christmas_trees_according_to_the_size_of_his_allotment(){
        RandomAllocator randomAllocator = new TestableRandomAllocator();
        Square square = new Square(4, randomAllocator);
        ArrayConverter arrayConverter = new ArrayConverter();
        SantasAllotment santasAllotment = new SantasAllotment(square, arrayConverter);
        String expectedSquare = "O---\n---O\n-O--\n--O-\n";
        String actualSquare = santasAllotment.execute();

        assertEquals(expectedSquare, actualSquare);
    }
}
