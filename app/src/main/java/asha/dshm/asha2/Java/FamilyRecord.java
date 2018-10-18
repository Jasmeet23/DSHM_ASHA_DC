package asha.dshm.asha2.Java;

import java.util.ArrayList;

public class FamilyRecord {
    ArrayList<FamilyMember> familyMembers;
    String nameASHA;
    String nameANM;
    String areaCode;
    FamilyMember head;
    String address;
    String familyID;

    public FamilyRecord(String nameASHA, String nameANM, String areaCode, FamilyMember head, String address, String familyID) {
        this.nameASHA = nameASHA;
        this.nameANM = nameANM;
        this.areaCode = areaCode;
        this.head = head;
        this.address = address;
        this.familyID = familyID;
    }

    @Override
    public String toString() {
        return "Family Head Name:"+this.head.name +"\nANM name: " +this.nameANM + "\nASHA name: " + this.nameASHA + "\nArea Code: " + this.areaCode + "\nAddress:" + this.address + "\nFamily ID: " + this.familyID;
    }
}
