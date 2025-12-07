package br.com.cefetmg.batalhapokemon.model.planta.rowlet;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Decidueye extends Dartrix {

    public Decidueye(String apelido) {
        super(apelido);
        this.especie = "Decidueye";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double)78.0F;
        this.vida = (double)78.0F;
        this.ataque = (double)107.0F;
        this.defesa = (double)75.0F;
        this.velocidade = (double)70.0F;
        this.adicionarAtaque(new Ataque("Leaf Blade", 90, Tipo.PLANTA));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("DeciduEYE!");
    }


}
