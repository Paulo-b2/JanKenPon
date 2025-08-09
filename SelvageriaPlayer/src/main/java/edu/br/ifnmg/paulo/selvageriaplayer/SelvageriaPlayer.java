/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.br.ifnmg.paulo.selvageriaplayer;

import io.github.guisso.jankenpon.AbstractPlayer;
import io.github.guisso.jankenpon.Move;

/**
 *
 * @author Paulo Eduardo Nunes Ribeiro
 */
public class SelvageriaPlayer extends AbstractPlayer {

    public int contPedra = 0;
    public int contPapel = 0;
    public int contTesoura = 0;

    @Override
    public String getDeveloperName() {
        return "Paulo Ribeiro";
    }

    @Override
    public Move makeMyMove(Move opponentPreviousMove) {
        //Começo sempre jogando Pedra
        if (opponentPreviousMove == Move.NONE) {
            return Move.ROCK;
        }

        //<editor-fold defaultstate="collapsed" desc="JogadasPensadas">
        if (opponentPreviousMove == Move.PAPER && this.contPapel >= 2) {
            this.contPapel = 0;
            return Move.SCISSORS;
        }

        if (opponentPreviousMove == Move.ROCK && this.contPedra >= 2) {
            this.contPedra = 0;
            return Move.PAPER;
        }

        if (opponentPreviousMove == Move.SCISSORS && this.contTesoura >= 2) {
            this.contPapel = 0;
            return Move.ROCK;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="jogadasPadrao">
        //minha mão será a que perde para a mão anterior do meu adversário
        if (opponentPreviousMove == Move.PAPER) {
            this.contPapel++;
            this.contPedra = 0;
            this.contTesoura = 0;
            return Move.ROCK;
        }
        if (opponentPreviousMove == Move.ROCK) {
            this.contPedra++;
            this.contPapel = 0;
            this.contTesoura = 0;
            return Move.SCISSORS;
        }
        if (opponentPreviousMove == Move.SCISSORS) {
            this.contTesoura++;
            this.contPapel = 0;
            this.contPedra = 0;
            return Move.PAPER;
        }
        //</editor-fold>

        return Move.ROCK;
    }

}
