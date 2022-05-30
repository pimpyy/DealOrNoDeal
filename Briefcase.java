public class Briefcase {
    private final double amount;
    private final String model;
    private boolean removed = false;
    private String face;

    public Briefcase(double amount, int face, String model) {
        this.face = Integer.toString(face);
        this.amount = amount;
        this.model = model;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return face;
    }

    public String getModel() {
        return model;
    }

    public void remove() {
        removed = true;
        face = "X";
    }

    public boolean isRemoved() {
        return removed;
    }
}