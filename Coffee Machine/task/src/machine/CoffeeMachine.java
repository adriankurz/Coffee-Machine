package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Machine saeco = new Machine(400, 540, 120, 9, 550);

        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();

            if (choice.equals("buy")){
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                choice = scanner.next();

                if (choice.equals("1")) {
                    saeco.makeBevarage(250, 0, 16, 1, 4);
                } else if (choice.equals("2")) {
                    saeco.makeBevarage(350, 75, 20, 1, 7);
                } else if (choice.equals("3")) {
                    saeco.makeBevarage(200, 100, 12, 1, 6);
                }
            } else if (choice.equals("fill")) {
                saeco.fill();
            } else if (choice.equals("take")) {
                saeco.take();
            } else if (choice.equals("remaining")) {
                saeco.printMachineStatus();
            } else if (choice.equals("exit")) {
                System.exit(0);
            }
        }
    }
}

class Machine {

    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    public Machine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }

    public void makeBevarage(int water, int milk, int coffee, int cups, int money) {

        if(this.water - water >= 0 && this.coffee - coffee >= 0 && this.cups - cups >= 0){
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.coffee -= coffee;
            this.cups -= cups;
            this.money += money;
        } else {
            if(this.water - water < 0) {
                System.out.println("Sorry, not enough water!");
            } else if(this.coffee - coffee < 0){
                System.out.println("Sorry, not enough coffee!");
            } else if(this.cups - cups < 0){
                System.out.println("Sorry, not enough cups!");
            }
        }
    }

    public void fill() {
        System.out.println("Enter quantities for water, milk, coffee, cups");
        Scanner scanner = new Scanner(System.in);

        int water = scanner.nextInt();
        int milk = scanner.nextInt();
        int coffee = scanner.nextInt();
        int cups = scanner.nextInt();

        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.cups += cups;
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        System.out.println();
        this.money = 0;
    }

    public void printMachineStatus() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffee + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }
}