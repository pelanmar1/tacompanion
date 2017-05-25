package com.example.tacompanion.tacompanion.fragments;


import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tacompanion.tacompanion.R;
import com.example.tacompanion.tacompanion.activities.UserPageActivity;
import com.example.tacompanion.tacompanion.model.User;
import com.wang.avi.AVLoadingIndicatorView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {
    static AVLoadingIndicatorView avi;
    private static TextView title;
    private static TextView statusTxt;
    private static CircleImageView circleImageView;
    private static Activity act;

    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        avi= (AVLoadingIndicatorView) getActivity().findViewById(R.id.avi);
        title=(TextView) getActivity().findViewById(R.id.tv_welcome);
        circleImageView= (CircleImageView) getActivity().findViewById(R.id.profile_image);
        statusTxt=(TextView) getActivity().findViewById(R.id.tv_sessionStat);
        act=this.getActivity();
        updateStatus();

    }
    static void startAnim(){
        avi.show();
        // or avi.smoothToShow();
    }

    static void stopAnim(){
        avi.hide();
        // or avi.smoothToHide();
    }
    static void updateStatus(){

        if(User.getCurrentUser()!=null) {
            title.setText("Welcome " + User.getInstance().getName());
            if(!User.getInstance().getPicturePath().equals(""))
                circleImageView.setImageBitmap(BitmapFactory.decodeFile(User.getInstance().getPicturePath()));
            if(UserPageActivity.activeSession){
                statusTxt.setText("Almost ready!");
            }
            else
                statusTxt.setText("At the moment you don't have an active session on any restaurant. Swipe right to start a new session!");
        }
        if(UserPageActivity.activeSession)
            startAnim();
        else
            stopAnim();
    }
}
