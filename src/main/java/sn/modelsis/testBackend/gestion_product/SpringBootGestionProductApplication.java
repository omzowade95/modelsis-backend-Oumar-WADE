package sn.modelsis.testBackend.gestion_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.modelsis.testBackend.gestion_product.dto.ProductDTO;
import sn.modelsis.testBackend.gestion_product.dto.ProductTypeDTO;
import sn.modelsis.testBackend.gestion_product.repository.ProductRepository;
import sn.modelsis.testBackend.gestion_product.repository.ProductTypeRepository;
import sn.modelsis.testBackend.gestion_product.service.ProductService;
import sn.modelsis.testBackend.gestion_product.service.ProductTypeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootGestionProductApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeService productTypeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGestionProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
			List de type de produit
		 */
		List<ProductTypeDTO> productTypeDTOS = new ArrayList<>(List.of(
				new ProductTypeDTO(1L, "Smartphone"),
				new ProductTypeDTO(2L, "Laptop"),
				new ProductTypeDTO(3L, "Screen")
		));

		/*
			List de produit
		 */

		List<ProductDTO> productDTOS = new ArrayList<>(List.of(
				new ProductDTO(1L, "Iphone", new Date(), 1L),
				new ProductDTO(2L, "Dell", new Date(), 2L),
				new ProductDTO(3L, "HP 4K", new Date(), 3L)
		));

		/*
			On ajoute d'abord des types de produit puis ensuite des produits
		 */

		productTypeDTOS.stream().forEach(productTypeDTO -> productTypeService.addProductType(productTypeDTO));
		productDTOS.stream().forEach(productDTO -> productService.addProduct(productDTO));
	}

}
