package com.edwardhand.mobrider.goals;

import org.bukkit.entity.LivingEntity;

import com.edwardhand.mobrider.MobRider;
import com.edwardhand.mobrider.models.Rider;

public class GotoGoal extends LocationGoal
{
    protected LivingEntity target;

    public GotoGoal(MobRider plugin, LivingEntity target)
    {
        super(plugin, target.getLocation());
        this.target = target;
    }

    @Override
    public void executeUpdate(Rider rider)
    {
        if (rider != null) {
            rider.setTarget(null);
            LivingEntity ride = rider.getRide();

            if (target == null) {
                goalManager.setStopGoal(rider);
            }
            else {
                if (target.isDead()) {
                    target = null;
                    goalManager.setStopGoal(rider);
                }
                else {
                    if (goalManager.isGoalWithinRange(ride.getLocation(), target.getLocation(), rangeSquared)) {
                        goalManager.setStopGoal(rider);
                    }
                    else {
                        goalManager.setPathEntity(rider, target.getLocation());
                        goalManager.updateSpeed(rider);
                    }
                }
            }
        }
    }
}