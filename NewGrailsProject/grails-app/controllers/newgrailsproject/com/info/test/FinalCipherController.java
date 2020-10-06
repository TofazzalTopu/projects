package newgrailsproject.com.info.test;

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
@RequestMapping(value = "/finalCipher")
public class FinalCipherController {

    @RequestMapping(value = "/generateChypher")
    public static void generateChypher() {
        count();

        /*Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        String plainText = readFile(inputFile);

        String cipherText = encrypt(plainText);
        String decryptedText = decrypt(cipherText, outputFile);

        System.out.println("Plain Text :" + plainText);
        System.out.println("Encrypted Text :" + cipherText);
        System.out.println("Decrypted Text :" + decryptedText);*/

        //space(plainText, outputFile);

    }

    private static String encrypt(String text) {

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue > 255 ? currentByteValue - 255 + 2 : currentByteValue + 2);
        }
        String strByte = new String(textBytes);
        return strByte;
    }

    private static String decrypt() {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFile = console.next();
        System.out.print("Output file: ");
        String outputFile = console.next();

        String plainText = readFile(inputFile);

        byte[] textBytes = plainText.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strByte = new String(textBytes);

        try {
            File file = new File(outputFile + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(strByte);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("strByte");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strByte;
    }


    static void count() {

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

        try {
            File file = new File(System.getProperty("user.dir") + "/src/" +outputFile);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(hashMap.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* for (char c : strArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(new StringBuilder().append('"').append(c).append('"').toString(), new StringBuilder().append('"').append(hashMap.get(c)).append(1).append('"').toString());
            } else {
                hashMap.put(new StringBuilder().append('"').append(c).append('"').toString(), new StringBuilder().append('"').append(1).append('"').toString());
            }
        }*/
        /*StringBuilder mapAsString = new StringBuilder("{");
        for (String key : hashMap.keySet()) {
            mapAsString.append(key + "=" + hashMap.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        System.out.println(mapAsString.toString());
        String s = new String(hashMap.toString());*/

        /*ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(outputFile + ".json"), hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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

    private static String space(String text, String outputFile) {
        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            if (currentByteValue == ' ') {
                System.out.println("currentByteValue " + (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2));
            }
            textBytes[i] = (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strByte = new String(textBytes);

        try {
            File file = new File(outputFile + ".json");
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
            mapper.writeValue(new File(outputFile + ".txt"), strByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        return strByte;
    }

}
