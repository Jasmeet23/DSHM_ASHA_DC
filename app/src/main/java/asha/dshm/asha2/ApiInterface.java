package asha.dshm.asha2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/family_profile/")
    Call<FamilyResponse> family(
                                @Field("family_id") String fam_id,
                                @Field("asha") String asha,
                                @Field("anm") String anm,
                                @Field("health_facility") String health_facility,
                                @Field("area_code") Integer area_code,
                                @Field("area_description") String area_description,
                                @Field("date_of_survey") String date_of_survey,
                                @Field("name_head_of_family") String name_head_of_family,
                                @Field("address") String address,
                                @Field("pincode") String pincode,
                                @Field("mobile_no") String mobile_no,
                                @Field("landline") String landline,
                                @Field("category") String category,
                                @Field("religion") String religion
    );

    @FormUrlEncoded
    @POST("/basic_amenities/")
    Call<BasicAmenitiesResponse> basicAmenities(@Field("family_id") String fam_id,
                                                @Field("house_type") String house_type,
                                                @Field("ownership") String ownership,
                                                @Field("no_of_rooms") Integer no_of_rooms,
                                                @Field("separate_room") Boolean separate_room,
                                                @Field("electricity") Boolean electricity,
                                                @Field("water_source") String water_source,
                                                @Field("vehicle") String vehicle,
                                                @Field("toilet_facility") String toilet_facility,
                                                @Field("water_available_in_toilet") Boolean water_available_in_toilet,
                                                @Field("drainage") String drainage,
                                                @Field("garbage_disposal") int garbage_disposal
    );

    @FormUrlEncoded
    @POST("/other_service_provision/")
    Call<OtherServiceResponse> otherService(@Field("family_id") String fam_id,
                                            @Field("anganwadi_services") Boolean anganwadi_services,
                                            @Field("CATs") Boolean CATs,
                                            @Field("Disability") Boolean Disability,
                                            @Field("PDS") Boolean PDS
    );
}
