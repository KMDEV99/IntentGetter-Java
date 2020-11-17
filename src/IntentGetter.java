import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IntentGetter {
    private final Pattern pattern;
    private final Map<String, String> classification_map;

    IntentGetter(Map<String, String> classification_map) {
        StringBuilder pattern_builder = new StringBuilder();
        this.classification_map = classification_map;

        for (String key : classification_map.keySet())
            pattern_builder.append("|" + "\\b").append(key).append("\\b");

        pattern = Pattern.compile(pattern_builder.substring(1));
    }

    final String get_intent(String text) {
        String intent = "brak";
        Matcher matcher = pattern.matcher(text);

        if (matcher.find())
            intent = classification_map.get(matcher.group());

        return intent;
    }
}
