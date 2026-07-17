package chapter2.examples;

public class ScopeDemo {
        public static void main(String[] args) {
                int x;

                x = 10;

                if (x == 10) {
                        int y = 10;

                        System.out.println("X: " + x + " and Y: " + y);

                        x *= y;
                }

                // does not compile if uncommented. y = 100;

                System.out.println("The value of X is: " + x);
        }
}
