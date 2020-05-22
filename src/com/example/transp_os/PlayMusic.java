package com.example.transp_os;

import org.jfugue.player.Player;

public class PlayMusic {
    public void playScale(int current_transpose_value) {
        if (current_transpose_value == 0) {
            Player player = new Player();
            player.play("C D E F G A B");
        }
    }

}
