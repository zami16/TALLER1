import java.util.Scanner;

public class Jubilacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese la antigüedad en el empleo (en años): ");
        int antiguedad = scanner.nextInt();

        String tipoJubilacion = determinarTipoJubilacion(edad, antiguedad);
        System.out.println("Tipo de jubilación: " + tipoJubilacion);

        scanner.close();
    }

    public static String determinarTipoJubilacion(int edad, int antiguedad) {
        if (edad >= 60 && antiguedad < 25) {
            return "Jubilación por edad";
        } else if (edad < 60 && antiguedad >= 25) {
            return "Jubilación por antigüedad joven";
        } else if (edad >= 60 && antiguedad >= 25) {
            return "Jubilación por antigüedad adulta";
        } else {
            return "No cumple con los requisitos para jubilación";
        }
    }
}