package neo4j.repositories;

import neo4j.nodes.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {
    Category findByCategoryName(String categoryName);

    Category findById(Long id);
}
