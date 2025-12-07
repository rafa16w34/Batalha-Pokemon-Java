package br.com.cefetmg.batalhapokemon.model.planta.rowlet;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Rowlet extends Pokemon {

    public Rowlet(String apelido) {
        super(apelido, "Rowlet", Tipo.PLANTA, 1, (double)68.0F, (double)55.0F, (double)55.0F, (double)42.0F);
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Leafage", 40, Tipo.PLANTA));
    }

    public Pokemon evoluir() {
        return new Dartrix(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Roowwlet!");
    }



}
