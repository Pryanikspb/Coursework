public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Казимиров Константин Викторович", 1, 50000);
        employees[1] = new Employee("Смирнов Дмитрий Сергеевич", 2, 60000);
        employees[2] = new Employee("Тарасова Светлана Сергеевна", 3, 50000);
        employees[3] = new Employee("Николаева Вероника Николаевна", 4, 45000);

        printNameEmployee();
        System.out.println(getCalculateSumSalary());
        System.out.println(getEmployeeMinSalary());
        System.out.println(getEmployeeMaxSalary());
        System.out.println(getCalculateAverageSalary());
        printNameAllEmployee();
    }

    public static void printNameEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double getCalculateSumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
            return sum;
        }

        public static Employee getEmployeeMinSalary() {
            double min = 0;
            int index = 0;
            Employee employeeMinSalary = null;

            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    min = employees[i].getSalary();
                    index = i;
                    break;
                }
            }
            for (int i = index; i < employees.length; i++) {
                if (employees[i] == null) continue;
                if (employees[i].getSalary() < min) {
                    min = employees[i].getSalary();
                    employeeMinSalary = employees[i];
                }
            }
            return employeeMinSalary;
        }

    public static Employee getEmployeeMaxSalary() {
        double max = 0;
        int index = 0;
        Employee employeeMaxSalary = null;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                index = i;
                break;
            }
        }
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                employeeMaxSalary = employees[i];
            }
        }
        return employeeMaxSalary;
    }

    public static double getCalculateAverageSalary() {
        double sum = 0;
        int countEmp = 0;
        for (Employee emp : employees) {
            if (emp == null) continue;
            countEmp++;
            sum += emp.getSalary();
        }
        return sum/countEmp;
    }

    public static void printNameAllEmployee() {
        for (Employee empl: employees) {
            if(empl == null) continue;
            System.out.println(empl.getFullname());
        }
    }
}