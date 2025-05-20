import java.util.ArrayList;
import java.util.Random;

public class Ejercicio1 {
    static Random rand = new Random();

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        
        poblarDatos(productos);
        poblarDatos(productos);
        poblarDatos(productos);
        poblarDatos(productos);
        poblarDatos(productos);

        mostrarDatos(productos);

        //No supe como hacer la funcion sumarListas
    }

    public static ArrayList<Producto> poblarDatos(ArrayList<Producto> productosVendidos){
        Producto produc = new Producto(1000 + rand.nextInt(1010), rand.nextInt(100), rand.nextDouble(1000.0));
        productosVendidos.add(produc);
        return productosVendidos;
    }

    public static void mostrarDatos(ArrayList<Producto> productosVendidos){
        for (Producto producto : productosVendidos) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Cantidad: " + producto.getCantidadProducto());
            System.out.println("Precio: " + producto.getPrecioProducto());
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
