import java.util.Scanner;
import java.util.Random;



public class RandomPasswordGenerator {

    public static void main(String[] args){

        //Checks that the user enters a valid digit between 8 and 50
       int validDigit = checkLength();
       System.out.println("The length of your password is: " + validDigit);

       String Password = generatePassword(validDigit);
       System.out.println("Your password is: " + Password);
    }

    public static int checkLength(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter length of password between 8 and 50: ");

        String userInput = input.nextLine();

        try {
            Integer.parseInt(userInput);
            int length = Integer.parseInt(userInput);

            if ( length >50 || length < 8){
                System.out.println("Invalid entry");
                return checkLength();
            }
            else{
                return length;
            }


        } catch (NumberFormatException e){
            System.out.println("Invalid entry");
            return checkLength();
        }


    }

    public static String generatePassword(int validDigit){

        String allChars = "ABCDEFGHIJCLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@#$%^&*()?<>";
        Random rand = new Random();

        char[] Password = new char[validDigit];

        for (int i =0; i < validDigit; i++ ){
                int index = rand.nextInt(allChars.length());
                Password[i] = allChars.charAt(index);
            }

        return new String (Password);

    }

}
