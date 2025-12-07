package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Luxray extends Luxio {

    public Luxray(String apelido) {
        super(apelido);
        this.especie = "Luxray";
        this.nivelEvolucao = 3;
        this.vidaMaxima = (double)80.0F;
        this.vida = (double)80.0F;
        this.ataque = (double)120.0F;
        this.defesa = (double)79.0F;
        this.velocidade = (double)70.0F;
        this.adicionarAtaque(new Ataque("Wild Charge", 90, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return this;
    }

    public void realizarSom() {
        System.out.println("LuuuxxRAAY!");
    }



}
