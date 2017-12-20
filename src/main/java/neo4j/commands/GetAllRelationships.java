package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllRelationships implements Command{
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Node id: ");
        long id = Long.parseLong(scanner.nextLine());

        Object node = db.getEntity(id);

        db.getRelationships(node).forEach(System.out::println);
    }
}
