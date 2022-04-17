import java.util.Scanner;
import java.util.stream.IntStream;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /* try {//първа задача от лаба
            System.out.println(sqrt(scanner));

        }catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Good bye");
        }*/

        while (true) {
            String start = scanner.nextLine();
            String end = scanner.nextLine();

            try {
                printNumberRange(start, end);
                return;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printNumberRange(String start, String end) {
        int s;
        int e;
        try {
            s = Integer.parseInt(start);
            e = Integer.parseInt(end);

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid input, please enter new range", ex);
        }
        if (!(1 < s && s < e && e < 100)){
            throw new IllegalArgumentException("Invalid input, please enter new range");
        }
        IntStream.rangeClosed(s, e).forEach(System.out::println);
    }

    public static double sqrt(Scanner scanner) {
        String str = scanner.nextLine();
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException("Invalid number");
            }
        }
        return Math.sqrt(Integer.parseInt(str));
    }
}
