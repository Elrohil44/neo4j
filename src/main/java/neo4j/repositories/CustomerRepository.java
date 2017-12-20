package neo4j.repositories;

import neo4j.nodes.Customer;
import neo4j.nodes.Warehouse;
import org.neo4j.cypher.internal.frontend.v2_3.ast.functions.Str;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface CustomerRepository extends Neo4jRepository<Customer, Long> {
    Customer findByLastNameAndFirstName(String lastName, String FirstName);

    Customer findByLastName(String lastName);

    Customer findById(Long id);

    @Query("MATCH p=shortestPATH((c:Customer)-[r*]-(w:Warehouse)) " +
            "WHERE id(c)={c} AND id(w)={w} " +
            "RETURN nodes(p) as nodes, relationships(p) as relationships")
    Iterable<Map<String, Object>> shortestPath(@Param("c") Customer customer, @Param("w") Warehouse w);



}
