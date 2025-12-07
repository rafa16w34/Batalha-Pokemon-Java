package br.com.cefetmg.batalhapokemon.model.terra.cubone;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil.Quilava;

public class Cubone extends Pokemon {

    public Cubone(String apelido) {
        super(apelido, "Cubone", Tipo.TERRA, 1, (double)50.0F, (double)50.0F, (double)95.0F, (double)35.0F);
        this.adicionarAtaque(new Ataque("Rage", 20, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Bone Club", 65, Tipo.TERRA));
    }

    public Pokemon evoluir() {
        return new Marowak(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Cubone!");
    }

}
