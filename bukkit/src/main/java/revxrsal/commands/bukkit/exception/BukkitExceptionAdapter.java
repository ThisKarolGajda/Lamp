package revxrsal.commands.bukkit.exception;

import org.jetbrains.annotations.NotNull;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.DefaultExceptionHandler;

public class BukkitExceptionAdapter extends DefaultExceptionHandler {

    public static final BukkitExceptionAdapter INSTANCE = new BukkitExceptionAdapter();

    public BukkitExceptionAdapter() {
        super();
    }

    public void senderNotPlayer(@NotNull CommandActor actor, @NotNull SenderNotPlayerException exception) {
        actor.errorLocalizedMessage("Musisz być graczem!");
    }

    public void senderNotConsole(@NotNull CommandActor actor, @NotNull SenderNotConsoleException exception) {
        actor.errorLocalizedMessage("Musisz być konsolą!");
    }

    public void invalidPlayer(@NotNull CommandActor actor, @NotNull InvalidPlayerException exception) {
        actor.errorLocalizedMessage("Nieprawidłowy gracz!", exception.getInput());
    }

    public void invalidWorld(@NotNull CommandActor actor, @NotNull InvalidWorldException exception) {
        actor.errorLocalizedMessage("Nieprawidłowy świat!", exception.getInput());
    }

    public void malformedEntitySelector(@NotNull CommandActor actor, @NotNull MalformedEntitySelectorException exception) {
        actor.errorLocalizedMessage("Nieprawidłowy selektor!", exception.getInput());
    }

    public void moreThanOnePlayer(@NotNull CommandActor actor, @NotNull MoreThanOnePlayerException exception) {
        actor.errorLocalizedMessage("Wybrano więcej niż jednego gracza!", exception.getInput());
    }

    public void nonPlayerEntities(@NotNull CommandActor actor, @NotNull NonPlayerEntitiesException exception) {
        actor.errorLocalizedMessage("Wybrane istoty są niedozwolone", exception.getInput());
    }
}
