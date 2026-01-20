import java.util.*;

public class FindUniqueElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         // take the size of the array
        System.out.print("Enter the size of the array");
        int n = sc.nextInt();
        // create the array
        int[] arr = new  int[n];
        // take the input element for array from user
        for(int i = 0;i<n;i++){
            System.out.println("enter the "+i+ "in array");
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        // count the frequency of array
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // print the unique element
        System.out.print("unique elements=>" );
        for(int num:arr){
            if(map.get(num)==1){
                System.out.print(num +"  ");
            }
        }
    }
}
