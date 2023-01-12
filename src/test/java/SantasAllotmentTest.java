import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SantasAllotmentTest {

    private SantasAllotment santasAllotment;
    @Mock
    private Square square;
    @Mock
    private ArrayConverter arrayConverter;

    @BeforeEach
    public void setup(){
        santasAllotment = new SantasAllotment(square, arrayConverter);
    }

    @Test
    public void should_return_an_empty_array_when_the_size_is_zero(){
        String expectedSquare = "[]";
        String[][] expectedSquareArray = new String[][] {{}};
        given(square.plant()).willReturn(expectedSquareArray);
        given(arrayConverter.parse(expectedSquareArray)).willReturn("[]");

        String actualSquare = santasAllotment.execute();

        assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void should_return_three_planted_trees_when_the_size_is_tree(){
        String expectedSquare = "--O\nO--\n-O-";
        String[][] expectedSquareArray = {{"--O"}, {"O--"}, {"-O-"}};

        given(square.plant()).willReturn(expectedSquareArray);
        given(arrayConverter.parse(expectedSquareArray)).willReturn(expectedSquare);

        String actualSquare = santasAllotment.execute();

        assertEquals(expectedSquare, actualSquare);
    }

}