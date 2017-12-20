package neo4j;

import neo4j.model.Path;
import neo4j.nodes.Category;
import neo4j.nodes.Customer;
import neo4j.nodes.Item;
import neo4j.nodes.Warehouse;
import neo4j.repositories.*;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

@Component
public class DatabaseAccess {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session = null;

    private Session getSession(){
        if (session == null){
            session = sessionFactory.openSession();
        }
        return session;
    }

    public Item addItem(String productName, float price){
        Item item = new Item(productName, price);

        itemRepository.save(item);
        return item;
    }

    public Category addCategory(String name){
        Category category = new Category(name);

        categoryRepository.save(category);
        return category;
    }

    public Warehouse addWarehouse(String symbol, String address, Long phoneNumber){
        Warehouse warehouse = new Warehouse(symbol, address, phoneNumber);

        warehouseRepository.save(warehouse);
        return warehouse;
    }

    public Customer addCustomer(String firstName, String lastName, int age, String address){
        Customer customer = new Customer(firstName, lastName, age, address);

        customerRepository.save(customer);
        return customer;
    }

    public Item getItem(Long id){
        return itemRepository.findOne(id);
    }

    public Customer getCustomer(Long id){
        return customerRepository.findOne(id);
    }

    public Warehouse getWarehouse(Long id){
        return warehouseRepository.findOne(id);
    }

    public Category getCategory(Long id){
        return categoryRepository.findOne(id);
    }

    public Item addItemToWarehouse(Item item, Warehouse warehouse, int inStock){
        if (item == null) return null;
        item.addWarehouse(warehouse, inStock);
        itemRepository.save(item);
        return item;
    }

    public Item addItemToCategory(Item item, Category category){
        if (item == null || category == null) return item;
        item.addCategory(category);
        itemRepository.save(item);
        return item;
    }

    public Customer buyItem(Customer customer, Item item){
        if (customer == null || item == null) return customer;
        customer.buyItem(item);
        customerRepository.save(customer);
        return customer;
    }

    public Customer commentItem(Customer customer, Item item, String message){
        if (customer == null || item == null) return customer;
        customer.commentItem(item, message);
        customerRepository.save(customer);
        return customer;
    }

    public Customer rateItem(Customer customer, Item item, int rating){
        if (customer == null || item == null) return customer;
        customer.rateItem(item, rating);
        customerRepository.save(customer);
        return customer;
    }

    public void drop(){
        getSession().purgeDatabase();
    }

    public Path getShortestPath(Object e1, Object e2){
        return e1 == null || e2 == null ? new Path() : new Path(entityRepository.getShortestPath(e1, e2));
    }

    public Iterable<Object> getRelationships(Object e1){
        if (e1 == null) return new ArrayList<>();
        Result result = entityRepository.getRelations(e1);
        LinkedList<Object> rels = new LinkedList<>();
        result.forEach(map -> rels.add(map.getOrDefault("r", null)));
        return rels;
    }

    public Result query(String s){
        return getSession().query(s, Collections.EMPTY_MAP);
    }

    public Object getEntity(long id) {
        return entityRepository.findById(id);
    }
}
