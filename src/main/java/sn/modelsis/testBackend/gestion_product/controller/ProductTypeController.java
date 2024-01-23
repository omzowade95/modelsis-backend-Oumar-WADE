package sn.modelsis.testBackend.gestion_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.service.impl.ProductTypeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @GetMapping
    public List<ProductTypeDTO> getAllProductType() {
        return productTypeService.getAllProductType();
    }

    @PostMapping
    public ProductTypeDTO addProducType(@RequestBody ProductTypeDTO productTypeDTO) {
        return productTypeService.addProductType(productTypeDTO);
    }

}
