package newgrailsproject.com.info.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mdtofazzal.hossain on 3/13/2019.
 */

@RestController
@RequestMapping(value = "/finalCipher2")
public class FinalCipherController2 {

    @RequestMapping(value = "/generateChypher2")
    public static void generateChypher() {
//        count();
        //space();
//        decrypt();

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        String plainText = readFile(inputFile);

//        String cipherText = encrypt(plainText);
        String cipherText = encrypt();
        String decryptedText = decrypt();
//        String decryptedText = decrypt(cipherText, outputFile);

        System.out.println("Plain Text :" + plainText);
        System.out.println("Encrypted Text :" + cipherText);
        System.out.println("Decrypted Text :" + decryptedText);

        //space(plainText, outputFile);

    }

    private static String encrypt() {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        String plainText = readFile(inputFile);

        byte[] textBytes = plainText.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue > 255 ? currentByteValue - 255 + 2 : currentByteValue + 2);
        }
        String strByte = new String(textBytes);
        return strByte;
    }

    private static String decrypt() {
        Scanner console = new Scanner(System.in);
        System.out.print("Output file: ");
        String outputFile = console.next();

        String encryptText = encrypt();

        byte[] textBytes = encryptText.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strByte = new String(textBytes);

        try {
            File file = new File(outputFile);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(strByte);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strByte;
    }


    static void count() throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        String plainText = readFile(inputFile);

        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        char[] strArray = plainText.toCharArray();

        for (char c : strArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c,1);
            }
        }

        /*try {
            File file = new File(System.getProperty("user.dir") + "/src/" +outputFile);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(hashMap.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println(hashMap.toString());

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(outputFile + ".json"), hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String inputFile) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/" + inputFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String plainText = sb.toString();
            return plainText;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private static String space() {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        String plainText = readFile(inputFile);
        byte[] textBytes = plainText.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            if (currentByteValue == ' ') {
                System.out.println("currentByteValue " + (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2));
            }
            textBytes[i] = (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strByte = new String(textBytes);

        try {
            File file = new File(System.getProperty("user.dir") + "/src/" + outputFile );
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(strByte);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("strByte");
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(System.getProperty("user.dir") + "/src/" +outputFile), strByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        return strByte;
    }

}
