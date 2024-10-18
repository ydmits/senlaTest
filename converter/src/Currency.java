public class Currency {
    private String firstName;
    private String secondName;
    private double rate;

    public Currency (String firstName, String secondName, double rate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public  String toString() {
        return firstName + " - " + secondName + ": " + rate + " => ";
    }
}

