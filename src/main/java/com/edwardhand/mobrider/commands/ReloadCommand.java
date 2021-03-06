/*
 * This file is part of MobRider.
 *
 * Copyright (c) 2011-2013, R. Ramos <http://github.com/mung3r/>
 * MobRider is licensed under the GNU Lesser General Public License.
 *
 * MobRider is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MobRider is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.edwardhand.mobrider.commands;

import org.bukkit.command.CommandSender;

import com.edwardhand.mobrider.MobRider;

public class ReloadCommand extends BasicCommand
{
    private MobRider plugin;

    public ReloadCommand(MobRider plugin)
    {
        super("Reload");
        this.plugin = plugin;
        setDescription("Reload configuration");
        setUsage("/mob reload");
        setArgumentRange(0, 0);
        setIdentifiers("reload");
        setPermission("mobrider.admin.reload");
    }

    @Override
    public boolean execute(CommandSender sender, String identifier, String[] args)
    {
        plugin.reloadConfig();
        sender.sendMessage("MobRider config reloaded.");
        return true;
    }
}
