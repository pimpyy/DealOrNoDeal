public class Banker {

    private double total = 0;
    private int a = 0;
    private double amount =0;
    double average = 0;

    public void setOffer(int turn, Briefcase[] cases, double myAmount) {

        for (int i = 0; i < cases.length; i++) {
            if (! cases[i].isRemoved()) {
                total += cases[i].getAmount();
                a++;
            }
        }
        average = myAmount + total / a;
        amount = average*turn/ 10;
    }

    public double getOffer(int turn, Briefcase[] cases, double myAmount) {
        setOffer(turn, cases, myAmount);
        System.out.printf("\tThe Bankers Offer is: %.2f \n\n", amount);
        return amount;
    }
}