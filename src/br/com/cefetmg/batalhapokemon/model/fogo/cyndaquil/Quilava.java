package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Quilava extends Cyndaquil{

    public Quilava(String apelido) {
        super(apelido);
        this.especie = "Quilava";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double) 58.0F;
        this.vida = (double) 58.0F;
        this.ataque = (double) 64.0F;
        this.defesa = (double) 58.0F;
        this.velocidade = (double) 80.0F;
        this.adicionarAtaque(new Ataque("Flame Wheel", 60, Tipo.FOGO));
    }

    public Pokemon evoluir() {
        return new Typhlosion(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Quilava!");
    }

}
