// Question 10:
// Adapt Try This 1-2 so that it prints a conversion table of inches to meters. 
// Display 12 feet of conversions, inch by inch. 
// Output a blank line every 12 inches.
// (One meter equals approximately 39.37 inches.)

// Answer: 
public class ex10 {
        public static void main(String[] args) {

                double meters;
                int i;

                System.out.println("|Inches\tMeters|");

                for (i = 1; i <= 120; ++i) {

                        meters = i / 39.37;

                        System.out.printf("|%d\t%.2f|\n", i, meters);

                        if ((i % 12) == 0)
                                System.out.println();
                }
        }
}
