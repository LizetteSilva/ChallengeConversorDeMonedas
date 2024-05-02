import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;


public class GeneradorDeArchivo {
        public void guardarJson(double tasaCambio) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter escritura = new FileWriter(tasaCambio+"divisa.json");
            escritura.write(gson.toJson(tasaCambio));
            escritura.close();
        }
}
