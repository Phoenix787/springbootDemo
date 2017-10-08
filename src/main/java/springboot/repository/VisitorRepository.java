package springboot.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.entity.Visitor;

public interface VisitorRepository extends CrudRepository<Visitor, Long> {
}
