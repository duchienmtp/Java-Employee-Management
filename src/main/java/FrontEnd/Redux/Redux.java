package FrontEnd.Redux;

import java.util.ArrayList;

import BackEnd.DegreeManagement.Degree;
import BackEnd.DegreeManagement.DegreeBUS;
import BackEnd.DepartmentManagement.Department;
import BackEnd.DepartmentManagement.DepartmentBUS;
import BackEnd.EmployeeManagement.Employee;
import BackEnd.EmployeeManagement.EmployeeBUS;
import BackEnd.PositionManagement.Position;
import BackEnd.PositionManagement.PositionBUS;
import BackEnd.SpecialtyManagement.Specialty;
import BackEnd.SpecialtyManagement.SpecialtyBUS;

public class Redux {

    public static boolean isLoggedIn = false;
    public static boolean isAdmin = false;

    public static ArrayList<Degree> degreeList;
    public static ArrayList<Position> positionList;
    public static ArrayList<Specialty> specialtyList;
    public static ArrayList<Employee> employeeList;
    public static ArrayList<Department> departmentList;

    public static void getAllEmployees() {
        employeeList = new EmployeeBUS().getEmployeeList();
    }

    public static void getAllDegrees() {
        degreeList = new DegreeBUS().getDegreeList();
    }

    public static void getAllPositions() {
        positionList = new PositionBUS().getPositionList();
    }

    public static void getAllSpecialties() {
        specialtyList = new SpecialtyBUS().getSpecialtyList();
    }

    public static void getAllDepartments() {
        departmentList = new DepartmentBUS().getDepartmentList();
    }
}
