package designpatterns.example.stracture.adaptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataServiceAdaptorTest {

    @Test
    public void userAdaptorToCallApiVersion2() {
        String text1 = "text1";
        String text2 = "text2";
        ApiEndpoint legacyApiEndpoint = new ApiEndpoint(new DataServiceV1Impl());
        int legacyText1Index = legacyApiEndpoint.validateAndSaveText(text1);
        int legacyText2Index = legacyApiEndpoint.validateAndSaveText(text2);
        assertEquals(text1, legacyApiEndpoint.validateAndGetText(legacyText1Index));
        assertEquals(text2, legacyApiEndpoint.validateAndGetText(legacyText2Index));

        ApiEndpoint newApiEndpoint = new ApiEndpoint(new DataServiceAdaptor());
        int newText1Index = newApiEndpoint.validateAndSaveText(text1);
        int newText2Index = newApiEndpoint.validateAndSaveText(text2);
        assertEquals(text1, newApiEndpoint.validateAndGetText(newText1Index));
        assertEquals(text2, newApiEndpoint.validateAndGetText(newText2Index));
    }

}
