package rating;

public class RatingProducts implements RatingService {
    double rate;

    @Override
    public double calcRating(int givenRating, double originalRating) {
        if (originalRating == 0) {
            this.rate = givenRating;
        } else {
            this.rate = (givenRating + originalRating) / 2;
        }
        return rate;
    }
}
