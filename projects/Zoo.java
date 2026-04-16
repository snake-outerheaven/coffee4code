package projects;

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
                Animal animal = new Animal("Bicho");

                Cat gato = new Cat("Crookshanks", "Inglês");

                animal.fazBarulho();

                gato.fazBarulho();
        }
}
