import bl.HibernateUtil;
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
        item.setId(1L);
        item.setTitle("Phone");
        item.setDescription("Cool phone");
        item.setPrice("5000");

        User user = new User();
        user.setId(1L);
        user.setLogin("QWERTY");
        user.setFirstName("Bob");
        user.setLastName("Sponge");
        user.setDeliveryAddress("Bikini Bottom");
        user.setContactPhone("88005553535");
        User user1 = new User();
        user1.setId(2L);
        user1.setLogin("ASD");
        user1.setFirstName("Patrick");
        user1.setLastName("Star");
        user1.setDeliveryAddress("Stone");
        user1.setContactPhone("What is phone?");

        Set<User> users = new HashSet<User>();
        users.add(user);
        users.add(user1);

        Order order = new Order();
        order.setId(1L);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1945, Calendar.MAY, 9);
        order.setDate(new Date(calendar.getTime().getTime()));
        order.setItem(item);
        order.setUsers(users);
        order.setQuantity(1);

        session.save(item);
        session.save(user);
        session.save(user1);
        session.save(order);

        session.getTransaction().commit();
        HibernateUtil.shutdown();


    }
}
