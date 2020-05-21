
import static java.lang.Integer.*;

/**
 * Kaprekar's constant, or 6174, is a constant that arises when we take a 4-digit integer, 
 * form the largest and smallest numbers from its digits, and then subtract these two numbers. 
 * Continuing with this process of forming and subtracting, we will always arrive at the number 6174.
 * @author HarmoniousMechanism
 */
public class KaprekarsConstant {
    int steps = 0;


    public int KaprekarsConstant(int num){
        int ascending, descending;
        
        // Exit condition
        if(num == 6174){
            System.out.println("The value of KaprekasConstant is: " + num);
            System.out.println("The number of steps is: " + steps);
            return steps;
        }
        
        int arr[] = breakNumber(num);
        
        ascending = (intArrayToInt(LowestValue(arr)));
        descending = (intArrayToInt(HighestValue(arr)));
        
        int result = descending - ascending;
        System.out.println(descending +" - " + ascending + " = " + result);
        steps++;
        return KaprekarsConstant(result);
    }

    public int[] breakNumber(int num){
        int arr[] = new int[4];
        for(int i = 3; i >= 0; i--){
            arr[i] = num % 10;
            num = num / 10;
        }
        return arr;
    }

    public int[] LowestValue(int[] arr){
        for(int j = 4; j > 0; j--){
            for(int i = 1; i < j; i++){
                if(arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
    
    public int[] HighestValue(int[] arr){
        for(int j = 4; j > 0; j--){
            for(int i = 1; i < j; i++){
                if(arr[i-1] < arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public int intArrayToInt(int[] arr){
        int returnInt = 0;
        for(int i = 0; i < arr.length; i++){
           returnInt += (int) (arr[arr.length - 1 - i] * java.lang.Math.pow(10, i)); 
        }
        return returnInt;
    }
    public static void main(String[] args){
        int num = 2421;
        
        KaprekarsConstant k = new KaprekarsConstant();
        int value = k.KaprekarsConstant(num);
    }


}
