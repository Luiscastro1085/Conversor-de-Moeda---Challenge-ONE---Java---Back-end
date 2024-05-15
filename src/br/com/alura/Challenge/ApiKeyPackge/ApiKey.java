package br.com.alura.Challenge.ApiKeyPackge;

import br.com.alura.Challenge.ModeloDoJson.ModeloDoJsonCoin;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiKey {

    private ModeloDoJsonCoin jsonCoin;

    public ModeloDoJsonCoin getJsonCoin() {
        return jsonCoin;
    }

    public void httpRequest(String baseCurrency,  String targetCurrency) throws IOException, InterruptedException {

        var key = "ab6e64c13244ebb508ed5b9f";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseCurrency + "/" + targetCurrency;

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            String json = response.body();
            jsonCoin = gson.fromJson(json, ModeloDoJsonCoin.class);

        } catch  (IllegalArgumentException e) {
            throw  new RuntimeException();}
    }}