import edu.mednikov.backtracking.LetterCombinationsOfAPhoneNumber;
import edu.mednikov.multithreading.SimpleSteppingRobot;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        var bot = new SimpleSteppingRobot();

        bot.start();

        var scanner = new Scanner(System.in);
        while (!scanner.hasNext() && !scanner.next().equalsIgnoreCase("y")) {
            Thread.sleep(1000);
        }

        bot.stop();
    }
}
