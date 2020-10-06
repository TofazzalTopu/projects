package com.example.demo.domain

class Student {
    String name
    String studentId
    int age


    static constraints(){
        name (null : false)
        studentId (null : false)
    }
}
