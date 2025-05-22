package Lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ejercicio1 {
    static Random rand = new Random();
    static ArrayList<Producto> productosEntrada = new ArrayList<>();  
    static ArrayList<Producto> productosSalida = new ArrayList<>();
    public static void main(String[] args){

        for (int i = 0; i < 10; i++) {
            poblarDatos(productosEntrada);
        }
        
        mostrarDatos(productosEntrada);

        Comparator<Producto > compararPorCodigo = Comparator.comparing(Producto :: getCodigo);
        Collections.sort(productosEntrada,compararPorCodigo);
        System.out.println();
        mostrarDatos(productosEntrada);
        sumarVentas(productosEntrada, productosSalida);
        System.out.println();
        mostrarDatos(productosSalida);


    }

    public static void sumarVentas(ArrayList<Producto> productosVendidos, ArrayList<Producto> productosSalida){
        for (Producto producto : productosVendidos) {
            boolean encontrado = false;
            for (Producto salida : productosSalida) {
                if (salida.getCodigo() == producto.getCodigo()) {
                    salida.setCantidadProducto(salida.getCantidadProducto() + producto.getCantidadProducto());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                productosSalida.add(new Producto(
                    producto.getCodigo(),
                    producto.getCantidadProducto(),
                    producto.getPrecioProducto()
                ));
            }
        }
    }
    public static void poblarDatos(ArrayList<Producto> productosVendidos){
        Producto produc = new Producto(1000 + rand.nextInt(11), 1 + rand.nextInt(100), 10 + rand.nextDouble(1000.0));
        productosEntrada.add(produc);
    }

    public static void mostrarDatos(ArrayList<Producto> productos){
        System.out.println();
        System.out.print("Código: " );
        for (Producto producto : productos) {
            System.out.print(" " + producto.getCodigo() + " ");
        }
        System.out.println();
        System.out.print("Cantidad: " );
        for (Producto producto : productos) {
            System.out.print(" " + producto.getCantidadProducto() + " ");
        }
        System.out.println();
        System.out.print("Precio: " );
        for (Producto producto : productos) {
            System.out.print(" " + producto.getPrecioProducto() + " ");
        }
    }
}

class Producto {
    private int codigo;
    private int cantidadProducto;
    private double precioProducto;


    public Producto(int codigo, int cantidadProducto, double precioProducto) {
        this.codigo = codigo;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
}
