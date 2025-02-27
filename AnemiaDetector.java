import java.util.Scanner;

public class AnemiaDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la edad (en años o meses según corresponda): ");
        double edad = scanner.nextDouble();

        System.out.print("Ingrese el sexo (hombre/mujer): ");
        String sexo = scanner.next();

        System.out.print("Ingrese el nivel de hemoglobina (g%): ");
        double nivelHemoglobina = scanner.nextDouble();

        String resultado = determinarAnemia(edad, sexo, nivelHemoglobina);
        System.out.println("Resultado: " + resultado);

        scanner.close();
    }

    public static String determinarAnemia(double edad, String sexo, double nivelHemoglobina) {
        double[] rango = new double[2];

        if (edad <= 1) { // 0 - 1 mes
            rango[0] = 13;
            rango[1] = 26;
        } else if (edad > 1 && edad <= 6) { // > 1 y <= 6 meses
            rango[0] = 10;
            rango[1] = 18;
        } else if (edad > 6 && edad <= 12) { // > 6 y <= 12 meses
            rango[0] = 11;
            rango[1] = 15;
        } else if (edad > 1 && edad <= 5) { // > 1 y <= 5 años
            rango[0] = 11.5;
            rango[1] = 15;
        } else if (edad > 5 && edad <= 10) { // > 5 y <= 10 años
            rango[0] = 12.6;
            rango[1] = 15.5;
        } else if (edad > 10 && edad <= 15) { // > 10 y <= 15 años
            rango[0] = 13;
            rango[1] = 15.5;
        } else if (edad > 15) {
            if (sexo.equalsIgnoreCase("mujer")) {
                rango[0] = 12;
                rango[1] = 16;
            } else if (sexo.equalsIgnoreCase("hombre")) {
                rango[0] = 14;
                rango[1] = 18;
            } else {
                return "Sexo no válido";
            }
        } else {
            return "Edad no válida";
        }

        if (nivelHemoglobina < rango[0]) {
            return "Positivo (Anemia)";
        } else {
            return "Negativo (No anemia)";
        }
    }
}