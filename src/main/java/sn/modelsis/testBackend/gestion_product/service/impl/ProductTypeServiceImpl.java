package sn.modelsis.testBackend.gestion_product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.entity.ProductType;
import sn.modelsis.testBackend.gestion_product.repository.ProductTypeRepository;
import sn.modelsis.testBackend.gestion_product.service.ProductTypeService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private  ProductTypeRepository productTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductTypeDTO> getAllProductType() {
        List<ProductType> productTypes = productTypeRepository.findAll();
        return productTypes.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductTypeDTO addProductType(ProductTypeDTO productTypeDTO) {

        log.info("Ajout du type de produit !");
        return entityToDTO(productTypeRepository.save(DTOToEntity(productTypeDTO)));
    }

    @Override
    public ProductTypeDTO entityToDTO(ProductType productType) {
        return modelMapper.map(productType, ProductTypeDTO.class);
    }

    @Override
    public ProductType DTOToEntity(ProductTypeDTO productTypeDTO) {
        return modelMapper.map(productTypeDTO, ProductType.class);
    }
}
