package sn.modelsis.testBackend.gestion_product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sn.modelsis.testBackend.gestion_product.dto.ProductDTO;
import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.entity.Product;
import sn.modelsis.testBackend.gestion_product.entity.ProductType;
import sn.modelsis.testBackend.gestion_product.repository.ProductRepository;
import sn.modelsis.testBackend.gestion_product.repository.ProductTypeRepository;
import sn.modelsis.testBackend.gestion_product.service.impl.ProductServiceImpl;
import sn.modelsis.testBackend.gestion_product.service.impl.ProductTypeServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @Test
    public void testGetAllProducts() {

        when(productRepository.findAll()).thenReturn(Arrays.asList(
            new Product(1L, "Iphone", new Date(),new ProductType()),
            new Product(2L, "Dell 4k", new Date(), new ProductType())
        ));

        List<ProductDTO> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Iphone", result.get(0).getProductName());
    }

    @Test
    public void testAddProduct() {

        ProductDTO expectedProductDto =  new ProductDTO(1L, "Iphone", new Date(), 1L);
        Product savedProductDto = productService.DTOToEntity(expectedProductDto);
        when(productRepository.save(savedProductDto)).thenReturn(savedProductDto);

        assertNotNull(savedProductDto);
        assertNotNull(savedProductDto.getId());
    }

    @Test
    public void testUpdateProduct() {

        ProductDTO expectedProductDto =  new ProductDTO(1L, "Iphone", new Date(), 1L);
        Product savedProductDto = productService.DTOToEntity(expectedProductDto);
        when(productRepository.save(savedProductDto)).thenReturn(savedProductDto);

        assertNotNull(savedProductDto);
        assertNotNull(savedProductDto.getId());
    }


}
