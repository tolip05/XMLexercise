package cardiller.domein.enteties.dtos;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerXmlImportDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "is-young-driver")
    private Boolean isYongDriver;

    public CustomerXmlImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYongDriver() {
        return this.isYongDriver;
    }

    public void setYongDriver(Boolean yongDriver) {
        isYongDriver = yongDriver;
    }
}
