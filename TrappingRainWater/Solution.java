import java.util.List;
import java.util.*;


public class Solution {

    public static void main(String args[]){
        int[] height = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
        int totalWater = trap(height);

        System.out.println("Total Water: " + totalWater);
    }

    public static int trap(int[] height){
        int[] maxLeft = getMaxLeft(height);
        int[] maxRight = getMaxRight(height);

        int totalWater = 0;
        for(int i = 0; i < height.length; i++){
            int currentWater = Math.min(maxLeft[i], maxRight[i]) - height[i];

            if(currentWater > 0) {
                totalWater += currentWater;
            }
        }

        return totalWater;
    }

    public static int[] getMaxLeft(int[] height){

        int maxLeft = height[0];
        int[] maxLeftArray = new int[height.length];

        for(int i = 1; i < height.length; i++){
            maxLeft = Math.max(height[i], maxLeft);
            maxLeftArray[i] = maxLeft;
        }

        return maxLeftArray;
    }

    public static int[] getMaxRight(int[] height){

        int maxRight = height[height.length - 1];
        int[] maxRightArray = new int[height.length];

        for(int i = height.length - 2; i >= 0; i--){
            maxRight = Math.max(height[i], maxRight);
            maxRightArray[i] = maxRight;
        }

        return maxRightArray;
    }

}