import java.util.ArrayList;

public class Race {
    public ArrayList<Vehicle> vehicles;
    public ArrayList<Vehicle> competitionVehicles;

    public Race(){
        this.vehicles = new ArrayList<>();
        this.competitionVehicles = new ArrayList<>();
    }

    public Race defaultRace(Race race){
        race.addVehicle(race, new Car("Volvo", "XC60", 210));
        race.addVehicle(race, new Motorbike("Yamaha", "R6", 260));
        race.addVehicle(race, new Car("Renault", "Clio", 170));
        return race;
    }

    public void addVehicle(Race race, Vehicle vehicle){
        race.vehicles.add(vehicle);
        System.out.println("Vehicle " + vehicle.brand + " " + vehicle.type + " added to the race vehicles.");
    }

    public void enteringAVehicleForARace(Race race, int numberOfVehicle){
        Vehicle vehicle = race.vehicles.get(numberOfVehicle);
        this.competitionVehicles.add(vehicle);
        System.out.println("Vehicle " + vehicle.brand + " " + vehicle.type + " added to the competition vehicles.");
        this.vehicles.remove(vehicle);
    }

    public void printVehicles(ArrayList<Vehicle> vehicles){
        for (Vehicle vehicle: vehicles){
            System.out.println(vehicles.indexOf(vehicle) + " - " + vehicle.brand + " " + vehicle.type + ".");
        }
    }

    public void startARace(Race race, int length){
        ArrayList<Double> timeArray = new ArrayList<>();
        for (Vehicle vehicle: race.competitionVehicles){
            Double timeOfVehicle = vehicle.raceTime(length);
            timeArray.add(timeOfVehicle);
//            System.out.println(vehicle.brand + " " + vehicle.type + "'s time: " + timeOfVehicle);
        }
        double min = timeArray.get(0);
        int numberOfWinnerVehicle = 0;
        for (int i = 1; i < timeArray.size(); i++) {
            if (timeArray.get(i) < min) {
                min = timeArray.get(i);
                numberOfWinnerVehicle = i;
            }
        }
        System.out.println("\nThe winner is:\n" + race.competitionVehicles.get(numberOfWinnerVehicle).brand + " " + race.competitionVehicles.get(numberOfWinnerVehicle).type);
    }
}
