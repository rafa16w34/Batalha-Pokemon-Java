package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Shinx extends Pokemon {

    public Shinx(String apelido) {
        super(apelido, "Shinx", Tipo.ELETRICO, 1, (double)45.0F, (double)65.0F, (double)34.0F, (double)45.0F);
        this.adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        this.adicionarAtaque(new Ataque("Thunder Shock", 40, Tipo.ELETRICO));
    }

    public Pokemon evoluir() {
        return new Luxio(this.getApelido());
    }

    public void realizarSom() {
        System.out.println("Shiiinx !");
    }



}
