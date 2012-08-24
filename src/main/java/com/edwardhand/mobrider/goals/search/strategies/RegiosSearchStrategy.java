package com.edwardhand.mobrider.goals.search.strategies;

import com.edwardhand.mobrider.ConfigManager;
import com.edwardhand.mobrider.commons.DependencyUtils;
import com.edwardhand.mobrider.goals.RegiosGoal;
import com.edwardhand.mobrider.rider.Rider;

import couk.Adamki11s.Regios.Regions.Region;

public class RegiosSearchStrategy extends LocationSearchStrategy
{
    public RegiosSearchStrategy(ConfigManager configManager)
    {
        super(configManager);
    }

    @Override
    public boolean find(Rider rider, String regionName)
    {
        boolean foundRegion = false;

        if (DependencyUtils.hasRegios()) {
            Region region = DependencyUtils.getRegiosAPI().getRegion(regionName);
            if (region != null && region.getWorld().equals(rider.getWorld())) {
                rider.setGoal(new RegiosGoal(configManager, region, rider.getWorld()));
                foundRegion = true;
            }
        }

        return foundRegion;
    }
}