package App;


import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static final int AMOUNT_TRIES = 1000;
    public static final boolean CHANGE = true;
    public static final boolean DO_NOT_CHANGE = false;
    public static Goat goat = new Goat("Goat",10);
    public static Car car = new Car("Car",1000);
    public static Random random = new Random();

    public static HashMap<Integer,Winnable> result;
    public static void main(String[] args) {
        letsMakeADeal(3,CHANGE);
        letsMakeADeal(3,DO_NOT_CHANGE);
        letsMakeADeal(1000,CHANGE);
        letsMakeADeal(1000,DO_NOT_CHANGE);
    }

    public static void letsMakeADeal(int countDoors, boolean changeOrNot){
        Winnable prize;
        result = new HashMap<>();
        for (int i = 0; i < AMOUNT_TRIES; i++) {
            Winnable[] doors = generateDoors(countDoors);
            int choice = random.nextInt(countDoors);
            prize = doors[choice];
            if (!changeOrNot){
                result.put(i,prize);
            } else {
                if(prize instanceof Car){
                    result.put(i,goat);
                } else {
                    result.put(i,car);
                }
            }

        }

        showStatistics(result, changeOrNot, countDoors);
    }

    public static void showStatistics(HashMap<Integer,Winnable> result , boolean changeOrNot ,int countDoors){
        double percent = (double) result.values().stream().filter(s -> s instanceof Car).toList().size() / 10;
        if(changeOrNot){
            System.out.println("Процент выйгрыша со сменой выбора и количеством дверей = "
                    + countDoors + " составляет: " + percent + "%");
        } else {
            System.out.println("Процент выйгрыша без смены выбора и количеством дверей = "
                    + countDoors + " составляет: " + percent + "%");
        }




    }

    public static Winnable[] generateDoors(int countDoors){
        int i = random.nextInt(countDoors);
        Winnable[] array = new Winnable[countDoors];
        array[i] = car;
        for (int j = 0; j < array.length; j++) {
            if(array[j] == null){
                array[j] = goat;
            }
        }
        return array;
    }


}
