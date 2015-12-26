package org.zumh.android.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspectName;
    private String mSuspectPhoneNumber;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSuspectName() {
        return mSuspectName;
    }

    public void setSuspectName(String suspectName) {
        mSuspectName = suspectName;
    }

    public String getSuspectPhoneNumber() {
        return mSuspectPhoneNumber;
    }

    public void setSuspectPhoneNumber(String suspectPhoneNumber) {
        mSuspectPhoneNumber = suspectPhoneNumber;
    }

    public boolean canCallSuspect() {
        return (mSuspectName != null && mSuspectPhoneNumber != null);
    }
}
