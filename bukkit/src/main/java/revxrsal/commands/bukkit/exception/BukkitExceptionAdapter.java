package revxrsal.commands.bukkit.exception;

import org.jetbrains.annotations.NotNull;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.DefaultExceptionHandler;

public class BukkitExceptionAdapter extends DefaultExceptionHandler {

    public static final BukkitExceptionAdapter INSTANCE;

    static {
        INSTANCE = new PolishBukkitExceptionAdapter();
    }

    private final String mustBePlayer;
    private final String mustBeConsole;
    private final String invalidPlayer;
    private final String invalidWorld;
    private final String invalidSelector;
    private final String selectedMoreThanOnePlayer;
    private final String selectedEntitiesAreNotAllowed;


    public BukkitExceptionAdapter(String mustBePlayer, String mustBeConsole, String invalidPlayer, String invalidWorld, String invalidSelector, String selectedMoreThanOnePlayer, String selectedEntitiesAreNotAllowed) {
        super();
        this.mustBePlayer = mustBePlayer;
        this.mustBeConsole = mustBeConsole;
        this.invalidPlayer = invalidPlayer;
        this.invalidWorld = invalidWorld;
        this.invalidSelector = invalidSelector;
        this.selectedMoreThanOnePlayer = selectedMoreThanOnePlayer;
        this.selectedEntitiesAreNotAllowed = selectedEntitiesAreNotAllowed;
    }

    public void senderNotPlayer(@NotNull CommandActor actor, @NotNull SenderNotPlayerException exception) {
        actor.errorLocalizedMessage(mustBePlayer);
    }

    public void senderNotConsole(@NotNull CommandActor actor, @NotNull SenderNotConsoleException exception) {
        actor.errorLocalizedMessage(mustBeConsole);
    }

    public void invalidPlayer(@NotNull CommandActor actor, @NotNull InvalidPlayerException exception) {
        actor.errorLocalizedMessage(invalidPlayer, exception.getInput());
    }

    public void invalidWorld(@NotNull CommandActor actor, @NotNull InvalidWorldException exception) {
        actor.errorLocalizedMessage(invalidWorld, exception.getInput());
    }

    public void malformedEntitySelector(@NotNull CommandActor actor, @NotNull MalformedEntitySelectorException exception) {
        actor.errorLocalizedMessage(invalidSelector, exception.getInput());
    }

    public void moreThanOnePlayer(@NotNull CommandActor actor, @NotNull MoreThanOnePlayerException exception) {
        actor.errorLocalizedMessage(selectedMoreThanOnePlayer, exception.getInput());
    }

    public void nonPlayerEntities(@NotNull CommandActor actor, @NotNull NonPlayerEntitiesException exception) {
        actor.errorLocalizedMessage(selectedEntitiesAreNotAllowed, exception.getInput());
    }
}
