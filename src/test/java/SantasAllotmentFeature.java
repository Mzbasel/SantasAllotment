import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SantasAllotmentFeature {

    @Test
    public void should_align_christmas_trees_according_to_the_size_of_his_allotment(){
        int size = 2;
        RandomAllocator randomAllocator = new RandomAllocator();
        Square square = new Square(size, randomAllocator);
        ArrayConverter arrayConverter = new ArrayConverter();
        SantasAllotment santasAllotment = new SantasAllotment(square, arrayConverter);
        String expectedSquare = "[]";
        String actualSquare = santasAllotment.execute();

        assertEquals(expectedSquare, actualSquare);

    }
}
