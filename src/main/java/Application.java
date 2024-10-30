import edu.mednikov.backtracking.LetterCombinationsOfAPhoneNumber;
import edu.mednikov.multithreading.SimpleSteppingRobot;
import edu.mednikov.sorting_n_searching.KthLargestElementInArray;
import edu.mednikov.sorting_n_searching.TopKFrequentElements;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws InterruptedException {
//        var bot = new SimpleSteppingRobot();
//
//        bot.start();
//
//        var scanner = new Scanner(System.in);
//        while (!scanner.hasNext() && !scanner.next().equalsIgnoreCase("y")) {
//            Thread.sleep(1000);
//        }
//
//        bot.stop();

//        TopKFrequentElements topk = new TopKFrequentElements();
//        int[] result = topk.topKFrequent(new int[] {1, 2, 3, 1, 2, 1}, 2);
//        System.out.println(result);

        KthLargestElementInArray kth = new KthLargestElementInArray();
        int kthr = kth.findKthLargest(new int[] {3,2,1,5,6,4}, 2);
        System.out.println(kthr);
    }
}
