package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.Website;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {
    //если недостаточно тех методов которые предоставляет JpaRepository можно добавить специальн
    List<Website> findByTitle(String website);
}
