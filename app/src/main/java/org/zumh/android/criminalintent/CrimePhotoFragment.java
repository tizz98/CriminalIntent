package org.zumh.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.UUID;

public class CrimePhotoFragment extends DialogFragment {
    private static final String ARG_CRIME_ID = "crime_id";

    private ImageView mImageView;

    public static CrimePhotoFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        Crime crime = crimeLab.getCrime(crimeId);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_crime_photo, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_crime_photo_iv);
        Bitmap bitmap = PictureUtils.getScaledBitmap(crimeLab.getPhotoFile(crime).getPath(), getActivity());
        mImageView.setImageBitmap(bitmap);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle(R.string.crime_photo_title)
            .create();
    }
}