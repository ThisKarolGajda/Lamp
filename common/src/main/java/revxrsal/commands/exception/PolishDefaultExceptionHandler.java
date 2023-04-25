package revxrsal.commands.exception;

public class PolishDefaultExceptionHandler extends DefaultExceptionHandler {
    public PolishDefaultExceptionHandler() {
        super("Musisz wybrać wartość dla {0}!", "Nieprawidłowe {0}: {1}.", "Oczekiwano liczbę, znaleziono \\''{0}\\''.", "Nieprawidłowe UUID: {0}", "Nieprawidłowy link: {0}", "Oczekiwano tak lub nie, znaleziono \\''{0}\\''.", "Nie masz pozwolenia do wykonania tego zadania.", "Nieprawidłowe oznaczenie.", "Wystapil nieoczekiwany błąd.", "Zbyt dużo argumentów! Oczekiwano: /{0}", "Brak wybranej subkomendy!", "Musisz poczekać {0} zanim użyjesz tej komendy ponownie.", "{0} musi być pomiędzy {1} i {2} (znaleziono {3})", "Nieprawidłowa komenda: {0}.", "Nieprawidłowa subkomenda: {0}.", "Nieprawidłowa strona pomocy: {0}. Musi byc pomiędzy 1 i {1}.");
    }
}
