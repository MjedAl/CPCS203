
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static ArrayList<Event> EventsList = new ArrayList();
    private static ArrayList<Customer> CustomersList = new ArrayList();
    private static int CustomerCount = 0; // to keep track of customer

    // keep track of tickets 
    // there was no mention in the pdf file to how to create the tickets id so this is how i did it :)
    private static int TicketsID = 0;

    private static SimpleDateFormat MyDateFormat = new SimpleDateFormat("dd/MM/yyyy"); // this will help me convert any date to string.

    // --------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        File inputTxt = new File("input.txt");
        if (!inputTxt.exists()) {
            System.out.println("Error 001 (input.txt) file is not found, Please try again.");
            System.exit(1);
        }

        Scanner TxtInput = new Scanner(inputTxt); // Scanner to read from input.txt

        PrintWriter Pen = new PrintWriter(new File("output.txt")); // PrintWriter to print in output.txt  
        Pen.println("\r\n########################################################################################################\n"
                + "############################# Welcome to Entertainment Booking System ##################################\n"
                + "########################################################################################################\r\n");

        while (TxtInput.hasNextLine()) {
            String CommandLine = TxtInput.nextLine();
            if (CommandLine.contains("AddMovie")) {
                AddMovieCMD(CommandLine, Pen);

            } else if (CommandLine.contains("AddFestival")) {
                AddFestivalCMD(CommandLine, Pen);

            } else if (CommandLine.contains("AddConcert")) {
                AddConcertCMD(CommandLine, Pen);

            } else if (CommandLine.contains("AddCustomer")) {
                AddCustomerCMD(CommandLine, Pen);

            } else if (CommandLine.contains("BuyTicket")) { // if the command is buy ticket i will take the next lines until its Sumbit
                while (!CommandLine.contains("Submit")) {
                    CommandLine += "###" + TxtInput.nextLine();  // << the ### just so i know where to split the string later.
                }
                BuyTicketCMD(CommandLine, Pen);
            } else if (CommandLine.contains("PrintSortMovies")) {
                PrintSortMovies(Pen);
            } else if (CommandLine.contains("PrintSortFestivals")) {
                PrintSortFestivals(Pen);
            }

        }

        Pen.flush();
        Pen.close();

    }

    // --------------------------------------------------------------------------------------------------
    public static void AddMovieCMD(String Command, PrintWriter pen) throws ParseException {
        // first we r going to split the command
        String[] Tokens = Command.split("--|,\\s"); // Splitting the command line into multipile strings,this is because of the ','

        // Tokens[0] will be "AddMovie" so we'r gonna skip that
        String Name = Tokens[1];
        Date StartDate = MyDateFormat.parse(Tokens[2]);
        Date EndDate = MyDateFormat.parse(Tokens[3]);
        double Price = Double.parseDouble(Tokens[4]);
        String City = Tokens[5];
        String Address = Tokens[6];
        String Language = Tokens[7];
        String TargetedAudience = Tokens[8];
        double Rating = Double.parseDouble(Tokens[9]);
        int AvailableTickets = Integer.parseInt(Tokens[10]);
        String Genre = Tokens[11];
        // FOR ACTOR
        String Main_Actor_Name = Tokens[12];
        char Main_Actor_Gender = Tokens[13].charAt(0);
        int Main_Actor_Birth_Year = Integer.parseInt(Tokens[14]);

        Event Movie = new Movie(Name, StartDate, EndDate, Price, City, Address, Language, TargetedAudience, Rating, AvailableTickets, Genre, (new Actor(Main_Actor_Name, Main_Actor_Gender, Main_Actor_Birth_Year)));
        EventsList.add(Movie);
        pen.println(Movie);
    }

    // --------------------------------------------------------------------------------------------------
    public static void AddFestivalCMD(String Command, PrintWriter pen) throws ParseException {
        String[] Tokens = Command.split("--|,\\s");

        String Name = Tokens[1];
        Date StartDate = MyDateFormat.parse(Tokens[2]);
        Date EndDate = MyDateFormat.parse(Tokens[3]);
        double Price = Double.parseDouble(Tokens[4]);
        String City = Tokens[5];
        String Address = Tokens[6];
        String TargetedAudience = Tokens[7];
        int AvailableTickets = Integer.parseInt(Tokens[8]);

        // Tokens[9] will have multiple words each will represent a food venue so we need to split them first
        String FoodVenie[] = Tokens[9].split(" ");
        // same thing goes for the Activities
        String Activities[] = Tokens[10].split(" ");

        Event Festival = new Festival(Name, StartDate, EndDate, Price, City, Address, TargetedAudience, AvailableTickets, FoodVenie, Activities);
        EventsList.add(Festival);
        pen.println(Festival);
    }

    // --------------------------------------------------------------------------------------------------
    public static void AddConcertCMD(String Command, PrintWriter pen) throws ParseException {
        String[] Tokens = Command.split("--|,\\s");

        String Name = Tokens[1];
        Date StartDate = MyDateFormat.parse(Tokens[2]);
        Date EndDate = MyDateFormat.parse(Tokens[3]);
        String City = Tokens[4];
        String Address = Tokens[5];

        double Price = Double.parseDouble(Tokens[6]);
        int AvailableTickets = Integer.parseInt(Tokens[7]);
        String TargetedAudience = Tokens[8];
        String Perfromers = Tokens[9];

        Event Concert = new Concert(Name, StartDate, EndDate, City, Address, Price, AvailableTickets, TargetedAudience, Perfromers);
        EventsList.add(Concert);
        pen.println(Concert);
    }

    // --------------------------------------------------------------------------------------------------
    public static void AddCustomerCMD(String Command, PrintWriter pen) throws ParseException {
        String[] Tokens = Command.split("--|,\\s");

        CustomerCount++;
        String CustomerID = String.format("%06d", CustomerCount);
        String Name = Tokens[1];
        char Gender = Tokens[2].charAt(0);
        String City = Tokens[3];
        Date DateOfBirth = MyDateFormat.parse(Tokens[4]);
        String Email = Tokens[5];

        Customer C = new Customer(CustomerID, Name, Gender, City, Email, DateOfBirth);
        CustomersList.add(C);
        pen.println(C);
    }

    // --------------------------------------------------------------------------------------------------
    public static void BuyTicketCMD(String Command, PrintWriter pen) throws ParseException {
        ArrayList<Event> EventsCart = new ArrayList(); // to store all the events in it

        String Tokens[] = Command.split("###");

        for (int i = 0; i < Tokens.length; i++) {

            if (Tokens[i].contains("BuyTicket")) { // *** 1- Buying Tickets ***
                String[] ThisTicket = Tokens[i].split("--|,\\s");
                // ok so now we have name and date

                boolean FoundTheMovie = false;
                boolean MovieDate = false;

                for (int j = 0; j < EventsList.size(); j++) { // first search for the event in the ArrayList
                    if ((EventsList.get(j).getName().equalsIgnoreCase(ThisTicket[1]))) { // if we found the event
                        FoundTheMovie = true;
                        // now we need to check the date.
                        // Start and End Date of the event
                        Date EndDate = EventsList.get(j).getEDate();
                        Date StartDate = EventsList.get(j).getSDate();

                        //  convert the string in the command to date
                        Date Ticket = MyDateFormat.parse(ThisTicket[2]);

                        // now compare between Ticket Date and Start&EndDate
                        if ((Ticket.compareTo(EndDate) < 0) && (Ticket.compareTo(StartDate) >= 0)) { // if the date wanted is between the start and end date of the event, we can add the ticket
                            MovieDate = true;
                            EventsCart.add(EventsList.get(j));
                            pen.println("The requested event " + EventsList.get(j).getName() + " is available in the selected date");
                            pen.println("Ticket is successfully added to the ShoppingCart: Cart Size -> " + EventsCart.size());
                        }

                    }

                }

                // if we didnt found the event or the date is not available
                if (!FoundTheMovie) {
                    pen.println("The event " + ThisTicket[1] + " is not found.");
                }
                if (!MovieDate) {
                    pen.println("The requested event " + ThisTicket[1] + " is not available in the selected date");
                    pen.println("Ticket not successfully added to the ShoppingCart: Cart Size -> " + EventsCart.size());
                }

            } else if (Tokens[i].contains("For--")) { // *** 2- Adding the ArrayList of events to a customer if we found him
                String[] Customer = Tokens[i].split("--|,\\s");

                boolean FoundHim = false;

                for (int j = 0; j < CustomersList.size(); j++) { // search for the customer.
                    if (CustomersList.get(j).getName().equalsIgnoreCase(Customer[1])) { // if we found the customer we make book
                        TicketsID++; // i decided to make the tickets number like this because if we make it random there's a chance that we get to tickets we the same id;
                        String TicketID = String.format("%09d", TicketsID);
                        Booking Book = new Booking(TicketID, CustomersList.get(j), EventsCart); //
                        pen.println("**Buying Ticket for " + Customer[1] + " was successfully completed\r\n");
                        pen.println(Book);
                        FoundHim = true;
                        break;
                    }
                }

                if (!FoundHim) { // if we did not find the customer
                    pen.println("The customer " + Customer[1] + " is not found");
                    pen.println("**Buying Ticket for " + Customer[1] + " was not successfully completed\r\n");
                }
            }

        }
    }

    // --------------------------------------------------------------------------------------------------
    public static void PrintSortMovies(PrintWriter pen) {
        ArrayList<Movie> MoviesList = new ArrayList(); // new array list to store only movies in it

        for (int i = 0; i < EventsList.size(); i++) { // taking only movies from the eventsList and store in the the new movie list
            if (EventsList.get(i) instanceof Movie) {
                MoviesList.add((Movie) EventsList.get(i));
            }
        }

        Collections.sort(MoviesList); // sorting that array list

        pen.println("----------------------------------------- Movie Sorted By Rating ------------------------------------------");
        pen.println("Movie name                   Dates         	    Actor             	Ratings          Available Tickets ");
        pen.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < MoviesList.size(); i++) {
            pen.println(MoviesList.get(i).PrintDetails()); // printintg all movies
        }
        pen.println("---------------------------------------------------------------------------------------------------------\r\n\r\n");

    }

    // --------------------------------------------------------------------------------------------------
    public static void PrintSortFestivals(PrintWriter pen) {
        // same as above method.
        ArrayList<Festival> FestivalsList = new ArrayList();

        for (int i = 0; i < EventsList.size(); i++) {
            if (EventsList.get(i) instanceof Festival) {
                FestivalsList.add((Festival) EventsList.get(i));
            }
        }

        Collections.sort(FestivalsList);
        pen.println("---------------------------------------- Festival Sorted By Starting Date -----------------------------------------------");
        pen.println("Festival Name       	     Dates               FoodVenues                   	    Activities          Available Tickets");
        pen.println("------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < FestivalsList.size(); i++) {
            pen.println(FestivalsList.get(i).PrintDetails());
        }
        pen.println("------------------------------------------------------------------------------------------------------------------------\r\n\r\n");

    }

}
