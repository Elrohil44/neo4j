package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GetShortestPath implements Command {
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Node1 id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Node2 id: ");
        long id1 = Long.parseLong(scanner.nextLine());

        Object node1 = db.getEntity(id);
        Object node2 = db.getEntity(id1);

        System.out.println(db.getShortestPath(node1, node2).describe());
    }
}
