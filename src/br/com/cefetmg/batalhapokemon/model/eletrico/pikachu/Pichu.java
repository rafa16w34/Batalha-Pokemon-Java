package br.com.cefetmg.batalhapokemon.model.eletrico.pikachu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Pichu extends Pokemon {

    public Pichu(String apelido) {
        super(apelido, "Pichu", Tipo.ELETRICO, 1, (double)20.0F, (double)40.0F, (double)15.0F, (double)60.0F, "Pedra do Trovão");
        this.adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Thunder Shock", 40, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return new Pikachu(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Pichu Pichu");
    }



}
