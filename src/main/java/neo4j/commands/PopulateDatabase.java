package neo4j.commands;

import neo4j.DatabaseAccess;
import neo4j.nodes.Category;
import neo4j.nodes.Customer;
import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import neo4j.relationships.Bought;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PopulateDatabase implements Command {
    @Autowired
    private DatabaseAccess db;

    DataFactory df = new DataFactory();

    @Override
    public void execute() {
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Warehouse> warehouses = new ArrayList<>();

        for (int i = 0; i<30; i++){
            warehouses.add(db.addWarehouse(df.getRandomChars(2), df.getAddress(),
                    Long.parseLong(df.getNumberText(9))));
            categories.add(db.addCategory(df.getRandomWord()));
            items.add(db.addItem(df.getRandomWord(),
                    (double) df.getNumberBetween(100, 10000) / 100));
            customers.add(db.addCustomer(df.getFirstName(), df.getLastName(),
                    df.getNumberBetween(18, 100), df.getAddress()));
        }

        for (int i = 0; i<50; i++){
            db.buyItem(df.getItem(customers), df.getItem(items));
            db.addItemToWarehouse(df.getItem(items),
                    df.getItem(warehouses), df.getNumberBetween(30, 1000));
            db.addItemToCategory(df.getItem(items), df.getItem(categories));
        }

        for (int i = 0; i<10; i++){
            Customer c = df.getItem(customers);
            List<Item> itemsBought = c.getItemsBought()
                    .stream()
                    .map(Bought::getItem)
                    .collect(Collectors.toList());
            if (!itemsBought.isEmpty()) {
                db.commentItem(c, df.getItem(itemsBought), df.getRandomText(50, 150));
                db.rateItem(c, df.getItem(itemsBought), df.getNumberBetween(1, 10));
            }
        }


    }
}
