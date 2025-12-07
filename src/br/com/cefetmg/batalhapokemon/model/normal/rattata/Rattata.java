package br.com.cefetmg.batalhapokemon.model.normal.rattata;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Rattata extends Pokemon {

    public Rattata(String apelido) {
        super(apelido, "Rattata", Tipo.NORMAL, 1, (double)30.0F, (double)56.0F, (double)35.0F, (double)72.0F);
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
    }

    public Pokemon evoluir() {
        return new Raticate(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("RATAATAA!");
    }



}
