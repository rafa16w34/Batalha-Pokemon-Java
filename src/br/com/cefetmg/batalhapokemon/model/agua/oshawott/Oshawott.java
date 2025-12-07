package br.com.cefetmg.batalhapokemon.model.agua.oshawott;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Oshawott extends Pokemon {

        public Oshawott(String apelido) {
            super(apelido, "Oshawott", Tipo.AGUA, 1, (double)55.0F, (double)55.0F, (double)45.0F, (double)45.0F);
            this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
            this.adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
        }

        public Pokemon evoluir() {
            return new Dewott(this.getApelido());
        }

        public void realizarSom() {
            System.out.println("OSHAWHASHASHAHA WHATASHA WHASHASHA ASHASHA WATHASHA!");
        }



}
