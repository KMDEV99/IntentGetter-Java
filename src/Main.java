import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Proszę podać zdanie: ");
        String sentence = sc.nextLine();

        Map<String, String> classification_map = TreeMapManager.get_filled_classification();
        IntentGetter IG = new IntentGetter(classification_map);

        System.out.println(IG.get_intent(sentence));
    }
}
