package com.mohammad.mojapplication.NotaryServicesFragments;

import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mohammad.mojapplication.Communicator;
import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.Objects.Party;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

/**
 * Created by alisa on 11/19/2015.
 */
public class NotaryAddParty extends Fragment {

    private LinearLayout loAddById;
    private Button btnPicFrontMan,btnPicBackMan,btnFront,btnBack,btnAddParty;
    private Spinner spPartyTypeMan, spIdDoc,spPartyType;
    private CommunicatorService communicatorService;
    private RadioGroup rbgParty;
    private RadioButton rbMan,rbId;
    private ScrollView scrollView;
    private TextView tvPicFrontMan,tvPicBackMan,tvFront,tvBack;
    private EditText etNameAddPartyMan,etAddMobileAddPartyMan,etAddresssAddPartyMan,
                        etNIDCardAddParty;
    private int one, two;
    private MOJManager mojManager;
    private User user;
    private Party party;
    private String dir1= "";




    public void receiveExtra(int one,int two) {

        this.one = one;
        this.two = two;

    }

    public void receiveExtraFromCam(Party party,int one,int two,String dir1) {
        this.party = party;
        this.one = one;
        this.two = two;
        this.dir1 = dir1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mojManager = MOJManager.getMOJManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_services_pg_add, container, false);
        communicatorService = (CommunicatorService) getActivity();

        loAddById = (LinearLayout) v.findViewById(R.id.loAddById);
        btnPicBackMan = (Button) v.findViewById(R.id.btnPicBackMan);
        btnPicFrontMan = (Button) v.findViewById(R.id.btnPicFrontMan);
        btnFront = (Button) v.findViewById(R.id.btnFront);
        btnBack = (Button) v.findViewById(R.id.btnPicBack);
        spPartyType = (Spinner) v.findViewById(R.id.spPartyType);
        spIdDoc = (Spinner) v.findViewById(R.id.spidDoc);
        spPartyTypeMan = (Spinner) v.findViewById(R.id.spPartyTypeMan);
        rbgParty = (RadioGroup) v.findViewById(R.id.rbgParty);
        rbId = (RadioButton) v.findViewById(R.id.rbID);
        rbMan = (RadioButton) v.findViewById(R.id.rbMan);
        scrollView = (ScrollView) v.findViewById(R.id.svMan);
        tvPicFrontMan = (TextView) v.findViewById(R.id.tvPicFrontMan);
        tvPicBackMan = (TextView) v.findViewById(R.id.tvPicBackMan);
        tvFront = (TextView) v.findViewById(R.id.tvFrontPic);
        tvBack = (TextView) v.findViewById(R.id.tvBackPic);
        etNameAddPartyMan = (EditText) v.findViewById(R.id.etNameAddPartyMan);
        etAddMobileAddPartyMan = (EditText) v.findViewById(R.id.etMobileAddPartyMan);
        etAddresssAddPartyMan = (EditText) v.findViewById(R.id.etAddressAddPartyMan);
        etNIDCardAddParty = (EditText) v.findViewById(R.id.etNidCardAddParty);
        btnAddParty = (Button) v.findViewById(R.id.btnAddtolist);


        if (!dir1.equals("")) {
            tvFront.setText(dir1);
        }

        btnFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communicatorService.PartyToCam(party,one,two);
            }
        });


        scrollView.setVisibility(View.GONE);
        loAddById.setVisibility(View.VISIBLE);



        rbgParty.check(R.id.rbID);
        if(rbgParty.getCheckedRadioButtonId() == R.id.rbID)
        {
            btnAddParty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user = mojManager.findUserById(getActivity().getIntent().getStringExtra("userID"));
                    Party party = new Party("123", user.getName(), spPartyType.getSelectedItem().toString()
                            , user.getMobile(), user.getAddress(),null,null);
                    communicatorService.backFromAdd(party, one, two);

                }
            });

        }


        rbgParty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbID) {
                    scrollView.setVisibility(View.GONE);
                    loAddById.setVisibility(View.VISIBLE);
                    btnAddParty.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            user = mojManager.findUserById(getActivity().getIntent().getStringExtra("userID"));


                            Party party = new Party("123", user.getName(), spPartyType.getSelectedItem().toString()
                                    , user.getMobile(), user.getAddress(),null,null);
                            communicatorService.backFromAdd(party, one, two);
                        }
                    });
                } else if (checkedId == R.id.rbMan) {
                    scrollView.setVisibility(View.VISIBLE);
                    loAddById.setVisibility(View.GONE);
                    btnAddParty.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Party party = new Party("123", etNameAddPartyMan.getText().toString()
                                    , spPartyTypeMan.getSelectedItem().toString()
                                    , etAddMobileAddPartyMan.getText().toString(),
                                    etAddresssAddPartyMan.getText().toString(),null,null);
                            communicatorService.backFromAdd(party, one, two);

                        }
                    });

                }
            }
        });





            return v;
    }

}


