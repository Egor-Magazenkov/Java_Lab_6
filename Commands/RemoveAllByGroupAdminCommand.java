package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.FindStudyGroupByVariable;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveAllByGroupAdminCommand extends AbstractCommand{
    private String name = "remove_all_by_group_admin";
    private String description = "удалить из коллекции все элементы, значение поля groupAdmin которого эквивалентно заданному";

    public RemoveAllByGroupAdminCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String name, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        FindStudyGroupByVariable finder = new FindStudyGroupByVariable(groups);

        try{
            HashSet<StudyGroup> group_to_remove = finder.find_by_admin_name(name);
            int n = 0;
            for (StudyGroup group :
                    group_to_remove) {
                groups.remove(group);
                n++;
            }
            throw new CommandResultException(0, "Удалены все ("+ n +") группы, управляемые админом с именем "+name);
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
