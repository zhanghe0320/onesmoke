package com.onesmoke.db.machine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 */
public class Equipment implements Parcelable {
    private int mId;//数据库 固定  不许插入数据
    private String mEquipmentName;//设备名字   设备0~设备9
    private Long mCreatedTime;//时间戳 数据修改的时候插入时间轴
    private String mEquipmenthost;//主机标志，010100000001     (主机的 host base相同，货架host,base参数不相同)
    private String mEquipmentbase;//绑定 010100000001           根据equipmentbase删除货架
    private String mEquipmentid;//绑定 010100000001           根据equipmentbase删除货架
    private String mLackProduct;//绑定 010100000001           根据equipmentbase删除货架
    private String mShelfState;//绑定 010100000001           根据equipmentbase删除货架

    @Override
    public String toString() {
        return "Equipment{" +
                "mId=" + mId +
                ", mEquipmentName='" + mEquipmentName + '\'' +
                ", mCreatedTime=" + mCreatedTime +
                ", mEquipmenthost='" + mEquipmenthost + '\'' +
                ", mEquipmentbase='" + mEquipmentbase + '\'' +
                ", mEquipmentid='" + mEquipmentid + '\'' +
                ", mLackProduct='" + mLackProduct + '\'' +
                ", mShelfState='" + mShelfState + '\'' +
                '}';
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmEquipmentName() {
        return mEquipmentName;
    }

    public void setmEquipmentName(String mEquipmentName) {
        this.mEquipmentName = mEquipmentName;
    }

    public Long getmCreatedTime() {
        return mCreatedTime;
    }

    public void setmCreatedTime(Long mCreatedTime) {
        this.mCreatedTime = mCreatedTime;
    }

    public String getmEquipmenthost() {
        return mEquipmenthost;
    }

    public void setmEquipmenthost(String mEquipmenthost) {
        this.mEquipmenthost = mEquipmenthost;
    }

    public String getmEquipmentbase() {
        return mEquipmentbase;
    }

    public void setmEquipmentbase(String mEquipmentbase) {
        this.mEquipmentbase = mEquipmentbase;
    }

    public String getmEquipmentid() {
        return mEquipmentid;
    }

    public void setmEquipmentid(String mEquipmentid) {
        this.mEquipmentid = mEquipmentid;
    }

    public String getmLackProduct() {
        return mLackProduct;
    }

    public void setmLackProduct(String mLackProduct) {
        this.mLackProduct = mLackProduct;
    }

    public String getmShelfState() {
        return mShelfState;
    }

    public void setmShelfState(String mShelfState) {
        this.mShelfState = mShelfState;
    }

    public static Creator<Equipment> getCREATOR() {
        return CREATOR;
    }

    protected Equipment(Parcel in) {
        mId = in.readInt();
        mEquipmentName = in.readString();
        if (in.readByte() == 0) {
            mCreatedTime = null;
        } else {
            mCreatedTime = in.readLong();
        }
        mEquipmenthost = in.readString();
        mEquipmentbase = in.readString();
        mEquipmentid = in.readString();
        mLackProduct = in.readString();
        mShelfState = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mEquipmentName);
        if (mCreatedTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mCreatedTime);
        }
        dest.writeString(mEquipmenthost);
        dest.writeString(mEquipmentbase);
        dest.writeString(mEquipmentid);
        dest.writeString(mLackProduct);
        dest.writeString(mShelfState);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Equipment> CREATOR = new Creator<Equipment>() {
        @Override
        public Equipment createFromParcel(Parcel in) {
            return new Equipment(in);
        }

        @Override
        public Equipment[] newArray(int size) {
            return new Equipment[size];
        }
    };
}
