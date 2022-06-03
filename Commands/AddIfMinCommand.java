package Lab_6.Commands;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;
import Lab_6.Exceptions.CommandResultException;
import Lab_6.Exceptions.SetResultException;
import Lab_6.Utilities.ChangeGroupFieldFromFile;
import Lab_6.Utilities.ChangeGroupFieldFromInput;
import Lab_6.Utilities.Control;
import Lab_6.Utilities.FindMax_MinGroup;

import java.util.HashSet;
import java.util.Scanner;

public class AddIfMinCommand extends AbstractCommand{
    private String name = "add_if_min";
    private String description = "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";

    public AddIfMinCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        StudyGroup new_group = new StudyGroup();
        if (control.isFromFile()){
            ChangeGroupFieldFromFile fieldSetter = new ChangeGroupFieldFromFile(new_group, sc);
            boolean res = true;
            try {
                fieldSetter.change_name();
            } catch (SetResultException e) {
                res = false;
            }
            try {
                fieldSetter.change_coordinate();
            } catch (SetResultException e) {
                res = false;

            }
            try {
                fieldSetter.change_StudentsCount();
            } catch (SetResultException e) {
                res = false;

            }
            try {
                fieldSetter.change_ExpelledStudents();
            } catch (SetResultException e) {
                res = false;

            }
            try {
                fieldSetter.change_AverageMark();
            } catch (SetResultException e) {
                res = false;

            }
            try {
                fieldSetter.change_FormOfEducation();
            } catch (SetResultException e) {
                res = false;

            }
            try {
                fieldSetter.change_Admin();
            } catch (SetResultException e) {
                res = false;

            }
            if (res){
                groups.add(new_group);}
            else {
                throw new CommandResultException(1, "Элемент не был добавлен из-за неправильного ввода.");
            }
        }else {
            ChangeGroupFieldFromInput fieldSetter = new ChangeGroupFieldFromInput(new_group, control.getOis(), control.getOos());
            fieldSetter.change_name();
            fieldSetter.change_coordinate();
            fieldSetter.change_StudentsCount();
            fieldSetter.change_ExpelledStudents();
            fieldSetter.change_AverageMark();
            fieldSetter.change_FormOfEducation();
            fieldSetter.change_Admin();
        }
        FindMax_MinGroup finder = new FindMax_MinGroup(groups);
        StudyGroup min;
        try {
            min = finder.find_min();
        } catch (AbsenceResultException e) {
            groups.add(new_group);
            throw new CommandResultException(0, "Группа добавлена.");
        }
        if (new_group.getAverageMark() < min.getAverageMark()){
            groups.add(new_group);
            throw new CommandResultException(0, "Группа добавлена.");
        }
        else {
            throw new CommandResultException(1, "Группа не добавлена. Средняя оценка не наименьшая!");
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
