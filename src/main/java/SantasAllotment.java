public class SantasAllotment {

    private Square square;
    private ArrayConverter arrayConverter;

    public SantasAllotment(Square square, ArrayConverter arrayConverter) {
        this.square = square;
        this.arrayConverter = arrayConverter;
    }

    public String execute() {
        String[][] squareArray = square.plant();
        String square = arrayConverter.parse(squareArray);
        return square;
    }
}
