package revxrsal.commands.bukkit.exception;

public class EnglishBukkitExceptionAdapter extends BukkitExceptionAdapter {
    public EnglishBukkitExceptionAdapter() {
        super("You must be a player!", "You must be a console!", "Invalid player!", "Invalid world!", "Invalid selector!", "Selected more than 1 player!", "Selected entities are not allowed!");
    }
}
