import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Producto> Carrito;

    public Cliente(String nombre, String apellido, List<Producto> carrito) {
        this.nombre = nombre;
        this.apellido = apellido;
        Carrito = carrito;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public List<Producto> getCarrito() {return Carrito;}

    public void setCarrito(List<Producto> carrito) {Carrito = carrito;}

    public void agregarProducto(Producto producto){
        Carrito.add(producto);
    }

    public double calcularTotal(){
        double sumaTotal = 0.0;
        for (Producto producto : Carrito){
            sumaTotal += producto.getPrecio();
       }
        return sumaTotal;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Carrito=" + Carrito +
                '}';
    }
}

