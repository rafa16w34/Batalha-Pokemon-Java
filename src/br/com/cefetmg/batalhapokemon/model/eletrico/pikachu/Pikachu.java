package br.com.cefetmg.batalhapokemon.model.eletrico.pikachu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Pikachu extends Pichu {

    public Pikachu(String apelido) {
        super(apelido);
        this.especie = "Pikachu";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double)35.0F;
        this.vida = (double)35.0F;
        this.ataque = (double)55.0F;
        this.defesa = (double)40.0F;
        this.velocidade = (double)90.0F;
        this.itemEvolucaoStr = "Pedra do Trovão";
        this.adicionarAtaque(new Ataque("Thunderbolt", 90, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return new Raichu(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Pika Pika!");
    }



}
