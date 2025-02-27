import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagement {
    List<Employee> list = new ArrayList<>();

    void add(int id, String name, double salary) {
        list.add(new Employee(id, name, salary));
    }

    void update(int id, String name, double salary) {
        for (Employee e : list) {
            if (e.id == id) {
                e.name = name;
                e.salary = salary;
                return;
            }
        }
    }

    void remove(int id) {
        list.removeIf(e -> e.id == id);
    }

    Employee search(int id) {
        for (Employee e : list) {
            if (e.id == id) return e;
        }
        return null;
    }

    void display() {
        for (Employee e : list) System.out.println(e);
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.add(1, "Alice", 50000);
        em.add(2, "Bob", 60000);
        em.display();
        em.update(1, "Alice Brown", 55000);
        System.out.println(em.search(1));
        em.remove(2);
        em.display();
    }
}
