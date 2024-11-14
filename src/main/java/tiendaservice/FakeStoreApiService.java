package tiendaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tiendadto.ProductoDTO;
import tiendamodel.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreApiService implements ProductoService {

    private final RestTemplate restTemplate;
    private final String apiUrl = "https://fakestoreapi.com/products";

    @Autowired
    public FakeStoreApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        return restTemplate.postForObject(apiUrl, productoDTO, ProductoDTO.class);
    }

    @Override
    public void updateProducto(Long id, ProductoDTO productoDTO) {
        String url = apiUrl + "/" + id;
        HttpEntity<ProductoDTO> requestEntity = new HttpEntity<>(productoDTO);
        restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Void.class);
    }

    @Override
    public void deleteProducto(Long id) {
        String url = apiUrl + "/" + id;
        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
        Producto[] productosArray = restTemplate.getForObject(apiUrl, Producto[].class);
        return Arrays.stream(productosArray)
                .map(producto -> new ProductoDTO(
                        producto.getId(),
                        producto.getTitle(),
                        producto.getPrice(),
                        producto.getDescription(),
                        producto.getImage(),
                        producto.getCategory()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO getProductoById(Long id) {
        String url = apiUrl + "/" + id;
        Producto producto = restTemplate.getForObject(url, Producto.class);
        return new ProductoDTO(
                producto.getId(),
                producto.getTitle(),
                producto.getPrice(),
                producto.getDescription(),
                producto.getImage(),
                producto.getCategory()
        );
    }
}
