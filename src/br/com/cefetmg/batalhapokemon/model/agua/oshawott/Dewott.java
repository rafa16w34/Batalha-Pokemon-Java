package br.com.cefetmg.batalhapokemon.model.agua.oshawott;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Dewott extends Oshawott {

    public Dewott(String apelido) {
        super(apelido);
        this.especie = "Dewottt";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double)75.0F;
        this.vida = (double)75.0F;
        this.ataque = (double)75.0F;
        this.defesa = (double)60.0F;
        this.velocidade = (double)60.0F;
        this.adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
    }

    public Pokemon evoluir() {
        return new Samurott(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Dewott Dewott!");
    }

}
