import java.util.Scanner;

public class Main {

    final static String WELCOME_1 = "Welcome to Amazing Numbers!\n";
    final static String WELCOME_2 = "Supported requests:";
    final static String WELCOME_3 = "- enter a natural number to know its properties;";
    final static String WELCOME_4 = "- enter 0 to exit.\n";
    final static String ENTER_INPUT = "Enter a request:";
    final static String ERROR_OUTPUT = "\nThe first parameter should be a natural number or zero.\n";
    final static String OUTPUT_LINE_1 = "\nProperties of ";
    final static String OUTPUT_LINE_2 = "        even: ";
    final static String OUTPUT_LINE_3 = "         odd: ";
    final static String OUTPUT_LINE_4 = "        buzz: ";
    final static String OUTPUT_LINE_5 = "        duck: ";
    final static String OUTPUT_LINE_6 = " palindromic: ";
    final static String OUTPUT_GOODBYE = "\nGoodbye!";

    static Scanner scanner = new Scanner(System.in);

    public static boolean isANaturalNumber(long input) {
        return input > 0;
    }

    public static boolean isEven(long input) {
        return 0 == input % 2;
    }

    public static boolean isDivisibleBySeven(long input) {
        return 0 == input % 7;
    }

    public static boolean endsWithSeven(long input) {
        return 7 == input % 10;
    }

    public static boolean isBuzz(long input) {
        boolean isDivisibleBySeven = isDivisibleBySeven(input);
        boolean endsWithSeven = endsWithSeven(input);
        return isDivisibleBySeven || endsWithSeven;
    }

    public static boolean isDuck(long input) {
        if (input % 10 == 0) {
            return true;
        } else if (input - input % 10 == 0 ){
            return false;
        } else {
            return isDuck((input - input % 10) / 10);
        }
    }

    public static boolean isPalindrome(long input) {
        long reversedNum = 0;
        long remainder;
        long originalNum = input;
        while (input != 0) {
            remainder = input % 10;
            reversedNum = reversedNum * 10 + remainder;
            input /= 10;
        }
        return originalNum == reversedNum;
    }

    public static void output(long input) {
            System.out.printf(OUTPUT_LINE_1 +"%,d\n", input);
            System.out.println(OUTPUT_LINE_2 + isEven(input));
            System.out.println(OUTPUT_LINE_3 + !isEven(input));
            System.out.println(OUTPUT_LINE_4 + isBuzz(input));
            System.out.println(OUTPUT_LINE_5 + isDuck(input));
            System.out.println(OUTPUT_LINE_6 + isPalindrome(input) + "\n");
    }

    public static void menu() {
        System.out.println(WELCOME_1);
        System.out.println(WELCOME_2);
        System.out.println(WELCOME_3);
        System.out.println(WELCOME_4);
        while (true) {
            System.out.println(ENTER_INPUT);
            long input = scanner.nextLong();
            if (input == 0) {
                System.out.println(OUTPUT_GOODBYE);
                break;
            } else if (!isANaturalNumber(input)) {
                System.out.println(ERROR_OUTPUT);
            } else {
                output(input);
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}

//Stage 1: extra code:

//    final static String NOR_OUTPUT = " is neither divisible by 7 nor does it end with 7";
//    final static String DIVISIBLE_BY_SEVEN_OUTPUT = " is divisible by 7";
//    final static String ENDS_WITH_SEVEN_OUTPUT = " ends with 7";
//    final static String BOTH_OUTPUT = " is divisible by 7 and ends with 7";
//    final static String EVEN_OUTPUT = "This number is Even.";
//    final static String ODD_OUTPUT = "This number is Odd.";
//    final static String BUZZ_OUTPUT = "It is a Buzz number.";
//    final static String NOT_BUZZ_OUTPUT = "It is not a Buzz number.";
//    final static String EXPLANATION_OUTPUT = "Explanation:";

//public static void isBuzz(int input) {
//    boolean isDivisibleBySeven = isDivisibleBySeven(input);
//    boolean endsWithSeven = endsWithSeven(input);
//    if (isDivisibleBySeven && !endsWithSeven) {
//    System.out.println(BUZZ_OUTPUT);
//    System.out.println(EXPLANATION_OUTPUT);
//    System.out.println(input + DIVISIBLE_BY_SEVEN_OUTPUT);
//    } else if (!isDivisibleBySeven && endsWithSeven) {
//    System.out.println(BUZZ_OUTPUT);
//    System.out.println(EXPLANATION_OUTPUT);
//    System.out.println(input + ENDS_WITH_SEVEN_OUTPUT);
//    } else if (isDivisibleBySeven && endsWithSeven) {
//    System.out.println(BUZZ_OUTPUT);
//    System.out.println(EXPLANATION_OUTPUT);
//    System.out.println(input + BOTH_OUTPUT);
//    } else {
//    System.out.println(NOT_BUZZ_OUTPUT);
//    System.out.println(EXPLANATION_OUTPUT);
//    System.out.println(input + NOR_OUTPUT);
//    }
//}
//public static void buzzNumbers() {
//    System.out.println(ENTER_INPUT);
//    int input = scanner.nextInt();
//    if(!isANaturalNumber(input)) {
//        System.out.println(ERROR_OUTPUT);
//    } else {
//        if(isEven(input)) {
//            System.out.println(EVEN_OUTPUT);
//        } else {
//            System.out.println(ODD_OUTPUT);
//        }
//        isBuzz(input);
//    }
//}