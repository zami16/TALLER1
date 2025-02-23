import java.util.Scanner;

public class FinanzasEmpresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el saldo actual del capital (U$): ");
        double capitalActual = scanner.nextDouble();
        
        double prestamo = 0.0;
        double nuevoSaldo;
        
        if (capitalActual < 0) {
            prestamo = 10000 - capitalActual; 
            nuevoSaldo = 10000;
        } else if (capitalActual <= 20000) {
            prestamo = 20000 - capitalActual;
            nuevoSaldo = 20000;
        } else {
            prestamo = 0.0;
            nuevoSaldo = capitalActual;
        }
     
        double gastoComputo = 5000;
        double gastoMobiliario = 2000;
        double restante = nuevoSaldo - gastoComputo - gastoMobiliario;
        
        double insumos = restante / 2;
        double incentivos = restante / 2;
        
        System.out.println("\n--- Distribución Final ---");
        System.out.printf("Insumos: U$%.2f%n", insumos);
        System.out.printf("Incentivos al personal: U$%.2f%n", incentivos);
        
        if (prestamo > 0) {
            System.out.printf("\nPréstamo requerido: U$%.2f%n", prestamo);
        }
        
        scanner.close();
    }
}