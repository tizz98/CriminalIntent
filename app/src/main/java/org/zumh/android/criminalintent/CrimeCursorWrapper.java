package org.zumh.android.criminalintent;

import android.database.Cursor;
import android.database.CursorWrapper;

import org.zumh.android.criminalintent.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        String suspectPhone = getString(getColumnIndex(CrimeTable.Cols.PHONENUMBER));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspectName(suspect);
        crime.setSuspectPhoneNumber(suspectPhone);

        return crime;
    }
}
