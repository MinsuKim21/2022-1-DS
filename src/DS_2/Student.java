package DS_2;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    protected int id;
    String name;
    protected String dept;
    protected int grade;

    public Student(int id, String name, String dept, int grade) {
        this.id = id;
        this.dept = dept;
        this.grade = grade;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.id; //this.id - s.id는 오름차순 / s.id - this.id는 내림차순
    }

    public static Comparator<Student> CompName = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);//string은 기본적으로 compareTo 메소드를 가지고있음
        }
    };
    public static Comparator<Student> CompDept = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.dept.compareTo(s2.dept);//string은 기본적으로 compareTo 메소드를 가지고있음
        }
    };
    public static Comparator<Student> CompGrade = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.grade - s2.grade;//s2.grade - s1.grade는 내림차순
        }
    };
}
