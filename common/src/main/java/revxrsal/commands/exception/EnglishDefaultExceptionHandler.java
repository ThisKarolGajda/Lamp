package revxrsal.commands.exception;

public class EnglishDefaultExceptionHandler extends DefaultExceptionHandler {
    public EnglishDefaultExceptionHandler() {
        super("You must specify a value for the {0}!", "Invalid {0}: {1}", "Expected a number, but found \\''{0}\\''.", "Invalid UUID: {0}", "Invalid URL: {0}", "Expected true or false, but found \\''{0}\\''.", "You do not have permission to execute this command.", "Invalid quoted string", "An error occurred while executing this command.", "Too many arguments! Correct usage: /{0}", "You must specify a subcommand!", "You must wait {0} before using this command again.", "{0} must be between {1} and {2} (found {3})", "Invalid command: {0}.", "Invalid subcommand: {0}.", "Invalid help page: {0}. Must be between 1 and {1}.");
    }
}
