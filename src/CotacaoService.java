import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class CotacaoService {
    public void buscarCotacao() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://economia.awesomeapi.com.br/json/last/USD-BRL"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        Cotacao cotacao = gson.fromJson(json.get("USDBRL"), Cotacao.class);

        System.out.println("Moeda: " + cotacao.getName());
        System.out.println("Compra: R$: " + cotacao.getBid());
        System.out.println("Maior do dia: R$ " + cotacao.getHigh());
        System.out.println("Menor do dia: R$ " + cotacao.getLow());
    }
}