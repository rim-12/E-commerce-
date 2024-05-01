package com.review.ReviewMicroservice.Service;
import com.review.ReviewMicroservice.Entity.Dto.ReviewRequestDto;
import com.review.ReviewMicroservice.Entity.Dto.ReviewResponseDto;
import com.review.ReviewMicroservice.Entity.Review;
import com.review.ReviewMicroservice.Exception.ReviewNotFoundException;
import com.review.ReviewMicroservice.Repository.ReviewRepository;
import com.review.ReviewMicroservice.Util.MappingProfile;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewResponseDto> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(MappingProfile::mapToReviewDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDto addReview(ReviewRequestDto reviewDto) {
        var review = MappingProfile.mapToReviewEntity(reviewDto);
        return MappingProfile.mapToReviewDto(reviewRepository.save(review));
    }

    @Override
    public ReviewResponseDto getReviewById(Long id) throws ReviewNotFoundException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found"));
        ReviewResponseDto reviewResponseDto = MappingProfile.mapToReviewDto(review);
        return reviewResponseDto;
    }

    @Override
    public ReviewResponseDto updateReview(Long id, ReviewRequestDto reviewRequest) throws ReviewNotFoundException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with id: " + id));

        review.setComment(reviewRequest.getComment());
        review.setRating(reviewRequest.getRating());
        review.setCustomerId(reviewRequest.getCustomerId());
        review.setProductId(reviewRequest.getProductId());
        Review updatedReview = reviewRepository.save(review);
        return MappingProfile.mapToReviewDto(updatedReview);
    }


    @Override

    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new ReviewNotFoundException("Review not found with id: " + id);
        }
    }
    @Override
    public List<ReviewResponseDto> getReviewResponsesByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream()
                .map(MappingProfile::mapToReviewDto)
                .collect(Collectors.toList());
    }
}
