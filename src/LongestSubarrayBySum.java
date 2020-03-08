import java.util.Arrays;

public class LongestSubarrayBySum {

    int[] longestSubArrayBySum(int sum, int arr[]){
        /*Given a sum find the longest sub-array whose values add up to the sum;
        the array consists of non-negative numbers*/
        int result[] = new int[]{-1};
        int curr_sum = 0;
        int left = 0;
        int right = 0;

        while(right < arr.length){
            curr_sum+=arr[right];
            while(curr_sum > sum && left < right){
                curr_sum -= arr[left++];
            }
            if(curr_sum == sum && (result.length ==1 || result[1] - result[0] < right - left)){
                result = new int[]{ left+1, right+1};
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,0,0,0,6,7,8,9,10};
        int sum =15;
        LongestSubarrayBySum ls = new LongestSubarrayBySum();
        int result[] = ls.longestSubArrayBySum(sum, arr);
        System.out.println("Range:"+ Arrays.toString(result));

    }
}
