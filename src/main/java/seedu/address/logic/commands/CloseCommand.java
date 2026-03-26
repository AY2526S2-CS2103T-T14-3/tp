package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Saves interview notes to the currently open applicant and closes the interview session.
 */
public class CloseCommand extends Command {

    public static final String COMMAND_WORD = "close";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Saves interview notes to the currently open applicant.\n"
            + "Parameters: i/NOTES (use i/ with no text to clear notes)\n"
            + "Example: " + COMMAND_WORD + " i/Strong candidate. Score: 4/5.";

    public static final int MAX_INTERVIEW_LENGTH = 4000;

    private final String notes;

    /**
     * @param notes the interview notes to save; empty string clears existing notes
     */
    public CloseCommand(String notes) {
        this.notes = notes;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        // TODO: implement in a later iteration
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CloseCommand)) {
            return false;
        }
        CloseCommand otherCloseCommand = (CloseCommand) other;
        return notes.equals(otherCloseCommand.notes);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("notes", notes)
                .toString();
    }
}
