import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to encode or decode a message? (Type E for encode and D for decode):");

        String i = scanner.nextLine();

        if(i.equals("E")){

            System.out.println("Enter the text you wish to encode:");

            String msg = scanner.nextLine();

            System.out.println("Your encoded message is: " + encode(msg));

        }else if(i.equals("D")){

            System.out.println("Enter the text you wish to decode:");

            String encoded = scanner.nextLine();

            System.out.println("Your encoded message is: " + decode(encoded));

        }else{
            System.out.println("Invalid input.");
        }



    }

    public static String alphabet(){

        String alphabet = "ABCDEFGHIJKLM NOPQRSTUVWSYZ";

        return alphabet;

    }

    public static String revAlphabet(){

        String revAlphabet = reverseString(alphabet());

        return revAlphabet;
    }

    public static String reverseString(String string){

            String og = string.toUpperCase();
            String reverse = "";

            char[] arr = string.toCharArray();

            for(int i = arr.length - 1; i > -1; i--){

                reverse = reverse + og.charAt(i);

            }

            return reverse;
    }

    public static String decode(String string){

        String alph = alphabet();
        String revAlph = revAlphabet();
        String encoded = string.toUpperCase();
        String decoded = "";


        char[] arr = encoded.toCharArray();

        for(int i = 0; i < arr.length; i++){

            Boolean running = true;
            int search = 0;

            while(running){
                if(encoded.charAt(i) == revAlph.charAt(search)){
                    running = false;
                }else{
                    search++;
                }
            }

            decoded = decoded + alph.charAt(search);

        }


        return decoded;
    }

    public static String encode(String string){


        String alph = alphabet();
        String revAlph = revAlphabet();
        String message = string.toUpperCase();
        String encoded = "";


        char[] arr = message.toCharArray();

        for(int i = 0; i < arr.length; i++){

            Boolean running = true;
            int search = 0;

            while(running){
                if(message.charAt(i) == alph.charAt(search)){
                    running = false;
                }else{
                    search++;
                }
            }

            encoded = encoded + revAlph.charAt(search);

        }


        return encoded;

    }

}
