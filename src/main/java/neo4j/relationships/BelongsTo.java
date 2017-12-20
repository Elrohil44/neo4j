package neo4j.relationships;

import neo4j.nodes.Category;
import neo4j.nodes.Item;
import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type="BELONGS_TO")
public class BelongsTo {
    @GraphId
    private Long id;

    @StartNode
    Item item;

    @EndNode
    Category category;

    private Date date;

    public BelongsTo() {
    }

    public BelongsTo(Item item, Category category) {
        this.item = item;
        this.category = category;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s\t----[BELONGS_TO]---->\t%s", this.item, this.category);
    }
}
