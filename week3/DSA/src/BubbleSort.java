public class BubbleSort {

    void bubbleSort(int arr[]){

        for(int i = 0; i < arr.length; i++){
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j+1]){
                    isSorted = false;
                    int placeholder = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = placeholder;
                }
            }
            if (isSorted){
                break;
            }
        }
    }


    public static void main(String[] args) {
        //Unsorted
        int arr[] = {2,4,1,7,3};
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        //Sorted using bubble sort
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
