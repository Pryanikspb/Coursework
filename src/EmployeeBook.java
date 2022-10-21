import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees;
    private int department;

    public EmployeeBook(Map<String, Employee> employees, Map<String, Employee> employees1) {
        this.employees = employees1;
        employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getFullname() + " ";
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String fullname,
                            double salary,
                            int department) {
        addEmployee(new Employee(fullname, (int) salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        String employeeKeyForRemoving = null;
        for (String key: employees.keySet()) {
            if (employees.get(key).getId() == id) {
                employeeKeyForRemoving = key;
                break;
            }
        }
        if (employeeKeyForRemoving != null) {
            employees.remove(employeeKeyForRemoving);
        }
    }

    public void changeSalary(Employee employee,
                             double newSalary) {
        String key = getKey(employee);
        if(employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee,
                                 int newDepartment) {
        String key = getKey(employee);
        if(employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        for (int department = 1; department <=5 ; department++) {
            System.out.println("Сотрудники из отдела " + department + ": ");
            for (Employee employee: employees.values()) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getFullname());
                }
            }
        }
    }

    public void printEmployeeWithSalaryLessThan (double bound) {
        System.out.println("Сотрудники с ЗП меньшей, чем " + bound + ": ");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО: %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getFullname(),
                        employee.getSalary()
                );
            }
        }
    }

    public void printEmployeesWithSalaryGreaterOrEqualThan (double bound) {
        System.out.println("Сотрудники с ЗП большей или равной, чем " + bound + ": ");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() >= bound) {
                System.out.printf(
                        "id: %d, ФИО: %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getFullname(),
                        employee.getSalary()
                );
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if(employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public double averageSalary() {
        int count = employees.values().size();
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                totalSalaryForDepartment += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment (int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry: employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry: employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment (int department) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry: employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry: employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public void printAllEmployees() {
        for (Employee employee: employees.values()) {
            System.out.println(employee);
        }
    }

    public void printAllEmployeesFromDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.printf(
                        "id: %d, ФИО: %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getFullname(),
                        employee.getSalary()
                );
            }
        }
    }






}
