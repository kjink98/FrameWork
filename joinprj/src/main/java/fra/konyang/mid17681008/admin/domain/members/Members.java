package fra.konyang.mid17681008.admin.domain.members;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pass;

    @Column(length = 100, nullable = false)
    private String email;

    @Builder
    public Members(String id, String name, String pass, String email){
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public void update(String id, String name, String pass, String email){
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
    }
}
