package estimatecosts;

public class PurchasingStaff extends Staff{

    public void setMemberPaycheck(long projectHours){
        Salary purchasingSalary = new Salary();
        this.memberPaycheck = purchasingSalary.getPurchasingStaffSalary() * projectHours;
    }
}