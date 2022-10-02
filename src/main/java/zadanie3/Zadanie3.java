package zadanie3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Zadanie3 {

    public static void main(String[] args) {
        String command = "next";
        List<String> quotes = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                switch (command) {
                    case "next":
                        String quote = getKanyeQuote().getQuote();
                        if (!quotes.contains(quote)) {
                            quotes.add(quote);
                            System.out.println(quote);
                        }else{
                            log.info("quote '{}' repeat!", quote);
                        }
                        break;

                    case "exit":
                        return;

                    default:
                        System.out.println("Unknown command!");
                        break;
                }

                command = scanner.next().toLowerCase();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static KanyeQuote getKanyeQuote() throws IOException {
        URL url = new URL("https://api.kanye.rest/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }

        return new ObjectMapper().readValue(url, KanyeQuote.class);
    }
}
