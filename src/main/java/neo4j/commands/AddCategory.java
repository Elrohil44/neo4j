package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCategory implements Command{
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        db.addCategory(name);
    }
}
