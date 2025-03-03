import java.util.Scanner;

public class ReproductorMusica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Solicitar datos de entrada
        System.out.print("Ingrese la marca del reproductor: ");
        String marca = sc.nextLine();
        
        System.out.print("Ingrese el precio base (sin IVA) del reproductor: ");
        double precioBase = sc.nextDouble();
        
        // 2. Aplicar descuento por marca NOSY (5%)
        double precioConDescuentos = precioBase;
        
        // Si la marca es "NOSY" (ignorando mayúsculas/minúsculas)
        if (marca.equalsIgnoreCase("NOSY")) {
            precioConDescuentos = precioConDescuentos * 0.95;  // Aplica 5% de descuento
        }
        
        // 3. Aplicar descuento del 10% si el precio base es >= 500
        if (precioBase >= 500) {
            precioConDescuentos = precioConDescuentos * 0.90;  // Aplica 10% de descuento
        }
        
        // 4. Calcular el IVA (19%)
        double precioFinal = precioConDescuentos * 1.19;  // Se aplica el 19% al subtotal con descuentos
        
        // 5. Mostrar resultados
        System.out.printf("Precio base (sin IVA): %.2f\n", precioBase);
        System.out.printf("Precio tras descuentos (sin IVA): %.2f\n", precioConDescuentos);
        System.out.printf("Precio final con IVA (19%%): %.2f\n", precioFinal);
        
        sc.close();
    }
}
