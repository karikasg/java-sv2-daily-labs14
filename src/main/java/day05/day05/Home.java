package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(int area, int levels, Address address) {
        super(area, address);
        if (levels <= 3) {
            this.levels = levels;
        } else {
            throw new IllegalArgumentException("Max levels is 3!");
        }
    }

    public Home(int area, Address main) {
        super(area, main);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (this.getFullArea() / SQUARE_METERS_NEED_PER_PERSON);
    }
}
