package cardiller.web.controllers;

import cardiller.domein.enteties.dtos.CarExportRootDto;
import cardiller.services.CarService;
import cardiller.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.xml.bind.JAXBException;

@Controller
public class ExportController {

    private final String FILE_PATH =
            "D:\\JavaIvanov\\cardiller\\src\\main\\resources\\files\\output\\car-parts.xml";
    private final CarService carService;
    private final XmlParser xmlParser;

    @Autowired
    public ExportController(CarService carService, XmlParser xmlParser) {
        this.carService = carService;
        this.xmlParser = xmlParser;
    }
    public String exportCars() throws JAXBException {
        CarExportRootDto carExportRootDto = this.carService.exportCars();
        this.xmlParser.exportToXml(carExportRootDto,CarExportRootDto.class,FILE_PATH);
        return null;
    }
}
