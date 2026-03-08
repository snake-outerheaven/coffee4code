package chapter1.examples;

public class FourthExample {
        public static void main(String[] args) {
                int a, b, c;

                a = 2;

                b = 3;

                if (a < b)
                        System.out.println("a is less than b");

                if (a == b)
                        System.out.println("You won't see this.");

                System.out.println();

                c = a - b;

                System.out.println("c contains " + c);

                if (c >= 0)
                        System.out.println("c is non-negative.");

                if (c < 0)
                        System.out.println("C is negative.");

                System.out.println(a + " " + b + " " + c);
        }
}
