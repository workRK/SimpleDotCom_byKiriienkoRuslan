package org.kiriienko;

import org.kiriienko.game.DotComBust;

public class App
{
    public static void main( String[] args ) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
