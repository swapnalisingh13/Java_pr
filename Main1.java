package Pract_Code_For_4;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        System.out.println("Choose an option to steal from:");
        System.out.println("1. Row-Houses ");
        System.out.println("2. Round-Houses ");
        System.out.println("3. Square-Houses ");
        System.out.println("4. Building-Houses ");
        System.out.println("5. Exit");

        int choice;
        while (true) {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the size of the array:");
                    int size = scanner.nextInt();

                    int[] houses = new int[size];
                    System.out.println("Enter the values for the array:");

                    for (int i = 0; i < size; i++) {
                        houses[i] = scanner.nextInt();
                    }

                    int profit = robber.RowHouses(houses);
                    System.out.println("Sum of the two maximum non-adjacent numbers: " + profit);
                    break;

                case 2:
                    System.out.println("Enter the size of the array:");
                    int size1 = scanner.nextInt();

                    int[] roundHouses = new int[size1];
                    System.out.println("Enter the values for the circular house:");

                    for (int i = 0; i < size1; i++) {
                        roundHouses[i] = scanner.nextInt();
                    }

                    int roundProfit = robber.RoundHouses(roundHouses);
                    System.out.println("Maximum profit for circular houses: " + roundProfit);
                    break;

                case 3:
                    int[] squareHouses = new int[4];
                    System.out.println("Enter 4 values for SquareHouse:");
                    for (int i = 0; i < 4; i++) {
                        squareHouses[i] = scanner.nextInt();
                    }
                    int squareProfit = robber.SquareHouse(squareHouses);
                    System.out.println("Maximum profit for square houses: " + squareProfit);
                    break;

                case 4:
                    System.out.println("Enter the number of rows for multi-house building:");
                    int rows = scanner.nextInt();
                    System.out.println("Enter the number of columns for multi-house building:");
                    int cols = scanner.nextInt();

                    int[][] multiHouses = new int[rows][cols];
                    System.out.println("Enter values for multi-house building:");

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            multiHouses[i][j] = scanner.nextInt();
                        }
                    }

                    int multiProfit = robber.MultiHouseBuilding(multiHouses);
                    System.out.println("Maximum profit for multi-house building: " + multiProfit);
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
    }
}


