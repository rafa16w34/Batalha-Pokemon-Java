package br.com.cefetmg.batalhapokemon.model.terra.cubone;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Marowak extends Cubone{

    public Marowak(String apelido) {
        super(apelido);
        this.especie = "Marowak";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double) 60.0F;
        this.vida = (double) 60.0F;
        this.ataque = (double) 80.0F;
        this.defesa = (double) 110.0F;
        this.velocidade = (double) 45.0F;
        this.adicionarAtaque(new Ataque("Bonemerang", 50, Tipo.TERRA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Marowak!");
    }

}
