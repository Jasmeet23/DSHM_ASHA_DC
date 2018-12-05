package asha.dshm.asha2.Java;

import java.util.ArrayList;

public class FamilyRecord {
    private String asha;
    private String family_id;
    private String anm;
    private int area_code;
    private String name_head_of_family;
    private String address;

    public String getAsha() {
        return asha;
    }

    public void setAsha(String asha) {
        this.asha = asha;
    }

    public String getFamilyID() {
        return family_id;
    }

    public void setFamilyID(String familyID) {
        this.family_id = familyID;
    }

    public String getAnm() {
        return anm;
    }

    public void setAnm(String anm) {
        this.anm = anm;
    }

    public int getArea_code() {
        return area_code;
    }

    public void setArea_code(int area_code) {
        this.area_code = area_code;
    }

    public String getName_head_of_family() {
        return name_head_of_family;
    }

    public void setName_head_of_family(String name_head_of_family) {
        this.name_head_of_family = name_head_of_family;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FamilyRecord(String asha, String familyID, String anm, int area_code, String name_head_of_family, String address) {

        this.asha = asha;
        this.family_id = familyID;
        this.anm = anm;
        this.area_code = area_code;
        this.name_head_of_family = name_head_of_family;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Family Head Name:"+this.name_head_of_family +"\nANM name: " +this.anm + "\nASHA name: " + this.asha + "\nArea Code: " + this.area_code + "\nAddress:" + this.address + "\nFamily ID: " + this.family_id;
    }

}
