package neo4j.nodes;

import neo4j.relationships.*;
import org.neo4j.ogm.annotation.*;

import java.util.*;

@NodeEntity
public class Item {
    @GraphId
    private Long id;

    private String productName;
    private float price;
    private Date availableFrom;

    @Relationship(type = "IN")
    private List<In> inWarehouses = new LinkedList<>();

    @Relationship(type = "BOUGHT", direction = Relationship.INCOMING)
    private List<Bought> boughtBy = new LinkedList<>();

    @Relationship(type = "COMMENTED", direction = Relationship.INCOMING)
    private List<Commented> commentedBy = new LinkedList<>();

    @Relationship(type = "RATED", direction = Relationship.INCOMING)
    private List<Rated> ratedBy = new LinkedList<>();

    @Relationship(type = "BELONGS_TO")
    private List<BelongsTo> categories = new LinkedList<>();

    public Item() {
    }

    public Item(String productName, float price) {
        this.productName = productName;
        this.price = price;
        this.availableFrom = new Date();
        this.inWarehouses = new LinkedList<>();
        this.boughtBy = new LinkedList<>();
        this.commentedBy = new LinkedList<>();
        this.ratedBy = new LinkedList<>();
        this.categories = new LinkedList<>();
    }

    public BelongsTo addCategory(neo4j.nodes.Category category){
        BelongsTo belongsTo = new BelongsTo(this, category);
        this.categories.add(belongsTo);
        return belongsTo;
    }

    public In addWarehouse(neo4j.nodes.Warehouse warehouse, int inStock){
        In in = new In(this, warehouse, inStock);
        this.inWarehouses.add(in);
        return in;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public List<In> getInWarehouses() {
        return inWarehouses;
    }

    public List<Bought> getBoughtBy() {
        return boughtBy;
    }

    public List<Commented> getCommentedBy() {
        return commentedBy;
    }

    public List<Rated> getRatedBy() {
        return ratedBy;
    }

    public List<BelongsTo> getCategories() {
        return categories;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d ProductName: %s", this.id, this.productName);
    }
}
