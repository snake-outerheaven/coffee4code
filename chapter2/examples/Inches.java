package chapter2.examples;

public class Inches {
        public static void main(String[] args) {
                long ci, im;

                // 5280 pes / milha, 12 polegadas por pé, fazendo o produto, sobra polegadas por milha, que é o que queremos.
                im = 5280L * 12L;

                System.out.println("The value of im is " + im);

                ci = im * im * im;

                System.out.println("There is " + ci + " cubic inches in a cubic mile.");
        }
}