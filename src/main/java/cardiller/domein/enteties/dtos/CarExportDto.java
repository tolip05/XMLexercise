package cardiller.domein.enteties.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportDto {
@XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Double travelledDistance;
    @XmlElement(name = "parts")
    private PartExportRootDto partExportRootDto;

    public CarExportDto() {
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(Double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartExportRootDto getPartExportRootDto() {
        return this.partExportRootDto;
    }

    public void setPartExportRootDto(PartExportRootDto partExportRootDto) {
        this.partExportRootDto = partExportRootDto;
    }
}
