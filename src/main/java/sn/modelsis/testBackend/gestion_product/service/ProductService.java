package sn.modelsis.testBackend.gestion_product.service;

import sn.modelsis.testBackend.gestion_product.dto.ProductDTO;
import sn.modelsis.testBackend.gestion_product.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    ProductDTO entityToDTO(Product product);
    Product DTOToEntity(ProductDTO productDTO);
}
