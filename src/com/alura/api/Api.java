package com.alura.api;

import com.alura.convertidor.Valor;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/c2d3d16464c36e44cb5e24a9/latest/";

    public Valor obtenerTasasDeCambio(String monedaBase) {
        URI direccion = URI.create(API_URL + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Valor.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener las tasas de cambio", e);
        }
    }
}
