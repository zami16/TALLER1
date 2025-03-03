import java.util.Scanner;

public class ReporteHeladeria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int PRECIO_LIMON = 2500;
        final int PRECIO_NUEZ = 2800;
        final int PRECIO_LULO = 2600;
        final int PRECIO_FRESA = 2000;
        final int PRECIO_CREMA = 3000;

        int totalLimon = 0, totalNuez = 0, totalLulo = 0, totalFresa = 0, totalCrema = 0;
        
        System.out.print("Ingrese el número de facturas: ");
        int numFacturas = sc.nextInt();
 
        for (int i = 0; i < numFacturas; i++) {
            System.out.println("\nFactura " + (i + 1) + ":");
            System.out.print("Ingrese el número de items en la factura: ");
            int numItems = sc.nextInt();

            for (int j = 0; j < numItems; j++) {
                System.out.print("Ingrese el sabor (limon, nuez, lulo, fresa, crema): ");
                String sabor = sc.next().toLowerCase();
                System.out.print("Ingrese la cantidad de paletas de este sabor: ");
                int cantidad = sc.nextInt();

                switch (sabor) {
                    case "limon":
                        totalLimon += cantidad;
                        break;
                    case "nuez":
                        totalNuez += cantidad;
                        break;
                    case "lulo":
                        totalLulo += cantidad;
                        break;
                    case "fresa":
                        totalFresa += cantidad;
                        break;
                    case "crema":
                        totalCrema += cantidad;
                        break;
                    default:
                        System.out.println("Sabor no reconocido.");
                        break;
                }
            }
        }

        int ventaLimon = totalLimon * PRECIO_LIMON;
        int ventaNuez = totalNuez * PRECIO_NUEZ;
        int ventaLulo = totalLulo * PRECIO_LULO;
        int ventaFresa = totalFresa * PRECIO_FRESA;
        int ventaCrema = totalCrema * PRECIO_CREMA;

        int ventaTotal = ventaLimon + ventaNuez + ventaLulo + ventaFresa + ventaCrema;

        System.out.println("\nReporte Semanal de Ventas:");
        System.out.println("Sabor: limon -> Cantidad: " + totalLimon + " -> Valor: $" + ventaLimon);
        System.out.println("Sabor: nuez -> Cantidad: " + totalNuez + " -> Valor: $" + ventaNuez);
        System.out.println("Sabor: lulo -> Cantidad: " + totalLulo + " -> Valor: $" + ventaLulo);
        System.out.println("Sabor: fresa -> Cantidad: " + totalFresa + " -> Valor: $" + ventaFresa);
        System.out.println("Sabor: crema -> Cantidad: " + totalCrema + " -> Valor: $" + ventaCrema);
        System.out.println("Venta Total: $" + ventaTotal);
        
        sc.close();
    }
}
