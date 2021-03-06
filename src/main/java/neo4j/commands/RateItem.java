package neo4j.commands;

import neo4j.DatabaseAccess;
import neo4j.nodes.Customer;
import neo4j.nodes.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateItem implements Command {
    @Autowired
    private DatabaseAccess db;

    @Override
    public void execute() {
        System.out.print("Item id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Customer id: ");
        long c_id = Long.parseLong(scanner.nextLine());
        System.out.print("Rating: ");
        int rating = Integer.parseInt(scanner.nextLine());

        Item item = db.getItem(id);
        Customer customer = db.getCustomer(c_id);

        db.rateItem(customer, item, rating);
    }
}
