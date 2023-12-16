package Code_for_package_5b;
import java.util.Scanner;

public class WaterConserveMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the no. of blocks for CityBlocks: ");
        int n = s.nextInt();
        try {
        int a = 0;
        int[] blocks1 = new int[n];
        System.out.println("Enter value for array below");
        for (int i = 0; i < n; i++) {
            a = i+1;
            System.out.println("Enter the "+ a +" number: ");
            blocks1[i] = s.nextInt();
        }
        CityBlockConservation conservation = new CityBlockConservation();

        int result1 = conservation.calculateTrappedWater(blocks1);
        System.out.println("You entered this- ");
        System.out.println("CityBlocks Height: " + java.util.Arrays.toString(blocks1));
        System.out.println("Total Water trapped: " + result1 + " units.");
        }
        catch (Exception e){
            System.out.println("No of elements in arrays in negative or not correct");
        }
    }
}
