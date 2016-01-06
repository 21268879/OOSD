package estimatecosts;

public class Administrator extends Staff {

    public void setMemberPaycheck(long projectHours){
        Salary adminSalary = new Salary();
        this.memberPaycheck = adminSalary.getAdministratorStaffSalary() * projectHours;
    }
}