/*
 * This file is part of lamp, licensed under the MIT License.
 *
 *  Copysecond (c) Revxrsal <reflxction.github@gmail.com>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the seconds
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copysecond notice and this permission notice shall be included in all
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
package revxrsal.commands.exception;

import org.jetbrains.annotations.NotNull;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.command.ExecutableCommand;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Default implementation of {@link CommandExceptionHandler}, which sends basic messages
 * describing the exception.
 * <p>
 * See {@link CommandExceptionAdapter} for handling custom exceptions.
 */
public class DefaultExceptionHandler extends CommandExceptionAdapter {

    public static final DefaultExceptionHandler INSTANCE = new PolishDefaultExceptionHandler();
    public static final NumberFormat FORMAT = NumberFormat.getInstance();

    private final String missingArgument;
    private final String invalidEnum;
    private final String invalidNumber;
    private final String invalidUuid;
    private final String invalidUrl;
    private final String invalidBoolean;
    private final String noPermission;
    private final String invalidQuotedString;
    private final String errorOccurred;
    private final String tooManyArguments;
    private final String noSubcommandSpecified;
    private final String onCooldown;
    private final String numberNotInRange;
    private final String invalidCommand;
    private final String invalidSubcommand;
    private final String invalidHelpPage;

    public DefaultExceptionHandler(String missingArgument, String invalidEnum, String invalidNumber, String invalidUuid, String invalidUrl, String invalidBoolean, String noPermission, String invalidQuotedString, String errorOccurred, String tooManyArguments, String noSubcommandSpecified, String onCooldown, String numberNotInRange, String invalidCommand, String invalidSubcommand, String invalidHelpPage) {
        this.missingArgument = missingArgument;
        this.invalidEnum = invalidEnum;
        this.invalidNumber = invalidNumber;
        this.invalidUuid = invalidUuid;
        this.invalidUrl = invalidUrl;
        this.invalidBoolean = invalidBoolean;
        this.noPermission = noPermission;
        this.invalidQuotedString = invalidQuotedString;
        this.errorOccurred = errorOccurred;
        this.tooManyArguments = tooManyArguments;
        this.noSubcommandSpecified = noSubcommandSpecified;
        this.onCooldown = onCooldown;
        this.numberNotInRange = numberNotInRange;
        this.invalidCommand = invalidCommand;
        this.invalidSubcommand = invalidSubcommand;
        this.invalidHelpPage = invalidHelpPage;
    }

    public DefaultExceptionHandler(@NotNull DefaultExceptionHandler instance) {
        this(instance.missingArgument, instance.invalidEnum, instance.invalidNumber, instance.invalidUuid, instance.invalidUrl,
                instance.invalidBoolean, instance.noPermission, instance.invalidQuotedString, instance.errorOccurred,
                instance.tooManyArguments, instance.noSubcommandSpecified, instance.onCooldown, instance.numberNotInRange,
                instance.invalidCommand, instance.invalidSubcommand, instance.invalidHelpPage);
    }

    @Override
    public void missingArgument(@NotNull CommandActor actor, @NotNull MissingArgumentException exception) {
        actor.errorLocalizedMessage(missingArgument, exception.getParameter().getName());
    }

    @Override
    public void invalidEnumValue(@NotNull CommandActor actor, @NotNull EnumNotFoundException exception) {
        actor.errorLocalizedMessage(invalidEnum, exception.getParameter().getName(), exception.getInput());
    }

    @Override
    public void invalidNumber(@NotNull CommandActor actor, @NotNull InvalidNumberException exception) {
//        actor.error("Expected a number, but found '" + exception.getInput() + "'.");
        actor.errorLocalizedMessage(invalidNumber, exception.getInput());
    }

    @Override
    public void invalidUUID(@NotNull CommandActor actor, @NotNull InvalidUUIDException exception) {
        actor.errorLocalizedMessage(invalidUuid, exception.getInput());
    }

    @Override
    public void invalidURL(@NotNull CommandActor actor, @NotNull InvalidURLException exception) {
        actor.errorLocalizedMessage(invalidUrl, exception.getInput());
    }

