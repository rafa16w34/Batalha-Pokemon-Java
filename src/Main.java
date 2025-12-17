import br.com.cefetmg.batalhapokemon.infra.PokedexRegistry;
import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



        // 1. Inicializa e descobre Pokémons (apenas nível 1)
        PokedexRegistry.inicializar("br.com.cefetmg.batalhapokemon.model");
        List<String> especies = PokedexRegistry.getEspeciesDisponiveis();

        if (especies.isEmpty()) {
            System.err.println("Nenhum Pokémon encontrado no pacote. Verifique as classes.");
            return;
        }

        System.out.println("=== BATTLE POKÉMON JAVA 21 ===");

        // 2. Escolha do Jogador
        System.out.println("Escolha seu parceiro:");
        for (int i = 0; i < especies.size(); i++) {
            System.out.println((i + 1) + ". " + especies.get(i));
        }

        int escolha;

        // loop até receber um número válido
        while (true) {
            System.out.print("Digite o número do Pokémon: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // consumir quebra de linha

                // validar intervalo
                if (escolha >= 1 && escolha <= especies.size()) {
                    break; // ok! sai do while
                } else {
                    System.out.println("Número inválido! Escolha entre 1 e " + especies.size() + ".");
                }

            } else {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.nextLine(); // descartar entrada errada
            }
        }

        String especieJog = especies.get(escolha - 1);

        System.out.print("Dê um apelido para ele: ");
        String apelidoJog = scanner.nextLine();

        Pokemon player = PokedexRegistry.criar(especieJog, apelidoJog);

        // --- 3. Escolha do Computador (LÓGICA ALTERADA) ---

        // Criamos uma lista de opções para o Bot, copiando a lista original
        List<String> opcoesBot = new ArrayList<>(especies);

        // Removemos a espécie que o jogador escolheu
        opcoesBot.remove(especieJog);

        String especieBot;

        // Verificação de segurança: Se só existe 1 tipo de pokémon no sistema (ex: Só criou Charmander),
        // o Bot é obrigado a jogar com ele também, senão a lista fica vazia e dá erro.
        if (opcoesBot.isEmpty()) {
            System.out.println("⚠️ Aviso: Apenas uma espécie registrada no sistema. O Rival usará a mesma espécie.");
            especieBot = especieJog;
        } else {
            // Sorteia da lista filtrada
            especieBot = opcoesBot.get(random.nextInt(opcoesBot.size()));
        }

        Pokemon bot = PokedexRegistry.criar(especieBot, "Rival " + especieBot);

        System.out.println("\n-------------------------------------------");
        System.out.println("BATALHA INICIADA: " + player.getApelido() + " VS " + bot.getApelido());
        System.out.println("-------------------------------------------");

        // 4. Definição de quem começa (Velocidade)
        boolean turnoPlayer = player.getVelocidade() >= bot.getVelocidade();
        if (player.getVelocidade() == bot.getVelocidade()) turnoPlayer = random.nextBoolean(); // Desempate aleatório

        // LOOP DE BATALHA
        while (player.estaVivo() && bot.estaVivo()) {
            System.out.println("\n>>> Status Atual <<<");
            System.out.printf("👤 %s (%s): %.0f/%.0f VIDA | %d Poções\n", player.getApelido(), player.getEspecie(), player.getVida(), player.getVidaMaxima(), player.getPocoes());
            System.out.printf("🤖 %s (%s): %.0f/%.0f VIDA | %d Poções\n", bot.getApelido(), bot.getEspecie(), bot.getVida(), bot.getVidaMaxima(), bot.getPocoes());
            System.out.println("-------------------------------------------");


            realizarTurnoJogador(scanner, player,bot);


            realizarTurnoBot(bot, player);


            if (player.getAtacar()){

                selecionarAtaque(scanner,player,bot);

            } else if (player.getCurar()) {

                player.usarPocao();

            }

            if (bot.estaVivo()) {

                try { Thread.sleep(1500); } catch (InterruptedException e) {} // Pausa dramática
                System.out.println("\n------------------------------------------------------------\n");

                if (bot.getAtacar()) {

                    List<Ataque> ataques = bot.getAtaques();
                    Ataque ataqueEscolhido = ataques.get(new Random().nextInt(ataques.size()));
                    bot.atacar(bot, player, ataqueEscolhido);

                }else if (bot.getCurar()) {

                    bot.usarPocao();

                }
            }

            // Checagem de morte antes da evolução
            if (!bot.estaVivo() || !player.estaVivo()) break;

            // Checagem de Evolução Automática
            // ATENÇÃO: Se evoluir, a variável player/bot passa a apontar para o novo objeto
            player = player.tentarEvoluir();
            bot = bot.tentarEvoluir();










        }

        // Fim de jogo
        System.out.println("\n===========================================");
        if (player.estaVivo()) {
            System.out.println("🏆 VITÓRIA! \n" + player.getApelido() + " venceu a batalha!");
            player.realizarSom();
        } else {
            System.out.println("💀 DERROTA... " + player.getApelido() + " desmaiou.");
        }
        System.out.println("===========================================");
    }

    private static void realizarTurnoJogador(Scanner scanner, Pokemon atacante, Pokemon oponente) {

        atacante.setDesviar(false);
        atacante.setCurar(false);
        atacante.setAtacar(false);
        boolean podeMegaEvoluir = atacante.getMegaEvolucao();
        boolean podeEvoluir = atacante.getItemEvolucao();

        System.out.println("\n SUA VEZ! O que deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Curar (Custo: 1 Poção)");
        System.out.println("3. Evasiva!");

        if (podeMegaEvoluir && podeEvoluir){

            System.out.println("4. Mega Evoluir!");

        }

        int acao = 0;

        while (true) {
            System.out.print("Escolha umas das opções acima: ");
            String input = scanner.nextLine();

            // Verificar se é número
            try {
                acao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números de 1 a 3.");
                continue; // volta pro início do while
            }

            // Verificar faixa permitida
            if(!podeMegaEvoluir) {
                if (acao < 1 || acao > 3) {
                    System.out.println("Opção inválida! Digite apenas 1, 2 ou 3.");
                    continue;
                }
            }else{
                if (acao < 1 || acao > 4) {
                    System.out.println("Opção inválida! Digite apenas 1, 2 ou 3.");
                    continue;
                }
            }

            break; // saiu porque agora a entrada está válida
        }


        if (acao == 3){

            int n = (int) (Math.random() * 2) + 1;

            if (atacante.getVelocidade() > oponente.getVelocidade()) {

                atacante.setDesviar(true);

            }else if (n == 1){

                atacante.setDesviar(true);

            }else{

                System.out.println("\n"+atacante.getApelido()+ " tentou desviar mas falhou! \n");

            }

        }else if (acao == 2) {

            if (atacante.getPocoes() > 0) {
                atacante.setCurar(true);
            }else{
                System.out.println("ERRO: Poções insuficientes!");
                realizarTurnoJogador(scanner,atacante,oponente);
            }

        } else if (acao == 4){//Megaevolui o pokemon

            atacante.megaEvoluir();

        } else {

            atacante.setAtacar(true);
        }
    }

    private static void selecionarAtaque(Scanner scanner, Pokemon atacante, Pokemon alvo) {
        System.out.println("Escolha o ataque:");
        List<Ataque> ataques = atacante.getAtaques();
        for (int i = 0; i < ataques.size(); i++) {
            System.out.println((i + 1) + ". " + ataques.get(i).nome() + " (Poder: " + ataques.get(i).poder() + " | Tipo: " + ataques.get(i).tipo() + ")");
        }

        int index = 0;

        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {}

        if (index < 0 || index >= ataques.size()) index = 0; // Default attack

        atacante.atacar(atacante,alvo, ataques.get(index));
    }

    private static void realizarTurnoBot(Pokemon atacante, Pokemon alvo) {

        atacante.setDesviar(false);
        atacante.setCurar(false);
        atacante.setAtacar(false);
        boolean podeMegaEvoluir = atacante.getMegaEvolucao();
        boolean podeEvoluir = atacante.getItemEvolucao();


        if (podeMegaEvoluir && podeEvoluir){

            atacante.megaEvoluir();
            boolean botMegaEvoluido = true;

        }

        // IA Simples: Se vida < 30% e tem poção, cura. Senão, ataca aleatoriamente.
        if (atacante.getVida() < (atacante.getVidaMaxima() * 0.3) && atacante.getPocoes() > 0) {
            atacante.setCurar(true);
        } else {

            int n = (int) (Math.random() * 2) + 1;

            if (n == 1) {

                atacante.setAtacar(true);

            } else{

                int d = (int) (Math.random() * 2) + 1;

                if (atacante.getVelocidade() > alvo.getVelocidade()) {

                    atacante.setDesviar(true);

                }else if (d == 1){

                    atacante.setDesviar(true);

                }else{

                    System.out.println("\n"+atacante.getApelido()+ " tentou desviar mas falhou! \n");

                }

            }
        }
    }
}