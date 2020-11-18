import java.util.HashMap;
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
        String normalized_text = prepare_string(text);
        Matcher matcher = pattern.matcher(normalized_text);

        if (matcher.find())
            intent = classification_map.get(matcher.group());

        return intent;
    }

    final String prepare_string(String text) {
        text = text.replaceAll(",|\\.", "").replaceAll("  +", " ");
        char[] char_array = text.toLowerCase().toCharArray();

        Map<Character, Character> normalization_map = new HashMap<>();
        normalization_map.put('ą', 'a');
        normalization_map.put('ć', 'c');
        normalization_map.put('ę', 'e');
        normalization_map.put('ł', 'l');
        normalization_map.put('ń', 'n');
        normalization_map.put('ó', 'o');
        normalization_map.put('ś', 's');
        normalization_map.put('ź', 'z');
        normalization_map.put('ż', 'z');

        for (int i = 0; i < char_array.length; i++) {
            if (normalization_map.containsKey(char_array[i]))
                char_array[i] = normalization_map.get(char_array[i]);
        }
        return String.valueOf(char_array);
    }
}
