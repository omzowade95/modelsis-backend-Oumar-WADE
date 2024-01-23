package sn.modelsis.testBackend.gestion_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.modelsis.testBackend.gestion_product.entity.ProductType;
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
