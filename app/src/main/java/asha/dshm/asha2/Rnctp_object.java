package asha.dshm.asha2;

public class Rnctp_object {
    private String family_member_id;
    private String cough;
    private String fever;
    private String loss_of_appetite;
    private String blood_in_sputum;
    private String chest_pain;
    private String treatment_status;
    private String past_history;

    public Rnctp_object(String family_member_id, String cough, String fever, String loss_of_appetite, String blood_in_sputum, String chest_pain, String treatment_status, String past_history) {
        this.family_member_id = family_member_id;
        this.cough = cough;
        this.fever = fever;
        this.loss_of_appetite = loss_of_appetite;
        this.blood_in_sputum = blood_in_sputum;
        this.chest_pain = chest_pain;
        this.treatment_status = treatment_status;
        this.past_history = past_history;
    }

    public String getFamily_member_id() {
        return family_member_id;
    }

    public void setFamily_member_id(String family_member_id) {
        this.family_member_id = family_member_id;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getLoss_of_appetite() {
        return loss_of_appetite;
    }

    public void setLoss_of_appetite(String loss_of_appetite) {
        this.loss_of_appetite = loss_of_appetite;
    }

    public String getBlood_in_sputum() {
        return blood_in_sputum;
    }

    public void setBlood_in_sputum(String blood_in_sputum) {
        this.blood_in_sputum = blood_in_sputum;
    }

    public String getChest_pain() {
        return chest_pain;
    }

    public void setChest_pain(String chest_pain) {
        this.chest_pain = chest_pain;
    }

    public String getTreatment_status() {
        return treatment_status;
    }

    public void setTreatment_status(String treatment_status) {
        this.treatment_status = treatment_status;
    }

    public String getPast_history() {
        return past_history;
    }

    public void setPast_history(String past_history) {
        this.past_history = past_history;
    }
    @Override
    public String toString() {
        return "Family Member Id:"+this.family_member_id +"\ncough: " +this.cough + "\nfever: " + this.fever + "\nLoss of appetite: " + this.loss_of_appetite + "\nBlood in Sputum:" + this.blood_in_sputum + "\nChest Pain: " + this.chest_pain + "\nTreatment Status: " + this.treatment_status + "\nPast history: " + this.past_history;
    }

}