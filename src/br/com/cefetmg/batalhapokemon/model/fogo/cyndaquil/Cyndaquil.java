package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.agua.oshawott.Dewott;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Cyndaquil extends Pokemon {

    public Cyndaquil(String apelido) {
        super(apelido, "Cyndaquil", Tipo.FOGO, 1, (double)39.0F, (double)52.0F, (double)43.0F, (double)65.0F);
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Ember", 40, Tipo.FOGO));
    }

    public Pokemon evoluir() {
        return new Quilava(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Cyndaquil!");
    }

}
