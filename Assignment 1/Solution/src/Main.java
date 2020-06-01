
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    //------------------------------ Main Method ------------------------------
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt"); // Reading from input.txt
        File outputFile = new File("print.txt"); // Writing to print.txt
        PrintWriter Write2Print = new PrintWriter(outputFile);
        Write2Print.println("\r\n	Welcome to Toyota Sales Analysis App!\r\n");
        if (!(file.exists())) {
            System.out.println("Error 001 (input.txt) file is not found, Please try again.");
            System.exit(0);
        }

        // **** Initializing all the arrays ****
        Scanner txtInput = new Scanner(file);

        String[] City = new String[txtInput.nextInt()];

        String[][] Branches = new String[City.length][];
        for (int i = 0; i < Branches.length; i++) {
            Branches[i] = new String[txtInput.nextInt()];
        }

        String[] Months = new String[txtInput.nextInt()];

        int[][][] Sales = new int[City.length][][];
        for (int i = 0; i < City.length; i++) {
            Sales[i] = new int[Branches[i].length][Months.length];
        }

        // **** Reading the commands ****
        String Commands;
        do {
            Commands = txtInput.next();
            if (Commands.equalsIgnoreCase("add_city")) {
                readCity(txtInput, City, Write2Print);

            } else if (Commands.equalsIgnoreCase("Add_City_Branch")) {
                readBranch(txtInput, Branches, Write2Print, City);

            } else if (Commands.equalsIgnoreCase("Add_Month")) {
                readMonth(txtInput, Months, Write2Print);

            } else if (Commands.equalsIgnoreCase("ADD_SALES")) {
                PrintAllSales(Sales, Months, Branches, City, Write2Print, txtInput);

            } else if (Commands.equalsIgnoreCase("PRINT_TOTAL_SALES_BRANCH")) {
                PrintSalesBranch(Sales, Branches, City, Write2Print);

            } else if (Commands.equalsIgnoreCase("PRINT_TOTAL_SALES_MONTH")) {
                PrintSalesMonth(Sales, Months, City, Write2Print);

            } else if (Commands.equalsIgnoreCase("PRINT_MAX_SALE_BRANCH")) {
                PrintMaxSaleBranch(Write2Print, Sales, Months, Branches, City);

            } else if (Commands.equalsIgnoreCase("PRINT_MAX_SALE_MONTH")) {
                PrintMaxSaleMonth(Write2Print, Sales, Months, Branches, City);

            } else if (Commands.equalsIgnoreCase("PRINT_AVERAGE_SALES_BRANCH")) {
                AvgSalesBranch(Sales, Branches, City, Write2Print);

            } else if (Commands.equalsIgnoreCase("PRINT_AVERAGE_SALES_MONTH")) {
                AvgSalesMonth(Sales, Months, City, Write2Print);

            } else if (Commands.equalsIgnoreCase("quit")) {
                Write2Print.print("\r\nThank you for using Toyota Sales Analysis App, Good Bye!");
                Write2Print.flush();
                Write2Print.close();
                txtInput.close();
                break;

            } else { // incase that the txt file is not formated correctly 
                System.out.println("ERROR 002, Something went wrong with the input file");
                System.exit(1);
            }
        } while (true);
    }

    //------------------------------ Read City and print it ------------------------------
    public static void readCity(Scanner txtInput, String City[], PrintWriter Write2Print) { // Done
        Write2Print.print("COMMAND: ADD_CITY\r\n***Following City names are recorded in the system - Toyota Car Sale App - ***\r\n\r\n City Names:\r\n\t");
        for (int i = 0; i < City.length; i++) { // I'm gonna take the city name is print it at the same time to save some time ;)
            City[i] = txtInput.next(); // Store
            Write2Print.print(City[i].toUpperCase() + "  "); // Print
        }
        Write2Print.println("\r\n-------------------------------------------------------------------------------------------------------\r\n");
    }

    //------------------------------ Read Branches and print it ------------------------------
    public static void readBranch(Scanner txtInput, String Branches[][], PrintWriter Write2Print, String City[]) {
        Write2Print.println("COMMAND: ADD_BRANCH\r\n***Following branch names are recorded in the system  - Toyota Sales Analysis App - ***\r\n");
        for (int i = 0; i < Branches.length; i++) { // Cities
            Write2Print.print(City[i].toUpperCase() + "\r\n    ");
            for (int j = 0; j < Branches[i].length; j++) { // All Branches inside a city
                Branches[i][j] = txtInput.next();
                Write2Print.print(Branches[i][j].toUpperCase() + "   ");
            }
            Write2Print.println();
        }
        Write2Print.println("\r\n-------------------------------------------------------------------------------------------------------\r\n");
    }

    //------------------------------ Read Months and print it ------------------------------
    public static void readMonth(Scanner txtInput, String Month[], PrintWriter Write2Print) {
        Write2Print.println("COMMAND: ADD_MONTH");
        Write2Print.print("***Following month names are recorded in the system - Toyota Sales Analysis App - ***\r\n\r\n Month Names: \r\n");
        for (int i = 0; i < Month.length; i++) {
            Month[i] = txtInput.next();
            Write2Print.print(Month[i].toUpperCase() + ", ");
        }
        Write2Print.println("\r\n-------------------------------------------------------------------------------------------------------\r\n");
    }

    //------------------------------ Read and Print All Sales ------------------------------
    public static void PrintAllSales(int Sales[][][], String Months[], String Branches[][], String City[], PrintWriter Write2Print, Scanner txtInput) {
        Write2Print.println("COMMAND: ADD_SALES");
        Write2Print.println("***Following Sales Figures are recorded in the system - Toyota Sales Analysis App - ***\r\n");
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("***For the City : " + City[i] + "***\r\n");

            for (int j = 0; j < Sales[i].length; j++) { // Branches
                Write2Print.println("Branch ( " + Branches[i][j] + " )");

                for (int k = 0; k < Sales[i][j].length; k++) { // Months
                    Sales[i][j][k] = txtInput.nextInt();
                    Write2Print.printf("     Month (%15s): %d\r\n", Months[k], Sales[i][j][k]);
                }
                Write2Print.println();
            }
        }
    }

    //------------------------------ Print total sales in branches ------------------------------
    public static void PrintSalesBranch(int Sales[][][], String Branches[][], String City[], PrintWriter Write2Print) {
        Write2Print.println("\r\nCOMMAND: PRINT_TOTAL_SALES_BRANCH");
        Write2Print.println("***Following is  Total Sales Figures based on branches recorded in the system - Toyota Sales Analysis App - ***");
        int total;
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("\r\n-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("***Total Sales Figures For the City : " + City[i] + "***\r\n");

            for (int j = 0; j < Sales[i].length; j++) { // Branches
                total = 0;

                for (int k = 0; k < Sales[i][j].length; k++) { // Months
                    total += Sales[i][j][k];
                }
                Write2Print.printf("%25s: %d SR\r\n", Branches[i][j], total);
            }
        }
    }

    //------------------------------ Print total sales in months ------------------------------
    public static void PrintSalesMonth(int Sales[][][], String Months[], String City[], PrintWriter Write2Print) {
        Write2Print.println("\r\n\r\nCOMMAND: PRINT_TOTAL_SALES_MONTH");
        Write2Print.println("***Following is Monthly Sales Figures recorded in the system - Toyota Sales Analysis App - ***");
        int total;
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("Total Sales Figures For the City : " + City[i] + "\r\n");

            for (int j = 0; j < Months.length; j++) { // Months
                total = 0;
                for (int k = 0; k < Sales[i].length; k++) { // Branches
                    total += Sales[i][k][j];
                }
                Write2Print.printf("Month :%12s :     (%d SR)\r\n", Months[j], total);
            }
        }
    }

    //------------------------------ Print Max Sale in all branches  ------------------------------
    public static void PrintMaxSaleBranch(PrintWriter Write2Print, int Sales[][][], String Months[], String Branches[][], String City[]) {
        Write2Print.println("\r\n\r\nCOMMAND: PRINT_MAX_SALE_BRANCH");
        Write2Print.println("***Following Max Sales Figures for Branches recorded in the system - Toyota Sales Analysis App - ***");
        int MaxValue, MaxValueIndex;

        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("Max Sales Figures For the City : " + City[i] + "\r\n");

            for (int j = 0; j < Sales[i].length; j++) { // Branches
                MaxValue = 0;
                MaxValueIndex = 0;

                for (int k = 0; k < Sales[i][j].length; k++) { // Months
                    if (Sales[i][j][k] > MaxValue) { // Comparing
                        MaxValue = Sales[i][j][k];
                        MaxValueIndex = k;
                    }
                }
                Write2Print.printf("%25s:  ( %d SR ) for the month %15S\r\n", Branches[i][j], MaxValue, Months[MaxValueIndex]);
            }
        }
    }

    //------------------------------ Find and Print the max sale of all branches per month ------------------------------
    public static void PrintMaxSaleMonth(PrintWriter Write2Print, int Sales[][][], String Months[], String Branches[][], String City[]) {
        Write2Print.println("\r\n\r\nCOMMAND: PRINT_MAX_SALE_MONTH");
        Write2Print.println("***Following Max Sales Figures for Months recorded in the system - Toyota Sales Analysis App - ***");
        int MaxValue, MaxValueIndex;
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("Max Sales Figures For the City : " + City[i] + "\r\n");

            for (int j = 0; j < Months.length; j++) { // Months
                MaxValue = 0;
                MaxValueIndex = 0;

                for (int k = 0; k < Branches[i].length; k++) { // Branches
                    if (Sales[i][k][j] > MaxValue) { // Comparing
                        MaxValue = Sales[i][k][j];
                        MaxValueIndex = k;
                    }
                }
                Write2Print.printf("Month : %15s (   %d SR) for the branch %20S\r\n", Months[j], MaxValue, Branches[i][MaxValueIndex]);
            }
        }
        Write2Print.println();
    }

    //------------------------------ Find and print the average sale per branch for the whole year ------------------------------
    public static void AvgSalesBranch(int Sales[][][], String Branches[][], String City[], PrintWriter Write2Print) {
        Write2Print.println("\r\nCOMMAND: PRINT_AVERAGE_SALES_BRANCH");
        Write2Print.println("***Following Average Sales Figures based on Branches  recorded in the system - Toyota Sales Analysis App - ***");
        double total;
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("\r\n-------------------------------------------------------------------------------------------------------");
            Write2Print.println("\r\n***Average Sales Figures For the City : " + City[i] + "***\r\n");

            for (int j = 0; j < Sales[i].length; j++) { // Branches
                total = 0;
                for (int k = 0; k < Sales[i][j].length; k++) { // Months
                    total += Sales[i][j][k];
                }
                total /= Sales[i][j].length;
                Write2Print.printf("  Branch : %25s  ( %.2f SR) \r\n", Branches[i][j], total);
            }
            Write2Print.println();
        }
        Write2Print.println();
    }

    //------------------------------ Find and Print the average sales for all branches in months ------------------------------
    public static void AvgSalesMonth(int Sales[][][], String Months[], String City[], PrintWriter Write2Print) {
        Write2Print.println("\r\nCOMMAND: PRINT_AVERAGE_SALES_MONTH");
        Write2Print.println("***Following Average Sales Figures based on Months  recorded in the system - Toyota Sales Analysis App - ***");
        double total;
        for (int i = 0; i < Sales.length; i++) { // Cities
            Write2Print.println("-------------------------------------------------------------------------------------------------------\r\n");
            Write2Print.println("Total Average Sales Figures For the City : " + City[i] + "\r\n");
            for (int j = 0; j < Months.length; j++) { // Months
                total = 0;
                for (int k = 0; k < Sales[i].length; k++) { // Branches
                    total += Sales[i][k][j];
                }
                total /= Sales[i].length;
                Write2Print.printf("     Month : %15s (%.2f SR)\r\n", Months[j], total);
            }
        }
    }
}
