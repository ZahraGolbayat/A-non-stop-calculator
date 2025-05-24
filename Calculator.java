import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double resualt = 0;
        boolean hasPreviousResualt = false;

        while (true) {
            System.out.println("Enter the operator: ");
            System.out.println("press 'E' to exit. ");
            String operator = scanner.nextLine().trim();

            if (operator.equalsIgnoreCase("E")) {
                break;
            }

            System.out.println("Enter your numbers or 'ans' to use previous result:  ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split("\\s+");
            double[] numbers = new double[parts.length];
            int numCount = 0;

            
            for (String part : parts) {
                if (part.equalsIgnoreCase("ans")) {
                    if (hasPreviousResualt) {
                        numbers[numCount++] = resualt;
                    } else {
                        System.out.println("No previous result available!");
                        break;
                    }
                } 
                else {
                    try {
                        numbers[numCount++] = Double.parseDouble(part);
                    } 
                    catch (NumberFormatException e) {
                        System.out.println("Invalid number: " + part);
                    }
                }
            }

            switch (operator) {
                case "+":
                    resualt = add(numbers, numCount);
                    break;
                case "-":
                    resualt = subtract(numbers, numCount);
                    break;
                case "*":
                    resualt = multiply(numbers, numCount);
                    break;
                case "/":
                    resualt = divide(numbers, numCount);
                    break;
                default:
                    System.out.println("Invalid operation!");
                    continue;
            }

            hasPreviousResualt = true;
            System.out.println("Result: " + resualt);
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }

    public static double add(double[] numbers, int count) {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static double subtract(double[] numbers, int count) {
        double result = numbers[0];
        for (int i = 1; i < count; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiply(double[] numbers, int count) {
        double result = 1;
        for (int i = 0; i < count; i++) {
            result *= numbers[i];
        }
        return result;
    }

    public static double divide(double[] numbers, int count) {
        double result = numbers[0];
        for (int i = 1; i < count; i++) {
            if (numbers[i] == 0) {
                System.out.println("Error: Division by zero!");
                return Double.NaN;
            }
            result /= numbers[i];
        }
        return result;
    }




        }
