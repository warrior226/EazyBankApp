import java.util.Base64;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    /**
     * Calculates the square root of a number
     * @param number the number to calculate the square root of
     * @return the square root of the number
     */
    public static double calculateSquareRoot(double number){
        return Math.sqrt(number);
    }
    /**
     * Decodes a base64 string
     * @param base64String the string to decode
     * @return the decoded string
     */
    public static String decodeBase64(String base64String){
        return new String(Base64.getDecoder().decode(base64String));
    }
}
