import java.util.Scanner;

public class CalculadorManzanas {
    private static final double PRECIO_POR_KILO = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de kilos de manzanas comprados: ");
        double kilos = scanner.nextDouble();

        double descuento = 0.0;

        if (kilos <= 2) {
            descuento = 0.0;
        } else if (kilos <= 5) {
            descuento = 0.10; // 10%
        } else if (kilos <= 10) {
            descuento = 0.15; // 15%
        } else {
            descuento = 0.20; // 20%
        }

        double subtotal = kilos * PRECIO_POR_KILO;
        double total = subtotal * (1 - descuento);

        System.out.printf("\nSubtotal (sin descuento): $%.2f", subtotal);
        System.out.printf("\nDescuento aplicado: %.0f%%", descuento * 100);
        System.out.printf("\nTotal a pagar: $%.2f", total);

        scanner.close();
    }
}