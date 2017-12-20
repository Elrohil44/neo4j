package neo4j.commands;

import neo4j.DatabaseAccess;
import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddItemToWarehouse implements Command{
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Item id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Warehouse id: ");
        long w_id = Long.parseLong(scanner.nextLine());
        System.out.print("In stock: ");
        int inStock = Integer.parseInt(scanner.nextLine());

        Item item = db.getItem(id);
        Warehouse warehouse = db.getWarehouse(w_id);
        db.addItemToWarehouse(item, warehouse, inStock);
    }
}
