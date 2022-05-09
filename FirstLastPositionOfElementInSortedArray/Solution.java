package FirstLastPositionOfElementInSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        boolean firstOccFound = false;
        boolean secondOccFound = false;       
        int[] occurrenceIndices = new int[2];
        int numSize = nums.length;
        
            for(int i = 0; i < numSize; i++){
                if(nums[i] == target && firstOccFound == false){
                    occurrenceIndices[0] = i;
                    firstOccFound = true;
                }
                
                if(nums[(numSize - 1) - i] == target && secondOccFound == false){
                    occurrenceIndices[1] = (numSize - 1) - i;
                    secondOccFound = true;
                }
                
                if(firstOccFound == true && secondOccFound == true){
                    return occurrenceIndices;
                }
            }
        
        
        return new int[] {-1,-1};
        
    }
}
