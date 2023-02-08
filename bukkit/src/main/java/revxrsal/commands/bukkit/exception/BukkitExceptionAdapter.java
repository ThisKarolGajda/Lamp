package revxrsal.commands.bukkit.exception;

import org.jetbrains.annotations.NotNull;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.DefaultExceptionHandler;

public class BukkitExceptionAdapter extends DefaultExceptionHandler {

    public static final BukkitExceptionAdapter INSTANCE = new BukkitExceptionAdapter();

    public BukkitExceptionAdapter() {
        super("Musisz wybrac wartosc dla {0}!", "Nieprawidlowe {0}: {1}.", "Oczekiwano liczbe, znaleziono \\''{0}\\''.", "Nieprawidlowe UUID: {0}", "Nieprawidlowy link: {0}", "Oczekiwano tak lub nie, znaleziono \\''{0}\\''.", "Nie masz pozwolenia do wykonania tego zadania.", "Nieprawidlowe oznaczenie.", "Wystapil nieoczekiwany blad.", "Zbyt duzo argumentow! Oczekiwano: /{0}", "Brak wybranej subkomendy!", "Musisz poczekac {0} zanim uzyjesz tej komendy ponownie.", "{0} musi byc pomiedzy {1} i {2} (znaleziono {3})", "Nieprawidlowa komenda: {0}.", "Nieprawidlowa subkomenda: {0}.", "Nieprawidlowa strona pomocy: {0}. Musi byc pomiedzy 1 i {1}.");
    }

    public void senderNotPlayer(@NotNull CommandActor actor, @NotNull SenderNotPlayerException exception) {
        actor.errorLocalizedMessage("must-be-player");
    }

    public void senderNotConsole(@NotNull CommandActor actor, @NotNull SenderNotConsoleException exception) {
        actor.errorLocalizedMessage("must-be-console");
    }

    public void invalidPlayer(@NotNull CommandActor actor, @NotNull InvalidPlayerException exception) {
        actor.errorLocalizedMessage("invalid-player", exception.getInput());
    }

    public void invalidWorld(@NotNull CommandActor actor, @NotNull InvalidWorldException exception) {
        actor.errorLocalizedMessage("invalid-world", exception.getInput());
    }

    public void malformedEntitySelector(@NotNull CommandActor actor, @NotNull MalformedEntitySelectorException exception) {
        actor.errorLocalizedMessage("invalid-selector", exception.getInput());
    }

    public void moreThanOnePlayer(@NotNull CommandActor actor, @NotNull MoreThanOnePlayerException exception) {
        actor.errorLocalizedMessage("only-one-player", exception.getInput());
    }

    public void nonPlayerEntities(@NotNull CommandActor actor, @NotNull NonPlayerEntitiesException exception) {
        actor.errorLocalizedMessage("non-players-not-allowed", exception.getInput());
    }
}
