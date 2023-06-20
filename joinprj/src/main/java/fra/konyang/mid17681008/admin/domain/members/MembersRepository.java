package fra.konyang.mid17681008.admin.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members, Long> {

}
