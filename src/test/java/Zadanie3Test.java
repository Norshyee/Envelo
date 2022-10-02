import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zadanie3.KanyeQuote;
import zadanie3.Zadanie3;

import java.io.IOException;

@Slf4j
public class Zadanie3Test {

    @Test
    void getKanyeQuoteTest(){
        // Given
        KanyeQuote kanyeQuote = null;

        // When
        try {
            kanyeQuote = Zadanie3.getKanyeQuote();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            Assertions.fail();
        }

        // Then
        Assertions.assertNotNull(kanyeQuote);
        Assertions.assertFalse(kanyeQuote.getQuote().isEmpty());
    }
}
