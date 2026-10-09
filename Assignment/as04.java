import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 1000.00;
    }
}

public class as04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee emp = null;
            switch (type) {
                case "FULLTIME":
                    emp = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    emp = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    emp = new InternEmployee(name, salary);
                    break;
            }

            if (emp != null) {
                double bonus = emp.calculateBonus();
                totalBonus += bonus;
                System.out.printf("%s: %.2f\n", emp.getName(), bonus);
            }
        }

        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        sc.close();
    }
}