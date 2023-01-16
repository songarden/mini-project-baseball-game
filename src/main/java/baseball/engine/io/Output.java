package baseball.engine.io;

import baseball.engine.model.BallCount;

public interface Output {
    void ballCount(BallCount bc);

    void inputError();

    void correct();
}
