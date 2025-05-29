package AlgoritmoHash;

import java.util.LinkedList;
//Clase principal llamada HashInteger por ser el algoritmo hash pero solo para claves enteras
public class HashInteger {
    public static void main(String[] args) {
        //Se crea una instancia de la clase TablaHash
        //Donde esta trabajara las funciones de insertar y buscar simulando una tabla Hash
        TablaHash tabla = new TablaHash();
        tabla.insertar(5, "A");
        tabla.insertar(6, "B");
        tabla.insertar(3, "C");
        tabla.insertar(15, "D");
        tabla.insertar(25, "E");
        tabla.insertar(56, "G");
        //Salidas de los resultados 
        System.out.println("Buscar 15: " + tabla.Buscar(15));
        System.out.println("Buscar 40: " + tabla.Buscar(6));
    }
}
//Clase DiccionarioHash donde esta permite crear nuevos conjuntos de clave - valor
class DiccionarioHash {
    //Variables clase y valor publicas
    //Para acceder mas facilmente desde todo el programa
    public int clave;
    public String valor;

    //Constructor necesario para cada par que se desee organizar en la TablaHash
    public DiccionarioHash(int clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }
}
//Clase TablaHash donde se almacenan los pares ordenados y se orgnizan los datos
class TablaHash {
    //Variables de tipo publico de facil acceso
    //Crea una lista enlazada de tipo DiccionarioHash donde se llama cubetas simulando
    //El ordenamiento por cubetas para facilitar su entendimiento 
    public LinkedList<DiccionarioHash>[] cubetas;
    //Tamaño del numero de cubetas, fundamental para calcular las llaves y para saber hasta donde
    //Puede llegar el indice de las cubetas
    public int tamaño = 10;

    @SuppressWarnings("unchecked")
    //Constructor de la clase TablaHash donde no recibe parametros
    //Su finalidad es crear cada una de las cubetas para asi guardar los pares o diccionarios
    public TablaHash() {
        //En cubetas crea una lista enlazada hasta el tamaño declaro en la variable tamaño
        cubetas = new LinkedList[tamaño];
        //Crea una estructura repetitiva donde inicia desde el punto 0 de la lista enlazada hasta tamaño
        for (int i = 0; i < tamaño; i++) {
            //Cada espacio en memoria del arreglo cubetas los llena con una lista enlazada
            cubetas[i] = new LinkedList<>();
        }
    }
    
    //Funcion escencial para saber en el indice de cada clave
    //Por medio de esta funcion se conoce en que posicion de cubetas ubicarse para insertar o buscar
    //Recibe como parametros y retorna el valor del indice 
    public int indiceLlaveEntero(int clave){
        //Math.abs es una funcion que permite sacar el valor absoluto para no tener inconvenientes con el calculo
        //Hace el modulo con el tamaño para asi saber en que posicion debe moverse siempre y cuando no se pase
        //Del tamaño declarado desde un inicio
        return Math.abs(clave) % tamaño;
    }
    //Funcion insetar donde recibe como parametros la clave y el valor
    public void insertar(int clave, String valor){
        //Calcula el indice por la funcion indiceLlaveEntero y retornando a la variable indice
        int indice = indiceLlaveEntero(clave);
        //Se ubica en una lista enlazada llamada lista en la posicion cubetas[indice]
        LinkedList<DiccionarioHash> lista = cubetas[indice];
        // Buscar si la clave ya existe
        for (DiccionarioHash par : lista) {
            //Compara si la clave coincide con alguna que este en la lista enlazada
            if (par.clave == clave) {
                // Si ya existe y actualizamos el valor
                par.valor = valor;
                return;
            }
        }
        // Si no existe y  lo agregamos a la lista creando una instancia de DiccionarioHash
        lista.add(new DiccionarioHash(clave, valor));
    }

    //Funcion buscar que recibe como parametro clave
    public String Buscar(int clave){
        //Calcula su indice por medio de su clave
        int indice = indiceLlaveEntero(clave);
        //Recorre la lista donde esta ese indice 
        for (DiccionarioHash par : cubetas[indice]) {
            //Comparando cada uno por clave si lo encuentra retorna su valor
            if (par.clave == clave) {
                return par.valor;
            }
        }
        //En caso de no estar devuelve null
        return null;
    }

    

}