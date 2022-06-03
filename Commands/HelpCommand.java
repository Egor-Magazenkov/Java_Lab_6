package Lab_6.Commands;

import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelpCommand extends AbstractCommand{
    private String name = "help";
    private String description = "вывести справку по доступным командам";

    public HelpCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        Collection<AbstractCommand> commands = control.getCommands();
            try {
                control.getOos().writeObject("Список доступных команд:\n" + commands.stream().map((AbstractCommand command) -> command.getName() + " (" + command.getDescription() + ")").collect(Collectors.joining("\n")));
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
