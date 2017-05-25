package com.example.tacompanion.tacompanion.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.tacompanion.tacompanion.R;
import com.example.tacompanion.tacompanion.activities.UserPageActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRCodeFragment extends Fragment implements ZXingScannerView.ResultHandler, NumberPicker.OnValueChangeListener {
    private final int MAX_NUM_OF_GUESTS_X_SESSION=20;
    private ZXingScannerView mScannerView;
    private View view;
    private int actualNumOfGuests=1;

    public QRCodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_qrcode, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view=view;
        qrScanner(view);
    }

    @Override
    public void handleResult(final Result rawResult) {
        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

// show the scanner result into dialog box.

        if(UserPageActivity.activeSession==true){
            showSessionWarning(rawResult);
        }
        UserPageActivity.viewPager.setCurrentItem(1);
        if(UserPageActivity.activeSession==false){
            showNumberPicker(rawResult);
                UserPageActivity.activeSession = true;
            }
        UserProfileFragment.updateStatus();




        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);

    }
    public void showSessionWarning(final Result rawResult){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Ops!");
        builder.setMessage("It seems you already have an active session with a restaurant. Do you wish to finish your current session?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                showNumberPicker(rawResult);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


            }
        });
        AlertDialog alert1 = builder.create();
        alert1.show();

    }
    public void showQRCodeResult(Result rawResult){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("Resultado de escaneo");
        builder.setMessage(rawResult.getText()+" - "+String.valueOf(actualNumOfGuests));
        AlertDialog alert1 = builder.create();
        alert1.show();
        Toast.makeText(this.getActivity(), "Your session is active! We will let you know when your table is ready!", Toast.LENGTH_LONG).show();
    }
    public void showNumberPicker(final Result rawResult)
    {
        final NumberPicker picker = new NumberPicker(this.getActivity());
        picker.setMinValue(1);
        picker.setMaxValue(MAX_NUM_OF_GUESTS_X_SESSION);

        final FrameLayout layout = new FrameLayout(this.getActivity());
        layout.addView(picker, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER));
        picker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        picker.setScaleX((float) 1.3);
        picker.setScaleY((float) 1.3);

        final AlertDialog.Builder builder =new AlertDialog.Builder(this.getActivity())
                .setView(layout)
                .setTitle("Number of guests")
                .setMessage("For how many people do you want your table?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        actualNumOfGuests=picker.getValue();
                        dialogInterface.dismiss();
                        showQRCodeResult(rawResult);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        Dialog d = builder.create();
        d.getWindow().setBackgroundDrawableResource(R.color.tpn_blue);
        d.show();



    }

    public void qrScanner(View view){

        mScannerView = new ZXingScannerView(this.getActivity()); // Programmatically initialize the scanner view
        ((FrameLayout)view.findViewById(R.id.qrcsFLayout)).addView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera(); // Start camera
    }
    @Override
    public void onPause() {
        super.onPause();
        if(mScannerView!=null)
            mScannerView.stopCamera(); // Stop camera on pause
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mScannerView!=null)
            mScannerView.stopCamera(); // Stop camera on pause
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mScannerView!=null)
            mScannerView.resumeCameraPreview(this);
            qrScanner(view);

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }
}
