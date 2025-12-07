package br.com.cefetmg.batalhapokemon.model.agua.magikarp;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Magikarp extends Pokemon {

    public Magikarp(String apelido) {
        super(apelido, "Magikarp", Tipo.AGUA, 1, (double)20.0F, (double)10.0F, (double)55.0F, (double)80.0F);
        this.adicionarAtaque(new Ataque("Splash", 0, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
    }

    public Pokemon evoluir() {
        return new Gyarados(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Kaaarp!");
    }



}
