package br.com.cefetmg.batalhapokemon.model;

import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
    // Atributos fixos
    private String apelido;
    protected String especie;
    protected Tipo tipo;
    protected int nivelEvolucao;

    // Status dinâmicos
    protected double vida;
    protected double vidaMaxima;
    protected double ataque;
    protected double defesa;
    protected double velocidade;
    protected String itemEvolucaoStr;//Vem com o nome do item que o pokémon precisa para evoluir
    protected boolean desviar;
    protected boolean atacar;
    protected boolean curar;
    protected boolean megaevolucao; //Verifica se o pokemon pode megaevoluir



    protected int experiencia = 0;
    protected int pocoes = 0;
    protected boolean itemEvolucao = false; //para graveler,growlithe e piakchu evoluírem
    protected int contadorAtaquesBemSucedidos = 0;

    private List<Ataque> ataques = new ArrayList<>();

    //construtor com o item de evolucao, pois nao e todo pokemon que precisa de item
    public Pokemon(String apelido, String especie, Tipo tipo, int nivelEvolucao, double vidaMaxima, double ataque, double defesa, double velocidade,String itemEvolucaoStr) {
        this.apelido = apelido;
        this.especie = especie;
        this.tipo = tipo;
        this.nivelEvolucao = nivelEvolucao;
        this.vidaMaxima = vidaMaxima +50;
        this.vida = vidaMaxima + 50;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.itemEvolucaoStr = itemEvolucaoStr;
        this.desviar = false;
    }

    public Pokemon(String apelido, String especie, Tipo tipo, int nivelEvolucao, double vidaMaxima, double ataque, double defesa, double velocidade) {
        this.apelido = apelido;
        this.especie = especie;
        this.tipo = tipo;
        this.nivelEvolucao = nivelEvolucao;
        this.vidaMaxima = vidaMaxima +20;
        this.vida = vidaMaxima + 20;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.desviar = false;

    }

    // --- Lógica de Batalha ---

    public void atacar(Pokemon atacante,Pokemon oponente, Ataque golpe) {

        Tipo tipoGolpe = golpe.tipo();//Definido antes para que, caso seja o Arceus, seja possível alterar depois

        if (atacante.especie.equals("Arceus")) {

            if (golpe.nome().equals("Judgment")){

                double multiplicadorAtual = Tipo.obterMultiplicador(tipoGolpe, oponente.getTipo());

                if (multiplicadorAtual < 2.0) {

                    tipoGolpe = atacante.trocarTipo(atacante,oponente,golpe);

                }
            }
        }

        System.out.printf("⚔️ %s usou %s!%n", this.apelido, golpe.nome());

        if (!oponente.getDesviar()) {

            double multiplicador = Tipo.obterMultiplicador(tipoGolpe, oponente.getTipo());

            // Feedback visual e Cálculo de XP
            int xpGanho = 15; // XP Neutro padrão
            if (multiplicador > 1.0) {
                System.out.println("🔥 Foi super efetivo!");
                xpGanho = 20;
            } else if (multiplicador < 1.0 && multiplicador > 0) {
                System.out.println("🛡️ Não foi muito efetivo...");
                xpGanho = 10;
            } else {
                System.out.println("😐 Dano normal.");
            }

            // Dano: (Atk * Poder / 20) - (Def / 3) * Multiplicador
            double danoBase = ((   atacante.ataque + (double) golpe.poder()) - oponente.getDefesa());
            double danoReal = Math.max(1, (danoBase * multiplicador) / 5);

            oponente.receberDano(danoReal);


            // Lógica de Recompensa (Poção e XP)
            this.contadorAtaquesBemSucedidos++;
            if (this.contadorAtaquesBemSucedidos % 2 == 0) {

                this.pocoes++;
                System.out.println("💊 " + this.apelido + " ganhou uma Poção de Cura por bons ataques!");

                if (!itemEvolucao){
                if (this.especie.equals("Pikachu") || this.especie.equals("Graveler") || this.especie.equals("Growlithe") || this.especie.equals("Raichu") || this.especie.equals("Gyarados")) {

                    if (!megaevolucao) {
                        System.out.println(this.apelido + " encontrou um(a) " + this.itemEvolucaoStr + ". Agora ele pode evoluir!");
                        itemEvolucao = true;
                    }else{
                        System.out.println(this.apelido + " encontrou um(a) " + this.itemEvolucaoStr + ". Agora ele pode Mega Evoluir!");
                        itemEvolucao = true;
                    }


                }
                }


            }

            ganharExperiencia(xpGanho);
        }else{

            System.out.println(oponente.getApelido() + " desviou do ataque!");

        }
    }



    public void receberDano(double dano) {

        if (!getDesviar()) {

            this.vida -= dano;
            System.out.printf("💥 %s recebeu %.1f de dano. (VIDA: %.1f/%.1f)%n", this.apelido, dano, Math.max(0, this.vida), this.vidaMaxima);

        }else{

            System.out.println(this.apelido + " desviou do ataque!");

        }

    }

    public boolean usarPocao() {
        if (this.pocoes > 0) {
            this.pocoes--;
            double cura = 20.0;
            this.vida += cura;
            if (this.vida > this.vidaMaxima) this.vida = this.vidaMaxima;
            System.out.printf("✨ %s usou uma poção! Recuperou %.1f VIDA. (Restam %d poções)%n", this.apelido, cura, this.pocoes);
            return true;
        } else {
            System.out.println("❌ Você não tem poções!");
            return false;
        }
    }

    //Evasiva:

    public void evasiva(Pokemon oponente){



    }

    //Só funciona para o Arceus
    public Tipo trocarTipo(Pokemon atacante,Pokemon oponente, Ataque golpe ) {



        Tipo tipoOponente = oponente.tipo;
        Tipo tipoGolpe = golpe.tipo();

        if (tipoOponente.equals(Tipo.AGUA)) {

            tipoGolpe = Tipo.ELETRICO;


        } else if (tipoOponente.equals(Tipo.FOGO)) {

            tipoGolpe = Tipo.AGUA;

        } else if (tipoOponente.equals(Tipo.PLANTA)) {

            tipoGolpe = Tipo.FOGO;

        } else if (tipoOponente.equals(Tipo.ELETRICO)) {

            tipoGolpe = Tipo.TERRA;

        } else if (tipoOponente.equals(Tipo.TERRA)) {

            tipoGolpe = Tipo.PLANTA;

        }


        if (!atacante.tipo.equals(tipoGolpe)) {
            System.out.println("\n" + this.getApelido() + " mudou de tipo usando suas placas!");
            System.out.println(atacante.getApelido() + " agora é do tipo " + tipoGolpe + "!\n");
        }

        setTipo(tipoGolpe);

        return tipoGolpe;
    }


    // --- Lógica de Evolução ---

    private void ganharExperiencia(int xp) {
        this.experiencia += xp;
        System.out.printf("🎓 %s ganhou %d XP. (Total: %d/100)%n", this.apelido, xp, this.experiencia);
    }

    /**
     * Verifica se deve evoluir. Se sim, retorna a NOVA instância.
     * Se não, retorna 'this' (a própria instância atual).
     */
    public Pokemon tentarEvoluir() {

        if (!this.especie.equals("Pikachu") && !this.especie.equals("Graveler") && !this.especie.equals("Growlithe") && !this.especie.equals("Arceus") && !this.especie.equals("Carnivine")) {


            if (this.experiencia >= 100 && this.nivelEvolucao < 3) {
                System.out.println("\n✨✨ O QUE? " + this.apelido + " ESTÁ EVOLUINDO! ✨✨");
                Pokemon evoluido = evoluir(); // Método abstrato implementado pelos filhos

                // Transfere o estado importante
                evoluido.pocoes = this.pocoes;
                // Reseta XP ou transfere excedente (opcional, aqui reseta para o novo nível)
                evoluido.experiencia = 0;

                // Mantém a porcentagem de vida atual ou cura? Vamos curar na evolução (bônus)
                System.out.println("🎉 " + this.apelido + " se tornou um " + evoluido.especie + "!\n");
                return evoluido;
            }
        }

        if (this.experiencia >= 100 && this.nivelEvolucao < 3 && this.itemEvolucao && !this.especie.equals("Arceus") && !this.especie.equals("Carnivine")) {
            System.out.println("\n✨✨ O QUE? " + this.apelido + " ESTÁ EVOLUINDO! ✨✨");
            Pokemon evoluido = evoluir(); // Método abstrato implementado pelos filhos

            // Transfere o estado importante
            evoluido.pocoes = this.pocoes;
            // Reseta XP ou transfere excedente (opcional, aqui reseta para o novo nível)
            evoluido.experiencia = 0;

            // Mantém a porcentagem de vida atual ou cura? Vamos curar na evolução (bônus)
            System.out.println("🎉 " + this.apelido + " se tornou um " + evoluido.especie + "!\n");
            this.itemEvolucao = false;
            return evoluido;
        }


        return this;
    }

    public void megaEvoluir(){

        if (megaevolucao && this.itemEvolucao){

            System.out.println("\n✨✨ " + this.apelido + " está reagindo a "+ this.itemEvolucaoStr + "! ✨✨");

            this.vida = this.vida *5;
            this.vidaMaxima = this.vidaMaxima *5;
            this.ataque = this.ataque *5;
            this.defesa = this.defesa *5;
            this.velocidade = this.velocidade *5;

            // Mantém a porcentagem de vida atual ou cura? Vamos curar na evolução (bônus)
            System.out.println("🎉 " + this.apelido + " se tornou um  Mega " + this.especie + "!\n");

            this.megaevolucao = false;

        }



    }

    // Métodos abstratos e auxiliares
    public abstract Pokemon evoluir();
    public abstract void realizarSom();

    public void adicionarAtaque(Ataque a) { ataques.add(a); }

    // Getters
    public boolean estaVivo() { return vida > 0; }
    public double getVelocidade() { return velocidade; }
    public String getApelido() { return apelido; }
    public String getEspecie() { return especie; }
    public List<Ataque> getAtaques() { return ataques; }
    public double getDefesa() { return defesa; }
    public Tipo getTipo() { return tipo; }
    public int getNivelEvolucao() { return nivelEvolucao; }
    public int getPocoes() { return pocoes; }
    public double getVida() { return vida; }
    public double getVidaMaxima() {
        return this.vidaMaxima;
    }
    public boolean getDesviar(){//Getter de desviar
        return this.desviar;
    }
    public boolean getAtacar(){//Getter de desviar
        return this.atacar;
    }
    public boolean getCurar(){//Getter de desviar
        return this.curar;
    }
    public boolean getMegaEvolucao(){//Getter de desviar
        return this.megaevolucao;
    }
    public boolean getItemEvolucao(){//Getter de desviar
        return this.itemEvolucao;
    }


    //Setters
    public void setDesviar(boolean status){this.desviar = status;}
    public void setAtacar(boolean status){this.atacar = status;}
    public void setCurar(boolean status){this.curar = status;}
    public void setTipo(Tipo tipoNovo){this.tipo = tipoNovo;}


    // Construtor protegido para cópia de dados na evolução
    protected void copiarDados(Pokemon antigo) {
        this.pocoes = antigo.pocoes;
        // Vida enche na evolução
    }

    @Override
    public String toString() {
        return "Pokemon: " + apelido + " (" + especie + ") | VIDA: " + vida + "/" + vidaMaxima;
    }

}