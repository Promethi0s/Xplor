package com.promethi0s.syk0tik.xplor.components.gameData.objects.mapObjects;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CollisionBehavior;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.CombatProjectile;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.PositionLayer1Mobile;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectBehaviors.UpdateProjectile;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Damage;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.objectInfrastructure.Projectile;
import com.promethi0s.syk0tik.xplor.components.gameData.positioning.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Fireball extends MapObject implements Projectile {

    public Fireball(Coordinates spawnPoint, int faceDir, Damage damage) {

        setBehaviors(new CollisionBehavior(), new PositionLayer1Mobile(this, spawnPoint, faceDir, 3, Sprite.fireball), new UpdateProjectile(this), new CombatProjectile(damage));

    }

}
