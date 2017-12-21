package neo4j.repositories;

import org.neo4j.graphdb.Entity;
import org.neo4j.graphdb.Node;
import org.neo4j.ogm.model.Result;
import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EntityRepository extends Neo4jRepository<Entity, Long>{
    @Query("MATCH path=shortestPATH((n1)-[*]-(n2)) WHERE " +
            "id(n1)={n1} AND id(n2)={n2} " +
            "RETURN nodes(path) as npath, relationships(path) as relationships")
    Result getShortestPath(@Param("n1") Object n1, @Param("n2") Object n2);

    @Query("MATCH (e)-[r]-(b) WHERE " +
            "id(e)={e} RETURN r, e, b")
    Result getRelations(@Param("e") Object e);

    @Depth(2)
    @Query("MATCH (e)-[]->(b) RETURN e LIMIT 100")
    Result get100();

    @Query("MATCH (n) WHERE id(n)={n} RETURN n")
    Object findById(@Param("n") Long id);

}
