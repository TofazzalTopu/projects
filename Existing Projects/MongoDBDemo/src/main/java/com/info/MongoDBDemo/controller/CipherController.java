package com.info.MongoDBDemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.util.JSONParseException;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping(value = "/cipher")
public class CipherController {
    public static final String plainText = "abcdefghijklmnopqrstuvwxyz";


    public static String generateChypher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text");
        String pl = sc.nextLine();
        pl = pl.toUpperCase();
        System.out.println(pl);
        System.out.println("Enter the shift factor");
        int n = sc.nextInt();
        System.out.println("Cipher Text:");
        char a[] = pl.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (n + (int) a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        return "Success";
    }

    public static void cipherExample() {
        String plainText = "The brown fox jum.ped over the lazy dog.";
        String strcipherText = Encrypt(plainText);
        String strdecryptedText = Decrypt(strcipherText);

        System.out.println("Plain Text :" + plainText);
        System.out.println("Encrypted Text :" + strcipherText);
        System.out.println("Decrypted Text :" + strdecryptedText);
    }

    private static String Encrypt(String text) {
        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue > 255 ? currentByteValue - 255 + 2 : currentByteValue + 2);
        }
        String strbyte = new String(textBytes);
        return strbyte;
    }

    private static String Decrypt(String text) {
        byte[] textBytes = text.getBytes();
        for (int i = 0; i < textBytes.length; i++) {
            int currentByteValue = (int) textBytes[i];
            textBytes[i] = (byte) (currentByteValue < 0 ? currentByteValue + 255 - 2 : currentByteValue - 2);
        }
        String strbyte = new String(textBytes);
        return strbyte;
    }



    public static int frequency1(String str) {

        char[] string = {100};
        int c, count[] = {26};

        System.out.println("Input a string\n");
//        gets(string);

        find_frequency(string, count);

        System.out.println("Character Count\n");

        for (c = 0 ; c < 26 ; c++)
            System.out.println("%c \t  %d\n"+ c + 'a'+ count[c]);

        return 0;
    }

    static void find_frequency(char s[], int count[]) {
        int c = 0;

        while (s[c] != '\0') {
            if (s[c] >= 'a' && s[c] <= 'z' )
                count[s[c]-'a']++;
            c++;
        }
    }


    public static String frequency(String str) {
//        String str = "This website is awesome.";
        char ch = 'e';
        int frequency = 0;

        for(int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i)) {
                ++frequency;
            }
        }
        ObjectMapper mapper = new ObjectMapper();

        /*JSONPObject json = new JSONPObject();
        json.put("title", "Harry Potter and Half Blood Prince");
        json.put("author", "J. K. Rolling");
        json.put("price", 20);
    */


        try {

            // Writing to a file
            mapper.writeValue(new File("D://data.json"), frequency);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Frequency of " + ch + " = " + frequency);
        return "";
    }

    public static void testRun() {
        Object countryObj = new Object();
        List<String> listOfStates = new ArrayList<>();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Rajasthan");

//        countryObj.states = listOfStates ;
        ObjectMapper mapper = new ObjectMapper();

        /*JSONPObject json = new JSONPObject();
        json.put("title", "Harry Potter and Half Blood Prince");
        json.put("author", "J. K. Rolling");
        json.put("price", 20);
    */


        try {

            // Writing to a file
            mapper.writeValue(new File("D://country.json"), listOfStates);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //==============
    }

    public static void newData( String cipherText) {
        Map<String,String> mymap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char cipherTextChar = cipherText.charAt(i);
            char plainTextChar = plainText.charAt(i);
            String s = String.valueOf(cipherTextChar);
            String ss = String.valueOf(plainTextChar);

            mymap.put(s, ss);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Writing to a file
            mapper.writeValue(new File("D://data.json"), mymap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String encrypt(String inputWord, String cipherText) {
        String encryptedString = inputWord.toLowerCase();
        for (int i = 0; i < 26; i++) {
            char cipherTextChar = cipherText.charAt(i);
            char plainTextChar = plainText.charAt(i);
            encryptedString = encryptedString.replace(plainTextChar, cipherTextChar);

        }
        System.out.print("Output encryptedString: " + encryptedString + "\n");

        return encryptedString;
    }
    @RequestMapping(value = "/testCipher")
    public static void testCipher() throws FileNotFoundException{
        String cipherText = "INTERNATIONAFOOTBALLBANGLADESHAABBDD";

        System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String basic01 = console.next();
        System.out.print("Output file: ");
        String result = console.next();
        try {
//            String data = readFileAsString(System.getProperty("user.dir")+"/src/"+basic01+".txt");
//            System.out.println(data);


            FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/"+basic01+".txt");
//            FileReader reader = new FileReader("D:/" + basic01 + ".txt");
            Scanner in = new Scanner(reader);
//            PrintWriter out = new PrintWriter("D:/" + result + ".txt");
            String line = in.nextLine();

            characterCount(cipherText, result);

            /*while (in.hasNextLine()) {
                String line = in.nextLine();
                String encipheredText = encrypt(line, cipherText);
                System.out.println("Plain Text: " + line);
                System.out.println("Cipher Text: " + encipheredText);
                out.println(encipheredText);
            }*/
//            out.close();
        } catch (IOException exception) {
            System.out.println("Error processing file:" + exception);
        }
    }
    static void characterCount(String inputString, String result)
    {


//        PrintWriter out = new PrintWriter(writer);
        // Creating a HashMap containing char as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        // Converting given string to char array
        char[] strArray = inputString.toCharArray();

        // checking each char of strArray
        for (char c : strArray) { if (charCountMap.containsKey(c)) {
                // If char is present in charCountMap, incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                // If char is not present in charCountMap, // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }

        // Printing the charCountMap
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            PrintWriter out = new PrintWriter(System.getProperty("user.dir")+"//src//" + result + ".json");

            mapper.writeValue(new File( result +".json"), charCountMap); // Writing to a file
//            mapper.writeValue(new File("D://jsnData.json"), charCountMap); // Writing to a file
            System.out.println("Present Project Directory : "+ new PrintWriter(System.getProperty("user.dir")+"//src//" + result)+".json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFileAsString(String fileName)throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }catch (IOException e){
            return e.getMessage();
        }
    }



}
