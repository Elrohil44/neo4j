package neo4j.relationships;

import neo4j.nodes.Item;
import neo4j.nodes.Customer;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="RATED")
public class Rated {
//    @Id
//    @GeneratedValue
    @GraphId
    private Long id;
    @StartNode
    Customer customer;
    @EndNode Item item;

    private int rate;
    private Date rateDate;

    public Rated() {
    }

    public Rated(Customer customer, Item item, int rate) {
        this.customer = customer;
        this.item = item;
        this.rate = rate;
        this.rateDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }

    public int getRate() {
        return rate;
    }

    public Date getRateDate() {
        return rateDate;
    }

    @Override
    public String toString() {
        return String.format("%s\t----[RATED]---->\t%s", customer, item);
    }
}
