package com.mohammad.mojapplication.mainActivityFragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by user on 11/28/2015.
 */
public class SettingsDialogFragment extends DialogFragment
{

    public static final String EXTRA_PASS = "com.mohammad.settingDialogFragment.EXTRA_PASS";
    private EditText etOldPassword,etNewPassword,etReEnterNewPassword;

    private String userId,oldPassword,pass,newPass,reEnteredPass;
    private Button btnSubmitPass,btnCancel;
    private  AlertDialog dialog;
    private MOJManager mojManager;
    private User user;
    private TextView tvSettingsDialogTitle,tvChangePass,tvNewPass,tvReEnterPass,tvIncorrectInfo;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mojManager = MOJManager.getMOJManager(getActivity());
        int mode = getArguments().getInt("mode");
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.settings_dialog_fragment, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        dialog = builder.setView(v).create();

        tvIncorrectInfo = (TextView) v.findViewById(R.id.tvIncorrectInfo);
        btnSubmitPass = (Button) v.findViewById(R.id.btnSubmitPass);
        btnCancel = (Button) v.findViewById(R.id.btnCancel);
        tvChangePass = (TextView) v.findViewById(R.id.tvChangePass);
        tvNewPass = (TextView) v.findViewById(R.id.tvNewPassword);
        tvReEnterPass = (TextView) v.findViewById(R.id.tvReenterPassword);
        tvSettingsDialogTitle = (TextView) v.findViewById(R.id.tvSettingsDialogTitle);

        etOldPassword = (EditText) v.findViewById(R.id.etOldPassword);
        etNewPassword = (EditText) v.findViewById(R.id.etNewPassword);
        etReEnterNewPassword = (EditText) v.findViewById(R.id.etReenterPassword);
        userId = getArguments().getString("userID");


        if(mode == 0)
        {
            doMode0(v,userId);
        }else if (mode == 1) {
            doMode1(v,userId);
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });

        return dialog;

    }

    private void doMode1(View v,String userId) {

        user = mojManager.findUserById(userId);
        oldPassword = user.getPass();
        tvSettingsDialogTitle.setText("Settings :");
        tvSettingsDialogTitle.setText(oldPassword);
        tvChangePass.setText("Enter your password :");
        tvNewPass.setText("Enter your new number:");
        pass = etOldPassword.getText().toString().trim();
        newPass = etNewPassword.getText().toString();
        tvReEnterPass.setVisibility(View.GONE);
        etReEnterNewPassword.setVisibility(View.GONE);


        btnSubmitPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etOldPassword.getText().toString().equals(oldPassword)) {
                    user.setMobile(newPass);
                    mojManager.update(user);
                    dialog.hide();
                }
                else
                {
                    tvIncorrectInfo.setText("Incorrect password !!!");
                    return;
                }

            }
        });

    }

    private void doMode0(View v,String userId) {

        user = mojManager.findUserById(userId);
        oldPassword = user.getPass();
        tvSettingsDialogTitle.setText("Settings :");
        pass = etOldPassword.getText().toString();
        newPass = etNewPassword.getText().toString();
        reEnteredPass = etReEnterNewPassword.getText().toString();

        btnSubmitPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.equals(oldPassword) && !pass.equals("")) {
                    if (newPass.equals(reEnteredPass)) {
                        user.setPass(etNewPassword.getText().toString());
                        mojManager.update(user);
                        dialog.hide();

                    } else {

                        tvIncorrectInfo.setText("Passwords does not match!");
                        return;
                    }
                }else
                {
                    tvIncorrectInfo.setText("Incorrect information written!");
                    return;
                }

            }
        });


    }

}
