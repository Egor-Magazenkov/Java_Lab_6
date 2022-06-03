package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.FindStudyGroupByVariable;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveByIdCommand extends AbstractCommand{
    private String name = "remove_by_id";
    private String description = "удалить элемент из коллекции по его id";

    public RemoveByIdCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String s, Scanner sc) throws CommandResultException {
        int ID;
        try {
            ID = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            throw new CommandResultException(1, "Ошибка ввода. Воспользуйтесь командой help.");
        }
        HashSet<StudyGroup> groups = this.control.getGroups();
        FindStudyGroupByVariable finder = new FindStudyGroupByVariable(groups);

        try{
            StudyGroup group = finder.find_by_id(ID);
            groups.remove(group);
            throw new CommandResultException(0, "Группа с Id=" + ID + " удалена");
        }
        catch(AbsenceResultException e){
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
