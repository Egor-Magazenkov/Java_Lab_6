package Lab_6;
import Lab_6.Collection.*;
import Lab_6.Utilities.*;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
        /**
         * @param args
         */
        public static void main(String[] args){
            HashSet<StudyGroup> groups;
            Control control;
            if (args.length != 0){
                try{
                    File filename = new File(args[0]);

                    ParseXML parser = new ParseXML(filename);
                    parser.parseGroups();
                    groups = parser.getResult();

                    control = new Control(groups);
                    Scanner sc = new Scanner(System.in);

                    while(true){
                        System.out.println("Введите команду. (Для вывода списка команд ввыедите help)");
                        String command = sc.nextLine();
                        control.processing(command);
                    }
                }
                catch (NullPointerException e){
                    System.out.println("Файл не обнаружен. Проверьте переданный путь к файлу");
                    System.exit(1);
                }
                catch (Exception e){
                    System.out.println("Проблемы с парсером файла. \nОбратитесь в поддержку по телефону 02");
                    System.exit(1);
                }
            }
            else {
                System.out.println("Адрес файла не б. Для Корректной работы программы при запуске в аргументах укажите путь к файлу");
                System.exit(1);
            }

    }
}