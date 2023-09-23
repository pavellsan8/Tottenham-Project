package com.example.uts_mcs;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataUser implements Parcelable {
    private String regisName, regisEmail, regisPassword;

    public DataUser(String regisName, String regisEmail, String regisPassword) {
        this.regisName = regisName;
        this.regisEmail = regisEmail;
        this.regisPassword = regisPassword;
    }

    public String getRegisName() {
        return regisName;
    }

    public void setRegisName(String regisName) {
        this.regisName = regisName;
    }

    public String getRegisEmail() {
        return regisEmail;
    }

    public void setRegisEmail(String regisEmail) {
        this.regisEmail = regisEmail;
    }

    public String getRegisPassword() {
        return regisPassword;
    }

    public void setRegisPassword(String regisPassword) {
        this.regisPassword = regisPassword;
    }

    protected DataUser(Parcel in) {
        regisName = in.readString();
        regisEmail = in.readString();
        regisPassword = in.readString();
    }

    public static final  Creator<DataUser> CREATOR = new Creator<DataUser>() {
        @Override
        public DataUser createFromParcel(Parcel in) {
            return new DataUser(in);
        }

        @Override
        public DataUser[] newArray(int size) {
            return new DataUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(regisName);
        dest.writeString(regisEmail);
        dest.writeString(regisPassword);
    }
}
