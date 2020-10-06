package com.info;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mdtofazzal.hossain on 3/13/2019.
 */

//@RestController
//@RequestMapping(value = "/finalPalindrome2")
public class FinalPalindromeController2 {

    //    @RequestMapping(value = "/longestPalindrome2")
    public void longestPalindrome() {
        try {
            System.out.print("Input string.. :  ");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            String inputString = reader.readLine();
            System.out.println(inputString);
            System.out.println("Length of longest palindrome is: " +
                    longestPalindrome(inputString));

        } catch (Exception e) {
            new RuntimeException(e.getMessage());
        }
    }


    static void printSubString(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
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
        System.out.print("Longest palindrome substring is; ");
        printSubString(str, start, start + maxLength - 1);
        return maxLength;
    }


}
