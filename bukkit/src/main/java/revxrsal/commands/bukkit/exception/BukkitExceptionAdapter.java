package revxrsal.commands.bukkit.exception;

import org.jetbrains.annotations.NotNull;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.DefaultExceptionHandler;

public class BukkitExceptionAdapter extends DefaultExceptionHandler {
    private final String mustBePlayer;
    private final String mustBeConsole;
    private final String invalidPlayer;
    private final String invalidWorld;
    private final String invalidSelector;
    private final String onlyOnePlayer;
    private final String nonPlayersNotAllowed;

    public static final BukkitExceptionAdapter INSTANCE = new BukkitExceptionAdapter("Musisz być graczem!", "Musisz być konsolą!", "Nieprawidłowy gracz!", "Nieprawidłowy świat!", "Nieprawidłowy selektor!", "Tylko jeden gracz!", "Nie-gracze nie dozwoleni!");

    public BukkitExceptionAdapter(String mustBePlayer, String mustBeConsole, String invalidPlayer, String invalidWorld, String invalidSelector, String onlyOnePlayer, String nonPlayersNotAllowed) {
        this.mustBePlayer = mustBePlayer;
        this.mustBeConsole = mustBeConsole;
        this.invalidPlayer = invalidPlayer;
        this.invalidWorld = invalidWorld;
        this.invalidSelector = invalidSelector;
        this.onlyOnePlayer = onlyOnePlayer;
        this.nonPlayersNotAllowed = nonPlayersNotAllowed;
    }

    public void senderNotPlayer(@NotNull CommandActor actor, @NotNull SenderNotPlayerException exception) {
        actor.error(mustBePlayer);
    }

    public void senderNotConsole(@NotNull CommandActor actor, @NotNull SenderNotConsoleException exception) {
        actor.error(mustBeConsole);
    }

    public void invalidPlayer(@NotNull CommandActor actor, @NotNull InvalidPlayerException exception) {
        actor.error(invalidPlayer);
    }

    public void invalidWorld(@NotNull CommandActor actor, @NotNull InvalidWorldException exception) {
        actor.error(invalidWorld);
    }

    public void malformedEntitySelector(@NotNull CommandActor actor, @NotNull MalformedEntitySelectorException exception) {
        actor.error(invalidSelector);
    }

    public void moreThanOnePlayer(@NotNull CommandActor actor, @NotNull MoreThanOnePlayerException exception) {
        actor.error(onlyOnePlayer);
    }

    public void nonPlayerEntities(@NotNull CommandActor actor, @NotNull NonPlayerEntitiesException exception) {
        actor.error(nonPlayersNotAllowed);
    }
}
