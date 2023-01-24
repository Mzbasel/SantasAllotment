public class Main {

    public static void main(String[] args){
        RandomAllocator randomAllocator = new RandomAllocator();
        Square square = new Square(4, randomAllocator);
        ArrayConverter arrayConverter = new ArrayConverter();
        SantasAllotment santasAllotment = new SantasAllotment(square, arrayConverter);

        System.out.println(santasAllotment.execute());
    }
}
