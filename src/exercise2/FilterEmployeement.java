package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee {

  private String name;
  private String gender;
  private int salaryRank;

  public Employee(String name, String gender, int salaryRank) {
    super();
    this.name = name;
    this.gender = gender;
    this.salaryRank = salaryRank;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getSalaryRank() {
    return salaryRank;
  }

  public void setSalaryRank(int salaryRank) {
    this.salaryRank = salaryRank;
  }

  @Override
  public String toString() {
    return "Employee Name: " + name + "\t\t Gender: " + gender + "\t\t Salary Rank" + salaryRank;
  }

}

public class FilterEmployeement {

  public static void main(String[] args) {

    var employees = new ArrayList<>(List.of(new Employee("Bob", "male", 4), new Employee("Silke", "female", 2),
        new Employee("Theo", "male", 3), new Employee("Steffi", "female", 6), new Employee("Axel", "male", 2),
        new Employee("Andrea", "female", 3)));

    System.out.println("Orignal List: ");
    employees.forEach(System.out::println);
    System.out.println();

    System.out.println("Filtered Employee List: ");
    Predicate<Employee> filterSalary = employee -> employee.getSalaryRank() < 3;
    var filteredEmployee = filterEmpoyees(employees, filterSalary);
    filteredEmployee.forEach(System.out::println);
    System.out.println();

    System.out.println("Transformed Employee List: ");
    Function<Employee, String> addTitle = employee -> {
      if (employee.getGender().equals("male")) {
        return "Mr. " + employee.getName();
      } else {
        return "Mrs. " + employee.getName();
      }
    };

    var transformedNames = transformEmployeeNames(employees, addTitle);
    transformedNames.forEach(System.out::println);
    System.out.println();
  }

  public static List<Employee> filterEmpoyees(List<Employee> employees, Predicate<Employee> filter) {

    var filteredEmployees = new ArrayList<Employee>();
    employees.forEach(employee -> {
      if (filter.test(employee)) {
        filteredEmployees.add(employee);
      }
    });

    return filteredEmployees;
  }

  public static List<Employee> transformEmployeeNames(List<Employee> students,
      Function<Employee, String> transformer) {

    var transformEmployees = new ArrayList<Employee>();

    students.forEach(employee -> {

      String transformedName = transformer.apply(employee);
      var transformedEmployee = new Employee(transformedName, employee.getGender(), employee.getSalaryRank());
      transformEmployees.add(transformedEmployee);
    });

    return transformEmployees;
  }

}

