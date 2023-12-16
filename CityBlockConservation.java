package Code_for_package_5b;

public class CityBlockConservation extends RainySeasonConservation{

    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        //For  trapping the water need atleast 3 blocks
        if (blockHeights == null || blockHeights.length <= 2) {
            return 0;
        }

        int n = blockHeights.length;
        //Storing the values in left and right max value.
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }
        //Calculating max of both sides from opposite then calculating the area
        //subtracting from them if there is a presence of any blocks btwn it.
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        int waterleft = 0;
        for (int i = 0; i < n; i++) {
            waterleft += Math.max(0, Math.min(leftMax[i], rightMax[i]) - blockHeights[i]);
        }

        return waterleft;
    }
}
