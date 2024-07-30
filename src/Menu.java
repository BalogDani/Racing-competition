import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    // TODO create menu
    // https://www.youtube.com/watch?v=zCjY59M8qtY

    void mainMenu() {
        Race race = new Race();
//        race.defaultRace(race);

        int userIsSelected;
        do{
            userIsSelected = menuOptions();
            switch (userIsSelected){
                case 1:
                    System.out.println("\n");
                    mainMenuAddVehicle(race);
                    break;
                case 2:
                    System.out.println("\n");
                    mainMenuCreateARace(race);
                    break;
                case 3:
                    System.out.println("Thanks for racing with us! <3");
                    break;
                default:
                    System.out.println("Please select a valid choice.\n");
            }
        }
        while (userIsSelected!=1 && userIsSelected!=2 && userIsSelected!=3);
    }

    public int menuOptions() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("1 - Add a vehicle");
        System.out.println("2 - Create a race");
        System.out.println("3 - Exit");

        selection = input.nextInt();
        return selection;
    }

    public void mainMenuAddVehicle(Race race) {
        int vehicleIsSelected;
        do{
            vehicleIsSelected = menuAddVehicle();
            switch (vehicleIsSelected){
                case 1:
                    System.out.println("Enter the brand:");
                    String brand = inputString();
                    System.out.println("Enter the model:");
                    String model = inputString();
                    System.out.println("Enter the speed:");
                    int speed = inputInt();
                    Motorbike motorbike = new Motorbike(brand, model, speed);
                    race.addVehicle(motorbike);
                    System.out.println("\n");
                    mainMenu();
                    break;
                case 2:
                    System.out.println("Enter the brand:");
                    brand = inputString();
                    System.out.println("Enter the model:");
                    model = inputString();
                    System.out.println("Enter the speed:");
                    speed = inputInt();
                    Car car = new Car(brand, model, speed);
                    race.addVehicle(car);
                    System.out.println("\n");
                    mainMenu();
                    break;
                case 3:
                    System.out.println("\n");
                    mainMenu();
                    break;
                default:
                    System.out.println("Please select a valid choice.\n");
            }
        }
        while (vehicleIsSelected!=1 && vehicleIsSelected!=2 && vehicleIsSelected!=3);
    }

    public void mainMenuCreateARace(Race race){
        int vehicleIsSelected;
        do{
            vehicleIsSelected = menuCreateARace();
            switch (vehicleIsSelected){
                case 1:
                    System.out.println("\n");
                    mainEnterAnotherVehicle(race);
                    break;
                case 2:
                    System.out.println("\n");
                    int length = enterTheLength();
                    race.startARace(race, length);
                    break;
                case 3:
                    System.out.println("\n");
                    mainMenu();
                    break;
                default:
                    System.out.println("Please select a valid choice.\n");
            }
        }
        while (vehicleIsSelected!=1 && vehicleIsSelected!=2 && vehicleIsSelected!=3);
    }

    public void mainEnterAnotherVehicle(Race race){
        int vehicleIsSelected;
        do{
            vehicleIsSelected = menuEnterAnotherVehicle();
            switch (vehicleIsSelected){
                case 1:
                    if(!race.vehicles.isEmpty()){
                        System.out.println("\nList of available vehicles:");
                        race.printVehicles(race.vehicles);
                        System.out.println("Choose the number of the vehicle:");
                        int numberOfVehicle = inputInt();
                        race.enteringAVehicleForARace(race, numberOfVehicle);
                        System.out.println("\nList of available competition vehicles:");
                        race.printVehicles(race.competitionVehicles);
                        System.out.println("\nList of available vehicles:");
                        race.printVehicles(race.vehicles);
                    }
                    else{
                        System.out.println("\nNo more vehicle to add for a race.");
                    }
                    System.out.println("\n");
                    mainMenuCreateARace(race);
                    break;
                case 2:
                    System.out.println("\n");
                    mainMenuCreateARace(race);
                    break;
                default:
                    System.out.println("Please select a valid choice.\n");
            }
        }
        while (vehicleIsSelected!=1 && vehicleIsSelected!=2);
    }

    public String inputString(){
        String selection = "noSelection";
        Scanner input = new Scanner(System.in);
        selection = input.next();
        return selection;
    }

    public int inputInt(){
        int selection = 0;
        BufferedReader amountInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            selection = Integer.parseInt(amountInput.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return selection;
    }

    public int menuAddVehicle(){
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Add vehicle");
        System.out.println("-------------------------");
        System.out.println("1 - Motorbike");
        System.out.println("2 - Car");
        System.out.println("3 - Back");

        selection = input.nextInt();
        return selection;
    }

    public int menuCreateARace(){
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Create a race");
        System.out.println("-------------------------");
        System.out.println("1 - Entering a vehicle for a race");
        System.out.println("2 - Start a race");
        System.out.println("3 - Back");

        selection = input.nextInt();
        return selection;
    }

    public int menuEnterAnotherVehicle(){
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter another vehicle for the race:");
        System.out.println("-------------------------");
        System.out.println("1 - Choose an available vehicle");
        System.out.println("2 - Back");

        selection = input.nextInt();
        return selection;
    }

    public int enterTheLength(){
        System.out.println("Enter the legth of the track:");
        int length = inputInt();
        if(!(length>0)){
            System.out.println("Please select a valid choice. (Greater than zero.)\n");
            length = enterTheLength();
        }
        return length;
    }
}
