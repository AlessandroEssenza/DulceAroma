package vista;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner teclado = new Scanner(System.in);
    private final ProductoDAO dao = new ProductoDAO();

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("   CAFETERÍA DULCE AROMA");
            System.out.println("==============================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    agregarProducto();
                    break;

                case 2:
                    consultarProductos();
                    break;

                case 3:
                    actualizarProducto();
                    break;

                case 4:
                    eliminarProducto();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

    }

    private void agregarProducto() {

        Producto producto = new Producto();

        System.out.print("Nombre: ");
        producto.setNombre(teclado.nextLine());

        System.out.print("Descripción: ");
        producto.setDescripcion(teclado.nextLine());

        System.out.print("Precio: ");
        producto.setPrecio(teclado.nextDouble());

        System.out.print("Stock: ");
        producto.setStock(teclado.nextInt());

        teclado.nextLine();

        if (dao.insertarProducto(producto)) {
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("No fue posible agregar el producto.");
        }

    }

    private void consultarProductos() {

        System.out.println("Entró al método consultarProductos");
        
        List<Producto> lista = dao.consultarProductos();

        System.out.println("\nLISTA DE PRODUCTOS");

        for (Producto p : lista) {

            System.out.println("----------------------------");
            System.out.println("ID: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Descripción: " + p.getDescripcion());
            System.out.println("Precio: $" + p.getPrecio());
            System.out.println("Stock: " + p.getStock());

        }

    }

    private void actualizarProducto() {

        Producto producto = new Producto();

        System.out.print("ID del producto: ");
        producto.setId(teclado.nextInt());
        teclado.nextLine();

        System.out.print("Nuevo nombre: ");
        producto.setNombre(teclado.nextLine());

        System.out.print("Nueva descripción: ");
        producto.setDescripcion(teclado.nextLine());

        System.out.print("Nuevo precio: ");
        producto.setPrecio(teclado.nextDouble());

        System.out.print("Nuevo stock: ");
        producto.setStock(teclado.nextInt());

        teclado.nextLine();

        if (dao.actualizarProducto(producto)) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("No fue posible actualizar el producto.");
        }

    }

    private void eliminarProducto() {

        System.out.print("ID del producto: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (dao.eliminarProducto(id)) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No fue posible eliminar el producto.");
        }

    }

}