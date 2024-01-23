package sn.modelsis.testBackend.gestion_product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.modelsis.testBackend.gestion_product.dto.ProductDTO;
import sn.modelsis.testBackend.gestion_product.entity.Product;
import sn.modelsis.testBackend.gestion_product.repository.ProductRepository;
import sn.modelsis.testBackend.gestion_product.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        log.info("Ajout du produit réussi !!");
        return entityToDTO(productRepository.save(DTOToEntity(productDTO)));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null) {
            Product updatedProduct = DTOToEntity(productDTO);
            if(updatedProduct.getProductType() != null) {
                existingProduct.setProductType(updatedProduct.getProductType());
            }
            if(updatedProduct.getProductName() != null) {
                existingProduct.setProductName(updatedProduct.getProductName());
            }

            log.info("Update du produit réussi...");
            return entityToDTO(productRepository.save(existingProduct));
        }

        log.info("Update du produit a échoué...");
        return null;
    }

    @Override
    public ProductDTO entityToDTO(Product product) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Product DTOToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
