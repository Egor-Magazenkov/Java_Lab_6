package Lab_6.Commands;

import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Collection.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShowCommand extends AbstractCommand{
    private String name = "show";
    private String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    public ShowCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        if (groups.isEmpty()) {
            throw new CommandResultException(1, "Пустая коллекция. Нечего выводить.");
        }

        try {
            control.getOos().writeObject(String.format("%6s %10s %12s %20s %25s %35s  %20s %60s %15s\n", "Id", "Назание", "Координаты", "Форма обучения", "Количество студентов", "Количество отчисленных студентов", "Средняя оценка", "Админ", "Дата создания") + groups.stream().map(StudyGroup::toString).collect(Collectors.joining("\n")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        throw new CommandResultException(-1, "");
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}

