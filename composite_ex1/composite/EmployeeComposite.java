package composite_ex1.composite;

import java.util.ArrayList;
import java.util.List;

public class EmployeeComposite implements EmployeeComponent {
    private String name;
    private String depto;
    private List<EmployeeComponent> subordinates = new ArrayList<>();
    
    public EmployeeComposite(String name, String depto) {
        this.name = name;
        this.depto = depto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public void add(EmployeeComponent component) {
        subordinates.add(component);
    }

    public void remove(EmployeeComponent component) {
        subordinates.remove(component);
    }

    @Override
    public int getEmployeeCount() {
        int count = 1;
        for (EmployeeComponent employee : subordinates) {
            count += employee.getEmployeeCount();
        }
        return count;
    }

    @Override
    public int getSubodinateCount() {
        int count = 0;
        for (EmployeeComponent employee : subordinates) {
            count += employee.getSubodinateCount();
        }
        return count;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + getName() + "\nDepto: " + getDepto());
        for (EmployeeComponent employee : subordinates) {
            employee.showDetails();
        }
        
    }

    
    
}
