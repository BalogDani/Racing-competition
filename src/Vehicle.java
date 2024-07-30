import javax.smartcardio.Card;
import java.util.ArrayList;

abstract class Vehicle {
    String brand;
    String type;
    int speed;

    public Vehicle(String brand, String type, int speed) {
        this.brand = brand;
        this.type = type;
        this.speed = speed;
    }

    public double raceTime(double length) {
        double timInDouble = length/speed;
        printRaceTime(length);

        return timInDouble;
    }

    public void printRaceTime(double length) {
        double hour = Math.floor(length/speed);
        double length1 = length - speed*hour;
        double min = 0;
        if(length1>0){
            min = Math.floor(60*length1/speed);
        }
        double length2 = length1 - speed*min;
        double sec = 0;
        if(length2>0){
            sec = Math.ceil(60*length2/speed);
        }

        if(hour>0){
            System.out.println("The " + brand + " " + type + " covers the " + length + "km in " + hour + "h " + min + "min " + sec + "sec.");
        }
        else{
            System.out.println("The " + brand + " " + type + " covers the " + length + "km in " + min + "min " + sec + "sec.");
        }
    }
}