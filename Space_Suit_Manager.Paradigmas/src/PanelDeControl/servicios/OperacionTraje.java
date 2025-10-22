package PanelDeControl.servicios;

import Space_Suit_Manager.modelo.Traje_Espacial;

public interface OperacionTraje {

    void agregarTraje(Traje_Espacial traje);

    void listarTrajes();

    Traje_Espacial buscarTraje(String id);

    void actualizarTraje(String id, Traje_Espacial nuevoTraje);

    void eliminarTraje(String id);

    void guardarArchivo();

    /**
     * Lee el archivo y carga el arreglo interno.
     * Devuelve el primer traje leído (o null si no hay datos).
     */
    Traje_Espacial leerArchivo();
}
