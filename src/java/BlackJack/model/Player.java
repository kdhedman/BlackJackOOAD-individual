package BlackJack.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Player extends Hand {
    private String name = "Player"; //the players name
    public int balance = 1000; //the amount of balance the player has currently
    private int currentBet = 0; //the amount of balance the player have decided to bet this round
    private boolean broke = false;
    public StringProperty balanceValueProperty = new SimpleStringProperty();

    public Player() {
        ArrayList<Card> hand = new ArrayList<>();
    }

    /**
     * Increases the players balance
     */
    public void increaseBalance() {
        setBalance(getBalance() + (getCurrentBet()*2));

        setCurrentBet(0);
    }
    /**
     * sets the currentBet based on user input
     */
    public void bet(int bet) {
        setCurrentBet(bet);
    }

    /**
     * Getter for name
     *
     * @return the players name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name
     *
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the player balance
     *
     * @return the amount of balance the player has currently
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Setter for the player balance
     *
     * @param balance the amount of balance the player has currently
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Getter for the currentBet
     *
     * @return the amount of balance the player has decided to bet this round
     */
    public int getCurrentBet() {
        return currentBet;
    }

    /**
     * Setter for the currentBet
     *
     * @param currentBet the amount of balance the player has decided to bet this round
     */
    public void setCurrentBet(int currentBet) {

        if (currentBet <= balance) {
            this.currentBet = currentBet;
            balance -= currentBet;
        } else {
            System.out.println("För lite pengar.");
            broke = true;
        }
    }

    /**
     * Getter For broke
     *
     * @return if the ComputerPlayer is all out of balance (gets removed form the game)
     */
    public boolean isBroke() {
        setBroke(this.getBalance() <= 0 && this.getCurrentBet() <= 0);
        return broke;
    }

    /**
     * Setter for broke
     *
     * @param broke if the ComputerPlayer is all out of balance (gets removed form the game)
     */
    public void setBroke(boolean broke) {
        this.broke = broke;
    }
}

