package baseball;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Integer[] nums = Stream.generate(()->faker.number().randomDigitNotZero())
                .distinct()
                .limit(3)
                .toArray(Integer[]::new);
//        long r = faker.number().randomNumber();
//        String title = faker.starTrek().character();
//        System.out.println(Arrays.toString(nums));

        User user = new User();
        User user1 = new User();
        user1.setAge(2);
        System.out.println(user.equals(user1));
        System.out.println(user.getAge());


    }
}
