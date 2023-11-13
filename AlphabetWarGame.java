import java.util.Scanner;

public class AlphabetWarGame {

    // Default strengths for the letters
    private static int d_leftstrngth[] = {4, 3, 2, 1};
    private static int d_rightstrngth[] = {4, 3, 2, 1};

    // Custom strengths for the letters
    private int[] leftStrengths;
    private int[] rightStrengths;

    // Default constructor
    public AlphabetWarGame() {
        leftStrengths = d_leftstrngth.clone();
        rightStrengths = d_rightstrngth.clone();
    }

    //method to battle
    public void battle(String word) {
        int leftScore = 0;
        int rightScore = 0;

        for (char letter : word.toCharArray()) {
            switch (letter) {
                case 'w':
                    leftScore += leftStrengths[0];
                    break;
                case 'p':
                    leftScore += leftStrengths[1];
                    break;
                case 'b':
                    leftScore += leftStrengths[2];
                    break;
                case 's':
                    leftScore += leftStrengths[3];
                    break;
                case 'm':
                    rightScore += rightStrengths[0];
                    break;
                case 'q':
                    rightScore += rightStrengths[1];
                    break;
                case 'd':
                    rightScore += rightStrengths[2];
                    break;
                case 'z':
                    rightScore += rightStrengths[3];
                    break;
            }
        }

        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }


    // code method to run the game
    public void runGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Characters accepted (w, p, b, s, m, q, d, z): \n");

        try {
            System.out.print("Enter the number of elements: ");
            //storing the numbers enetered
            int battle_array = sc.nextInt();
            sc.nextLine();

            char[] userarray = new char[battle_array];


            for (int i = 0; i < battle_array; i++) {
                System.out.print("Enter character #" + (i + 1) + ": ");
                userarray[i] = sc.nextLine().charAt(0);
            }

            System.out.print("Entered array: ");
            for (char element : userarray) {
                System.out.print(element + " ");
            }
            System.out.println();

            String userinput = new String(userarray);

            if (valid_ip(userinput, battle_array)) {
                battle(userinput);
            } else {
                System.out.println("The elements inserted doesn't match the valid characters.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Wrong input entered for no. of elements.");
        }
    }


    // check the validity of elements entered
    private boolean valid_ip(String ip, int battlearray) {
        return ip.matches("[wpbsmqdz]+") && ip.length() == battlearray;
    }

    public static void main(String[] args) {
        AlphabetWarGame play = new AlphabetWarGame();
        play.runGame();
    }
}
