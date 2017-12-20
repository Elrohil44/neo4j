package neo4j.commands;

import neo4j.DatabaseAccess;
import neo4j.nodes.Category;
import neo4j.nodes.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddItemToCategory implements Command{
    @Autowired
    private DatabaseAccess db;


    @Override
    public void execute() {
        System.out.print("Item id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Category id: ");
        long c_id = Long.parseLong(scanner.nextLine());

        Category category = db.getCategory(c_id);
        Item item = db.getItem(id);

        db.addItemToCategory(item, category);

    }
}
