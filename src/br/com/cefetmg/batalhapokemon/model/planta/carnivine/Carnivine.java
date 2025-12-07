package br.com.cefetmg.batalhapokemon.model.planta.carnivine;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Carnivine extends Pokemon {

    public Carnivine(String apelido) {
        super(apelido, "Carnivine", Tipo.PLANTA, 1, (double)74.0F, (double)100.0F, (double)72.0F, (double)46.0F);
        this.adicionarAtaque(new Ataque("Absorb", 20, Tipo.PLANTA));
        this.adicionarAtaque(new Ataque("Energy Ball", 90, Tipo.PLANTA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Carnivine!");
    }



}
