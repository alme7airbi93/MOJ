package com.mohammad.mojapplication.RegistrationFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mohammad.mojapplication.Communicator;
import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.MainActivity;
import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;
import com.mohammad.mojapplication.RegistrationActivity;

/**
 * Created by user on 11/1/2015.
 */
public class RegStepThree extends Fragment
{
    private EditText etUserName, etPass;
    private Button btnFinish;
    private MOJManager mojManager;
    private NIDCard nidCard;
    private Communicator comm;

    public void reciveNIDCardObject(NIDCard nidCard)
    {

        this.nidCard = nidCard;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mojManager = MOJManager.getMOJManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg_step_three_layout, container, false);
        final NIDCard nidCard = this.nidCard;
        etPass = (EditText) v.findViewById(R.id.etPass);
        etUserName = (EditText) v.findViewById(R.id.etUser);
        btnFinish = (Button) v.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPass.getText().toString().equals("") && etUserName.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(),"Please fill the empty spaces",Toast.LENGTH_LONG).show();

                }else {
//
//                    User user = new User(nidCard.getId(), nidCard.getName(), nidCard.getMobile(),
//                            nidCard.getAddress(), etUserName.getText().toString(), etPass.getText().toString());
//                    mojManager.addUser(user);
//                    Toast.makeText(getActivity(),"Your Account Added",Toast.LENGTH_LONG).show();
//
//                    try{
//
//                        user = mojManager.findUserByUserName(etUserName.getText().toString());
//                        String pass = user.getPass().toString();
//                        if(user != null)
//                        {
//                            if(pass.equals(etPass.getText().toString()))
//                            {
//                                comm.sendUsertoMainActivity(user);
//                            }else
//                            {
//                                Toast.makeText(getActivity(),etPass.getText().toString() +" password incorrect" + pass,Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }
//                    catch (NullPointerException npe)
//                    {
//                        Toast.makeText(getActivity(),"Username or password incorrect",Toast.LENGTH_LONG).show();
//                    }

                }
            }
        });


        return v;
    }


}
