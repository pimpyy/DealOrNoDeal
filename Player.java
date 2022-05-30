import java.util.Scanner;

public class Player {

    Scanner input = new Scanner(System.in);
    Banker banker = new Banker();

    public boolean gamestatus() {
        System.out.print("\tAccept or Reject! [1]Accept [2]Reject: ");
        int temp = input.nextInt();
        System.out.println();
        return temp != 1;
    }

    public int nUser() {
        while (true) {
            System.out.print("\n\tPlease Select Your Case!: ");
            int nUser = input.nextInt() - 1;
            if (nUser < 0 || nUser >= 26) {
                System.out.println("\tInvalid input Try again");
            } else {
                return nUser;
            }
        }
    }

    public int remove(int index, Briefcase[] briefCases) {
        while (true) {
            System.out.print("\tPlease remove " + index + " case/s: "); 
            int nChoice = input.nextInt() - 1;
            if (nChoice < 0 || nChoice >= briefCases.length || briefCases[nChoice].isRemoved()) {
                System.out.println();
                System.out.println("\tInvalid Input please Try again\n");
            } else {
                System.out.println("\tI'm " + briefCases[nChoice].getModel() + ". You just removed case # " + (nChoice+1));
                System.out.println("\t|" + (nChoice + 1) + "| contains $" + briefCases[nChoice].getAmount() + "\n");
                briefCases[nChoice].remove();
                return nChoice;
            }
        }
    }
}