package com.mohammad.mojapplication.NotaryServicesFragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.Objects.Party;

import java.io.File;

/**
 * Created by alisa on 11/25/2015.
 */
public class NotaryCamFragment extends Fragment {
    private static final int CAMERA_REQUEST = 111;
    private File output = null;
    private Party party;
    private int one, two;
    CommunicatorService communicatorService;

    public void recieveFromAddParty(Party party,int one,int two) {
        this.party = party;
        this.one = one;
        this.two = two;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        communicatorService = (CommunicatorService) getActivity();

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        output = new File(dir, "CameraDemo.jpeg");
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
        startActivityForResult(i, CAMERA_REQUEST);

        communicatorService.CamtoParty(party,one,two,Uri.fromFile(output).toString());
        return super.onCreateView(inflater, container, savedInstanceState);
    }




}
