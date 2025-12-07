package br.com.cefetmg.batalhapokemon.model.enums;

public enum Tipo {
    FOGO, AGUA, PLANTA, ELETRICO,TERRA, NORMAL;

    /**
     * Calcula o multiplicador de dano.
     * @param tipoAtaque O tipo do movimento usado (ex: Água).
     * @param tipoDefensor O tipo do Pokémon que recebe o ataque (ex: Fogo).
     * @return 2.0 (Super Efetivo), 0.5 (Não muito efetivo), 1.0 (Neutro) ou 0.0 (Imune).
     */
    public static double obterMultiplicador(Tipo tipoAtaque, Tipo tipoDefensor) {



        return switch (tipoAtaque) {


            case FOGO -> switch (tipoDefensor) {
                case PLANTA -> 2.0;
                case AGUA, FOGO -> 0.5;
                default -> 1.0;
            };


            case AGUA -> switch (tipoDefensor) {
                case FOGO,TERRA -> 2.0; //Água causa muito dano em terra
                case PLANTA, AGUA -> 0.5;
                default -> 1.0;
            };


            case PLANTA -> switch (tipoDefensor) {
                case AGUA,TERRA -> 2.0; //Planta causa muito dano em terra
                case FOGO, PLANTA -> 0.5;
                default -> 1.0;
            };


            case ELETRICO -> switch (tipoDefensor) {
                case AGUA -> 2.0;
                case PLANTA, ELETRICO -> 0.5;
                case TERRA -> 0.0;// Terra não sofre dano de elétrico
                default -> 1.0;
            };

            case TERRA -> switch (tipoDefensor){
                case ELETRICO -> 2.0;//Terra é forte contra elétrico
                case PLANTA -> 0.5;//Terra é fraco contra planta e água
                default -> 1.0;
            };

            case NORMAL -> switch (tipoDefensor){

                default -> 1.0;

            };

        };
    }
}