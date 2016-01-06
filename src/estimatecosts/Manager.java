package estimatecosts;

import java.util.*;
import java.text.*;

public class Manager extends Staff{

    private static Scanner sc;

	public void setMemberPaycheck(long projectHours){
        Salary managerSalary = new Salary();
        this.memberPaycheck = managerSalary.getManagerStaffSalary() * projectHours;
    }

        public static void main(String[] args) {
            sc = new Scanner(System.in);
            Project testProject = new Project();
            boolean incorrectDateFormat;
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");       //DATE FORMATTER FOR PASING FORMATED STRINGS

                do {
                  incorrectDateFormat = false;
                    System.out.println("Please enter the starting date for the project in yyyy-MM-dd format:");    //GET START DATE
                    String startDate = sc.next();

                    try{
                        testProject.setStartDate(sf.parse(startDate));
                    }catch (ParseException wrongDateFormat) {
                        System.out.println("Wrong start date format, please use the yyyy-MM-dd format when entering the project start dates.");
                        incorrectDateFormat = true;
                    }

                }while(incorrectDateFormat);

                do{
                   incorrectDateFormat = false;
                    System.out.println("Please enter the end of the project in yyyy-MM-dd format:");   //GET END DATE
                    String endDate = sc.next();

                    try{
                        testProject.setEndDate(sf.parse(endDate));
                    }catch(ParseException wrongDateFormat2) {
                        System.out.println("Wrong end date format, please use the yyyy-MM-dd format when entering the project end dates.");
                        incorrectDateFormat = true;
                    }

                }while(incorrectDateFormat);

                    testProject.setProjectHours();   //CALCULATE HOURS
                    testProject.setBasicStaffCost();  //SET BASIC STAFF COST

            //ASK FOR ADVERT TYPES
            AdvertType testAdvertTypes = new AdvertType();
            String[] advertsAr = new String[6];
            boolean continueAds = true;
            String moreAds;
            boolean adPresent;
            String newAdvert;
            for(int i = 0; i < advertsAr.length; i++) {
                    if(continueAds == true){

                        do{
                            adPresent = false;
                            System.out.println("Enter one of the following advert types (Web-based, Email, TV, Radio, Newspaper, Magazine): ");
                            newAdvert = sc.next();
                            adPresent = Arrays.asList(advertsAr).contains(newAdvert);
                        }while(adPresent == true);   //TODO

                        advertsAr[i] = newAdvert;
                        switch (advertsAr[i]) {
                            case "Web-based": testProject.setCostEstimate(testAdvertTypes.calculateWeb());
                                break;
                            case "Email": testProject.setCostEstimate(testAdvertTypes.calculateEmail());
                                break;
                            case "TV": testProject.setCostEstimate(testAdvertTypes.calculateTV(testProject.getHours()));
                                break;
                            case "Radio":testProject.setCostEstimate(testAdvertTypes.calculateRadio(testProject.getHours()));
                                break;
                            case "Newspaper":testProject.setCostEstimate(testAdvertTypes.calculateNewspaper());
                                break;
                            case"Magazine": testProject.setCostEstimate(testAdvertTypes.calculateMagazine());
                                break;
                        }
                        testProject.setCostEstimate2();
                            if(i < 5){
                                System.out.println("Current cost estimate for the project is £"+ testProject.getCostEstimate2());
                                System.out.println("Would you like to ad more advert types, answer yes or no.");
                                moreAds = sc.next();

                                switch (moreAds){
                                        case "yes": continueAds = true;
                                            break;
                                        case "no": continueAds = false;
                                            break;
                                        default: continueAds = false;
                                    }
                        }
                    }
            }
            System.out.println("The final estimated cost for the project is £"+ testProject.getCostEstimate2());
        }
}