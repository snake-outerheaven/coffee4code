package projects;

public class AVLTree {
    private No raiz;

    private static class No {
	char info;
	int altura;
	No esquerdo, direito;

	No(char info) {
	    this.info = info;
	    this.altura = 1;
	}
    }

    private int altura(No n) {
	return (n == null) ? 0 : n.altura;
    }

    private int getBalanceamento(No n) {
	return (n == null) ? 0 : this.altura(n.esquerdo) - this.altura(n.direito);
    }

    private No rotacionarDireita(No y) {
	No x = y.esquerdo;
	No T2 = x.direito;

	x.direito = y;
	y.esquerdo = T2;

	y.altura = Math.max(this.altura(y.esquerdo), this.altura(y.direito)) + 1;
	x.altura = Math.max(this.altura(x.esquerdo), this.altura(x.direito)) + 1;

	return x;
    }

    private No rotacionarEsquerda(No x) {
	No y = x.direito;
	No T2 = y.esquerdo;

	y.esquerdo = x;
	x.direito = T2;

	x.altura = Math.max(this.altura(x.esquerdo), this.altura(x.direito)) + 1;
	y.altura = Math.max(this.altura(y.esquerdo), this.altura(y.direito)) + 1;

	return y;
    }

    public void inserir(char info) {
	this.raiz = this.inserirRecursivo(this.raiz, info);
    }

    private No inserirRecursivo(No no, char info) {
	if (no == null) {
	    return new No(info);
	}

	if (info < no.info) {
	    no.esquerdo = this.inserirRecursivo(no.esquerdo, info);
	} else if (info > no.info) {
	    no.direito = this.inserirRecursivo(no.direito, info);
	} else {
	    return no;
	}

	no.altura = 1 + Math.max(this.altura(no.esquerdo), this.altura(no.direito));
	int bal = this.getBalanceamento(no);

	if (bal > 1 && info < no.esquerdo.info) {
	    return this.rotacionarDireita(no);
	}

	if (bal < -1 && info > no.direito.info) {
	    return this.rotacionarEsquerda(no);
	}

	if (bal > 1 && info > no.esquerdo.info) {
	    no.esquerdo = this.rotacionarEsquerda(no.esquerdo);
	    return this.rotacionarDireita(no);
	}

	if (bal < -1 && info < no.direito.info) {
	    no.direito = this.rotacionarDireita(no.direito);
	    return this.rotacionarEsquerda(no);
	}

	return no;
    }

    public void mostrar() {
	this.executarLateral(this.raiz, 0);
    }

    private void executarLateral(No r, int nivel) {
	if (r == null) {
	    return;
	}

	this.executarLateral(r.direito, nivel + 1);

	for (int i = 0; i < nivel; i++) {
	    System.out.print("        ");
	}

	if (nivel > 0) {
	    System.out.print("|-------");
	}

	System.out.println("[" + r.info + "]");

	this.executarLateral(r.esquerdo, nivel + 1);
    }
}
