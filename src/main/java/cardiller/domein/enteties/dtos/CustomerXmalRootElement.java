package cardiller.domein.enteties.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerXmalRootElement {

    @XmlElement(name = "customer")
    private CustomerXmlImportDto[] customerImportDtos;

    public CustomerXmalRootElement() {
    }

    public CustomerXmlImportDto[] getCustomerImportDtos() {
        return this.customerImportDtos;
    }

    public void setCustomerImportDtos(CustomerXmlImportDto[] customerImportDtos) {
        this.customerImportDtos = customerImportDtos;
    }
}
