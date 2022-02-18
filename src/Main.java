import java.util.Scanner;

public class Main {

    final static String WELCOME_1 = "Welcome to Amazing Numbers!\n";
    final static String WELCOME_2 = "Supported requests:";
    final static String WELCOME_3 = "- enter a natural number to know its properties;";
    final static String WELCOME_4 = "- enter two natural numbers to obtain the properties of the list:";
    final static String WELCOME_5 = "  * the first parameter represents a starting number;";
    final static String WELCOME_6 = "  * the second parameter shows how many consecutive numbers are to be processed;";
    final static String WELCOME_7 = "- two natural numbers and a property to search for;";
    final static String WELCOME_8 = "- separate the parameters with one space;";
    final static String WELCOME_9 = "- enter 0 to exit.\n";
    final static String ENTER_INPUT = "Enter a request:";
    final static String ERROR_OUTPUT_1 = "\nThe first parameter should be a natural number or zero.\n";
    final static String ERROR_OUTPUT_2 = "\nThe second parameter should be a natural number.\n";
    final static String ERROR_OUTPUT_3 = "\nThe property %s is wrong.\n"; // UPDATE THIS WITH printF
    final static String ERROR_OUTPUT_4 = "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]\n";
    final static String OUTPUT_LINE_1 = "\nProperties of ";
    final static String OUTPUT_LINE_2 = "        even: ";
    final static String OUTPUT_LINE_3 = "         odd: ";
    final static String OUTPUT_LINE_4 = "        buzz: ";
    final static String OUTPUT_LINE_5 = "        duck: ";
    final static String OUTPUT_LINE_6 = "      gapful: ";
    final static String OUTPUT_LINE_7 = " palindromic: ";
    final static String OUTPUT_LINE_8 = "         spy: ";
    final static String OUTPUT_GOODBYE = "\nGoodbye!";
    final static String IS = " is ";
    final static String BUZZ = "buzz";
    final static String DUCK = "duck";
    final static String EVEN = "even";
    final static String ODD = "odd";
    final static String GAPFUL = "gapful";
    final static String PALINDROME = "palindromic";
    final static String SPY = "spy";
    final static String COMMA_SPACE = ", ";

    static Scanner scanner = new Scanner(System.in);

    public static boolean isEven(long input) {
        return 0 == input % 2;
    }

    // helper for isBuzz
    public static boolean isDivisibleBySeven(long input) {
        return 0 == input % 7;
    }

    // helper for isBuzz
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

    public static boolean isGapful(long input) {
        if (input < 100) {
            return false;
        } else {
            long last = input % 10;
            long first = firstDigit(input);
            long firstLast = first * 10 + last;
            return input % firstLast == 0;
        }
    }

    // Helper function for isGapful(), returns the first digit of a long
    public static long firstDigit(long input) {
        long digits = digitCount(input);
        long divisor = (long) Math.pow(10, digits - 1);
        return input / divisor;
    }

    // Helper function for firstDigit() which is a helper for isGapful(), returns the count of the digits in the long
    public static long digitCount(long input) {
        int digits = 0;
        while (input != 0) {
            input /= 10;
            digits++;
        }
        return digits;
    }

    public static boolean isSpy(long input) {
        String test = Long.toString(input);
        long multiplication = 1;
        long addition = 0;
        for (int i = 0; i < test.length(); i++) {
            long temp = Long.parseLong(String.valueOf(test.charAt(i)));
            multiplication *= temp;
            addition += temp;
        }
        return multiplication == addition;
    }

    public static void outputSingle(long input) {
            System.out.printf(OUTPUT_LINE_1 +"%,d\n", input);
            System.out.println(OUTPUT_LINE_2 + isEven(input));
            System.out.println(OUTPUT_LINE_3 + !isEven(input));
            System.out.println(OUTPUT_LINE_4 + isBuzz(input));
            System.out.println(OUTPUT_LINE_5 + isDuck(input));
            System.out.println(OUTPUT_LINE_6 + isGapful(input));
            System.out.println(OUTPUT_LINE_7 + isPalindrome(input));
            System.out.println(OUTPUT_LINE_8 + isSpy(input) + "\n");
    }

