import java.util.Scanner;

public class Main {

    final static String NOR_OUTPUT = " is neither divisible by 7 nor does it end with 7";
    final static String DIVISIBLE_BY_SEVEN_OUTPUT = " is divisible by 7";
    final static String ENDS_WITH_SEVEN_OUTPUT = " ends with 7";
    final static String BOTH_OUTPUT = " is divisible by 7 and ends with 7";
    final static String ERROR_OUTPUT = "This number is not natural!";
    final static String ENTER_INPUT = "Enter a natural number:";
    final static String EVEN_OUTPUT = "This number is Even.";
    final static String ODD_OUTPUT = "This number is Odd.";
    final static String BUZZ_OUTPUT = "It is a Buzz number.";
    final static String NOT_BUZZ_OUTPUT = "It is not a Buzz number.";
    final static String EXPLANATION_OUTPUT = "Explanation:";

    static Scanner scanner = new Scanner(System.in);

    public static boolean isANaturalNumber(int input) {
        return input > 0;
    }

    public static boolean isDivisibleBySeven(int input) {
//        int lastDigit = input % 10;
//        int test = input - lastDigit * 2;
        return 0 == input % 7;
    }

    public static boolean isEven(int input) {
        return 0 == input % 2;
    }

    public static boolean endsWithSeven(int input) {
        return 7 == input % 10;
    }

    public static void isBuzz(int input) {
        boolean isDivisibleBySeven = isDivisibleBySeven(input);
        boolean endsWithSeven = endsWithSeven(input);
        if (isDivisibleBySeven && !endsWithSeven) {
            System.out.println(BUZZ_OUTPUT);
            System.out.println(EXPLANATION_OUTPUT);
            System.out.println(input + DIVISIBLE_BY_SEVEN_OUTPUT);
        } else if (!isDivisibleBySeven && endsWithSeven) {
            System.out.println(BUZZ_OUTPUT);
            System.out.println(EXPLANATION_OUTPUT);
            System.out.println(input + ENDS_WITH_SEVEN_OUTPUT);
        } else if (isDivisibleBySeven && endsWithSeven) {
            System.out.println(BUZZ_OUTPUT);
            System.out.println(EXPLANATION_OUTPUT);
            System.out.println(input + BOTH_OUTPUT);
        } else {
            System.out.println(NOT_BUZZ_OUTPUT);
            System.out.println(EXPLANATION_OUTPUT);
            System.out.println(input + NOR_OUTPUT);
        }
    }

    public static void buzzNumbers() {
        System.out.println(ENTER_INPUT);
        int input = scanner.nextInt();
        if(!isANaturalNumber(input)) {
            System.out.println(ERROR_OUTPUT);
        } else {
            if(isEven(input)) {
                System.out.println(EVEN_OUTPUT);
            } else {
                System.out.println(ODD_OUTPUT);
            }
            isBuzz(input);
        }
    }

    public static void main(String[] args) {
        buzzNumbers();
    }
}
