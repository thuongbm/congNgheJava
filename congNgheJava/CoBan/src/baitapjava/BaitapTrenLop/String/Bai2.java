package baitapjava.BaitapTrenLop.String;

public class Bai2 {
    public static void main(String[] args){
        String s = "2 34.5 -12.9 0 12 1.98";
        if (!check(s)){
            System.out.println("false");
        }
        else {
            int res = count(s);
            System.out.println("co " + res + " so");
        }
    }
    public static int count (String s){
        String[] nums = s.split(" ");
        int cnt = 0;
        for (String num : nums){
            if (!num.isEmpty()){
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean check (String s){
        for (char c : s.toCharArray()){
            if (!Character.isDigit(c) && c != ' ' && c != '-' && c != '.'){
                return false;
            }
        }
        return true;
    }
}
