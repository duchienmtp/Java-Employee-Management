package BackEnd.DegreeManagement;

import java.util.ArrayList;

public class DegreeBUS {

    private ArrayList<Degree> degreeList = new ArrayList<>();
    private DegreeDAO degreeDAO = new DegreeDAO();

    public DegreeBUS() {
        degreeList = degreeDAO.getAllDegree();
    }

    public void readDB() {
        degreeList = degreeDAO.getAllDegree();
    }

    public ArrayList<Degree> getDegreeList() {
        return degreeList;
    }

    public String getNextID() {
        String lastID = degreeList.get(degreeList.size() - 1).getDegreeId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public Degree getDegreeById(String degreeId) {
        for (Degree degree : degreeList) {
            if (degree.getDegreeId().equals(degreeId)) {
                return degree;
            }
        }
        return null;
    }

    public void addDegree(Degree degree) {
        Boolean ok = degreeDAO.addNewDegree(degree);

        if (ok) {
            degreeList.add(degree);
        }
    }

    public void updateDegree(Degree degree) {
        Boolean ok = degreeDAO.updateDegree(degree);

        if (ok) {
            for (int i = 0; i < degreeList.size(); i++) {
                if (degreeList.get(i).getDegreeId().equals(degree.getDegreeId())) {
                    degreeList.set(i, degree);
                    break;
                }
            }
        }
    }

    public void deleteDegree(Degree degree) {
        Boolean ok = degreeDAO.deleteDegree(degree);

        if (ok) {
            for (int i = 0; i < degreeList.size(); i++) {
                if (degreeList.get(i).getDegreeId().equals(degree)) {
                    degreeList.remove(i);
                    break;
                }
            }
        }
    }
}
