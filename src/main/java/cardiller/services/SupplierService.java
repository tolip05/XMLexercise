package cardiller.services;

import cardiller.domein.enteties.Supplier;
import cardiller.domein.enteties.dtos.SupplierImportRootDto;

public interface SupplierService {
    void importSuppliers(SupplierImportRootDto supplierImportDtoRoot);
    Supplier getRandomSupplier();
}
