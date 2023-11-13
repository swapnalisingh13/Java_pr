import java.util.Scanner;
public class Performance {
    private int[] a;

    public Performance(){
        a = new int[10];
    }
    void readMarks(){
        System.out.println("Enter Marks below: ");
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            //correctip is false default. if only correct i/p entered then will return true.
            boolean correctip = false;
            do {
                try {
                    System.out.print("Enter marks of student " + (i + 1) + " : ");
                    int mark = Integer.parseInt(sc.nextLine());

                    if (mark >= 0 && mark <= 100) {
                        a[i] = mark;
                        correctip = true;
                    } else {
                        System.out.println("Invalid input! Marks should be between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                }
            } while (!correctip);
        }
    }
    public int highestMark() {
        int maxm = a[0];
        for (int i = 1; i < 10; i++) {
            if (a[i] > maxm) {
                maxm = a[i];
            }
        }
        return maxm;
    }

    // Method to return the least mark
    public int leastMark() {
        int minm = a[0];
        for (int i = 1; i < 10; i++) {
            if (a[i] < minm) {
                minm = a[i];
            }
        }
        return minm;
    }

    public int getMode() {
        int mode = a[0];
        int maxf = 1;

        for (int i = 0; i < 10; i++) {
            int freq = 1;

            for (int j = i + 1; j < 10; j++) {
                if (a[i] == a[j]) {
                    freq++;
                }
            }

            if (freq > maxf || (freq == maxf && a[i] > mode)) {
                mode = a[i];
                maxf = freq;
            }
        }

        return mode;
    }

    public int getFreqAtMode() {
        int mode = getMode();
        int freq = 0;

        for (int i = 0; i < 10; i++) {
            if (a[i] == mode) {
                freq++;
            }
        }
        return freq;
    }

    public void display() {
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }

    public static void main(String[] args){
        Performance p = new Performance();
        p.readMarks();
        p.display();
    }
}
