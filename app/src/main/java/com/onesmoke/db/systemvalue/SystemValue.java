package com.onesmoke.db.systemvalue;

import android.os.Parcel;
import android.os.Parcelable;

/**
 */
public class SystemValue implements Parcelable {
    private int mId;//数据库ID 自带 不修改
    private String mName;//名称  超级密码 密码 。。。。
    private String mValue;//参数     名称是【本机编号】的时候   就是主机的号码  010100000001
    private Long mCreatedTime;//时间戳 数据修改的时候插入时间轴
    private String mEquipmenthost;//唯一标识符     010100000001

    private String mCityID;//绑定 010100000001           根据equipmentbase删除货架
    private String mProviceID;//绑定 010100000001           根据equipmentbase删除货架

    protected SystemValue(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mValue = in.readString();
        if (in.readByte() == 0) {
            mCreatedTime = null;
        } else {
            mCreatedTime = in.readLong();
        }
        mEquipmenthost = in.readString();
        mCityID = in.readString();
        mProviceID = in.readString();
    }

    public static final Creator<SystemValue> CREATOR = new Creator<SystemValue>() {
        @Override
        public SystemValue createFromParcel(Parcel in) {
            return new SystemValue(in);
        }

        @Override
        public SystemValue[] newArray(int size) {
            return new SystemValue[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mValue);
        if (mCreatedTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mCreatedTime);
        }
        dest.writeString(mEquipmenthost);
        dest.writeString(mCityID);
        dest.writeString(mProviceID);
    }
}
