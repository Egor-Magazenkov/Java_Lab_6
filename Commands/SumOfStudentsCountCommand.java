package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class SumOfStudentsCountCommand extends AbstractCommand{
    private String name = "sum_of_students_count";
    private String description = "вывести сумму значений поля studentsCount для всех элементов коллекции";

    public SumOfStudentsCountCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        if (groups.isEmpty()){
            throw new CommandResultException(1, "Пустая коллекция.");
        }
        Long sum = 0L;
        for (StudyGroup studyGroup : groups) {
            sum += studyGroup.getStudentsCount();
        }
        try {
            control.getOos().writeObject(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new CommandResultException(0, "");
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
