package com.softwarica.assignment3;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment implements View.OnClickListener {
private EditText fname,lname,txtdob,username,password;
private Button btnregister;
SharedPreferences shared;
private SharedPreferences.Editor editor;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_register, container, false);
        initiate(view);


        return view;
    }

    public void initiate(View view){
        fname= view.findViewById(R.id.firstname);
        lname=view.findViewById(R.id.lastname);
        txtdob=view.findViewById(R.id.dob);
        username=view.findViewById(R.id.txtusername);
        password=view.findViewById(R.id.pwpassword);
        btnregister=view.findViewById(R.id.btnregister);

        btnregister.setOnClickListener(this);
        shared=getActivity().getSharedPreferences("register", Context.MODE_PRIVATE);
        editor=shared.edit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnregister:
                if (!TextUtils.isEmpty(fname.getText().toString())||!TextUtils.isEmpty(lname.getText().toString())||!TextUtils.isEmpty(txtdob.getText().toString())
                        ||!TextUtils.isEmpty(username.getText().toString())||!TextUtils.isEmpty(password.getText().toString())){
              String firstname=fname.getText().toString();
              String lastname=lname.getText().toString();
              String dob=txtdob.getText().toString();
              String user=username.getText().toString();
              String pass=password.getText().toString();
              editor.putString("FirstName",firstname);
              editor.putString("LastName",lastname);
              editor.putString("DOB",dob);
              editor.putString("Username",user);
              editor.putString("Password",pass);
              editor.commit();
              Toast.makeText(getActivity(),"You are registered",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Please complete the following form",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
