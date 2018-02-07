import java.io.*;
import java.util.ArrayList;
import static java.lang.Math.pow;

public class HexDec_Converter {

    public static void main(String[] args) {
        String s = new String();
        ArrayList<String> resultString = new ArrayList<String>();

        //String[] returnString = new String[];
        int inputFilePathIndex = 0;
        int outputFilePathIndex = 0;
        String line = null;
        boolean inputNotFound = false;
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-i")){
                inputFilePathIndex = i + 1;
                break;
            }
        }
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-o")){
                outputFilePathIndex = i + 1;
            }
        }
            if(inputFilePathIndex != 0){
                try {
                    FileReader fileReader = new FileReader(args[inputFilePathIndex]);
                    BufferedReader br = new BufferedReader(fileReader);
                    while((line = br.readLine())!= null){
                        s += line + "\n";
                    }
                    br.close();
                } catch (java.io.IOException e) {
                    System.out.println("Input file cannot be read!");
                    return;
                    //e.printStackTrace();
                }
            }else{
                if(args.length > 1){
                    for(int i = 0; i < args.length; i++){
                        if(args[i].equals("-o")){
                            break;
                        }
                        s += args[i].replace(";","").replace(",","").replace(" ","") + "\n";
                    }
                    //s.replaceAll("\\;","");
                }else{
                    System.out.println("Input not given!");
                    return;
                }
            }
                char[] valid = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
                //s.replace("\r\n", "\n");
                //String[] numbers = s.split(", |; | |\n|[\\r\\n]+|\r");
                String[] numbers = s.split(", |; | |\n");
                String result = new String();
                for (int i = 0; i < numbers.length; i++) {
                    char[] charArray = numbers[i].toCharArray();
                    if (charArray[0] == '0' && charArray[1] == 'x') {
                        result = convertHex2Dec(numbers[i]);
                    } else if (charArray[0] == '1' || charArray[0] == '2' || charArray[0] == '3' || charArray[0] == '4'
                            || charArray[0] == '5' || charArray[0] == '6' || charArray[0] == '7' || charArray[0] == '8'
                            || charArray[0] == '9') {
                        result = convertDec2Hex(numbers[i]);
                    } else {
                        result = "invalid hexadecimal/decimal value.";
                    }
                    resultString.add(numbers[i]);
                    resultString.add(result);
                    //System.out.print(numbers[i] + " " + result + "\n");
                }
            if(outputFilePathIndex == 0){
                for(int i = 0; i < resultString.size(); i+=2){
                    System.out.println(resultString.get(i) + " " + resultString.get(i+1));
                }
            }else if(args[outputFilePathIndex].equals(args[inputFilePathIndex])){
                System.out.println("Input and output cannot be the same!");
                for(int i = 0; i < resultString.size(); i+=2){
                    System.out.println(resultString.get(i) + " " + resultString.get(i+1));
                }
            }else{
                try {
                    BufferedWriter wr = new BufferedWriter(new FileWriter(args[outputFilePathIndex]));
                    //wr.append('input output');
                    for(int i = 0; i < resultString.size(); i += 2){
                        wr.append(resultString.get(i) + " " + resultString.get(i+1) + "\r\n");
                    }
                    wr.close();
                } catch (IOException e) {
                    System.out.println("Output file not found!");
                    return;
                }

            }
            return;
    }


    public static String convertHex2Dec(String inputHex){
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int[] dec = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int calculatedValue = 0;
        String reduced = inputHex.substring(2, inputHex.length());
        char[] charArray = reduced.toCharArray();
        //System.out.print(reduced);
        //System.out.print(reduced.length());
        //System.out.print(charArray.length);
        //System.out.print(charArray[2]);
        for(int i = charArray.length - 1; i >= 0; i--){
            for(int j = 0; j < hex.length; j++){
                if(charArray[i] > 'F'){
                    return "invalid hexadecimal/decimal value.";
                }
                if(charArray[i] == hex[j]){
                    calculatedValue = (int) (calculatedValue + ( pow(16, charArray.length - i - 1) * dec[j]));
                }
            }
        }
        return Integer.toString(calculatedValue);
    }


    public static String convertDec2Hex(String inputDec) {

        char digits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal="";
        inputDec = inputDec.toUpperCase();
        int num = Integer.parseInt(inputDec);
        int rem = 0;

        while(num != 0)
        {
            rem=num%16;
            hexadecimal= digits[rem] + hexadecimal;
            num= num/16;
        }


        String finalhex = "0x" + hexadecimal;
        return finalhex;
    }
}