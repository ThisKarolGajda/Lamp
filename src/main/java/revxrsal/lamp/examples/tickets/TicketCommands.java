/*
 * This file is part of lamp-examples, licensed under the MIT License.
 *
 *  Copyright (c) Revxrsal <reflxction.github@gmail.com>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package revxrsal.lamp.examples.tickets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.*;
import revxrsal.commands.bukkit.BukkitCommandActor;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.exception.CommandErrorException;

import java.util.concurrent.TimeUnit;

@Command("ticket")
public class TicketCommands {

    @Dependency
    private TicketManager ticketManager;

    @Subcommand("create")
    @Description("Creates a new ticket with the given description")
    @Cooldown(value = 10, unit = TimeUnit.MINUTES)
    public void createTicket(Player owner, String description) {
        if (description.length() < 10) {
            throw new CommandErrorException("Description too short!");
        }
        ticketManager.add(owner, description);
        owner.sendMessage(ChatColor.GREEN + "Ticket created successfully.");
    }

    @Subcommand({"view", "read"})
    @Description("Views the ticket")
    @CommandPermission("tickets.view")
    public void viewTicket(BukkitCommandActor admin, Ticket ticket) {
        admin.reply("&aTicket ID: &e" + ticket.getId());
        admin.reply("&aTicket owner: &e" + Bukkit.getOfflinePlayer(ticket.getOwner()).getName());
        admin.reply("&aTicket description: &e" + ticket.getDescription());
    }

    @Subcommand("close")
    @Usage("close <ticket> [-confirm]")
    @Description("Close the ticket")
    @CommandPermission("tickets.close")
    public void closeTicket(BukkitCommandActor admin, Ticket ticket, @Switch("confirm") boolean confirm) {
        if (confirm) {
            admin.reply("&aClosing ticket &e#" + ticket.getId() + "&a..");
        } else {
            admin.reply("&cAre you sure you want to close this ticket? Run &e/ticket close " + ticket.getId() + " -confirm &cto confirm.");
        }
    }

}
