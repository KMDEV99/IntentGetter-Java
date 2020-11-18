import org.junit.Assert;

import java.util.Map;


class IntentGetterTest {
    IntentGetter IG;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Map<String, String> classification_map = TreeMapManager.get_filled_classification();
        this.IG = new IntentGetter(classification_map);
    }

    @org.junit.jupiter.api.Test
    void get_intent() {
        String expected_output = "nie wiem";
        String input = "nie mam zielonego pojecia";
        String output = IG.get_intent(input);

        Assert.assertEquals(expected_output, output);
        System.out.printf("Input: %s\nExpected output: %s\nActual output: %s",input , expected_output, output);
    }

    @org.junit.jupiter.api.Test
    void get_intent_special_characters() {
        String expected_output = "tak";
        String input = "jeśźczę jąk";
        String output = IG.get_intent(input);

        Assert.assertEquals(expected_output, output);
        System.out.printf("Input: %s\nExpected output: %s\nActual output: %s",input , expected_output, output);
    }

    @org.junit.jupiter.api.Test
    void get_intent_special_characters_multiple_whitespaces() {
        String expected_output = "tak";
        String input = "jeśźczę,,,...           jąk";
        String output = IG.get_intent(input);

        Assert.assertEquals(expected_output, output);
        System.out.printf("Input: %s\nExpected output: %s\nActual output: %s",input , expected_output, output);
    }

    @org.junit.jupiter.api.Test
    void get_intent_not_present() {
        String expected_output = "brak";
        String input = "takie zdanie";
        String output = IG.get_intent(input);

        Assert.assertEquals(expected_output, output);
        System.out.printf("Input: %s\nExpected output: %s\nActual output: %s",input , expected_output, output);
    }

    @org.junit.jupiter.api.Test
    void get_intent_no() {
        String expected_output = "brak";
        String input = "java";
        String output = IG.get_intent(input);

        Assert.assertEquals(expected_output, output);
        System.out.printf("Input: %s\nExpected output: %s\nActual output: %s",input , expected_output, output);
    }
}