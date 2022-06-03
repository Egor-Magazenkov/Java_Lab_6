package Lab_6.Commands;

import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HistoryCommand extends AbstractCommand{
    private String name = "history";
    private String description = "Вывод последних 7 успешных команд.";
    public HistoryCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        String[] commandHistory = control.getCommandHistory();
        if (commandHistory[0] == null){
            try {
                control.getOos().writeObject("Не было успешных команд. История пуста!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            String result = "Последние использованные команды:\n";
            for (String command :
                    commandHistory) {
                if (command != null) result += command + "\n";
            }
            try {
                control.getOos().writeObject(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
