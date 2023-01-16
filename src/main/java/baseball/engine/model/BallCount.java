package baseball.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BallCount {
    private int strike;
    private int ball; //private하여 값 보호
}
