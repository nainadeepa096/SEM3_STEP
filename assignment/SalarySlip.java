public class SalarySlip {
    private final String employeeId;
    private double baseSalary;
    private double bonus;

    public SalarySlip(String employeeId, double baseSalary) {
        this.employeeId = employeeId;
        this.baseSalary = Math.max(0.0, baseSalary);
        this.bonus = 0.0;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        }
    }

    public double getTotalSalary() {
        return baseSalary + bonus;
    }
}