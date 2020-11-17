import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        Map<String, String> classification_map = TreeMapManager.get_filled_classification();
        IntentGetter IG = new IntentGetter(classification_map);
        System.out.println(IG.get_intent(classification_map, sentence));
    }
}

class IntentGetter {
    Pattern pattern;

    public IntentGetter(Map<String, String> classification_map) {
        StringBuilder pattern_builder = new StringBuilder();

        for (String key : classification_map.keySet())
            pattern_builder.append("|" + "\\b" + key + "\\b");

        pattern = Pattern.compile(pattern_builder.substring(1));
    }

    public String get_intent(Map<String, String> classification_map, String text) {
        String intent = "brak";
        Matcher matcher = pattern.matcher(text);

        if (matcher.find())
            intent = classification_map.get(matcher.group());

        return intent;
    }
}

class TreeMapManager {
    public static Map<String, String> get_filled_classification() {
        Map<String, String> classification_map = new LinkedHashMap<>();
        classification_map.put("skad mam wiedziec", "nie wiem");
        classification_map.put("nie znam odpowiedzi", "nie wiem");
        classification_map.put("nie wiem", "nie wiem");
        classification_map.put("nie mam pojecia", "nie wiem");
        classification_map.put("nie mam zielonego pojecia", "nie wiem");
        classification_map.put("nie rozumiem", "nie wiem");
        classification_map.put("nie umiem", "nie wiem");
        classification_map.put("nie jestem pewien", "nie wiem");
        classification_map.put("nie orientuje sie", "nie wiem");
        classification_map.put("tak", "tak");
        classification_map.put("nie widze przeszkod", "tak");
        classification_map.put("czemu nie", "tak");
        classification_map.put("ani chybi", "tak");
        classification_map.put("bez dwoch zdan", "tak");
        classification_map.put("bezspornie", "tak");
        classification_map.put("bezsprzecznie", "tak");
        classification_map.put("jak najbardziej", "tak");
        classification_map.put("jakze by inaczej", "tak");
        classification_map.put("jasne", "tak");
        classification_map.put("ma sie rozumiec", "tak");
        classification_map.put("mowa", "tak");
        classification_map.put("na bank", "tak");
        classification_map.put("naturalnie", "tak");
        classification_map.put("nie inaczej", "tak");
        classification_map.put("nie ma dwoch zdan", "tak");
        classification_map.put("oczywiscie ze nie", "nie");
        classification_map.put("oczywiscie", "tak");
        classification_map.put("owszem", "tak");
        classification_map.put("pewnie", "tak");
        classification_map.put("racja", "tak");
        classification_map.put("rozumie sie", "tak");
        classification_map.put("rzecz jasna", "tak");
        classification_map.put("slusznie", "tak");
        classification_map.put("tak jest", "tak");
        classification_map.put("wiadomo", "tak");
        classification_map.put("wlasnie", "tak");
        classification_map.put("z cala pewnoscia", "tak");
        classification_map.put("ano", "tak");
        classification_map.put("dokladnie", "tak");
        classification_map.put("dokladnie tak", "tak");
        classification_map.put("istotnie", "tak");
        classification_map.put("no tak", "tak");
        classification_map.put("rzeczywiscie", "tak");
        classification_map.put("w istocie", "tak");
        classification_map.put("w rzeczy samej", "tak");
        classification_map.put("zaiste", "tak");
        classification_map.put("no jasne", "tak");
        classification_map.put("prawda", "tak");
        classification_map.put("uhm", "tak");
        classification_map.put("yhm", "tak");
        classification_map.put("w samej rzeczy", "tak");
        classification_map.put("bezwzglednie", "tak");
        classification_map.put("no pewnie", "tak");
        classification_map.put("bez kwestii", "tak");
        classification_map.put("bez watpienia", "tak");
        classification_map.put("koniecznie", "tak");
        classification_map.put("obowiazkowo", "tak");
        classification_map.put("a jak", "tak");
        classification_map.put("a jakze", "tak");
        classification_map.put("jeszcze jak", "tak");
        classification_map.put("nic dodac", "tak");
        classification_map.put("nic ujac", "tak");
        classification_map.put("otoz to", "tak");
        classification_map.put("zgadza sie", "tak");
        classification_map.put("zgoda", "tak");
        classification_map.put("dobra", "tak");
        classification_map.put("dobrze", "tak");
        classification_map.put("okay", "tak");
        classification_map.put("okej", "tak");
        classification_map.put("w porzadku", "tak");
        classification_map.put("zgadzam sie", "tak");
        classification_map.put("nom", "tak");
        classification_map.put("ok", "tak");
        classification_map.put("tak bardzo", "tak");
        classification_map.put("w ten sposob", "tak");
        classification_map.put("a i owszem", "tak");
        classification_map.put("na pewno", "tak");
        classification_map.put("pewno", "tak");
        classification_map.put("nie", "nie");
        classification_map.put("akurat", "nie");
        classification_map.put("ale gdzie tam", "nie");
        classification_map.put("ale skad", "nie");
        classification_map.put("ani troche", "nie");
        classification_map.put("bron boze", "nie");
        classification_map.put("bynajmniej", "nie");
        classification_map.put("gdziez tam", "nie");
        classification_map.put("jeszcze czego", "nie");
        classification_map.put("nigdy w zyciu", "nie");
        classification_map.put("a skad", "nie");
        classification_map.put("skadze znowu", "nie");
        classification_map.put("gdzie tam", "nie");
        classification_map.put("pod zadnym pozorem", "nie");
        classification_map.put("za nic w swiecie", "nie");
        classification_map.put("za zadne skarby", "nie");
        classification_map.put("nie ma mowy", "nie");
        classification_map.put("nic takiego", "nie");
        classification_map.put("wykluczone", "nie");
        classification_map.put("skadze", "nie");
        classification_map.put("w zadnym razie", "nie");
        classification_map.put("wcale", "nie");
        classification_map.put("wcale nie", "nie");
        classification_map.put("absolutnie nie", "nie");
        classification_map.put("absolutnie", "tak");
        classification_map.put("nigdy", "nie");
        classification_map.put("w zyciu", "nie");
        classification_map.put("zupelnie nie", "nie");
        classification_map.put("nie ma o czym mowic", "nie");
        classification_map.put("nie moze byc mowy", "nie");
        classification_map.put("nie wchodzi w rachube", "nie");
        classification_map.put("niestety", "nie");
        classification_map.put("niestety nie", "nie");
        classification_map.put("w zadnym wypadku", "nie");
        classification_map.put("trudno powiedziec", "nie wiem");
        classification_map.put("no", "tak");

        return classification_map;
    }
}
