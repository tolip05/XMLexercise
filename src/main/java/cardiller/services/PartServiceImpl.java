package cardiller.services;

import cardiller.domein.enteties.Part;
import cardiller.domein.enteties.Supplier;
import cardiller.domein.enteties.dtos.PartImportDto;
import cardiller.domein.enteties.dtos.PartImportRootDto;
import cardiller.domein.enteties.repositoris.PartRepository;
import cardiller.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ValidationUtil validationUtil,
                           SupplierService supplierService, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importParts(PartImportRootDto partImportRootDto) {
        for (PartImportDto partImportDto : partImportRootDto.getPartImportDtos()) {
            if (!this.validationUtil.isValid(partImportDto)){
                System.out.println("Something is wrong");
                continue;
            }
            Part part = this.modelMapper.map(partImportDto,Part.class);
            part.setSupplier(this.getRandomSupplier());
            this.partRepository.saveAndFlush(part);
        }
    }

    @Override
    public List<Part> getRandomParts() {
        List<Part>parts = new ArrayList<>();
        Random random = new Random();
        int length = random.nextInt(11) + 10;
        List<Part> partEntities = this.partRepository.findAll();
        for (int i = 0; i < length; i++) {
            Part part = partEntities
                    .get(random.nextInt((int) (this.partRepository.count() -1)) + 1);
            if (parts.contains(part)){
                i--;
            }else{
                parts.add(part);
            }
        }
        return parts;
    }

    private Supplier getRandomSupplier() {
        return this.supplierService.getRandomSupplier();
    }
}
