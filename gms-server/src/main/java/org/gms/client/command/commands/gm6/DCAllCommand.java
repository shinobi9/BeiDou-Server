/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package org.gms.client.command.commands.gm6;

import org.gms.client.Character;
import org.gms.client.Client;
import org.gms.client.command.Command;
import org.gms.net.server.Server;
import org.gms.net.server.world.World;

public class DCAllCommand extends Command {
    {
        setDescription("Disconnect all players (online or logged in).");
    }

    @Override
    public void execute(Client c, String[] params) {
        Character player = c.getPlayer();
        for (World world : Server.getInstance().getWorlds()) {
            for (Character chr : world.getPlayerStorage().getAllCharacters()) {
                if (!chr.isGM()) {
                    chr.getClient().disconnect(false, false);
                }
            }
        }
        player.message("All players successfully disconnected.");
    }
}