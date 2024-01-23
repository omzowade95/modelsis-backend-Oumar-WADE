package sn.modelsis.testBackend.gestion_product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.entity.ProductType;
import sn.modelsis.testBackend.gestion_product.repository.ProductTypeRepository;
import sn.modelsis.testBackend.gestion_product.service.impl.ProductTypeServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductTypeServiceImplTest {

    @MockBean
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @Test
    public void testGetAllProductType() {

        when(productTypeRepository.findAll()).thenReturn(Arrays.asList(
            new ProductType(1L, "Smartphone", new ArrayList<>()),
            new ProductType(2L, "Laptop", new ArrayList<>())
        ));

        List<ProductTypeDTO> result = productTypeService.getAllProductType();

        assertEquals(2, result.size());
        assertEquals("Smartphone", result.get(0).getProductTypeName());
    }

    @Test
    public void testAddProductType() {

        ProductTypeDTO expectedProductTypeDto =  new ProductTypeDTO(1L, "Iphone");
        ProductType savedProductTypeDto = productTypeService.DTOToEntity(expectedProductTypeDto);
        when(productTypeRepository.save(savedProductTypeDto)).thenReturn(savedProductTypeDto);

        assertNotNull(savedProductTypeDto);
        assertNotNull(savedProductTypeDto.getId());
    }



}
