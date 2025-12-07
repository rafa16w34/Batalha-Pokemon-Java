package br.com.cefetmg.batalhapokemon.model.fogo.growlithe;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.agua.oshawott.Dewott;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Growlithe extends Pokemon {

    public Growlithe(String apelido) {
        super(apelido, "Growlithe", Tipo.FOGO, 1, (double)55.0F, (double)70.0F, (double)45.0F, (double)60.0F,"Pedra de Fogo");
        this.adicionarAtaque(new Ataque("Bite", 60, Tipo.NORMAL));//Levando em conta a gen 1 quando o tipo do ataque era normal
        this.adicionarAtaque(new Ataque("Ember", 40, Tipo.FOGO));
    }

    public Pokemon evoluir() {
        return new Arcanine(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Growl Growl!");
    }

}
