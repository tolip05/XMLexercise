package cardiller.services;

import cardiller.domein.enteties.Car;
import cardiller.domein.enteties.Part;
import cardiller.domein.enteties.dtos.*;
import cardiller.domein.enteties.repositoris.CarRepository;
import cardiller.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCars(CarImportRootDto carImportRootDto) {
        for (CarImportDto carImportDto : carImportRootDto.getCarImportDtos()) {
            if (!this.validationUtil.isValid(carImportDto)) {
                System.out.println("Something went wrong!");
                continue;
            }
            Car carEntity = this.modelMapper
                    .map(carImportDto, Car.class);
            carEntity.setParts(this.getRandomPartsCollection());

            this.carRepository.saveAndFlush(carEntity);
        }
    }

    @Override
    public CarExportRootDto exportCars() {

        List<Car> carEntities = this.carRepository.findAll();
        List<CarExportDto> carExportDtos = new ArrayList<>();
        for (Car carEntity : carEntities) {
            CarExportDto carExportDto = this.modelMapper.map(carEntity, CarExportDto.class);
            List<PartExportDto> partExportDtos = new ArrayList<>();
            for (Part part : carEntity.getParts()) {
                PartExportDto partExportDto =
                        this.modelMapper.map(part, PartExportDto.class);
                partExportDtos.add(partExportDto);
            }
            PartExportRootDto partExportRootDto = new PartExportRootDto();
            partExportRootDto.setPartExportDtos(partExportDtos);
            carExportDto.setPartExportRootDto(partExportRootDto);
            carExportDtos.add(carExportDto);
        }
        CarExportRootDto carExportRootDto = new CarExportRootDto();
        carExportRootDto.setCarExportDtos(carExportDtos);


        return carExportRootDto;
    }

    private List<Part> getRandomPartsCollection() {
        return this.partService.getRandomParts();
    }
}
