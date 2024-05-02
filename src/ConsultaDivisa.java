import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaDivisa {

    public static double consultaTasaCambio(String codigoDivisaBase, String codigoDivisaObjetivo){
        URI API_URL = URI.create("https://v6.exchangerate-api.com/v6/c7e754c7f2833c82dea0bbdd/latest/"+codigoDivisaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(API_URL)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                return conversionRates.get(codigoDivisaObjetivo).getAsDouble();
            } else {
                throw new RuntimeException("Error al obtener la tasa de cambio: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio: " + e.getMessage());
        }
    }
}