package br.com.cefetmg.batalhapokemon.model.agua.oshawott;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Samurott extends Dewott {

    public Samurott(String apelido) {
        super(apelido);
        this.especie = "Samurott";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double)95.0F;
        this.vida = (double)95.0F;
        this.ataque = (double)100.0F;
        this.defesa = (double)85.0F;
        this.velocidade = (double)70.0F;
        this.adicionarAtaque(new Ataque("Hydro Pump", 110, Tipo.AGUA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Samurott Samurott!");
    }

}
