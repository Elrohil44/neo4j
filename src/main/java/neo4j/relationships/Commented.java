package neo4j.relationships;

import neo4j.nodes.Item;
import neo4j.nodes.Customer;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="COMMENTED")
public class Commented {
//    @Id
//    @GeneratedValue
    @GraphId
    private Long id;
    @StartNode
    Customer customer;

    @EndNode
    Item item;

    private String message;
    private Date date;

    public Commented() {
    }

    public Commented(Customer customer, Item item, String message) {
        this.customer = customer;
        this.item = item;
        this.message = message;
        this.date = new Date();
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

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s\t----[COMMENTED]---->\t%s", customer, item);
    }
}
