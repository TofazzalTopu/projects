package com.info;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class FinalPalindrome05 {
    public static String outputFile = "";
    public static String inputFile = "";
    public static String sampleText  = "dfgdfgdgdgdf";

    public static void main(String args[]) {
        boolean s= true;
        /*Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        inputFile = console.next();
        System.out.print("Output file: ");
        outputFile = console.next();*/

        inputFile = "ddata.txt";
        outputFile = "yot.txt";

       /* String fileName = "data.txt";
        ClassLoader classLoader = new ReadResourceFileDemo().getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());*/
        URL viaClass=FinalPalindrome05.class.getResource("pal.txt");
        URL viaLoader=FinalPalindrome05.class.getClassLoader().getResource("pal.txt");

        String fileName = "pal.txt";

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        String plainText = readFile(inputFile);
        int length = longestPalindrome(plainText);

        System.out.print("\nLength of the Palindrome is: " + length);
    }

    public static String readFile(String inputFile) {
        try {
//            This will work in online
//            File file = new File( "src/" + inputFile);
            File file = new File(System.getProperty("user.dir") + "/src/" + inputFile);
           if(file.isFile()) {
               FileReader fileReader = new FileReader(file);
               BufferedReader br = new BufferedReader(fileReader);
               StringBuilder sb = new StringBuilder();
               String line = br.readLine();
               while (line != null) {
                   sb.append(line);
                   sb.append(System.lineSeparator());
                   line = br.readLine();
               }
               String plainText = sb.toString();
               return plainText;
           }else {
               System.out.println("File not found!");
               return sampleText;
           }

        } catch (IOException e) {
            return e.getMessage();
        }
    }


    static String printSubString(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
        try {
            File file = new File(System.getProperty("user.dir") + "/src/" + outputFile);
//            File file = new File( "src/" + outputFile);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str.substring(low, high + 1));
            fileWriter.flush();
            fileWriter.close();
            return str;
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    static int longestPalindrome(String str) {
        int n = str.length();
        boolean table[][] = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str.charAt(i) ==
                        str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        System.out.println("Longest palindrome substring is: ");
        printSubString(str, start, start + maxLength - 1);
        System.out.println(" And maxLength is " + maxLength);
        return maxLength;
    }
}
