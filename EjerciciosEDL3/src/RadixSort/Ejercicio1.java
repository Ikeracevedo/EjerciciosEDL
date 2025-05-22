package RadixSort;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;

public class Ejercicio1 {

    //Metodo estatico que retorna un numero entero
    //Recibe como parametro: C
    //Es el ultimo carater del String ingresado
    //Lo compara a ver si esta entre 0 y 1 sino 
    //Pasa a ser restado entre (c-A) eso es como decir C -10
    //A ese numero le suma 10 que desde ahi inician los hexadecimales
    public static int hexaEntero(char c){
        if( c >= '0' && c <= '9'){
            return c - '0';
        }else{
            return 10 + ( c - 'A');
        }
    }
    
    //Metodo estatico de tipo void
    //Recibe el arreglo de String itera sobre el como arr
    //Organiza los datos de tal forma que 
    //Los separa en cubos y va a sacando caracter por caracter
    //Para asi determinar su posicion en la cubeta
    public static void radixSort(String[] arr){
        //Variable de tamaño inicial 
        int tamaño = 0;
        //Itera sobre el arreglo con el puntero S
        for (String s : arr) {
            //Si el tamaño de la palabra es mayor a tamaño lo remplaza para que esa sea la llave
            //Con la cual clasificar las cubetas 
            if (s.length() > tamaño) {
                //Se remplaza tamaño para ser el clasificador
                tamaño = s.length();
            }   
        }

        //Se toma el tamaño del string de iteracion sobre el arreglo
        //Por medio del bucle for se va sacando letra por letra, del string hexadecimal
        //Hasta llegar a 0
        for (int pos = tamaño -1 ; pos >= 0; pos--) {
            //Crea una lista de colas String donde cada espacio de la lista
            //Es para un caracter, en total 16 espacios
            // 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 - A - B - C - D - E - F
            //Luego dentro de cada espacio hay otra lista que recolecta todos los numeors para cada cubeta
            List<Queue<String>> cubetas = new ArrayList<>();
            //Crea los espacios en memoria hasta 16 espacios del hexadecimal
            for (int i = 0; i < 16; i++) {
                //Crea los espacios en memoria
                cubetas.add(new ArrayDeque<String>());
            }

            //Se itera sobre el arreglo con la variable como num  
            for (String num : arr) {
                int digit;
                //Si la posición pos es menor que la longitud del número,
                //Se obtiene el dígito en esa posición, si no, se usa 0 (como relleno a la izquierda)
                int index = num.length() - 1 - (tamaño - 1 - pos);  //Indice real 

                if (index >= 0) {
                    //Guarda el valor en la variable digito llamando la funcion hexaEntero para conocer el valor del hexadecimal
                    //Luego toma la funcion .charAt para enviar a la otra funcion el indice de cada letra
                    digit = hexaEntero(num.charAt(index));
                }else{
                    //En caso de que el numero sea mas corto de la llave normal 
                    digit = 0;
                }
                //Se toma cada posicion de los 16 espacios y en cada espacio lo llena con el numero 
                cubetas.get(digit).add(num);
            }

            int puntero = 0;

            //Por medio de un bucle for y por el iterable de cubo en cubetas recorre cada uno de los 16 espacios
            for (Queue<String> cubo : cubetas) {
                //Por cada cubo se itera en el con la variable val 
                while (!cubo.isEmpty()) {
                   //Se asigna cada número val en orden a arr[puntero]
                    //Incrementamos puntero para llenar el arreglo arr en orden
                    arr[puntero++] = cubo.poll(); 
                }
            }
        }
    }

    //Metodo mostrar lista de tipo void
    //Recibe como parametro: un arreglo de tipo String
    //Para asi iterar sobre el e ir mostrando dato por dato 
    public static void mostrarLista(String[] arr){
        //Recorre el arreglo como s, donde s representa cada numero hexadecimal
       for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        //Arreglo de numeros hexadecimales
        String[] numerosHexadecimales = {"1C8", "A89", "401", "16C", "1E2", "173"};

        System.out.println("Antes de ordenar ");
        mostrarLista(numerosHexadecimales);
        //Se invoca la funcion de RadixSort
        radixSort(numerosHexadecimales);

        System.out.println("Después de ordenar:");
        mostrarLista(numerosHexadecimales);
    }
}
