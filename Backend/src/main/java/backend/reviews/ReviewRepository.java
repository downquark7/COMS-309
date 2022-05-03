package backend.reviews;

import backend.classes.ClassData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{
}
