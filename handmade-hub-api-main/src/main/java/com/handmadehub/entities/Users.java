package com.handmadehub.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="users")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_status")
    private Byte otpStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "address")
    private String address;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "firm_name")
    private String firmName;

    @Column(name = "sgst_no")
    private String sgstNo;

    @Column(name = "gst_upload")
    private String gstUpload;

    @Column(name = "pan_upload")
    private String panUpload;

    @Column(name = "aadhaar_upload")
    private String aadhaarUpload;

    @Column(name = "firm_upload")
    private String firmUpload;

    @Column(name = "gst_no")
    private String gstNo;

    @Column(name = "pan_no")
    private String panNo;

    @Column(name = "aadhaar_no")
    private String aadhaarNo;

    @Column(name = "firm_no")
    private String firmNo;

    @Column(name = "dob")
    private String dob;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "dist_id")
    private Integer distId;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "push_notification_id")
    private String pushNotificationId;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "status")
    private Integer status;

    @Column(name = "experience")
    private String experience;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "avg_rating")
    private Double avgRating;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "resume")
    private String resume;

    @Column(name = "updated_field")
    private String updatedField;

    @Column(name = "password")
    private String password;

    @Column(name = "encryption_key")
    private byte[] encryptionKey;


	
	    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Byte getOtpStatus() {
        return otpStatus;
    }

    public void setOtpStatus(Byte otpStatus) {
        this.otpStatus = otpStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getSgstNo() {
        return sgstNo;
    }

    public void setSgstNo(String sgstNo) {
        this.sgstNo = sgstNo;
    }

    public String getGstUpload() {
        return gstUpload;
    }

    public void setGstUpload(String gstUpload) {
        this.gstUpload = gstUpload;
    }

    public String getPanUpload() {
        return panUpload;
    }

    public void setPanUpload(String panUpload) {
        this.panUpload = panUpload;
    }

    public String getAadhaarUpload() {
        return aadhaarUpload;
    }

    public void setAadhaarUpload(String aadhaarUpload) {
        this.aadhaarUpload = aadhaarUpload;
    }

    public String getFirmUpload() {
        return firmUpload;
    }

    public void setFirmUpload(String firmUpload) {
        this.firmUpload = firmUpload;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getDistId() {
        return distId;
    }

    public void setDistId(Integer distId) {
        this.distId = distId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPushNotificationId() {
        return pushNotificationId;
    }

    public void setPushNotificationId(String pushNotificationId) {
        this.pushNotificationId = pushNotificationId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUpdatedField() {
        return updatedField;
    }

    public void setUpdatedField(String updatedField) {
        this.updatedField = updatedField;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(byte[] encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}
