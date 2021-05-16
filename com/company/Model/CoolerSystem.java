package com.company.Model;
import java.util.Scanner;

public class CoolerSystem implements ICentralProcessingUnit
{
    private IActuator actuator;
    private ITemperatureSensor temperatureSensor;
    private ILogger logger;
    private IDB db;

    private Boolean isOpen = true;
    private final String commandString =
            """
            
            --------------------------------
            What would you like to do ?
            1 - get temperature
            2 - turn on cooler
            3 - turn of cooler
            4 - show all logs
            6 - quit
            """;


    @Override
    public boolean turnOnCooler() {
        log("turn on cooler");
        System.out.println("cooler is turning on");
        return actuator.turnOnCooler();
    }

    @Override
    public boolean turnOfCooler() {
        log("turn off cooler");
        System.out.println("cooler is turning off");
        return actuator.turnOfCooler();
    }

    @Override
    public void signIn() throws InterruptedException {
        User user = readUserData();
        user = db.isUserExist(user);
        if(user != null)
        {
            log(user.getName() + " sign in");
            System.out.println("Sign in successfully \nWelcome " + user.getName());
            if(user.getRole() == 0){
                System.out.println("unauthorized user\n");
                signIn();
            }
            this.temperatureSensor.addObserver(user);
            run();
        }
        else
        {
            System.out.println("\n\nSign in error please try again");
            signIn();
        }
    }

    @Override
    public int getTemperature() {
        int temp = temperatureSensor.getTemperature();
        System.out.println("get temperature as " + temp);
        log("get temperature as " + temp);
        return temp;
    }

    @Override
    public void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (isOpen)
        {
            // Kısa bir bekleme süresi
            Thread.sleep(1000);
            System.out.println(commandString);
            String command = scanner.nextLine();
            switch (command) {
                case "q", "6" -> isOpen = false;
                case "1" -> getTemperature();
                case "2" -> turnOnCooler();
                case "3" -> turnOfCooler();
                case "4" -> showAllLogs();
                case "5" -> System.out.println("sing out successfully !");
            }
        }
    }

    @Override
    public void log(String log) {
        logger.log(log);
    }

    @Override
    public void showAllLogs() {
        logger.showAllLogs();
    }

    public User readUserData()
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object


        System.out.println("\n\n---------------------------------------");
        System.out.println("Enter username");
        String userName = scanner.nextLine();

        System.out.println("Enter password");
        String passWord = scanner.nextLine();

        return new User.Builder()
                .uUsername(userName)
                .password(passWord)
                .build();
    }

    public CoolerSystem(IActuator actuator, ITemperatureSensor temperatureSensor, ILogger logger, IDB db) {
        this.actuator = actuator;
        this.temperatureSensor = temperatureSensor;
        this.logger = logger;
        this.db = db;
    }

    public ILogger getLogger() {
        return logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public IDB getDb() {
        return db;
    }

    public void setDb(IDB db) {
        this.db = db;
    }


    public IActuator getActuator() {
        return actuator;
    }

    public void setActuator(IActuator actuator) {
        this.actuator = actuator;
    }

    public ITemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(ITemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

}
