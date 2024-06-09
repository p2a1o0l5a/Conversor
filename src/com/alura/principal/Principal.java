package com.alura.principal;

import com.alura.api.Api;
import com.alura.convertidor.Valor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        String menu = """
                ________________________________________________________
                |       SEA BIENVENIDO/A AL CONVERSOR DE MONEDAS       |
                ________________________________________________________
                |   1   |   Dolar ---> Peso Argentino                  |
                |   2   |   Peso Argentino --> Dolar                   |
                |   3   |   Dolar --> Real Brasileño                   |
                |   4   |   Real Brasileño --> Dolar                   |
                |   5   |   Dolar --> Peso Colombiano                  |
                |   6   |   Peso Colombiano --> Dolar                  |
                |   7   |   Salir                                      |
                ________________________________________________________
                """;

        while (true) {
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                break;
            }

            Api api = new Api();
            Valor tasas = api.obtenerTasasDeCambio("USD");

            switch (opcion) {
                case 1:
                    System.out.println("Se convertirá de Dólar a Peso Argentino");
                    double tasaARS = tasas.getConversionRates().get("ARS");
                    System.out.print("Ingrese la cantidad en dólares: ");
                    double dolares = teclado.nextDouble();
                    double pesosArgentinos = dolares * tasaARS;
                    System.out.printf("%.2f USD son %.2f ARS\n", dolares, pesosArgentinos);
                    break;
                case 2:
                    System.out.println("Se convertirá de Peso Argentino a Dólar");
                    double tasaUSDFromARS = tasas.getConversionRates().get("ARS");
                    System.out.print("Ingrese la cantidad en pesos argentinos: ");
                    double pesos = teclado.nextDouble();
                    double dolaresFromPesos = pesos / tasaUSDFromARS;
                    System.out.printf("%.2f ARS son %.2f USD\n", pesos, dolaresFromPesos);
                    break;
                case 3:
                    System.out.println("Se convertirá de Dólar a Real Brasileño");
                    double tasaBRL = tasas.getConversionRates().get("BRL");
                    System.out.print("Ingrese la cantidad en dólares: ");
                    double dolaresBRL = teclado.nextDouble();
                    double reales = dolaresBRL * tasaBRL;
                    System.out.printf("%.2f USD son %.2f BRL\n", dolaresBRL, reales);
                    break;
                case 4:
                    System.out.println("Se convertirá de Real Brasileño a Dólar");
                    double tasaUSDFromBRL = tasas.getConversionRates().get("BRL");
                    System.out.print("Ingrese la cantidad en reales: ");
                    double realesBRL = teclado.nextDouble();
                    double dolaresFromBRL = realesBRL / tasaUSDFromBRL;
                    System.out.printf("%.2f BRL son %.2f USD\n", realesBRL, dolaresFromBRL);
                    break;
                case 5:
                    System.out.println("Se convertirá de Dólar a Peso Colombiano");
                    double tasaCOP = tasas.getConversionRates().get("COP");
                    System.out.print("Ingrese la cantidad en dólares: ");
                    double dolaresCOP = teclado.nextDouble();
                    double pesosColombianos = dolaresCOP * tasaCOP;
                    System.out.printf("%.2f USD son %.2f COP\n", dolaresCOP, pesosColombianos);
                    break;
                case 6:
                    System.out.println("Se convertirá de Peso Colombiano a Dólar");
                    double tasaUSDFromCOP = tasas.getConversionRates().get("COP");
                    System.out.print("Ingrese la cantidad en pesos colombianos: ");
                    double pesosCOP = teclado.nextDouble();
                    double dolaresFromCOP = pesosCOP / tasaUSDFromCOP;
                    System.out.printf("%.2f COP son %.2f USD\n", pesosCOP, dolaresFromCOP);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
