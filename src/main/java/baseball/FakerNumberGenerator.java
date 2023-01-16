package baseball;

import baseball.engine.io.NumberGenerator;
import baseball.engine.model.Numbers;
import com.github.javafaker.Faker;

import java.util.stream.Stream;

public class FakerNumberGenerator implements NumberGenerator {
    private final Faker faker = new Faker();
    @Override
    public Numbers generate(int count) {
        return new Numbers(
                Stream.generate(() -> faker.number().randomDigitNotZero())
                        .distinct()
                        .limit(count)
                        .toArray(Integer[]::new)
        );
    }
}
