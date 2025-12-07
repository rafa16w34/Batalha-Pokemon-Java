package br.com.cefetmg.batalhapokemon.model.agua.magikarp;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Gyarados extends Magikarp {

    public Gyarados(String apelido) {
        super(apelido);
        this.especie = "Gyarados";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double) 95.0F;
        this.vida = (double) 95.0F;
        this.ataque = (double) 125.0F;
        this.defesa = (double) 79.0F;
        this.velocidade = (double) 81.0F;
        this.adicionarAtaque(new Ataque("Hidro Pump", 110, Tipo.AGUA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("GRRRRRR!");
    }
}