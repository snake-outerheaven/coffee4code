package chapter2.examples;

public class Pythagoras {
        public static void main(String[] args) {
                double x = 3;
                double y = 4;

                double z = Math.sqrt(x * x + y * y);

                System.out.println("hypotenuse for a triangle with sides " + x + " and " + y + " is " + z + ".");
        }
}
