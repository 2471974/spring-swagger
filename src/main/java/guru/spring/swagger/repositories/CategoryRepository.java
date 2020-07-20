package guru.spring.swagger.repositories;

import guru.spring.swagger.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/24/17.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByName(String name);

}
