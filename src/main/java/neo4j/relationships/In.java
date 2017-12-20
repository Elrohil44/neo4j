package neo4j.relationships;

import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="IN")
public class In {
    @GraphId
    private Long id;
    @StartNode Item item;
    @EndNode Warehouse warehouse;
    private Date from;
    private int inStock;

    public In() {
    }

    public In(Item item, Warehouse warehouse, int inStock) {
        this.item = item;
        this.warehouse = warehouse;
        this.inStock = inStock;
        this.from = new Date();
    }

    public void supply(int count) {
        inStock += count;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Date getFrom() {
        return from;
    }

    public int getInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return String.format("%s\t----[IN]---->\t%s", item, warehouse);
    }
}
