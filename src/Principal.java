import com.google.gson.Gson;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
    Gson gson = new Gson();
    ConsultaDivisa consulta = new ConsultaDivisa();
    Scanner teclado = new Scanner(System.in);

        Menu menu = new Menu();
        System.out.println("***************************************************");
        System.out.println("Bienvenido al conversor de moneda");

        while (true) {
            menu.mostrarMenu();
            int opcion = (teclado.nextInt());
            double valor;
            double tasaCambio = 0;
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Dolar a Peso Argentino");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("USD", "ARS");
                    double valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 2:
                    System.out.println("Seleccionaste Peso Argentino a Dolar");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("ARS", "USD");
                    valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 3:
                    System.out.println("Seleccionaste Dolar a Peso Mexicano");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("USD", "MXN");
                    valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 4:
                    System.out.println("Seleccionaste Peso Mexicano a Dolar");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("MXN", "USD");
                    valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 5:
                    System.out.println("Seleccionaste Dolar a Peso Colombiano");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("USD", "COP");
                    valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 6:
                    System.out.println("Seleccionaste Peso Colombiano a Dolar");
                    System.out.println("Ingresa el valor que deseas convertir\n");
                    valor = (teclado.nextDouble());
                    tasaCambio = ConsultaDivisa.consultaTasaCambio("COP", "USD");
                    valorConvertido = valor * tasaCambio;
                    System.out.println("El valor convertido es: " + valorConvertido);
                    System.out.println("***************************************************");
                    break;
                case 7:
                    System.out.println("Seleccionaste Salir");
                    System.out.println("Saliendo de la aplicación...");
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(tasaCambio);
            System.out.println("El archivo se ha guardado correctamente.");

            try {
            } catch (NumberFormatException e) {
                System.out.println("No es posible");
            } catch (InputMismatchException e) {
                System.out.println("Digitalice una opcion valida");
            }
        }

    }
}
