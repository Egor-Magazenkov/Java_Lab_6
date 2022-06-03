package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.SortCollection;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PrintDescendingCommand extends AbstractCommand{
    private String name = "print_descending";
    private String description = "вывод коллекции в порядке убывания";
    public PrintDescendingCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        try{
            SortCollection sorter = new SortCollection(groups);
            TreeSet<StudyGroup> sorted = sorter.sort_descending();
            control.getOos().writeObject(sorted.stream().map(StudyGroup::toString).collect(Collectors.joining("\n")));
            throw new CommandResultException(-1, "");
        }
        catch(AbsenceResultException e){
            throw new CommandResultException(1, e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
