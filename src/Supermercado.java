import java.util.List;

public class Supermercado {
    private List<Producto> inventario;


    public Supermercado(List<Producto> inventario) {
        this.inventario = inventario;
    }

    public List<Producto> getInventario() {
        return inventario;
    }

    public void setInventario(List<Producto> inventario) {
        this.inventario = inventario;
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public Producto buscarProducto(String nombreProducto) {
        for (Producto producto : inventario) {
            if (producto.getNombre() != null && producto.getNombre() == nombreProducto) {
                return producto;
            }
        }
        System.out.println("Producto no encontrado en el inventario");
        return null;
    }

    public void realizarCompra(Cliente cliente) {
        List<Producto> carrito = cliente.getCarrito();
        for(Producto productoCarrito : carrito){
            Producto productoInventario = buscarProducto(productoCarrito.getNombre());
            if(productoCarrito.getCantidadStock() <= productoInventario.getCantidadStock()){
                System.out.println("Compra realizada con éxito.");
                //Limpiar carro
                cliente.getCarrito().clear();
                //restar la cantidad comprada del inventario
                productoInventario.setCantidadStock(productoInventario.getCantidadStock() - productoCarrito.getCantidadStock());
            }else{
                System.out.println("No hay existencias suficientes en el inventario.");
            }
        }
    }

    public void mostrarInventario(){
        if(inventario.isEmpty()){
            System.out.println("El inventario está vacío.");
        }else{
            for(Producto producto : inventario){
                System.out.println(producto);
            }
        }
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "inventario=" + inventario +
                '}';
    }
}
