package sn.modelsis.testBackend.gestion_product.service;

import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.entity.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductTypeDTO> getAllProductType();
    ProductTypeDTO addProductType(ProductTypeDTO productTypeDTO);

    ProductTypeDTO entityToDTO(ProductType productType);
    ProductType DTOToEntity(ProductTypeDTO productTypeDTO);
}
