package chapter2.examples;

public class ModDemo {
        public static void main(String[] args) {
                int iresult, irem;
                double dresultm, drem;

                iresult = 10 / 3;
                irem = 10 % 3;

                dresultm = 10.0 / 3.0;
                drem = 10.0 % 3.0;

                System.out.println("Result and remainder of 10 / 3: " + iresult + " " + irem);
                System.out.println("Result and remainder of 10.0 / 3.0: " + dresultm + " " + drem);
        }
}
