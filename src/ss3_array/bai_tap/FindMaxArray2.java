package ss3_array.bai_tap;

public class FindMaxArray2 {
    public static void main(String[] args) {
        int [][] arr={
                {1,3,4,2,5},
                {3,5,6,7,10},
                {6,7,4,3,5,1,2,3}
        };
        int max=arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]>max){
                    max=arr[i][j];
                }
            }
        }
        System.out.println("Max: " + max);
    }
}
