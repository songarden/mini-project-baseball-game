package baseball.engine;

import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;
import baseball.engine.model.BallCount;
import baseball.engine.model.Numbers;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Baseball implements Runnable {
    private final int COUNT_OF_NUMBERS = 7;

    private NumberGenerator generator;
    private Input input;
    private Output output;

    @Override
    public void run() {
        Numbers answer = generator.generate(COUNT_OF_NUMBERS);

        while (true) {
            String inputString = input.input("숫자를 입력하시오. : ");
            Optional<Numbers> inputNumbers = parse(inputString);
            if (inputNumbers.isEmpty()) {
                output.inputError();
                continue;
            }

            BallCount bc = ballCount(answer, inputNumbers.get());
            output.ballCount(bc);
            if (bc.getStrike() == COUNT_OF_NUMBERS) {
                output.correct();
                break;
            }
        }
    }

    private BallCount ballCount(Numbers answer, Numbers inputNumbers) {
        AtomicInteger strike = new AtomicInteger();
        AtomicInteger ball = new AtomicInteger();
        answer.indexedForEach((a, i) -> {
            inputNumbers.indexedForEach((n, j) -> {
                if (!a.equals(n)) {
                    return;
                }
                if (i.equals(j)) strike.addAndGet(1);
                else ball.addAndGet(1);
            });
        });
        return new BallCount(strike.get(), ball.get());
    }

    private Optional<Numbers> parse(String inputString) {
        if(inputString.length() != COUNT_OF_NUMBERS) return Optional.empty();

        long count = inputString.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .filter(i -> i > 0)
                .distinct()
                .count();
        if(count != COUNT_OF_NUMBERS) return Optional.empty();

        return Optional.of(
                new Numbers(
                        inputString.chars()
                                .map(Character::getNumericValue)
                                .boxed()
                                .toArray(Integer[]::new)
                )
        );
    }

}
