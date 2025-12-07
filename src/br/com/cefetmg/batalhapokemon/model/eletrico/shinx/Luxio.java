package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Luxio extends Shinx {

    public Luxio(String apelido) {
        super(apelido);
        this.especie = "Luxio";
        this.nivelEvolucao = 2;
        this.vidaMaxima = (double)60.0F;
        this.vida = (double)60.0F;
        this.ataque = (double)85.0F;
        this.defesa = (double)49.0F;
        this.velocidade = (double)60.0F;
        this.adicionarAtaque(new Ataque("Spark", 65, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return new Luxray(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Luuuxioo!");
    }



}
