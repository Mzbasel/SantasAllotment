public class ArrayConverter {
    private String result = "";
    public String parse(String[][] square) {
        for(int x = 0; x < square.length; x++){
            String horizontal = "";
            for (int y = 0; y < square.length; y++) {
                horizontal += square[x][y];
            }
            result += horizontal + "\n";
        }
        if(result.equals("")) return "[]";
        return result;
    }
}
