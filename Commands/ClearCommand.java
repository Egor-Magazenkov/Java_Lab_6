package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.util.HashSet;
import java.util.Scanner;


public class ClearCommand extends AbstractCommand{
    private String name = "clear";
    private String description = "очистить коллекцию";

    public ClearCommand(Control control) {
        super(control);
    }


    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        groups.clear();
        throw new CommandResultException(0, "Все элементы коллекции были удалены.");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
