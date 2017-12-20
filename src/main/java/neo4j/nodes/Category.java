package neo4j.nodes;

import neo4j.relationships.BelongsTo;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@NodeEntity
public class Category {
    @GraphId
    private Long id;

    @Index(unique = true)
    private String categoryName;

    @Relationship(type="BELONGS_TO", direction = Relationship.INCOMING)
    private Set<BelongsTo> items;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        items = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Set<BelongsTo> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return String.format("ID: %d CategoryName: %s", this.id, this.categoryName);
    }
}
