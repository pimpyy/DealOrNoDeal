import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private Player player = new Player();
    private Banker banker = new Banker();
    private int a = 0;
    private int b = 6;
    private double myAmount = 0;
    private double offer = 0;
    private int turn = 1;
    private int cases = 26;
    private Briefcase briefcases[];

    public void casesSetup() {
        String[] modelNames = {"Michelle", "Obama", "Rosey", "Miney",
            "Ashley", "Maria", "Ozawa", "Audrey", "Kristen", "Kim",
            "Kardashian", "Kourtney", "Ann", "Macy", "Tori", "Sam", "Monica",
            "Jin", "Koi", "jill", "Usher", "Justin Bieber", "Lindsay Lohan",
            "Hazell", "Buttercup", "Don Amalia", "Kojic!"};

        List<Integer> amounts = Arrays.asList(1, 5, 10, 25, 50, 75, 100,
        200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000,
        100000, 300000, 400000, 500000, 750000, 1000000, 250000, 800);

        Collections.shuffle(amounts);

        briefcases = new Briefcase[amounts.size()];

        for (int i = 0; i < briefcases.length; i++) {
            double value = amounts.get(i);
            briefcases[i] = new Briefcase(value, i + 1, modelNames[i]);
        }
    }

    public void showCases() {
        for (int i = 0; i < briefcases.length; i++) {
            System.out.print("\t[" + briefcases[i] + "]");
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void welcomeMessage() {
        System.out.println("\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println("\t~*               Welcome !                ~*");
        System.out.println("\t~*~*~*~*~*~*~ Hosted by Group 8 ~*~*~*~*~*~*");
        System.out.println("\t~* Please Select from the Following Cases!~*");
        System.out.println("\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }

    public void startGame() {

        boolean gamestatus = true;
        casesSetup();
        welcomeMessage();
        showCases();

        int choice = player.nUser();
        myAmount = briefcases[choice].getAmount();
        briefcases[choice].remove();
        cases--;

        while (gamestatus == true) {
            showCases();
            if (cases == 25 || cases == 19 || cases == 14 || cases == 10 || cases == 7) {
                for (a = b; a > 0; a--) {
                    player.remove(a, briefcases);
                    cases--;
                }
                b--;
                turn++;
                banker.setOffer(turn, briefcases, myAmount);
                offer = banker.getOffer(turn, briefcases, myAmount);
                gamestatus = player.gamestatus();
            } else if (cases == 1) {
                player.remove(1, briefcases);
                gamestatus = false;
            } else {
                player.remove(1, briefcases);
                cases--;
                banker.setOffer(turn, briefcases, myAmount);
                offer = banker.getOffer(turn, briefcases, myAmount);
                gamestatus = player.gamestatus();
            }
        }
        finishgame();
    }

    public void finishgame() {
        if (cases == 1) {
            System.out.println("\tYou Rejected the Offer of Banker");
            System.out.printf("\tYour case contains $%.2f and the bankers offer is $%.2f\n", myAmount, offer);
            System.out.printf("\tYou've won your case with an amount of: %.2f", myAmount);
        } else {
            System.out.println("\tYou Accepted the offer of Banker");
            System.out.printf("\tYour case contains $%.2f and the bankers offer is $%.2f\n", myAmount, offer);
            System.out.printf("\tYou've won the offer of Banker: $%.2f", offer);
        }
    }
}