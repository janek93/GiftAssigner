import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GiftAssigner giftAssigner = new GiftAssigner(
                Arrays.asList("Janek", "Tomek", "Basia", "test"),
                Arrays.asList("Marysia", "Zosia", "Basia", "test"));
        System.out.println(giftAssigner.draw());
    }

}
