import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InversionCountFast {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = parseStringToIntArray(bufferedReader.readLine());
        int[] temp = new int[numbers.length];
        System.out.println(mergeSort(numbers, temp, 0, numbers.length - 1));
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    private static int mergeSort(int arr[], int temp[], int left, int right) {
        int invCount = 0;
        if (right > left) {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            int mid = left + ((right - left) / 2);

        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            invCount = mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);

        /*Merge the two parts*/
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }
    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/

    private static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left; /* i is index for left subArray*/
        int j = mid;  /* j is index for right subArray*/
        int k = left; /* k is index for resultant merged subArray*/
        int invCount = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }

      /* Copy the remaining elements of left subArray
       (if there are any) to temp*/
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }

      /* Copy the remaining elements of right subArray
       (if there are any) to temp*/
        while (j <= right) {
            temp[k++] = arr[j++];
        }

      /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    private static int[] parseStringToIntArray(String input) {
        String[] elements = input.split("\\s+");
        int[] arr = new int[elements.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }
        return arr;
    }
}