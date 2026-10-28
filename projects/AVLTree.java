package projects;

import java.util.Arrays;

public class AVLTree {
    private static final int LARGURA = 4;

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
	if (this.raiz == null) {
	    System.out.println("(arvore vazia)");
	    return;
	}

	int linhas = this.altura(this.raiz) * 2 - 1;
	int colunas = this.contar(this.raiz) * LARGURA;
	char[][] grade = new char[linhas][colunas];

	for (char[] linha : grade) {
	    Arrays.fill(linha, ' ');
	}

	this.desenhar(this.raiz, 0, new int[] { 0 }, grade);

	for (char[] linha : grade) {
	    System.out.println(new String(linha).stripTrailing());
	}
    }

    private int contar(No n) {
	return (n == null) ? 0 : 1 + this.contar(n.esquerdo) + this.contar(n.direito);
    }

    // Percurso em ordem define a coluna de cada no; a profundidade define a linha.
    // Retorna a coluna central do no desenhado.
    private int desenhar(No n, int nivel, int[] proximo, char[][] grade) {
	int colEsq = (n.esquerdo == null) ? -1 : this.desenhar(n.esquerdo, nivel + 1, proximo, grade);

	int col = proximo[0]++ * LARGURA + 1;
	int linha = nivel * 2;
	grade[linha][col - 1] = '[';
	grade[linha][col] = n.info;
	grade[linha][col + 1] = ']';

	int colDir = (n.direito == null) ? -1 : this.desenhar(n.direito, nivel + 1, proximo, grade);

	if (colEsq >= 0 || colDir >= 0) {
	    char[] lig = grade[linha + 1];

	    if (colEsq >= 0) {
		lig[colEsq] = '\u250C';
		for (int c = colEsq + 1; c < col; c++) {
		    lig[c] = '\u2500';
		}
	    }

	    if (colDir >= 0) {
		lig[colDir] = '\u2510';
		for (int c = col + 1; c < colDir; c++) {
		    lig[c] = '\u2500';
		}
	    }

	    if (colEsq >= 0 && colDir >= 0) {
		lig[col] = '\u2534';
	    } else if (colEsq >= 0) {
		lig[col] = '\u2518';
	    } else {
		lig[col] = '\u2514';
	    }
	}

	return col;
    }
}
