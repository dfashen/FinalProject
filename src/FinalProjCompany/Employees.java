package FinalProjCompany;

public class Employees {
    private int id;
    private String name;
    private Positions positions;
    private int salary;


    public Employees(int id, String name, Positions positions, int salary) {
        this.id = id;
        this.name = name;
        this.positions = positions;
        this.salary = salary;
    }

    public Employees(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-1d) %-10s %-5s %5d",
                id, name, positions.getPositions(), salary );

    }
}

