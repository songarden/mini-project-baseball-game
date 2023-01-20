package CNU_ACA_230120;

import java.util.Scanner;

public class ButFast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int questionNum = sc.nextInt();
        String[] answer = new String[questionNum];
        int num1;
        int num2;
        int i;
        int gcd;
        for(i=0;i<questionNum;i++){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            if(num1>=num2){
                gcd = getGCD(num1,num2);
            }
            else{
                gcd = getGCD(num2,num1);
            }
            if(gcd == 1){
                answer[i] = "Perfect";
            }
            else{
                answer[i] = "Not even close";
            }
        }
        for(i=0;i<questionNum;i++){
            System.out.println(answer[i]);
        }

    }
    public static int getGCD(int num1,int num2){
        if (num1%num2 == 0){
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}
