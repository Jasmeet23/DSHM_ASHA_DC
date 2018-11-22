
        package asha.dshm.asha2;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class FamilyResponse {

    @SerializedName("family_id")
    @Expose
    private String familyId;
    @SerializedName("asha")
    @Expose
    private String asha;
    @SerializedName("anm")
    @Expose
    private String anm;
    @SerializedName("health_facility")
    @Expose
    private String healthFacility;
    @SerializedName("area_code")
    @Expose
    private Integer areaCode;
    @SerializedName("area_description")
    @Expose
    private String areaDescription;
    @SerializedName("date_of_survey")
    @Expose
    private String dateOfSurvey;
    @SerializedName("name_head_of_family")
    @Expose
    private String nameHeadOfFamily;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("mobile_no")
    @Expose
    private String mobileNo;
    @SerializedName("landline")
    @Expose
    private String landline;
    @SerializedName("category")
    @Expose
    private int category;
    @SerializedName("religion")
    @Expose
    private int religion;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getAsha() {
        return asha;
    }

    public void setAsha(String asha) {
        this.asha = asha;
    }

    public String getAnm() {
        return anm;
    }

    public void setAnm(String anm) {
        this.anm = anm;
    }

    public String getHealthFacility() {
        return healthFacility;
    }

    public void setHealthFacility(String healthFacility) {
        this.healthFacility = healthFacility;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public String getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(String dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getNameHeadOfFamily() {
        return nameHeadOfFamily;
    }

    public void setNameHeadOfFamily(String nameHeadOfFamily) {
        this.nameHeadOfFamily = nameHeadOfFamily;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

}