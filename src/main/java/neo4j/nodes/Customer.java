package neo4j.nodes;

//import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.GraphId;
//import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import neo4j.relationships.Bought;
import neo4j.relationships.Commented;
import neo4j.relationships.Rated;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@NodeEntity
public class Customer {
    @GraphId
    private Long id;

    private String firstName;
    private String lastName;

    private int age;
    private String address;
    private Date registrationDate;

    @Relationship(type = "RATED")
    private List<Rated> itemsRated = new LinkedList<>();

    @Relationship(type = "COMMENTED")
    private List<Commented> itemsCommented = new LinkedList<>();

    @Relationship(type = "BOUGHT")
    private List<Bought> itemsBought = new LinkedList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.itemsBought = new LinkedList<>();
        this.itemsCommented = new LinkedList<>();
        this.itemsRated = new LinkedList<>();
        this.registrationDate = new Date();
    }

    public Commented commentItem(neo4j.nodes.Item item, String message) {
        Commented comment = new Commented(this, item, message);
        this.itemsCommented.add(comment);
        return comment;
    }

    public Bought buyItem(neo4j.nodes.Item item){
        Bought purchase = new Bought(this, item);
        this.itemsBought.add(purchase);
        return purchase;
    }


    public Rated rateItem(neo4j.nodes.Item item, int rate){
        Rated rating = new Rated(this, item, rate);
        this.itemsRated.add(rating);
        return rating;
    }

    public Long getId() {
        return id;
    }

    public List<Rated> getItemsRated() {
        return itemsRated;
    }

    public List<Commented> getItemsCommented() {
        return itemsCommented;
    }

    public List<Bought> getItemsBought() {
        return itemsBought;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " " + firstName + lastName + " Age: " + age + " Address: " + address;
    }
}
