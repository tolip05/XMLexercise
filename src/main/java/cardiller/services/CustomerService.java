package cardiller.services;

import cardiller.domein.enteties.dtos.CustomerXmalRootElement;

public interface CustomerService {
    void importCustomer(CustomerXmalRootElement customerXmalRootElement);
}
