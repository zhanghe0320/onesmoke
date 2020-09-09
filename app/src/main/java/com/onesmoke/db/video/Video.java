package com.onesmoke.db.video;

import android.os.Parcel;
import android.os.Parcelable;

/**
 */
public class Video implements Parcelable {
    private int mId;
    private String mEquipmenthost;
    private String mAdvUrl;

    @Override
    public String toString() {
        return "Video{" +
                "mId=" + mId +
                ", mEquipmenthost='" + mEquipmenthost + '\'' +
                ", mAdvUrl='" + mAdvUrl + '\'' +
                '}';
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmEquipmenthost() {
        return mEquipmenthost;
    }

    public void setmEquipmenthost(String mEquipmenthost) {
        this.mEquipmenthost = mEquipmenthost;
    }

    public String getmAdvUrl() {
        return mAdvUrl;
    }

    public void setmAdvUrl(String mAdvUrl) {
        this.mAdvUrl = mAdvUrl;
    }

    public static Creator<Video> getCREATOR() {
        return CREATOR;
    }

    protected Video(Parcel in) {
        mId = in.readInt();
        mEquipmenthost = in.readString();
        mAdvUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mEquipmenthost);
        dest.writeString(mAdvUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };
}
