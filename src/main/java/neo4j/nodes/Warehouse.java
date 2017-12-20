package neo4j.nodes;

//import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.*;
//import org.neo4j.ogm.annotation.Id;
import neo4j.relationships.In;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Warehouse {
    @GraphId
    private Long id;

    @Index(unique = true)
    private String symbol;

    private String address;
    private Long phoneNumber;

    @Relationship(type = "IN", direction = Relationship.INCOMING)
    private Set<In> items;

    public Warehouse() {
    }

    public Warehouse(String symbol, String address, Long phoneNumber) {
        this.symbol = symbol;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.items = new HashSet<>();
    }

    private In supplyItem(In in, int count){
        if (items.contains(in)) in.supply(count);
        return in;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAddress() {
        return address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Set<In> getItems() {
        return items;
    }

    public Long getId() {

        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d Address: %s Symbol: %s", this.id, this.address, this.symbol);
    }
}
