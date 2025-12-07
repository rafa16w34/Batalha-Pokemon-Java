package br.com.cefetmg.batalhapokemon.model.eletrico.pikachu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Raichu extends Pikachu {

    public Raichu(String apelido) {
        super(apelido);
        this.especie = "Raichu";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double)60.0F;
        this.vida = (double)60.0F;
        this.ataque = (double)90.0F;
        this.defesa = (double)55.0F;
        this.velocidade = (double)110.0F;
        this.itemEvolucaoStr = "Pedra do Trovão";
        this.adicionarAtaque(new Ataque("Thunder", 110, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("Raiii chu!");
    }



}
