// Question 9
// The moon’s gravity is about 17 percent that of Earth’s. 
// Write a program that computes your effective weight on the moon.

// Answer: 
public class ex9 {
        public static void main(String[] args) {
                double myweight = 87.1;

                System.out.println("Weight on earth: " + myweight);

                double moonweight = myweight * 0.17;

                System.out.println("Weight on moon: " + moonweight);
        }
}
