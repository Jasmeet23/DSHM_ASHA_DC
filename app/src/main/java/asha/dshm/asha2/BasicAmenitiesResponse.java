package asha.dshm.asha2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicAmenitiesResponse {

    @SerializedName("family_id")
    @Expose
    private String familyId;
    @SerializedName("house_type")
    @Expose
    private String houseType;
    @SerializedName("ownership")
    @Expose
    private String ownership;
    @SerializedName("no_of_rooms")
    @Expose
    private Integer noOfRooms;
    @SerializedName("separate_room")
    @Expose
    private Boolean separateRoom;
    @SerializedName("electricity")
    @Expose
    private Boolean electricity;
    @SerializedName("water_source")
    @Expose
    private String waterSource;
    @SerializedName("vehicle")
    @Expose
    private String vehicle;
    @SerializedName("toilet_facility")
    @Expose
    private String toiletFacility;
    @SerializedName("water_available_in_toilet")
    @Expose
    private Boolean waterAvailableInToilet;
    @SerializedName("drainage")
    @Expose
    private String drainage;
    @SerializedName("garbage_disposal")
    @Expose
    private String garbageDisposal;

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Boolean getSeparateRoom() {
        return separateRoom;
    }

    public void setSeparateRoom(Boolean separateRoom) {
        this.separateRoom = separateRoom;
    }

    public Boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(Boolean electricity) {
        this.electricity = electricity;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getToiletFacility() {
        return toiletFacility;
    }

    public void setToiletFacility(String toiletFacility) {
        this.toiletFacility = toiletFacility;
    }

    public Boolean getWaterAvailableInToilet() {
        return waterAvailableInToilet;
    }

    public void setWaterAvailableInToilet(Boolean waterAvailableInToilet) {
        this.waterAvailableInToilet = waterAvailableInToilet;
    }

    public String getDrainage() {
        return drainage;
    }

    public void setDrainage(String drainage) {
        this.drainage = drainage;
    }

    public String getGarbageDisposal() {
        return garbageDisposal;
    }

    public void setGarbageDisposal(String garbageDisposal) {
        this.garbageDisposal = garbageDisposal;
    }



}