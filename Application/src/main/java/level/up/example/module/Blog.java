package level.up.example.module;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String body;
    private String img;

    public Blog(String title, String body, String img) {
        this.title = title;
        this.body = body;
        this.img = img;
    }

}
