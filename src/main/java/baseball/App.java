package baseball;

import baseball.engine.Baseball;
import baseball.engine.io.Input;
import baseball.engine.io.NumberGenerator;
import baseball.engine.io.Output;

public class App {
    public static void main(String[] args) {
        NumberGenerator generator = new HackedFakerNumberGenerator();
        //NumberGenerator generator = new FakerNumberGenerator();
        Console console = new Console();

        new Baseball(generator,console,console).run();
    }
}
