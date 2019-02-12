package cardiller.services;

import cardiller.domein.enteties.dtos.CarExportDto;
import cardiller.domein.enteties.dtos.CarExportRootDto;
import cardiller.domein.enteties.dtos.CarImportRootDto;

public interface CarService {
    void importCars(CarImportRootDto carImportRootDto);

    CarExportRootDto exportCars();
}
