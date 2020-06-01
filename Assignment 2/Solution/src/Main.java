

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static int countCars = 0;
    public static int countServices = 0;
    public static int countCustomers = 0;
    public static int countReservations = 0;

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // **** Creating the file that we are going to need for car input ****
        File InputCar = new File("inputCar.txt");
        if (!(InputCar.exists())) {
            System.out.println("Error 001 (inputCar.txt) file is not found, Please try again.");
            System.exit(1);
        }
        File CarInfo = new File("CarsInfo.txt"); // making txt file to print CarsInfo in it.
        PrintWriter PrintToCarInfo = new PrintWriter(CarInfo); // PrintWriter for that file.

        Scanner InpuCarSC = new Scanner(InputCar); // Scanner to read from InputCar txt file.

        Car[] AllCars = new Car[InpuCarSC.nextInt()]; // making array of objects for ** Cars **       
        Service[] AllServices = new Service[InpuCarSC.nextInt()]; // array of objects for services

        PrintToCarInfo.println("--------------- Welcome to Car Renting  Data Base ---------------\r\n\r\n");
        String CCommand = null;  // now lets take the commands.
        do {
            CCommand = InpuCarSC.next();
            if (CCommand.equalsIgnoreCase("AddCar")) {
                AddCarCmd(InputCar, AllCars, InpuCarSC, PrintToCarInfo);
            } else if (CCommand.equalsIgnoreCase("AddService")) {
                AddServiceCmd(InputCar, AllServices, InpuCarSC, PrintToCarInfo);
            }
        } while (!(CCommand.equalsIgnoreCase("quit")));

        PrintToCarInfo.close(); // * closing the printWriter for CarInfo.txt *

        // ------------ **** the next part is for Reservation Input **** ------------
        File ReservationInput = new File("Reservationinput.txt");
        if (!(ReservationInput.exists())) {
            System.out.println("Error 002 (Reservationinput.txt) file is not found, Please try again.");
            System.exit(2);
        }
        File ReservationStatus = new File("ReservationStatus.txt"); // making txt file to print ReservationStatus in it.
        PrintWriter PrintToReStat = new PrintWriter(ReservationStatus); // PrintWriter for that file.

        Scanner ResInputSC = new Scanner(ReservationInput); // Scanner to read from InputCar txt file.
        // array of objects for the customers and Reservations.
        Customer[] Customers = new Customer[ResInputSC.nextInt()]; // array of objects for Customers
        Reservation[] Reservations = new Reservation[Customers.length]; // array of objects for reservation

        PrintToReStat.println("--------------- Welcome to Car Renting  Management System ---------------\r\n\r\n");
        PrintToReStat.println("--------------- Display All System Procedures ---------------\r\n\r\n");
        String RCommand = null;
        do {
            RCommand = ResInputSC.next();
            if (RCommand.equalsIgnoreCase("Reserve")) {
                Reservation(AllServices, PrintToReStat, Reservations, ReservationInput, Customers, ResInputSC, AllCars);
            }
        } while (!(RCommand.equalsIgnoreCase("quit")));

        PrintToReStat.close(); // * closing the printWriter for ReservationStatus.txt *

    }

    // --------------------- this method will read all the cars and store it in the array of objects. and also print it to car info txt file
    public static void AddCarCmd(File InputCar, Car[] AllCars, Scanner InpuCarSC, PrintWriter PrintToCarInfo) {
        AllCars[countCars] = new Car(InpuCarSC.next(), InpuCarSC.nextInt(), InpuCarSC.nextDouble(), InpuCarSC.nextBoolean(), InpuCarSC.next(), InpuCarSC.nextBoolean());
        PrintToCarInfo.println(AllCars[countCars].PrintDetails() + "\n------------------------------------------------------\n");
        countCars++;
    }

    // --------------------- this method will read and add new services to the array of objects.
    public static void AddServiceCmd(File InputCar, Service[] AllServices, Scanner InpuCarSC, PrintWriter PrintToCarInfo) {
        AllServices[countServices] = new Service(InpuCarSC.next(), InpuCarSC.nextDouble());
        countServices++;
    }

    // --------------------- this method will read the reservation command and do all the work.
    public static void Reservation(Service[] AllServices, PrintWriter PrintToReStat, Reservation[] Reservations, File ReservationInput, Customer[] Customers, Scanner ResInputSC, Car[] AllCars) throws ParseException {
        // first we are going to read the (CarType, Transmission and Convertible) and see if we have that car in stock or not
        String CarType = ResInputSC.next();
        String Transmission = ResInputSC.next();

        boolean Trans;
        if (Transmission.equalsIgnoreCase("Manual")) { // To switch a string to boolean i used this way
            Trans = true;
        } else {
            Trans = false;
        }

        String Convertible = ResInputSC.next();
        boolean Conv;
        if (Convertible.equalsIgnoreCase("Convertible")) {
            Conv = true;
        } else {
            Conv = false;
        }

        int FoundTheCar = -1; // temp value
        for (int i = 0; i < AllCars.length; i++) { // Searches for the right car.
            if (AllCars[i].getType().equalsIgnoreCase(CarType) && AllCars[i].isTransmission() == Trans && AllCars[i].isConvertible() == Conv && AllCars[i].isTaken() == false) {
                AllCars[i].setTaken(true); // reserving that car
                FoundTheCar = i; // the number of the car
                break;
            }
        }

        if (FoundTheCar == -1) { // if the loop is done and no car is found.
            PrintToReStat.println("\r\n\r\nSORRY: The reservation is NOT completed\r\nThere is no available Car\r\n\r\n");
        } else { // if the car is found

            // *** Start taking the rest of the command from the input ***            
            String PickUpLocation = ResInputSC.next();
            String DropOffLocation = ResInputSC.next();

            SimpleDateFormat MyDateFormat = new SimpleDateFormat("yyyy m d"); // to read the date from the input

            // taking all three numbers (date) and store them in a string for (pick up and drop off
            String PickUpDate = ResInputSC.next() + " " + ResInputSC.next() + " " + ResInputSC.next();
            Date PickUp = MyDateFormat.parse(PickUpDate);

            String DropOffDate = ResInputSC.next() + " " + ResInputSC.next() + " " + ResInputSC.next();
            Date DropOff = MyDateFormat.parse(DropOffDate);

            // Making new reservation
            Reservations[countReservations] = new Reservation(PickUp, DropOff, PickUpLocation, DropOffLocation);
            // Making new Customer
            Customers[countCustomers] = new Customer(ResInputSC.next(), ResInputSC.next(), ResInputSC.next(), ResInputSC.nextLong(), ResInputSC.nextInt());

            // Assigning that customer to the reservation
            Reservations[countReservations].setCustomer(Customers[countCustomers]);

            // Assigning the right car to the reservation
            Reservations[countReservations].setCar(AllCars[FoundTheCar]);

            // ** If there's Additional_services
            String AdditinalServiceInfo = "";
            String Temp = ResInputSC.next(); // This will be either a "service" or "submit"
            if (!(Temp.equalsIgnoreCase("submit"))) {
                // We need to find that service from the Array objects of Services
                int FoundTheService = -1;
                for (int i = 0; i < AllServices.length; i++) {
                    if (AllServices[i].getServiceType().equalsIgnoreCase(Temp)) {
                        FoundTheService = i;
                    }
                }
                if (FoundTheService == -1) { // The Service is not found
                    System.out.println("Error 003, Wrong Service");
                } else {
                    Reservations[countReservations].setAdditional_services(AllServices[FoundTheService]);
                }
                AdditinalServiceInfo += "******Additional services : Service " + AllServices[FoundTheService].getServiceType();
            }

            // **** Printing the details of the Reservations ****
            PrintToReStat.println("DONE: The reservation is completed");

            int ReservationRefrence = (int) (Math.random() * 999); // random Refrence number
            PrintToReStat.println("******Reservation Refrence number : " + Customers[countCustomers].getFirst_name().charAt(0) + Customers[countCustomers].getLast_name().charAt(0) + "_" + ReservationRefrence + "_" + AllCars[FoundTheCar].getYear());
            PrintToReStat.printf("******Customer information : Customer Name: %s %s, Email: %s, Code: %d\r\n", Customers[countCustomers].getFirst_name(), Customers[countCustomers].getLast_name(), Customers[countCustomers].getEmail(), Customers[countCustomers].getCustomerCode());
            PrintToReStat.printf("******Pick up location : %s	******Drop of location : %s\r\n", Reservations[countReservations].getPick_up_location(), Reservations[countReservations].getDrop_of_location());

            SimpleDateFormat MyPrintDateFormat = new SimpleDateFormat("d-m-yyyy");
            PrintToReStat.printf("******Pick up date : %s	******Drop of date : %s\r\n", MyPrintDateFormat.format(PickUp), MyPrintDateFormat.format(DropOff));
            PrintToReStat.println("******Car information : " + AllCars[FoundTheCar].PrintDetails());

            if (!"".equals(AdditinalServiceInfo)) { // if there is a service found the string will not be empty
                PrintToReStat.println(AdditinalServiceInfo);
            }

            PrintToReStat.print(Reservations[countReservations].PrintInvoiceDetails());

            countCustomers++;
            countReservations++;
        }
    }

}
