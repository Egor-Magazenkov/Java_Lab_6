package Lab_6.Utilities;

import Lab_6.Collection.StudyGroup;
import Lab_6.Commands.AbstractCommand;
import Lab_6.Exceptions.AbsenceResultException;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class FindMax_MinGroup {
    private HashSet<StudyGroup> groups;
    private HashSet<StudyGroup> result = new HashSet<StudyGroup>();

    public FindMax_MinGroup(HashSet<StudyGroup> groups){
        this.groups = groups;
    }

    public HashSet<StudyGroup> find_all_min() throws AbsenceResultException{
        try{
        SortCollection sorter = new SortCollection(groups);
        StudyGroup lowest = sorter.sort_descending().last();
        result.add(lowest);
        for (StudyGroup studyGroup : groups) {
            if (studyGroup.getAverageMark() == lowest.getAverageMark()){
                result.add(studyGroup);
            }
        }
        return result;
        }
        catch(NoSuchElementException e){
            throw new AbsenceResultException("Пустая коллекция. Нет группы с наименьшей средней оценкой.");
        }
    }public StudyGroup find_min() throws AbsenceResultException{
        try{
            SortCollection sorter = new SortCollection(groups);
            StudyGroup lowest = sorter.sort_descending().last();

            return lowest;
        }
        catch(NoSuchElementException e){
            throw new AbsenceResultException("Пустая коллекция. Нет группы с наименьшей средней оценкой.");
        }
    }

}
