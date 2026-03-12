package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTERVIEW;

import seedu.address.logic.commands.CloseCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new CloseCommand object.
 */
public class CloseCommandParser implements Parser<CloseCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CloseCommand
     * and returns a CloseCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CloseCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INTERVIEW);

        if (argMultimap.getValue(PREFIX_INTERVIEW).isEmpty()
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CloseCommand.MESSAGE_USAGE));
        }

        String notes = argMultimap.getValue(PREFIX_INTERVIEW).get();

        if (notes.length() > CloseCommand.MAX_INTERVIEW_LENGTH) {
            throw new ParseException(
                    String.format("Interview notes must not exceed %d characters.", CloseCommand.MAX_INTERVIEW_LENGTH));
        }

        return new CloseCommand(notes);
    }
}
