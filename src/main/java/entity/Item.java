package entity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE", unique = true, nullable = false)
    private String title;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "PRICE", nullable = false)
    private String price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
