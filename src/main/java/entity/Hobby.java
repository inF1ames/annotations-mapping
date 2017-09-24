package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "HOBBY")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "HOBBY", nullable = false, unique = true)
    private String hobby;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hobbies")
    private List<User> users;

    public Hobby setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Hobby setId(Long id) {
        this.id = id;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public Hobby setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

}
