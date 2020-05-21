package br.com.fiap.biblioteca.model;

public class Biblioteca {
	private Livro[] livros;
	private int totalLivros = -1;

	public Biblioteca() {
		this.livros = new Livro[10];
	}

	public Biblioteca(int quantidadeLivros) {
		this();
		this.livros = new Livro[quantidadeLivros];
	}
	
	// Getters e Setters
	
	public Livro[] getLivros() {
		return livros;
	}

	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}

	public int getTotalLivros() {
		return totalLivros;
	}

	public void setTotalLivros(int totalLivros) {
		this.totalLivros = totalLivros;
	}
	
	// Métodos
	
	public void adiciona(Livro livro) {

		try {
			if (this.cheia())
				throw new Exception("Não é possível adicionar. A lista está cheia.");

			for (int i = 0; i <= this.livros.length - 1; i++) {
				if (this.livros[i] == null) {
					this.totalLivros++;
					this.livros[i] = livro;
					break;
				}
			}

		} catch (Exception e) {
			System.err.print(e);
		}

	}

	public Livro consulta(String titulo) {
		try {

			if (this.vazia())
				throw new Exception("A lista está vazia.");

			for (int i = 0; i <= this.livros.length - 1; i++) {
				if (this.livros[i].getTitulo().contains(titulo)) {
					return this.livros[i];
				}
			}
		} catch (NullPointerException e) {
			System.err.print("Nenhum livro encontrado com o título especificado.");
		} catch (Exception e) {
			System.err.print(e);
		}
		return null;
	}

	public Livro remove(Livro livro) {
		for (int i = 0; i <= livros.length - 1; i++) {

			if (livro.equals(livros[i])) {
				livros[i] = null;
			}

			if (livros[i] == null && i < livros.length - 1) {
				livros[i] = livros[i + 1];
				livros[i + 1] = null;
			}

		}
		return livro;
	}

	public void atualiza(Livro livro) {

		try {

			if (this.vazia())
				throw new Exception("A lista está vazia.");

			this.consulta(livro.getTitulo());

			for (int i = 0; i <= livros.length - 1; i++) {

				if (livro.getTitulo().equals(livros[i].getTitulo())) {
					livros[i] = null;
					break;
				}
			}

			this.adiciona(livro);
		}

		catch (Exception e) {
			System.err.print(e);
		}

	}

	public int tamanho() {
		return this.totalLivros + 1;
	}

	public boolean cheia() {
		for (int i = 0; i <= this.livros.length - 1; i++) {
			if (this.livros[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean vazia() {

		return this.totalLivros == -1 ? true : false;
	}
}