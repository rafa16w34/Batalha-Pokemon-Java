package br.com.cefetmg.batalhapokemon.model.normal.rattata;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Raticate extends Rattata{

    public Raticate(String apelido) {
        super(apelido);
        this.especie = "Raticate";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double)55.0F;
        this.vida = (double)55.0F;
        this.ataque = (double)81.0F;
        this.defesa = (double)60.0F;
        this.velocidade = (double)97.0F;
        this.adicionarAtaque(new Ataque("Double-Edge", 120, Tipo.NORMAL));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Raticate!");
    }

}
