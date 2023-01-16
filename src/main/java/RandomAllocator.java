import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAllocator {
    private SecureRandom random = new SecureRandom();
    private List<Integer> indexList = new ArrayList<>();
    private List<Integer> availableIndexes = new ArrayList<>();
    private Map<Integer, Integer> diagonallyLeftToRight = new HashMap<>();
    private Map<Integer, Integer> diagonallyRightToLeft = new HashMap<>();
    private int leftToRightCount = 0, rightToLeftCount = 0, vertical = 0;
    private int index, randomIndex;

    public List<Integer> generate(int size) {
        createDiagonalObstacles(size);
        createAvailableIndexes(size);

        while(indexList.size()!= size){
            index = generateRandomIndex();
            randomIndex = availableIndexes.get(index);
            if(diagonallyRightToLeft.get(vertical)==randomIndex){
                rightToLeftCount++;
                if(rightToLeftCount < 2) addNewToIndexList();
                continue;
            }
            if(diagonallyLeftToRight.get(vertical)==randomIndex) {
                leftToRightCount++;
                if(leftToRightCount < 2) addNewToIndexList();
                continue;
            }
            addNewToIndexList();

        }
        return indexList;
    }

    private void addNewToIndexList() {
        indexList.add(randomIndex);
        availableIndexes.remove(index);
        vertical++;
    }

    private int generateRandomIndex() {
        return random.nextInt(availableIndexes.size());
    }

    private void createAvailableIndexes(int size) {
        for (int i = 0; i < size; i++) {
            availableIndexes.add(i);
        }
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
