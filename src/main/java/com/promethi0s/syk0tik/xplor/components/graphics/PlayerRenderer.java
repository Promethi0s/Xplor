package com.promethi0s.syk0tik.xplor.components.graphics;

import com.promethi0s.syk0tik.xplor.components.entities.Player;

public class PlayerRenderer {

    public static void render(Player player, Graphics graphics) {

        SpriteRenderer.render(player.getSprite(), player.loc.x - graphics.viewOffset.x, player.loc.y - graphics.viewOffset.y, graphics);

    }

}
