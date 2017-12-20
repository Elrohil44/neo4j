package neo4j.commands;

import neo4j.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCustomer implements Command {
    @Autowired
    private DatabaseAccess db;


    @Override
    public void execute() {
        System.out.print("Firstname: ");
        String firstName = scanner.nextLine();

        System.out.print("Lastname: ");
        String lastName = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Address: ");
        String address = scanner.nextLine();

        db.addCustomer(firstName, lastName, age, address);
    }
}
