package FinalProjCompany;

public class Positions {

    private int id;
    private String spec;

    public Positions(int id, String positions) {
        this.id = id;
        this.spec = positions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositions() {
        return spec;
    }

    public void setPositions(String positions) {
        this.spec = positions;
    }
}