    // single line output format for group of numbers (Stage 4)
    public static void outputMultiple(long input, long reps) {
        for (long i = input; i < input + reps; i++) {
            outputSingleOfMultiple(i);
        }
        System.out.println();
    }

    public static void outputSingleOfMultiple(long input) {
        System.out.print("             " + input + IS);
        if (isEven(input)) {
            System.out.print(EVEN);
        } else {
            System.out.print(ODD);
        }
        if (isBuzz(input)) {
            System.out.print(COMMA_SPACE + BUZZ);
        }
        if (isDuck(input)) {
            System.out.print(COMMA_SPACE + DUCK);
        }
        if (isPalindrome(input)) {
            System.out.print(COMMA_SPACE + PALINDROME);
        }
        if (isGapful(input)) {
            System.out.print(COMMA_SPACE + GAPFUL);
        }
        if (isSpy(input)) {
            System.out.print(COMMA_SPACE + SPY);
        }
        System.out.println();
    }

    // "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]\n";
    public static void outputWithSearchProperty(long input, long reps, String property) {
        int count = 0;
        for (long i = input; count < reps; i++) {
            switch (property) {
                case EVEN: if(isEven(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case ODD: if(!isEven(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case BUZZ: if(isBuzz(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case DUCK: if(isDuck(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case PALINDROME: if(isPalindrome(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case GAPFUL: if(isGapful(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
                case SPY: if(isSpy(i)) {
                    outputSingleOfMultiple(i);
                    count++;
                }
                    break;
            }
        }
        System.out.println();
    }

    // Helper for user input validation
    public static boolean isANaturalNumber(long input) {
        return input > 0;
    }

    // Helper for user input validation
    public static boolean isValidProperty(String input) {
        String[] test = {EVEN, ODD, BUZZ, DUCK, PALINDROME, GAPFUL, SPY};
        for (String testString : test) {
            if (testString.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public static void menu() { // UPDATE FOR STAGE 4
        System.out.println(WELCOME_1);
        System.out.println(WELCOME_2);
        System.out.println(WELCOME_3);
        System.out.println(WELCOME_4);
        System.out.println(WELCOME_5);
        System.out.println(WELCOME_6);
        System.out.println(WELCOME_7);
        System.out.println(WELCOME_8);
        System.out.println(WELCOME_9);
        while (true) {
            System.out.println(ENTER_INPUT);
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length == 1) {
                Long inputLong = Long.parseLong(inputArray[0]);
                if (inputLong == 0) {
                    System.out.println(OUTPUT_GOODBYE);
                    break;
                } else if (!isANaturalNumber(inputLong)) {
                    System.out.println(ERROR_OUTPUT_1);
                } else {
                    outputSingle(inputLong);
                }
            } else if (inputArray.length == 2) { // assumes there will only be two entries
                Long inputLongOne = Long.parseLong(inputArray[0]);
                Long inputLongTwo = Long.parseLong(inputArray[1]);
                if (!isANaturalNumber(inputLongOne)) {
                    System.out.println(ERROR_OUTPUT_1);
                } else if (!isANaturalNumber(inputLongTwo)) {
                    System.out.println(ERROR_OUTPUT_2);
                } else {
                    outputMultiple(inputLongOne, inputLongTwo);
                }
            } else if (inputArray.length == 3) {
                Long inputLongOne = Long.parseLong(inputArray[0]);
                Long inputLongTwo = Long.parseLong(inputArray[1]);
                String inputProperty = inputArray[2].toLowerCase();
                if (!isANaturalNumber(inputLongOne)) {
                    System.out.println(ERROR_OUTPUT_1);
                } else if (!isANaturalNumber(inputLongTwo)) {
                    System.out.println(ERROR_OUTPUT_2);
                } else if (!isValidProperty(inputProperty) ) {
                    System.out.printf(ERROR_OUTPUT_3, inputProperty);
                    System.out.println(ERROR_OUTPUT_4);
                } else {
                    outputWithSearchProperty(inputLongOne, inputLongTwo, inputProperty);
//                    System.out.println("farts");
                }
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

//    public static void singleInputValidation() {
//
//    }
//
//    public static void doubleInputValidation() {
//
//    }
//
//    public static void tripleInputValidation() {
//
//    }