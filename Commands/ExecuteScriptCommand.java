package Lab_6.Commands;

import Lab_6.Exceptions.CommandResultException;
import Lab_6.Utilities.Control;

import java.io.File;
import java.util.Scanner;

public class ExecuteScriptCommand extends AbstractCommand{
    private String name = "execute_script";
    private String description = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";

    public ExecuteScriptCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String filename, Scanner sc) throws CommandResultException {
        File script = new File(filename);
        try{
            Scanner scan = new Scanner(script);
            while(scan.hasNextLine()){
                String next_line = scan.nextLine();
                if (next_line.startsWith("execute_script")){
                    System.out.println("Не стоит вызывать скрипт из скрипта. ");
                    continue;
                }
                control.processing(next_line, scan);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
