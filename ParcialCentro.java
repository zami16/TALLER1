import java.util.Scanner;
import java.util.Random;
// programado por los estudiantes Albañil Maikol y Neira Zahira
//clase principal para calcular el costo de parqueadero 
public class ParcialCentro {

    private static double[][] matrizVehiculos = new double[100][6];
    private static int contadorVehiculos = 0;
    private static Scanner scanner = new Scanner(System.in);
        // matriz para almacenar los datos de los vehículos 
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de cálculo de parqueadero, por favor eliga deacuerdo a sus requerimientos: ");
        System.out.println("1. Ingresar los datos manualmente");
        System.out.println("2. Generar los datos aleatorios");
        int opcion = scanner.nextInt();
         // menú principal 
        if (opcion == 1) {
            capturarDatos();
        } else if (opcion == 2) {
            generarDatos();
        } else {
            System.out.println("Opción inválida");
            return;
        }
        generarInforme();
    }
    private static void capturarDatos() {
        boolean continuar = true;
        while (continuar && contadorVehiculos < 100) {
            int tipoServicio;
            do {
                System.out.print("Tipo de servicio (1=Descargar, 2=Cargar): ");
                tipoServicio = scanner.nextInt();
            } while (tipoServicio != 1 && tipoServicio != 2);

            double tipoProducto = 0, peso = 0, tiempo = 0, largo = 0;

            if (tipoServicio == 1) {
                int tp;
                do {
                    System.out.print("Tipo de producto (1=Perecedero, 2=No perecedero): ");
                    tp = scanner.nextInt();
                } while (tp != 1 && tp != 2);
                tipoProducto = tp;

                System.out.print("Peso que se encuentra transportando (en toneladas): ");
                peso = scanner.nextDouble();
            } else {
                System.out.print("Tiempo de permanencia (horas): ");
                tiempo = scanner.nextDouble();
                System.out.print("Largo del vehiculo (metros): ");
                largo = scanner.nextDouble();
            }

            double costo = calcularCosto(tipoServicio, tipoProducto, peso, tiempo, largo);
            guardarEnMatriz(tipoServicio, tipoProducto, peso, tiempo, largo, costo);

            System.out.print("¿Desea ingresar otro vehículo? (si/no): ");
            String respuesta = scanner.next().toLowerCase();
            continuar = respuesta.equals("si");
            // Captura los datos de los vehículos de forma manual.
        }
    }
    private static void generarDatos() {
        Random rand = new Random();
        int cantidad = rand.nextInt(100) + 1;

        for (int i = 0; i < cantidad && contadorVehiculos < 100; i++) {
            int tipoServicio = rand.nextInt(2) + 1;
            double tipoProducto = 0, peso = 0, tiempo = 0, largo = 0;

            if (tipoServicio == 1) {
                tipoProducto = rand.nextInt(2) + 1;
                peso = rand.nextDouble() * 20 + 1; // 1 a 21 toneladas
            } else {
                tiempo = rand.nextDouble() * 10; // 0 a 10 horas
                largo = rand.nextDouble() * 3 + 3; // 3 a 6 metros
            }

            double costo = calcularCosto(tipoServicio, tipoProducto, peso, tiempo, largo);
            guardarEnMatriz(tipoServicio, tipoProducto, peso, tiempo, largo, costo);
        }
        System.out.println("Datos aleatorios generados: " + cantidad + " vehículos.");
        //Genera datos aleatorios para hacer pruebas.
    }
    private static void guardarEnMatriz(double tipoServicio, double tipoProducto, double peso, double tiempo, double largo, double costo) {
        matrizVehiculos[contadorVehiculos][0] = tipoServicio;
        matrizVehiculos[contadorVehiculos][1] = tipoProducto;
        matrizVehiculos[contadorVehiculos][2] = peso;
        matrizVehiculos[contadorVehiculos][3] = tiempo;
        matrizVehiculos[contadorVehiculos][4] = largo;
        matrizVehiculos[contadorVehiculos][5] = costo;
        contadorVehiculos++;
        //Guarda los datos de un vehículo en la matriz.
    }
    private static double calcularCosto(int tipoServicio, double tipoProducto, double peso, double tiempo, double largo) {
        double costo = 0;

        if (tipoServicio == 1) { //Para descargar
            if (tipoProducto == 1) { // para perecedero
                costo = (peso < 8) ? 15000 * peso : 9000 * peso;
            } else { // para no perecedero
                if (peso < 8) {
                    costo = 80000;
                } else if (peso <= 10) {
                    costo = 60000;
                } else {
                    costo = 60000 + 7000 * (peso - 10);
                }
            }
        } else { // cargar
            if (tiempo > 2) {
                double horasExcedentes = tiempo - 2;
                int horasCobradas = (int) Math.ceil(horasExcedentes);
                costo = horasCobradas * 4000;
                if (largo > 4) {
                    costo *= 1.25;
                }
            } else {
                costo = 0;
            }
        }
        return costo;
        //Calcula el costo del parqueadero.
    }
    private static void generarInforme() {
        double totalServicio1 = 0, totalServicio2 = 0;
        int contadorServicio1 = 0, contadorServicio2 = 0;
        int contadorMenosDosHoras = 0;
        double totalPerecederos = 0;

        for (int i = 0; i < contadorVehiculos; i++) {
            double[] vehiculo = matrizVehiculos[i];
            int tipoServicio = (int) vehiculo[0];
            double costo = vehiculo[5];

            if (tipoServicio == 1) {
                contadorServicio1++;
                totalServicio1 += costo;
                if (vehiculo[1] == 1) { // Producto perecedero
                    totalPerecederos += costo;
                }
            } else {
                contadorServicio2++;
                totalServicio2 += costo;
                if (vehiculo[3] < 2) { // Menos de 2 horas
                    contadorMenosDosHoras++;
                }
            }    
             // Genera el informe con los resultados.
        }
        double promedio1 = contadorServicio1 > 0 ? totalServicio1 / contadorServicio1 : 0;
        double promedio2 = contadorServicio2 > 0 ? totalServicio2 / contadorServicio2 : 0;
         //Promedio por servicio
    
        System.out.println("\n--- Informe Final ---");
        System.out.printf("a. Promedio costo servicio 1: $%.2f\n", promedio1);
        System.out.printf("   Promedio costo servicio 2: $%.2f\n", promedio2);
        System.out.printf("b. Total servicio 1: %d vehículos, $%.2f\n", contadorServicio1, totalServicio1);
        System.out.printf("   Total servicio 2: %d vehículos, $%.2f\n", contadorServicio2, totalServicio2);
        System.out.printf("c. Vehículos con menos de 2 horas: %d\n", contadorMenosDosHoras);
        System.out.printf("d. Costo total descarga perecederos: $%.2f\n", totalPerecederos);
           // Resultados obtenidos
    }
}