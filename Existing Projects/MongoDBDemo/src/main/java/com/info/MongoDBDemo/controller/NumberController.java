package com.info.MongoDBDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

/**
 * Created by mdtofazzal.hossain on 3/10/2019.
 */

@RestController
@RequestMapping(value = "/number")
public class NumberController {


    @RequestMapping(value = "/test")
    public boolean testNumber() {
        int a = 10;
        int b = 10;

        System.out.println(a == b);
        return a == b;
    }

    @RequestMapping(value = "/sumOfRecursion")
    public String sumOfRecursion() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        addNumbers(num);

        return "Sum Of Recursion "+ addNumbers(num);
    }

    public int addNumbers(int n) {
        if (n != 0) {
            return n + addNumbers(n - 1);
        } else {
            return n;
        }
    }

    @RequestMapping(value = "/multiplyOfRecursion")
    public String multiplyOfRecursion() {
        int num = 5;
        long multiplyNumbers = multiplyNumbers(num);

        return "Multiply Of Recursion"+ num+" "+ multiplyNumbers;
    }

    public long multiplyNumbers(int n) {
        if (n >= 1) {
            return n * multiplyNumbers(n - 1);
        } else {
            return 1;
        }
    }
    @RequestMapping(value = "/sumOfArrayInRecursiveWay")
    public int sumOfArrayInRecursiveWay(){
        int arr[] = { 1, 2, 3, 4, 5 };
        findSum(arr, arr.length);
        return findSum(arr, arr.length);
    }

    static int findSum(int A[], int N)
    {
        if (N <= 0)
            return 0;
        return (findSum(A, N - 1) + A[N - 1]);
    }
}
