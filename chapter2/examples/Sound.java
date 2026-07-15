package chapter2.examples;

public class Sound {
        public static void main(String[] args) {
                double fs = 1100; // number of feet per second to meet the speed of sound.

                double ti = 7.2; // time interval

                System.out.println("The lightning is " + fs * ti + " feet away.");

                double fs1 = 1100;

                double ti1 = 9;

                System.out.println("A rock is " + fs1 * (ti1 / 2) + " ft away (calculated from a sonar).");
        }
}

// continue to Literals. <----- TODO