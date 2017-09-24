import bl.HibernateUtil;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.*;


public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Item item = new Item();
        item.setTitle("Phone");
        item.setDescription("Cool phone");
        item.setPrice("5000");

        Hobby hobby = new Hobby();
        hobby.setHobby("Football");

        Hobby hobby1 = new Hobby();
        hobby1.setHobby("DOTA 2");

        Hobby hobby2 = new Hobby();
        hobby2.setHobby("VODKA");


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

        user1.setHobbies(Arrays.asList(hobby, hobby1));
        user.setHobbies(Arrays.asList(hobby2, hobby));

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
        user1.setUserAddress(address1);

        Order order = new Order();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1945, Calendar.MAY, 9);
        order.setDate(new Date(calendar.getTime().getTime()));
        order.setItem(item);
        order.setUser(user);
        order.setQuantity(1);

        session.save(hobby);
        session.save(hobby1);
        session.save(hobby2);
        session.save(address);
        session.save(address1);
        session.save(item);
        session.save(user);
        session.save(user1);
        session.save(order);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
