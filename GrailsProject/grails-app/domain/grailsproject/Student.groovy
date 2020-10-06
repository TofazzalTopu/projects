package grailsproject

class Student {
    String      studentId
    String      name
    int         age
    boolean     status

    static constraints = {
        studentId(nullable: false)
        name(nullable: false)
    }
}
