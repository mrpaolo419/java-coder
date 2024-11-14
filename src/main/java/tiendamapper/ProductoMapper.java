package tiendamapper;

import tiendadto.ProductoDTO;
import tiendamodel.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    // Método para convertir de Producto a ProductoDTO
    public ProductoDTO productoToProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }

        return new ProductoDTO(
                producto.getId(),
                producto.getTitle(),
                producto.getPrice(),
                producto.getDescription(),
                producto.getImage(),
                producto.getCategory()
        );
    }

    // Método para convertir de ProductoDTO a Producto
    public Producto productoDTOToProducto(ProductoDTO productoDTO) {
        if (productoDTO == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setTitle(productoDTO.getTitle());
        producto.setPrice(productoDTO.getPrice());
        producto.setDescription(productoDTO.getDescription());
        producto.setImage(productoDTO.getImage());
        producto.setCategory(productoDTO.getCategory());

        return producto;
    }
}
