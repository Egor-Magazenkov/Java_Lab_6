package Lab_6.Utilities;
import Lab_6.Collection.*;
import Lab_6.Exceptions.*;
import java.util.HashSet;

public class FindStudyGroupByVariable {
    private HashSet<StudyGroup> groups;

    public FindStudyGroupByVariable(HashSet<StudyGroup> groups){
        this.groups = groups;
    }

    public StudyGroup find_by_id(int ID) throws AbsenceResultException{
        for (StudyGroup group :
                groups) {
            if (group.getId() == ID) {
                return group;
            }
        }
        throw new AbsenceResultException("Элемента с таким Id не существует.");
    }

    public HashSet<StudyGroup> find_by_name(String name){
        HashSet<StudyGroup> result = new HashSet<StudyGroup>();
        for (StudyGroup group :
                groups) {
            if (group.getName().equals(name)) {
                result.add(group);
            }
        }
        return result;
    }

    public HashSet<StudyGroup> find_by_admin_name(String name) throws AbsenceResultException{
        HashSet<StudyGroup> result = new HashSet<StudyGroup>();
        for (StudyGroup group :
                groups) {
            if (group.getGroupAdmin().getName().equals(name)) {
                result.add(group);
            }
        }
        if (result.isEmpty()){
            throw new AbsenceResultException("Нет группы с админом " + name);
        }
        return result;
    }
}
