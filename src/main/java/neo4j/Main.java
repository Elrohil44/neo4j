package neo4j;


import neo4j.commands.*;
import neo4j.nodes.Category;
import neo4j.nodes.Customer;
import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import neo4j.relationships.In;
import neo4j.repositories.*;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@EnableNeo4jRepositories
public class Main {

    private final static Logger log = (Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner demo(DatabaseAccess db,
                           AddCustomer addCustomer, AddCategory addCategory,
                           AddItem addItem, AddWarehouse addWarehouse,
                           AddItemToCategory addItemToCategory,
                           AddItemToWarehouse addItemToWarehouse,
                           BuyItem buyItem, RateItem rateItem,
                           CommentItem commentItem,
                           PopulateDatabase populateDatabase,
                           GetShortestPath getShortestPath,
                           GetAllRelationships getAllRelationships,
                           EntityRepository entityRepository,
                           CustomerRepository customerRepository,
                           ItemRepository itemRepository
                           ){
        return args -> {
            db.drop();
            populateDatabase.execute();
//            getShortestPath.execute();
//            getAllRelationships.execute();
            ArrayList<Customer> customers = new ArrayList<>();
            customerRepository.findAll().forEach(customer -> {
                if (!customer.getItemsBought().isEmpty()) customers.add(customer);
            });
            //
            // Shortest path
            //
            System.out.println(db.getShortestPath(customers.get(3), customers.get(23)).describe());

            //
            // Relationships
            //
            db.getRelationships(customers.get(23)).forEach(System.out::println);
            System.out.println("Finishing");

        };
    }
}
