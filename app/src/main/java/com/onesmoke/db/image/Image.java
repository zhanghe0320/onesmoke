package com.onesmoke.db.image;

import android.os.Parcel;
import android.os.Parcelable;

/**
 */
public class Image implements Parcelable {
    private int mId;//不修改
    private String mImgUrl;//图片地址
    private String mEquipmentbase;//设备编号
    private String mShelfState;//是否缺货
    private Long mCreatedTime;//时间戳 数据修改的时候插入时间轴
    private String mLackProduct;//绑定 010100000001           根据equipmentbase删除货架
    private String mProductName;//绑定 010100000001           根据equipmentbase删除货架

    protected Image(Parcel in) {
        mId = in.readInt();
        mImgUrl = in.readString();
        mEquipmentbase = in.readString();
        mShelfState = in.readString();
        if (in.readByte() == 0) {
            mCreatedTime = null;
        } else {
            mCreatedTime = in.readLong();
        }
        mLackProduct = in.readString();
        mProductName = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @Override
    public String toString() {
        return "Image{" +
                "mId=" + mId +
                ", mImgUrl='" + mImgUrl + '\'' +
                ", mEquipmentbase='" + mEquipmentbase + '\'' +
                ", mShelfState='" + mShelfState + '\'' +
                ", mCreatedTime=" + mCreatedTime +
                ", mLackProduct='" + mLackProduct + '\'' +
                ", mProductName='" + mProductName + '\'' +
                '}';
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public String getmEquipmentbase() {
        return mEquipmentbase;
    }

    public void setmEquipmentbase(String mEquipmentbase) {
        this.mEquipmentbase = mEquipmentbase;
    }

    public String getmShelfState() {
        return mShelfState;
    }

    public void setmShelfState(String mShelfState) {
        this.mShelfState = mShelfState;
    }

    public Long getmCreatedTime() {
        return mCreatedTime;
    }

    public void setmCreatedTime(Long mCreatedTime) {
        this.mCreatedTime = mCreatedTime;
    }

    public String getmLackProduct() {
        return mLackProduct;
    }

    public void setmLackProduct(String mLackProduct) {
        this.mLackProduct = mLackProduct;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mImgUrl);
        dest.writeString(mEquipmentbase);
        dest.writeString(mShelfState);
        if (mCreatedTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mCreatedTime);
        }
        dest.writeString(mLackProduct);
        dest.writeString(mProductName);
    }
}
