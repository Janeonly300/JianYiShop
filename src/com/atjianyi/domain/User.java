package com.atjianyi.domain;

/**
 * @author 简一
 * @className User
 * @Date 2020/11/8 15:09
 **/
public class User {
    private int id;
    private String userName;
    private String name;
    private String userPwd;
    private String userSex;
    private String userBirth;
    private String userIdenityCode;
    private String userEmail;
    private String userPone;
    private String userAddress;
    private int userStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String userName, String name, String userPwd, String userSex, String userBirth, String userIdenityCode, String userEmail, String userPone, String userAddress, int userStatus) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userIdenityCode = userIdenityCode;
        this.userEmail = userEmail;
        this.userPone = userPone;
        this.userAddress = userAddress;
        this.userStatus = userStatus;
    }

    public User(String userName, String name, String userPwd, String userSex, String userBirth, String userIdenityCode, String userEmail, String userPone, String userAddress, int userStatus) {

        this.userName = userName;
        this.name = name;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userBirth = userBirth;
        this.userIdenityCode = userIdenityCode;
        this.userEmail = userEmail;
        this.userPone = userPone;
        this.userAddress = userAddress;
        this.userStatus = userStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }
    @Override
    public String toString() {
        return "User{" +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userIdenityCode='" + userIdenityCode + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPone='" + userPone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserIdenityCode() {
        return userIdenityCode;
    }

    public void setUserIdenityCode(String userIdenityCode) {
        this.userIdenityCode = userIdenityCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPone() {
        return userPone;
    }

    public void setUserPone(String userPone) {
        this.userPone = userPone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
