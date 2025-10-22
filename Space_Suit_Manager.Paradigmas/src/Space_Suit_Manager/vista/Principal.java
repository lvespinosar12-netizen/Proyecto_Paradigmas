package Space_Suit_Manager.vista;

import java.io.IOException;
import java.util.Scanner;

import PanelDeControl.servicios.ImplementacionOperacionTraje;
import Space_Suit_Manager.modelo.Traje_Espacial;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ImplementacionOperacionTraje operacion = new ImplementacionOperacionTraje();
        Traje_Espacial traje = null;
        int opcion;

        do {
            System.out.println("\n===== MENÚ TRAJE ESPACIAL =====");
            System.out.println("1. Crear traje espacial");
            System.out.println("2. Mostrar traje espacial");
            System.out.println("3. Guardar en archivo");
            System.out.println("4. Leer desde archivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1:
                    traje = operacion.crearTraje_Espacial();
                    break;

                case 2:
                    if (traje != null) {
                        operacion.mostrarTraje_Espacial(traje);
                    } else {
                        System.out.println("No hay traje creado aún.");
                    }
                    break;

                case 3:
                    operacion.guardarArchivo();
                    break;

                case 4:
                    Traje_Espacial trajeLeido = operacion.leerArchivo();
                    if (trajeLeido != null) {
                        System.out.println("\n=== Primer traje leído desde archivo ===");
                        operacion.mostrarTraje_Espacial(trajeLeido);
                    } else {
                        System.out.println("No se cargó ningún traje desde archivo.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
