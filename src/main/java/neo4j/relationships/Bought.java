package neo4j.relationships;

import neo4j.nodes.Item;
import neo4j.nodes.Customer;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="BOUGHT")
public class Bought {
    @GraphId
    private Long id;
    @StartNode
    Customer customer;
    @EndNode Item item;

    private Date purchaseDate;

    public Bought() {
    }

    public Bought(Customer customer, Item item) {
        this.customer = customer;
        this.item = item;
        this.purchaseDate = new Date();
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return String.format("%s\t----[BOUGHT]---->\t%s", customer, item);
    }
}
