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
        String output = IG.get_intent("nie mam zielonego pojecia");

        Assert.assertEquals(expected_output, output);
        System.out.printf("Expected output: %s\nActual output: %s", expected_output, output);
    }
}