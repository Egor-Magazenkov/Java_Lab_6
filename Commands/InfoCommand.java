package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class InfoCommand extends AbstractCommand{
    private String name = "info";
    private String description = "получить информацию о коллекции";

    public InfoCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = control.getGroups();
        Date dateInitialization = control.getDateInitialization();
        Date dateSave = control.getDateSave();
        Date dateChange = control.getDateChange();
        try {
            control.getOos().writeObject("Дата загрузки: " + dateInitialization +
                    "\nДата сохранения: " + dateSave +
                    "\nДата изменения: " + dateChange +
                    "\nТип коллекции: " + groups.getClass() +
                    "\nКоличество элементов: " + groups.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
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
