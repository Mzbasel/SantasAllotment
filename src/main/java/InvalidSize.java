public class InvalidSize extends RuntimeException {
    public InvalidSize() {
        super("Size can not be less than zero!");
    }
}
