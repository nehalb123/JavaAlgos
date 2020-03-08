public class ProductOfArrayExceptSelf {

    int[] productExceptSelf(int arr[]){

        /*The idea here is to calculate product of left terms and the product of right terms.
        Multiplying these left and right array would result in product of array except self.
        Restriction: Division is not allowed.
        This is an optimised solution which doesn't use extra space for the right array*/
        
        int output_array[] = new int[arr.length];
        output_array[0] = 1;
        for(int i = 1; i < output_array.length; i++){
            output_array[i] = arr[i-1] * output_array[i-1];
        }

        int R = 1;
        for(int i = arr.length-1; i >= 0 ; i--){
            output_array[i] = output_array[i] * R;
            R *= arr[i];
        }
        return output_array;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int arr[] = {1,2,3,4};
        int output[] = obj.productExceptSelf(arr);
        for (int i =0; i< output.length; i++){
            System.out.println(output[i]);
        }
    }
}
