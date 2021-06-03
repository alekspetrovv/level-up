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

    @ManyToOne
    @JoinColumn(name = "api_user_id", nullable = false)
    private ApiUser api_user;

    public Blog(String title, String body, String img, ApiUser user) {
        this.title = title;
        this.body = body;
        this.img = img;
        this.api_user = user;
    }


    public String getImg() {
        return "/img/blogs/" + this.id + "/" + this.img;
    }
}
