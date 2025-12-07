package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Typhlosion extends Quilava{

    public Typhlosion(String apelido) {
        super(apelido);
        this.especie = "Typhlosion";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double) 78.0F;
        this.vida = (double) 78.0F;
        this.ataque = (double) 84.0F;
        this.defesa = (double) 78.0F;
        this.velocidade = (double) 100.0F;
        this.adicionarAtaque(new Ataque("Overheat", 130, Tipo.FOGO));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Typhlosion!");
    }

}
