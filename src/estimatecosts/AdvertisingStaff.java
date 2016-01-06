package estimatecosts;

public class AdvertisingStaff extends Staff {

    public void setMemberPaycheck(long projectHours){
        Salary advertisingSalary = new Salary();
        this.memberPaycheck = advertisingSalary.getAdvertisingStaffSalary() * projectHours;
    }
}