import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IntentGetter {
    Pattern pattern;

    public IntentGetter(Map<String, String> classification_map) {
        StringBuilder pattern_builder = new StringBuilder();

        for (String key : classification_map.keySet())
            pattern_builder.append("|" + "\\b").append(key).append("\\b");

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
