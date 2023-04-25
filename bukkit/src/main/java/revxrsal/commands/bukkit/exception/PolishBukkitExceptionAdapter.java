package revxrsal.commands.bukkit.exception;

public class PolishBukkitExceptionAdapter extends BukkitExceptionAdapter {

    public PolishBukkitExceptionAdapter() {
        super("Musisz być graczem!", "Musisz być konsolą!", "Nieprawidłowy gracz!", "Nieprawidłowy świat!", "Nieprawidłowy selektor!", "Wybrano więcej niż jednego gracza!", "Wybrane istoty są niedozwolone!");
    }
}
