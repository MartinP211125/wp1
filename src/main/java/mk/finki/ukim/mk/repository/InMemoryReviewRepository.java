package mk.finki.ukim.mk.repository;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Review;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryReviewRepository {
    public List<Review> findInInterval(LocalDateTime from, LocalDateTime to){
        return DataHolder.rewievs.stream().filter(r -> r.getTimestamp().isAfter(from) && r.getTimestamp().isBefore(to)).collect(Collectors.toList());
    }
}
