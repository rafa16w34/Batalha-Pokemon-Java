package br.com.cefetmg.batalhapokemon.model.terra.geodude;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil.Typhlosion;

public class Graveler extends Geodude{

    public Graveler(String apelido) {
        super(apelido);
        this.especie = "Graveler";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double) 55.0F;
        this.vida = (double) 55.0F;
        this.ataque = (double) 95.0F;
        this.defesa = (double) 115.0F;
        this.velocidade = (double) 35.0F;
        this.itemEvolucaoStr = "Cabo de ligação";
        this.adicionarAtaque(new Ataque("Rock Throw", 50, Tipo.TERRA));
    }

    public Pokemon evoluir() {
        return new Golem(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Graveler!");
    }

}
