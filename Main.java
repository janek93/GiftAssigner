import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GiftAssigner giftAssigner = new GiftAssigner(
                Arrays.asList("Janek", "Tomek"),
                Arrays.asList("Marysia", "Zosia", "Basia"));
        System.out.println(giftAssigner.assign());
    }

}
