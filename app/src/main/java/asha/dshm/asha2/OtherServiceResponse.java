package asha.dshm.asha2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtherServiceResponse {

    @SerializedName("family_id")
    @Expose
    private String familyId;
    @SerializedName("anganwadi_services")
    @Expose
    private Boolean anganwadiServices;
    @SerializedName("CATs")
    @Expose
    private Boolean cATs;
    @SerializedName("Disability")
    @Expose
    private Boolean disability;
    @SerializedName("PDS")
    @Expose
    private Boolean pDS;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public Boolean getAnganwadiServices() {
        return anganwadiServices;
    }

    public void setAnganwadiServices(Boolean anganwadiServices) {
        this.anganwadiServices = anganwadiServices;
    }

    public Boolean getCATs() {
        return cATs;
    }

    public void setCATs(Boolean cATs) {
        this.cATs = cATs;
    }

    public Boolean getDisability() {
        return disability;
    }

    public void setDisability(Boolean disability) {
        this.disability = disability;
    }

    public Boolean getPDS() {
        return pDS;
    }

    public void setPDS(Boolean pDS) {
        this.pDS = pDS;
    }


}