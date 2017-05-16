package com.rpham64.android.triplebyteproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Rudolf on 5/8/2017.
 */

public class Transaction implements Parcelable {

    public final Date date;

    public final String title;

    public final String category;

    public final String price;

    public Transaction(String title, String category, String price) {
        this.date = null;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public Transaction(Date date, String title, String category, String price) {
        this.date = date;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    protected Transaction(Parcel in) {
        long tmpDate = in.readLong();
        date = tmpDate != -1 ? new Date(tmpDate) : null;
        title = in.readString();
        category = in.readString();
        price = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(date != null ? date.getTime() : -1L);
        dest.writeString(title);
        dest.writeString(category);
        dest.writeString(price);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };
}