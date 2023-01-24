import java.util.List;

public class TestableRandomAllocator extends RandomAllocator{
    List<Integer> sizeFourSquareAllocation = List.of(0,2,0,0);
    int countAllocation = 0;
    @Override
    protected int generateRandomIndex(){
        int index =  sizeFourSquareAllocation.get(countAllocation);
        countAllocation++;
        return index;
    }
}
