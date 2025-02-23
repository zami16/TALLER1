import java.util.Scanner;

public class PromocionLlantas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de llantas a comprar: ");
        int cantidad = sc.nextInt();
        
        double precioPorLlanta;
        
        if (cantidad < 5) {
            precioPorLlanta = 100;
        } else if (cantidad >= 5 && cantidad <= 10) {
            precioPorLlanta = 75;
        } else {
            precioPorLlanta = 50;
        }
      
        double total = cantidad * precioPorLlanta;
       
        System.out.println("Precio por llanta: U$" + precioPorLlanta);
        System.out.println("Total a pagar: U$" + total);
        
        sc.close();
    }
}
