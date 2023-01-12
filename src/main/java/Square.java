import java.util.List;

public class Square {

    private int size;
    private RandomAllocator randomAllocator;
    private String[][] square;

    public Square(int size, RandomAllocator randomAllocator) {
        this.size = checkIfValid(size);
        this.randomAllocator = randomAllocator;
        square = createAnEmptySquare();
    }

    private int checkIfValid(int size) {
        if(size < 0){
            throw new InvalidSize();
        }
        return size;
    }

    public String[][] plant() {
        if(size < 3){
            return new String[][] {};
        }
        List<Integer> allocatedSpace = randomAllocator.generate(size);
        for(int index = 0; index < size; index++){
            square[index][allocatedSpace.get(index)] = "O";
        }
        return square;
    }

    private String[][] createAnEmptySquare() {
        String[][] emptySquare = new String[size][size];
        for (int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++){
                emptySquare[x][y] = "-";
            }
        }
        return emptySquare;
    }
}
