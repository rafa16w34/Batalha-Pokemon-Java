package br.com.cefetmg.batalhapokemon.model.fogo.growlithe;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Arcanine extends Growlithe {

    public Arcanine(String apelido) {
        super(apelido);
        this.especie = "Arcanine";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double) 90.0F;
        this.vida = (double) 90.0F;
        this.ataque = (double) 110.0F;
        this.defesa = (double) 80.0F;
        this.velocidade = (double) 95.0F;
        this.itemEvolucaoStr = "Pedra de Fogo";
        this.adicionarAtaque(new Ataque("Flamethrower", 90, Tipo.FOGO));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Arcanine!");
    }

}