    @Override
    public void invalidBoolean(@NotNull CommandActor actor, @NotNull InvalidBooleanException exception) {
        actor.errorLocalizedMessage(invalidBoolean, exception.getInput());
    }

    @Override
    public void noPermission(@NotNull CommandActor actor, @NotNull NoPermissionException exception) {
        actor.errorLocalizedMessage(noPermission);
    }

    @Override
    public void argumentParse(@NotNull CommandActor actor, @NotNull ArgumentParseException exception) {
        actor.errorLocalizedMessage(invalidQuotedString);
        actor.error(exception.getSourceString());
        actor.error(exception.getAnnotatedPosition());
    }

    @Override
    public void commandInvocation(@NotNull CommandActor actor, @NotNull CommandInvocationException exception) {
        actor.errorLocalizedMessage(errorOccurred);
        exception.getCause().printStackTrace();
    }

    @Override
    public void tooManyArguments(@NotNull CommandActor actor, @NotNull TooManyArgumentsException exception) {
        ExecutableCommand command = exception.getCommand();
        String usage = (command.getPath().toRealString() + " " + command.getUsage()).trim();
        actor.errorLocalizedMessage(tooManyArguments, usage);
    }

    @Override
    public void invalidCommand(@NotNull CommandActor actor, @NotNull InvalidCommandException exception) {
        actor.errorLocalizedMessage(invalidCommand, exception.getInput());
    }

    @Override
    public void invalidSubcommand(@NotNull CommandActor actor, @NotNull InvalidSubcommandException exception) {
        actor.errorLocalizedMessage(invalidSubcommand, exception.getInput());
    }

    @Override
    public void noSubcommandSpecified(@NotNull CommandActor actor, @NotNull NoSubcommandSpecifiedException exception) {
        actor.errorLocalizedMessage(noSubcommandSpecified);
    }

    @Override
    public void cooldown(@NotNull CommandActor actor, @NotNull CooldownException exception) {
        actor.errorLocalizedMessage(onCooldown, formatTimeFancy(exception.getTimeLeftMillis()));
    }

    @Override
    public void invalidHelpPage(@NotNull CommandActor actor, @NotNull InvalidHelpPageException exception) {
        actor.errorLocalizedMessage(invalidHelpPage, exception.getPage(), exception.getPageCount());
    }

    @Override
    public void sendableException(@NotNull CommandActor actor, @NotNull SendableException exception) {
        exception.sendTo(actor);
    }

    @Override
    public void numberNotInRange(@NotNull CommandActor actor, @NotNull NumberNotInRangeException exception) {
        actor.errorLocalizedMessage(numberNotInRange,
                exception.getParameter().getName(),
                FORMAT.format(exception.getMinimum()),
                FORMAT.format(exception.getMaximum()),
                FORMAT.format(exception.getInput())
        );
    }

    @Override
    public void onUnhandledException(@NotNull CommandActor actor, @NotNull Throwable throwable) {
        throwable.printStackTrace();
    }

    public static String formatTimeFancy(long time) {
        Duration d = Duration.ofMillis(time);
        long hours = d.toHours();
        long minutes = d.minusHours(hours).getSeconds() / 60;
        long seconds = d.minusMinutes(minutes).minusHours(hours).getSeconds();
        List<String> words = new ArrayList<>();
        if (hours != 0)
            words.add(hours + plural(hours, " hour"));
        if (minutes != 0)
            words.add(minutes + plural(minutes, " minute"));
        if (seconds != 0)
            words.add(seconds + plural(seconds, " second"));
        return toFancyString(words);
    }

    public static <T> String toFancyString(List<T> list) {
        StringJoiner builder = new StringJoiner(", ");
        if (list.isEmpty()) return "";
        if (list.size() == 1) return list.get(0).toString();
        for (int i = 0; i < list.size(); i++) {
            T el = list.get(i);
            if (i + 1 == list.size())
                return builder + " and " + el.toString();
            else
                builder.add(el.toString());
        }
        return builder.toString();
    }

    public static String plural(Number count, String thing) {
        if (count.intValue() == 1) return thing;
        if (thing.endsWith("y"))
            return thing.substring(0, thing.length() - 1) + "ies";
        return thing + "s";
    }
}
