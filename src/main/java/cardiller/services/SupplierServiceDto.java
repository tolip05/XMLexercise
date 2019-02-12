package cardiller.services;

import cardiller.domein.enteties.Supplier;
import cardiller.domein.enteties.dtos.SupplierImportDto;
import cardiller.domein.enteties.dtos.SupplierImportRootDto;
import cardiller.domein.enteties.repositoris.SupplierRepository;
import cardiller.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SupplierServiceDto implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceDto(SupplierRepository supplierRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importSuppliers(SupplierImportRootDto supplierImportDtoRoot) {
        for (SupplierImportDto supplierImportDto : supplierImportDtoRoot.getSupplierImportDtos()) {
            if (!this.validationUtil.isValid(supplierImportDto)){
                System.out.println("Something is wrong");
                continue;
            }
            Supplier supplier =
                    this.modelMapper.map(supplierImportDto,Supplier.class);
            this.supplierRepository.saveAndFlush(supplier);
        }
    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        return this.supplierRepository
                .findById((long) (random.nextInt((int) (this.supplierRepository.count()-1)) + 1)).orElse(null);

    }
}
