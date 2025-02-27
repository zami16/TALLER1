import java.util.Scanner;

public class ProgramaEducativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tipo de programa (tecnologia/profesional): ");
        String tipoPrograma = scanner.next();

        System.out.print("Ingrese el promedio del alumno: ");
        double promedio = scanner.nextDouble();

        int materiasReprobadas = 0;
        if (tipoPrograma.equalsIgnoreCase("tecnologia") && promedio <= 7) {
            System.out.print("Ingrese el número de materias reprobadas: ");
            materiasReprobadas = scanner.nextInt();
        }

        int creditos = 0;
        double descuento = 0;
        int costoPorCincoCreditos = tipoPrograma.equalsIgnoreCase("tecnologia") ? 18000 : 30000;

        if (tipoPrograma.equalsIgnoreCase("tecnologia")) {
            if (promedio >= 9.5) {
                creditos = 55;
                descuento = 0.25;
            } else if (promedio >= 9) {
                creditos = 50;
                descuento = 0.10;
            } else if (promedio > 7) {
                creditos = 50;
                descuento = 0;
            } else if (materiasReprobadas <= 3) {
                creditos = 45;
                descuento = 0;
            } else {
                creditos = 40;
                descuento = 0;
            }
        } else if (tipoPrograma.equalsIgnoreCase("profesional")) {
            if (promedio >= 9.5) {
                creditos = 55;
                descuento = 0.20;
            } else {
                creditos = 55;
                descuento = 0;
            }
        } else {
            System.out.println("Tipo de programa no válido.");
            return;
        }

        double costoTotal = (creditos / 5) * costoPorCincoCreditos * (1 - descuento);
        System.out.println("El total a pagar es: $" + costoTotal);

        scanner.close();
    }
}