package cardiller.domein.enteties;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    private Integer discount;

    private Car car;

    private Customer customer;

    public Sale() {
    }

    public Integer getDiscount() {
        return this.discount;
    }

    @Column(name = "discount")
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(
            name = "car_id",referencedColumnName = "id"
    )
    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(
            name = "customer_id",referencedColumnName = "id"
    )
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
