package entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "STORE_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "QUANTITY")
    private int quantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
