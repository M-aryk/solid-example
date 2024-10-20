package rating;

// SRP задача класса - подсчет рейтинга
// DIP данный класс может использоваться для присвоения рейтинга товару, продавцу и т.д.
public interface RatingService {
    double calcRating(int givenRating, double originalRating);
}
