package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddItem implements Command {
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Name: ");
        String productName = scanner.nextLine();
        System.out.print("Price: ");
        float price = Float.parseFloat(scanner.nextLine());

        db.addItem(productName, price);
    }
}
