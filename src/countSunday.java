import java.util.Scanner;

public class countSunday { 
    public static void main(String[] args) { 
        String[] weeks ={"MON", "TUE", "WED", "THUR", "FRI", "SAT", "SUN"}; 
        

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Starting Day:");
        String startingDay = sc.nextLine().toUpperCase(); 
        // Reading the starting day as input from the user and converting it to uppercase 
        // for consistent matching, as the array days are in uppercase.

        System.out.print("Enter No. of Days:"); 
        int noOfDays = sc.nextInt(); 

        int startingDayIndex = -1; // Initializing a variable to store the index of the starting day. -1 is a temporary value.


        // Loop to find the index of the starting day in the weeks array
        for (int i = 0; i < weeks.length; i++) {
            if (weeks[i].equals(startingDay)) { // Checking if the current day in weeks array matches the starting day
                startingDayIndex = i; // Setting startingDayIndex to the current index if match is found
            }
        }
        // String comparison uses `.equals()` and not == comparator.
        
        int countSunday = 0; // Initializing counter for Sundays to zero (temporary)

        // Loop to iterate over each day from the starting day up to the specified number of days
        for (int i = 0; i < noOfDays; i++) {
            int index = (startingDayIndex + i) % weeks.length; 
            // Calculating the index of the current day based on the starting day index and offset by 'i'.
            // Using modulo operation to loop back to the start of the array if the index goes past the array length.

            if (weeks[index].equals("SUN")) { // Checking if the current day is Sunday
                countSunday += 1; // Incrementing the count of Sundays by 1 if the condition is met
            }
        }

        sc.close(); // to free up system resources
        System.out.println("Total Sundays:" + countSunday);
    }
}
