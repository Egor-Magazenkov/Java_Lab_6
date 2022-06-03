package Lab_6.Commands;

import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.SaveToFile;

import java.io.IOException;
import java.util.Scanner;

public class ExitCommand extends AbstractCommand{
    private String name = "exit";
    private String description = "завершить программу (без сохранения в файл)";
    public ExitCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        SaveToFile saveToFile = new SaveToFile(control.getGroups());
        try {
            control.getOos().writeObject("Выход.\n Всего хорошего)");
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
