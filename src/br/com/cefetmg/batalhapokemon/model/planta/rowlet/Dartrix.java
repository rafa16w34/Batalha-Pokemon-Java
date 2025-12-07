package br.com.cefetmg.batalhapokemon.model.planta.rowlet;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.agua.oshawott.Samurott;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Dartrix extends Rowlet{

    public Dartrix(String apelido) {
        super(apelido);
        this.especie = "Dartrix";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double)78.0F;
        this.vida = (double)78.0F;
        this.ataque = (double)75.0F;
        this.defesa = (double)75.0F;
        this.velocidade = (double)52.0F;
        this.adicionarAtaque(new Ataque("Razor Leaf", 55, Tipo.PLANTA));
    }

    public Pokemon evoluir() {
        return new Decidueye(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Daaarttrix!");
    }

}
