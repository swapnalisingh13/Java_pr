import java.util.Scanner;

public class Records {
    private static int[] a;

    public Records() {
        a = new int[100];
    }

    void readArray() {
        System.out.println("Enter the number of elements you want to enter: ");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            boolean correctInput = false;
            do {
                try {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    int mark = Integer.parseInt(sc.nextLine());

                    if (mark >= 0 && mark <= 10000) {
                        a[i] = mark;
                        correctInput = true;
                    } else {
                        System.out.println("Enter correct details");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            } while (!correctInput);
        }
    }

    public int getK() {
        System.out.println("Enter the number of frequencies you want: ");
        Scanner sca = new Scanner(System.in);
        return Integer.parseInt(sca.nextLine());
    }

    public void Frequentmatching(int k) {
        int[] frequency = new int[10001]; // Index 0 won't be used

        // Calculate frequency of each element
        for (int i = 0; i < a.length; i++) {
            frequency[a[i]]++;
        }

        int frequenthigh = -1;

        // Find the nearest higher frequency to k
        for (int freq : frequency) {
            if (freq >= k && (frequenthigh == -1 || freq < frequenthigh)) {
                frequenthigh = freq;
            }
        }

        // Find the element with the highest frequency among the ones having nearest higher frequency to K
        int high_freq = -1;
        int maxFreq = -1;

        for (int i = frequency.length - 1; i >= 0; i--) {
            if (frequency[i] == frequenthigh) {
                high_freq = i;
                maxFreq = frequency[i];
                break;
            }
        }

        // Print the element with the highest frequency in descending order
        for (int i = frequency.length - 1; i >= 0; i--) {
            if (frequency[i] == maxFreq) {
                high_freq = i;
                System.out.print(high_freq + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Fill the details below....\n");
        Records p = new Records();
        p.readArray();
        int k = p.getK();
        p.Frequentmatching(k);
    }
}
