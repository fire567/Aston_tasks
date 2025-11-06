package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student first = new Student("Mihail", 110, 3, 4);
        Student second = new Student("Anastasia", 111, 3, 2);
        Student third = new Student("Sasha", 110, 2, 5);
        Student fourth = new Student("Lesha", 111, 3, 3);

        ArrayList<Student> students = new ArrayList<>();
        students.add(first);
        students.add(second);
        students.add(third);
        students.add(fourth);

        showStudentsList(students);

        deleteStudents(students);
        showStudentsList(students);

        setHigherCourse(students);
        showStudentsList(students);

        printStudents(students, 4);

    }

    public static void showStudentsList(ArrayList<Student> students) {
        for(Student student : students) {
            System.out.println("Имя: " + student.name + ", " + "Группа: " + student.group + ", " + "Курс: " + student.course + ", " + "Оценка: " + student.mark);
        }

        System.out.println("______________________________");
    }

    public static void deleteStudents(ArrayList<Student> students) {
        ArrayList<Student> studentsWithBadMarks = new ArrayList<>();

        for(Student student : students) {
            if(student.mark < 3) {
                studentsWithBadMarks.add(student);
            }
        }

        for(Student student : studentsWithBadMarks) {
            students.remove(student);
        }
    }

    public static void setHigherCourse(ArrayList<Student> students) {
        for (Student student : students) {
            if(student.mark >= 3){
                student.course += 1; 
            }
        }
    }

    public static void printStudents(ArrayList<Student> students, int course) {
        for (Student student : students) {
            if(student.course == course) {
                System.out.println(student.name);
            }
        }
    }
}