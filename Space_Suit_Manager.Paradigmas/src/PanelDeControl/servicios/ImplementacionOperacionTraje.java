package PanelDeControl.servicios;

import Space_Suit_Manager.modelo.Traje_Espacial;
import java.io.*;
import java.util.Scanner;

public class ImplementacionOperacionTraje implements OperacionTraje {

    private Traje_Espacial[] trajes;
    private int contador;
    private final int MAX_TAMANIO = 100;
    private final String RUTA_ARCHIVO = "trajes_espaciales.dat";

    public ImplementacionOperacionTraje() {
        trajes = new Traje_Espacial[MAX_TAMANIO];
        contador = 0;
    }


    @Override
    public void agregarTraje(Traje_Espacial traje) {
        if (contador < MAX_TAMANIO) {
            trajes[contador++] = traje;
            System.out.println("Traje registrado correctamente.");
        } else {
            System.out.println("No se pueden agregar más trajes, límite alcanzado.");
        }
    }

    @Override
    public void listarTrajes() {
        if (contador == 0) {
            System.out.println("No hay trajes registrados.");
            return;
        }
        System.out.println("=== LISTA DE TRAJES ESPACIALES ===");
        for (int i = 0; i < contador; i++) {
            System.out.println(trajes[i]);
        }
    }

    @Override
    public Traje_Espacial buscarTraje(String id) {
        for (int i = 0; i < contador; i++) {
            if (trajes[i] != null && trajes[i].getId_traje().equalsIgnoreCase(id)) {
                System.out.println("Traje encontrado:");
                System.out.println(trajes[i]);
                return trajes[i];
            }
        }
        System.out.println("No se encontró un traje con ese código.");
        return null;
    }

    @Override
    public void actualizarTraje(String id, Traje_Espacial nuevoTraje) {
        for (int i = 0; i < contador; i++) {
            if (trajes[i] != null && trajes[i].getId_traje().equalsIgnoreCase(id)) {
                trajes[i] = nuevoTraje;
                System.out.println("Traje actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el traje a actualizar.");
    }

    @Override
    public void eliminarTraje(String id) {
        for (int i = 0; i < contador; i++) {
            if (trajes[i] != null && trajes[i].getId_traje().equalsIgnoreCase(id)) {
                for (int j = i; j < contador - 1; j++) {
                    trajes[j] = trajes[j + 1];
                }
                trajes[--contador] = null;
                System.out.println("Traje eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el traje a eliminar.");
    }


    @Override
    public void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeInt(contador);
            for (int i = 0; i < contador; i++) {
                oos.writeObject(trajes[i]);
            }
            System.out.println("Archivo guardado correctamente (" + RUTA_ARCHIVO + ").");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    @Override
    public Traje_Espacial leerArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            int leidos = ois.readInt();
            trajes = new Traje_Espacial[MAX_TAMANIO];
            contador = 0;
            for (int i = 0; i < leidos && i < MAX_TAMANIO; i++) {
                Object obj = ois.readObject();
                if (obj instanceof Traje_Espacial) {
                    trajes[contador++] = (Traje_Espacial) obj;
                }
            }
            System.out.println("Archivo cargado correctamente. Tralles leídos: " + contador);
            return (contador > 0) ? trajes[0] : null;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo, se creará uno nuevo al guardar.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    /**
     * Lee por consola los datos y crea un nuevo Traje_Espacial, lo añade y lo devuelve.
     */
    public Traje_Espacial crearTraje_Espacial() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== CREAR NUEVO TRAJE ESPACIAL ===");
        System.out.print("ID del traje: ");
        String id = teclado.nextLine().trim();

        if (buscarTraje(id) != null) {
            System.out.println("Ya existe un traje con ese ID. Operación cancelada.");
            return null;
        }

        System.out.print("Talla: ");
        String talla = teclado.nextLine().trim();
        System.out.print("Peso soportado (kg): ");
        double peso = 0;
        try {
            peso = Double.parseDouble(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor de peso inválido, se usará 0.0");
        }
        System.out.print("Fecha de inspección (ej: 2025-10-21): ");
        String fecha = teclado.nextLine().trim();

        Traje_Espacial nuevo = new Traje_Espacial(id, talla, peso, fecha);
        agregarTraje(nuevo);
        return nuevo;
    }

    /**
     * Muestra un traje dado por consola.
     */
    public void mostrarTraje_Espacial(Traje_Espacial traje) {
        if (traje == null) {
            System.out.println("No hay traje para mostrar.");
            return;
        }
        System.out.println("=== DATOS DEL TRAJE ===");
        System.out.println(traje.toString());
    }
}
