import com.google.gson.JsonObject;



public record Divisa(
        String base_code,
        JsonObject conversion_rates) {
}
