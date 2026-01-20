
import java.util.*;


public class DuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();
        // initialize tje array
        int[] arr = new  int[n];
        System.out.println("enter the element in array");
        for (int i = 0;i<n;i++){
            System.out.print("enter the "+i+"element in array=>");
            arr[i]= sc.nextInt();

        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> Duplicate = new HashSet<>();
        for(int num:arr){
            if(!set.add(num)){
                Duplicate.add(num);
            }

        }
        System.out.println("Duplicate number is =>"+Duplicate);
    }
}
