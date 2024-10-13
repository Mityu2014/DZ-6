package org.example;

import lombok.Data;
import java.text.DecimalFormat;
import java.util.*;
@Data
public class Main {
    public static void main(String[] args) {
        double sumNumUnchangedSolutions = 0;
        double sumNumModifiedSolutions = 0;
        Random random = new Random();

        for(int i = 1;i < 1001;i++ ) {
            String[] doors = {"Коза", "Коза", "Коза"};
            int prize = random.nextInt(3);
            doors[prize] = "Машина";
            int movePlay = random.nextInt(3);
            int moveLead = 0;
            do{
                moveLead = random.nextInt(3);
            }while(moveLead==movePlay || doors[moveLead].equals("Машина"));
            boolean choicePlay = random.nextBoolean();
            if (prize == movePlay && !choicePlay) {
                sumNumUnchangedSolutions = sumNumUnchangedSolutions + 1;
            } else if (prize != movePlay && choicePlay){
                sumNumModifiedSolutions = sumNumModifiedSolutions + 1;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##%");
        System.out.println("Вероятность победы без смены двери составляет: " + df.format(sumNumUnchangedSolutions/1000));
        System.out.println("Вероятность победы со сменой двери составляет: " + df.format(sumNumModifiedSolutions/1000));
    }

}