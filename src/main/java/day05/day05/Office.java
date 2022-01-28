package city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if ((area / numberOfTablesPerLevel < 2) || (area / numberOfTablesPerLevel > 5)) {
            throw new IllegalArgumentException("Too small place for the tables");
        }
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (levels - 1) * numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
