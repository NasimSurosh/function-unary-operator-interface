package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Student {
  
  private String name; 
  private double gpa;
  private boolean graduated;
  
  
  public Student(String name, double gpa, boolean graduated) {
    super();
    this.name = name;
    this.gpa = gpa;
    this.graduated = graduated;
    
    
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getGpa() {
    return gpa;
  }
  public void setGpa(double gpa) {
    this.gpa = gpa;
  }
  public boolean isGraduated() {
    return graduated;
  }
  public void setGraduated(boolean graduated) {
    this.graduated = graduated;
  }
  
  
  
  @Override
  public String toString() {
    return "Student Name: " + name + "\tGPA: " + gpa + "\tGraduated: " + graduated;
  }
  
  
  
}

public class Main {

  public static void main(String[] args) {
    
    var students = new ArrayList<>(List.of(new Student("Bob", 4.9, true), new Student("Vanessa", 2.4, false),
        new Student("Fred", 1.5, false), new Student("Beau", 5.3, true), new Student("Silvie", 3.9, true),
        new Student("Alfie", 2.4, false), new Student("Silke", 3.6, true)));
    
    System.out.println("List of Students:");
    students.forEach(System.out::println);
    System.out.println();
    
    System.out.println("Filtered Student List: ");
    Predicate<Student> filterGPA = student -> student.getGpa() < 3;
    var filteredStudents = filterStudents(students, filterGPA);
    filteredStudents.forEach(System.out::println);
    System.out.println();
    
    System.out.println("Transformed Student List: ");
    Function<Student, String> addGraduation = student -> student.isGraduated() ? student.getName()  + "(Graduated)": student.getName();
    /*{
      if (student.isGraduated()) {
        return student.getName() + " (Graduated)";
    } else {
        return student.getName();
    }
};*/
    
    var transformedNames = transformStudentNames(students, addGraduation);
    transformedNames.forEach(System.out::println);
   
    System.out.println();
    System.out.println("Modified GPA: ");
    UnaryOperator<Double> increaseGPA = gpa -> gpa + 1;
    var modifiedGPAs = modifyStudentGPAs(students, increaseGPA);
    modifiedGPAs.forEach(System.out::println);

    
  }
  
  public static List<Student> filterStudents(List<Student> students, Predicate<Student> filter) {
    
    var filteredStudents = new ArrayList<Student>();
    
    students.forEach(student -> {
      if(filter.test(student)) {
        filteredStudents.add(student);
      }
    });
    
    return filteredStudents;
  }

  public static List<String> transformStudentNames(List<Student> students, Function<Student, String> transformer) {
    
    var transformStudents = new ArrayList<String>();
    
    students.forEach(student -> {
      
      //String transformedName = transformer.apply(student);
      //var transformedStudent = new Student(transformedName, student.getGpa(), student.isGraduated());
      transformStudents.add(transformer.apply(student));
    });
    
    return transformStudents;
  }
  
  public static List<Student> modifyStudentGPAs(List<Student> students, UnaryOperator<Double> modifier) {
    
    var modifiedStudents = new ArrayList<Student>();
    
    students.forEach(student -> {
      double modifiedGPA = modifier.apply(student.getGpa());
      var modifiedStudent = new Student(student.getName(), modifiedGPA, student.isGraduated());
      modifiedStudents.add(modifiedStudent);
    });
    
    return modifiedStudents;
  }
}