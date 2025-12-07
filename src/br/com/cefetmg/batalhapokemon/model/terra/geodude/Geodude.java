package br.com.cefetmg.batalhapokemon.model.terra.geodude;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.terra.cubone.Marowak;

public class Geodude extends Pokemon{

    public Geodude(String apelido) {
        super(apelido, "Geodude", Tipo.TERRA, 1, (double)40.0F, (double)80.0F, (double)100.0F, (double)20.0F, "Cabo de Ligação");
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Rollout", 30, Tipo.TERRA));
    }

    public Pokemon evoluir() {
        return new Graveler(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Geodude!");
    }

}
