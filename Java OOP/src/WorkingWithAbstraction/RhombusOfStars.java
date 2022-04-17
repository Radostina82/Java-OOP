package WorkingWithAbstraction;

import Input.Reader;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
      //  int size = readSize(new Scanner(System.in));
        int size = Reader.readIntArray("\\s+")[0];
        for (int i = 1; i <= size ; i++) {
            printSingleLineOfRhombus(size, i);
        }
        for (int i = size-1; i >=1 ; i--) {
            printSingleLineOfRhombus(size, i);
        }
    }

    private static void printSingleLineOfRhombus(int size, int starToPrint) {
        int leadingSpace = size-starToPrint;
        for (int j = 0; j <leadingSpace ; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < starToPrint; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static int readSize(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
