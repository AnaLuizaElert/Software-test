package br.senai.sc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private static Livro livro = new Livro("Alegria", "Ana", "Alegria", 2005);

    @BeforeEach
    public void setUp(){
        biblioteca = new Biblioteca("Ana's Books");
        biblioteca.adicionarLivro(livro);
    }

    @Test
    public void adicionarLivroTest(){
        assertTrue(biblioteca.adicionarLivro(new Livro("Felicidade", "Ana Luiza", "Angustia", 2023)));
    }

    @Test
    public void removerLivroTest(){
        assertTrue(biblioteca.removerLivro(livro));
    }

    @Test
    public void verQtdLivrosTest(){
        assertEquals(1, biblioteca.getQuantidadeLivros());
    }

    @Test
    public void buscarLivrosPorGeneroTest(){
       List<Livro> livros = new ArrayList<>();
       livros.add(livro);
       assertEquals(biblioteca.buscarLivrosPorGenero("Alegria"), livros);
    }

    @Test
    public void buscarLivrosPorAutorTest(){
        List<Livro> livros = new ArrayList<>();
        livros.add(livro);
        assertEquals(biblioteca.buscarLivrosPorAutor("Ana"), livros);
    }

    @Test
    public void buscarLivroPorTituloTest(){
        assertEquals(biblioteca.buscarLivroPorTitulo("Alegria"), livro);
    }

    @Test
    public void getNomeTest() {
        String nomeEsperado = "Ana's Books";
        String nomeObtido = biblioteca.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void setNomeTest() {
        biblioteca.setNome("Annabel's Books");

        String nomeEsperado = "Annabel's Books";
        String nomeObtido = biblioteca.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void getLivrosTest() {
        List<Livro> listLivrosTest = new ArrayList<>();
        listLivrosTest.add(livro);
        assertEquals(listLivrosTest, biblioteca.getLivros());
    }


}
