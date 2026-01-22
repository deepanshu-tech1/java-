import java.util.*;
class Solution{
    // S2 is the main string and S1 is the  subsequence string 
    public boolean issubsequence(String S1,String S2) {
        int j = 0, i = 0;
        while (i < S1.length() && j < S2.length()) {
            if (S1.charAt(i) == S2.charAt(j)) {
                i++;
            }
            j++;
        }
        return  i == S1.length();
    }


}

public class SubsequenceString{
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the first string");
        String S1 = sc.nextLine();
        System.out.println("please enter your second string =>");
        String S2 = sc.nextLine();
        if(obj.issubsequence(S1,S2)){
            System.out.println("yes your string is sebsequent");
        }
        else{
            System.out.println("String is not subsequent");
        }

    }
}
