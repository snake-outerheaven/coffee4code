package projects;

import java.util.ArrayList;
import java.util.List;

class Animal {

        // atributos
        private String nome;

        // método construtor
        public Animal(String nome) {
                this.nome = nome;
        }

        // métodos
        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public void fazBarulho() {
                System.out.println(this.nome + " faz barulho!");
        }
}

// vamos fazer herança

class Cat extends Animal {
        String tipo;

        public Cat(String nome, String tipo) {
                super(nome);

                this.tipo = tipo;
        }

        // polimorfismo
        @Override
        public String getNome() {
                return super.getNome();
        }

        @Override
        public void setNome(String nome) {
                super.setNome(nome);
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        // polimorfismo!!!
        @Override
        public void fazBarulho() {

                System.out.println(super.getNome() + " mia!");
        }
}

public class Zoo {
        public static void main(String[] args) {
                List<Animal> animais = new ArrayList<Animal>();

                for (int i = 0; i < 10; ++i) {
                        if (i % 2 == 0)
                                animais.add(new Cat("Camelo", "Leopardo"));
                        else
                                animais.add(new Animal("Banana"));
                }

                for (Animal ani : animais) {
                        ani.fazBarulho();
                }

        }
}
