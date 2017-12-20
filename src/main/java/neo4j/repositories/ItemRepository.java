package neo4j.repositories;

import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import neo4j.relationships.In;

import java.util.Map;

public interface ItemRepository extends Neo4jRepository<Item, Long> {
    Item findByProductName(String productName);

    Item findById(Long id);

}
