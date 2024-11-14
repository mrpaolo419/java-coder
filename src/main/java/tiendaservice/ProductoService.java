package tiendaservice;


import java.util.List;

import tiendadto.ProductoDTO;

public interface ProductoService {

    // Obtener un producto por su ID
    ProductoDTO getProductoById(Long id);

    // Crear un nuevo producto
    ProductoDTO createProducto(ProductoDTO productoDTO);

    // Obtener todos los productos
    List<ProductoDTO> getAllProductos();

    // Actualizar un producto existente por su ID
    void updateProducto(Long id, ProductoDTO productoDTO);

    // Eliminar un producto por su ID
    void deleteProducto(Long id);
}
