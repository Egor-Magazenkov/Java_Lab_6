package Lab_6.Utilities;

import Lab_6.Collection.StudyGroup;
import Lab_6.Exceptions.AbsenceResultException;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SortCollection {
    private HashSet<StudyGroup> groups;
    public SortCollection(HashSet<StudyGroup> groups) {
        this.groups = groups;
    }
    public TreeSet<StudyGroup> sort_descending() throws AbsenceResultException {
        try {
            TreeSet<StudyGroup> sorted = new TreeSet<StudyGroup>(groups);
            return sorted;
        }
        catch(NoSuchElementException e){
            throw new AbsenceResultException("Пустая коллекция. Нечего выводить.");
        }
    }
}
