package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.FindMax_MinGroup;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveLowerCommand extends AbstractCommand{
    private String name = "remove_lower";
    private String description = "удалить из коллекции все элементы, меньшие, чем заданный";

    public RemoveLowerCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        FindMax_MinGroup finder = new FindMax_MinGroup(groups);
        int n = 0;
        try {
            for (StudyGroup group :
                    finder.find_all_min()) {
                groups.remove(group);
                n++;
            }
            throw new CommandResultException(0, "Удалены все (" + n + ") группы с наименьшим значением средней оценки.");
        }
        catch (AbsenceResultException e){
            throw new CommandResultException(1, e.getMessage());
        }

    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
