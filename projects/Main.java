package projects;

import java.util.Random;

import projects.Tree;

public class Main {

        private static final Random gerador = new Random();

        public static void main(String[] args) {

                Tree tree = new Tree();

                for (int i = 0; i < 100; i++) {
                        char letra = (char) (gerador.nextInt(26) + 'A');
                        tree.inserir(letra);
                }
                tree.mostrar();

                return;
        }
}
