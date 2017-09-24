import bl.HibernateUtil;
import entity.Address;
import entity.Item;
import entity.Order;
import entity.User;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Item item = new Item();
        item.setTitle("Phone");
        item.setDescription("Cool phone");
        item.setPrice("5000");

        User user = new User();
        user.setLogin("QWERTY");
        user.setFirstName("Bob");
        user.setLastName("Sponge");
        user.setDeliveryAddress("Bikini Bottom");
        user.setContactPhone("88005553535");
        User user1 = new User();
        user1.setLogin("ASD");
        user1.setFirstName("Patrick");
        user1.setLastName("Star");
        user1.setDeliveryAddress("Stone");
        user1.setContactPhone("What is phone?");

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Sevastopol");
        address.setStreet("Wave street");
        address.setHouse("Pine-Apple");
        Address address1 = new Address();
        address1.setCountry("Ukraine");
        address1.setCity("Sevastopol");
        address1.setStreet("Wave street");
        address1.setHouse("StoneColdSteveAustin");

        user.setUserAddress(address);
        user1.setUserAddress(address);


        Order order = new Order();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1945, Calendar.MAY, 9);
        order.setDate(new Date(calendar.getTime().getTime()));
        order.setItem(item);
        order.setUser(user);
        order.setQuantity(1);

        session.save(item);
        session.save(user);
        session.save(user1);
        session.save(order);
        session.save(address);
        session.save(address1);

        session.getTransaction().commit();
        HibernateUtil.shutdown();


    }
}
