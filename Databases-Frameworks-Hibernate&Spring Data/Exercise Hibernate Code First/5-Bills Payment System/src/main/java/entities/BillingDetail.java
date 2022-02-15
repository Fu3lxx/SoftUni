package entities;

import javax.persistence.*;

@Entity
@Table (name = "billing_detail")
@Inheritance (strategy = InheritanceType.JOINED)
public class BillingDetail extends BaseEntity {

    private String number;
    private User user;

    public BillingDetail() {
    }

    @Column (name = "number",nullable = false,unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
