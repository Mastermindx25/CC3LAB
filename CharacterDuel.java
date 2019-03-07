/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrpg;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class CharacterDuel {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String action;
        Wizard char1 = new Wizard("Wizard", 2, 1, 4);
        Archer char2 = new Archer("Archer", 1, 2, 1);

        int round = 1;
        while (char1.getCurrentLife() > 0 && char2.getCurrentLife() > 0) {
            int damage = 0;

            System.out.println("Round " + round);

            System.out.println(char1.getName() + ": " + char1.getCurrentLife() + "/" + char1.getMaxLife() + "\tMagic: " + char1.getCurrentMagic() + "/" + char1.getMaxMagic());
            System.out.println(char2.getName() + ": " + char2.getCurrentLife() + "/" + char2.getMaxLife());

            System.out.print("Input Wizard action: (H for Health, LB for Lightning Bolt, and A for Attack): ");
            action = sc.next().toUpperCase();
            if ("H".equals(action)) {
                if (char1.getCurrentMagic() >= 8) {
                    int heal = char1.castHeal();
                    System.out.println(char1.getName() + " casts HEAL. " + char1.getName() + " heals " + heal + " health.");
                } else {
                    damage = char1.attack();
                    System.out.println("Not enough MAGIC to cast HEAL.");
                    System.out.println(char1.getName() + " attacks " + char2.getName() + " for " + damage + " damage.");
                    char2.wound(damage);
                }
            } else if ("LB".equals(action)) {
                if (char1.getCurrentMagic() >= 5) {
                    damage = char1.castLightningBolt();
                    System.out.println(char1.getName() + " casts LIGHTNING BOLT. " + char2.getName() + " takes " + damage + " damage.");
                    char2.wound(damage);
                } else {
                    damage = char1.attack();
                    System.out.println("Not enough MAGIC to cast LIGHTNING BOLT.");
                    System.out.println(char1.getName() + " attacks " + char2.getName() + " for " + damage + " damage.");
                    char2.wound(damage);
                }
            } else if ("A".equals(action)) {
                damage = char1.useWeapon();
                System.out.println(char1.getName() + " uses their weapon to attack " + char2.getName() + " for " + damage + " damage but");
                char2.wound(damage);
                int defense = char2.useArmor();
                System.out.println(char2.getName() + " uses their armor to deflect " + defense + " damage.");
            } else {
                damage = char1.attack();
                System.out.println("Invalid input.");
                System.out.println(char1.getName() + " attacks " + char2.getName() + " for " + damage + " damage.");
                char2.wound(damage);
            }

            if (char2.getCurrentLife() > 0) {
                damage = char2.castWindStrike();
                System.out.println(char2.getName() + " casts DEEP FRY. " + char2.getName() + " heals " + damage + " health and " + char1.getName() + " takes " + damage + " damage.");
                char1.wound(damage);
            }

            System.out.println("");
            round++;

        }

        System.out.println(char1.getName() + ": " + char1.getCurrentLife() + "/" + char1.getMaxLife());
        System.out.println(char2.getName() + ": " + char2.getCurrentLife() + "/" + char2.getMaxLife());
        System.out.println("");

        if (char1.getCurrentLife() == char2.getCurrentLife()) {
            System.out.println("Draw.");
        } else if (char1.getCurrentLife() > char2.getCurrentLife()) {
            System.out.println(char1.getName() + " wins.");
        } else if (char2.getCurrentLife() > char1.getCurrentLife()) {
            System.out.println(char2.getName() + " wins.");
        }
    }
}
