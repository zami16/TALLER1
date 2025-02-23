import java.util.Scanner;

public class DescuentoComputadoras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número de computadoras a comprar: ");
        int cantidad = scanner.nextInt();
        
        final double PRECIO_POR_COMPUTADORA = 500.0;
        double totalSinDescuento = cantidad * PRECIO_POR_COMPUTADORA;
        double descuento = 0.0;
        
        if (cantidad < 5) {
            descuento = 0.10;
        } else if (cantidad < 10) { 
            descuento = 0.20;
        } else {
            descuento = 0.40;
        }
        
        double totalConDescuento = totalSinDescuento * (1 - descuento);
        
        System.out.printf("El total a pagar es: U$%.2f%n", totalConDescuento);
    }
}