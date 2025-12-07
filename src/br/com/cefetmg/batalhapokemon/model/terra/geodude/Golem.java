package br.com.cefetmg.batalhapokemon.model.terra.geodude;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Golem extends Graveler{

    public Golem(String apelido) {
        super(apelido);
        this.especie = "Golem";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double) 80.0F;
        this.vida = (double) 80.0F;
        this.ataque = (double) 120.0F;
        this.defesa = (double) 130.0F;
        this.velocidade = (double) 45.0F;
        this.itemEvolucaoStr = "Cabo de Ligação";
        this.adicionarAtaque(new Ataque("Stone Edge", 100, Tipo.TERRA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Golem!");
    }

}
