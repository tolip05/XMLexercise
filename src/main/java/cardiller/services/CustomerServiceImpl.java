package cardiller.services;

import cardiller.domein.enteties.Customer;
import cardiller.domein.enteties.dtos.CustomerXmalRootElement;
import cardiller.domein.enteties.dtos.CustomerXmlImportDto;
import cardiller.domein.enteties.repositoris.CustomerRepository;
import cardiller.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void importCustomer(CustomerXmalRootElement customerXmalRootElement) {

        for (CustomerXmlImportDto customerImportDto : customerXmalRootElement.getCustomerImportDtos()) {
            if (!this.validationUtil.isValid(customerImportDto)){
                System.out.println("Something went wrong!");
                continue;
            }
            Customer customer =
                    this.modelMapper.map(customerImportDto,Customer.class);
            customer.setBirthDate(LocalDate.parse(customerImportDto.getBirthDate()));
             this.customerRepository.saveAndFlush(customer);
        }
    }
}
