package cardiller.web.controllers;

import cardiller.domein.enteties.dtos.CarImportRootDto;
import cardiller.domein.enteties.dtos.CustomerXmalRootElement;
import cardiller.domein.enteties.dtos.PartImportRootDto;
import cardiller.domein.enteties.dtos.SupplierImportRootDto;
import cardiller.services.CarService;
import cardiller.services.CustomerService;
import cardiller.services.PartService;
import cardiller.services.SupplierService;
import cardiller.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {
    private final String SUPPLIERS_XML_FILE_PATH =
            "D:\\JavaIvanov\\cardiller\\src\\main\\resources\\files\\suppliers.xml";

   private final String PART_XML_FILE_PATH =
           "D:\\JavaIvanov\\cardiller\\src\\main\\resources\\files\\parts.xml";

    private final String CARS_XML_FILE_PATH =
            "D:\\JavaIvanov\\cardiller\\src\\main\\resources\\files\\cars.xml";

    private final String CUSTOMERS_XML_FILE_PATH =
            "D:\\JavaIvanov\\cardiller\\src\\main\\resources\\files\\customers.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final XmlParser xmlParser;

    @Autowired
    public ImportController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.xmlParser = xmlParser;
    }

    public String importSuppliers() throws JAXBException, FileNotFoundException {
        SupplierImportRootDto supplierImportRootDto =
                this.xmlParser.parseXml(SupplierImportRootDto.class,SUPPLIERS_XML_FILE_PATH);
       this.supplierService.importSuppliers(supplierImportRootDto);
        return "Imported suppliers";
    }
    public String importParts() throws JAXBException, FileNotFoundException {
        PartImportRootDto partImportRootDto =
                this.xmlParser.parseXml(PartImportRootDto.class,PART_XML_FILE_PATH);
        this.partService.importParts(partImportRootDto);
        return "Imported parts";
    }

    public String importCars() throws JAXBException, FileNotFoundException {
        CarImportRootDto carImportRootDto =
                this.xmlParser.parseXml(CarImportRootDto.class,CARS_XML_FILE_PATH);
        this.carService.importCars(carImportRootDto);
        return "Imported cars";
    }
    public String importCustomer() throws JAXBException, FileNotFoundException {
        CustomerXmalRootElement customerXmalRootElement =
                this.xmlParser.parseXml(CustomerXmalRootElement.class,CUSTOMERS_XML_FILE_PATH);
        this.customerService.importCustomer(customerXmalRootElement);
        return "Imported customers";
    }
}
