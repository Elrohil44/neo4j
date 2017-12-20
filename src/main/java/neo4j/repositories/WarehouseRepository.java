package neo4j.repositories;

import neo4j.nodes.Warehouse;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface WarehouseRepository extends Neo4jRepository<Warehouse, Long> {
    Warehouse findBySymbol(String symbol);

    Warehouse findById(Long id);
}
