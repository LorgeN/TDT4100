package org.tanberg.oving9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HighscoreListProgram implements HighscoreChangeListener {

    public static void main(String[] args) {
        new HighscoreListProgram();
    }

    private final HighscoreList list;

    public HighscoreListProgram() {
        this.list = new HighscoreList(10);
        this.list.subscribe(this);

        this.read();
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int nextVal = scanner.nextInt();
                this.list.add(nextVal);
            } catch (InputMismatchException e) {
                System.out.println("Number please :)");
            }
        }
    }

    @Override
    public void onListChange(HighscoreList list, int position) {
        System.out.println("Received change: #" + position + "; " + list.get(position));
        System.out.println("List is now:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  #" + (i + 1) + ": " + list.get(i));

            if (!this.list.get(i).equals(list.get(i))) {
                System.out.println("Values are different between local list and passed list?");
            }
        }
    }
}
