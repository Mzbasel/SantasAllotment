import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAllocator {
    private SecureRandom random = new SecureRandom();
    private List<Integer> index = new ArrayList<>();
    private Map<Integer, Integer> diagonallyLeftToRight = new HashMap<>();
    private Map<Integer, Integer> diagonallyRightToLeft = new HashMap<>();
    private int leftToRightCount = 0;
    private int rightToLeftCount = 0;

    private int vertical = 0;

    public List<Integer> generate(int size) {
        createDiagonalObstacles(size);

        while(index.size()!= size){
            int randomIndex = random.nextInt(size);
            if(!index.contains(randomIndex)){
                if(diagonallyRightToLeft.get(vertical)==randomIndex){
                    rightToLeftCount++;
                    if(rightToLeftCount < 2){
                        index.add(randomIndex);
                        vertical++;
                        continue;
                    }
                    continue;
                }
                if(diagonallyLeftToRight.get(vertical)==randomIndex) {
                    leftToRightCount++;
                    if(leftToRightCount < 2) {
                        index.add(randomIndex);
                        vertical++;
                        continue;
                    }
                    continue;
                }
                index.add(randomIndex);
                vertical++;
            }
        }
        return index;
    }

    private void createDiagonalObstacles(int size) {
        int reverseSize = size;
        for (int i = 0; i < size; i++) {
            reverseSize--;
            diagonallyRightToLeft.put(i,reverseSize);
            diagonallyLeftToRight.put(i,i);
        }
    }
}
