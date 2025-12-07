package br.com.cefetmg.batalhapokemon.model.normal.arceus;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Arceus extends Pokemon {

    public Arceus(String apelido) {
        super(apelido, "Arceus", Tipo.NORMAL, 1, (double)120.0F, (double)120.0F, (double)120.0F, (double)120.0F);
        this.adicionarAtaque(new Ataque("Judgment", 100, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Hyper Beam", 150, Tipo.NORMAL));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("O dia do julgamento chegou...");
    }



}
