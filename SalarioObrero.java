import java.util.Scanner;

public class SalarioObrero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese las horas trabajadas esta semana: ");
        double horas = scanner.nextDouble();
        double salario;
        
        if (horas <= 40) {
            salario = horas * 5000;
        } else {
            double horasExtras = horas - 40;
            salario = (40 * 5000) + (horasExtras * 5000 * 1.2);
        }
        
        System.out.printf("El salario semanal es: $%.2f%n", salario);
        
        scanner.close();
    }
}