package backend.reviews;

import backend.classes.ClassData;
import backend.classes.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController
{
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ClassRepository classRepository;

    @PostMapping("/review")
    public Review addReview(@RequestBody Review review)
    {
        ClassData classData = classRepository.findById(review.getClassId()).get();
        review.setClassData(classData);
        reviewRepository.save(review);
        classData.addReview(review);
        classRepository.save(classData);
        return review;
    }

    @GetMapping("/reviews/{department}/{number}")
    public List<Review> getReviews(@PathVariable String department, @PathVariable String number)
    {
        return classRepository.findByDepartmentTitleAndClassNumber(department, number).getReviews();
    }
}
