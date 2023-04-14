package br.senai.sc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistMusicaTest {

    private PlaylistMusica playlistMusica;
    private static Musica musica = new Musica("Infinita Highway", "Engenheiros do Hawaii", 3);
    private static Musica musica2 = new Musica("Faroeste Caboclo", "Legião Urbana", 9);
    private static Musica musica3 = new Musica("Infinita", "Legião Urbana", 3);

    @BeforeEach
    public void setUp(){
        playlistMusica = new PlaylistMusica("Engenheiros");
        playlistMusica.adicionarMusica(musica);
    }

    @Test
    public void adicionarMusicaTeste() {
        assertTrue(playlistMusica.adicionarMusica(musica2));
    }

    @Test
    public void removerMusicaTeste() {
        assertTrue(playlistMusica.removerMusica(musica));
    }

    @Test
    public void buscarMusicaPorTituloTeste() {
       assertEquals(musica, playlistMusica.buscarMusicaPorTitulo("Infinita Highway"));
    }

    @Test
    public void buscarMusicasPorArtistaTeste() {
       playlistMusica.adicionarMusica(musica2);
       playlistMusica.adicionarMusica(musica3);

       List<Musica> listMusicas = new ArrayList<>();
       listMusicas.add(musica2);
       listMusicas.add(musica3);

       assertEquals(listMusicas, playlistMusica.buscarMusicasPorArtista("Legião Urbana"));
    }

    @Test
    public void ordenarPorTituloTeste() {
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorTitulo();

        List<Musica> listMusicasTest = new ArrayList<>();
        listMusicasTest.add(musica2);
        listMusicasTest.add(musica);

        assertEquals(playlistMusica.getMusicas(), listMusicasTest);
    }

    @Test
    public void ordenarPorArtistaTeste() {
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorArtista();

        List<Musica> listMusicasTest = new ArrayList<>();
        listMusicasTest.add(musica);
        listMusicasTest.add(musica2);

        assertEquals(listMusicasTest, playlistMusica.getMusicas());
    }

    @Test
    public void getQuantidadeMusicasTeste() {
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }

    @Test
    public void getNomeTest() {
        String nomeEsperado = "Engenheiros";
        String nomeObtido = playlistMusica.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void setNomeTest() {
        playlistMusica.setNome("Legião");

        String nomeEsperado = "Legião";
        String nomeObtido = playlistMusica.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void getMusicasTest() {
        List<Musica> playlistMusicaTest = new ArrayList<>();
        playlistMusicaTest.add(musica);

        assertEquals(playlistMusica.getMusicas(), playlistMusicaTest);
    }



}
