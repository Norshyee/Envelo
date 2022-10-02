package zadanie3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Slf4j
public class Zadanie3 {

    public static void main(String[] args) {
        String command = "next";

        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                switch(command){
                    case "next":
                        String quote = getKayneQuote().getQuote();
                        System.out.println(quote);
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("unknown command!");
                        break;
                }

                command = scanner.next().toLowerCase();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private static KanyeQuote getKayneQuote() throws IOException {
        URL url = new URL("https://api.kanye.rest/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if(responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }

        return new ObjectMapper().readValue(url, KanyeQuote.class);
    }
}
