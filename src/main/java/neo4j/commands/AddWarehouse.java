package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddWarehouse implements Command{
    @Autowired
    private DatabaseAccess db;


    @Override
    public void execute() {
        System.out.print("Symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone number: ");
        long phoneNumber = Long.parseLong(scanner.nextLine());

        db.addWarehouse(symbol, address, phoneNumber);
    }
}
