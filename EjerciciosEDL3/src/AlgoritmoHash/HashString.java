package AlgoritmoHash;

import java.util.LinkedList;

public class HashString {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash();
        tabla.insertar("a111", "A");
        tabla.insertar("b222", "B");
        tabla.insertar("c333", "C");
        tabla.insertar("d444", "D");
        tabla.insertar("e555", "E");
        tabla.insertar("f666", "G");

        System.out.println("Buscar d444: " + tabla.Buscar("d444"));
        System.out.println("Buscar b222: " + tabla.Buscar("b222"));
        System.out.println("Buscar x999: " + tabla.Buscar("x999")); // No existe, debe retornar null
    }
}

class DiccionarioHash {
    public String clave;
    public String valor;

    public DiccionarioHash(String clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }
}

class TablaHash {
    public LinkedList<DiccionarioHash>[] cubetas;
    public int tamaño = 10;

    @SuppressWarnings("unchecked")
    public TablaHash() {
        cubetas = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            cubetas[i] = new LinkedList<>();
        }
    }

    public int indiceLlaveString(String clave){
        return Math.abs(clave.hashCode()) % tamaño;
    }

    public void insertar(String clave, String valor){
        int indice = indiceLlaveString(clave);
        LinkedList<DiccionarioHash> lista = cubetas[indice];

        // Buscar si la clave ya existe
        for (DiccionarioHash par : lista) {
            if (par.clave.equals(clave)) {
                // Ya existe → actualizamos el valor
                par.valor = valor;
                return;
            }
        }
        // No existe → lo agregamos a la lista
        lista.add(new DiccionarioHash(clave, valor));
    }

    public String Buscar(String clave){
        int indice = indiceLlaveString(clave);
        for (DiccionarioHash par : cubetas[indice]) {
            if (par.clave.equals(clave)) {
                return par.valor;
            }
        }
        return null;
    }

    

}