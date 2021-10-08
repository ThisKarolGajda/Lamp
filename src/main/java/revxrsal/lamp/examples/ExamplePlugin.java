package revxrsal.lamp.examples;

import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;
import revxrsal.commands.exception.CommandErrorException;
import revxrsal.lamp.examples.tickets.Ticket;
import revxrsal.lamp.examples.tickets.TicketCommands;
import revxrsal.lamp.examples.tickets.TicketManager;

public final class ExamplePlugin extends JavaPlugin {

    private final TicketManager ticketManager = new TicketManager();

    @Override
    public void onEnable() {
        BukkitCommandHandler commandHandler = BukkitCommandHandler.create(this);

        // tickets
        commandHandler.registerDependency(TicketManager.class, ticketManager);
        commandHandler.registerValueResolver(Ticket.class, context -> {
            int id = context.popInt();
            Ticket ticket = ticketManager.getTicket(id);
            if (ticket == null) {
                throw new CommandErrorException("Invalid ticket: &e" + id);
            }
            return ticket;
        });
        commandHandler.register(new TicketCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
