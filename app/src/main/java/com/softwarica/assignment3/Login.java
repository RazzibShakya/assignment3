package com.softwarica.assignment3;


import android.content.Context;
import android.content.Intent;
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
public class Login extends Fragment implements View.OnClickListener {
private EditText username,password;
private Button btnlogin;
SharedPreferences sharedpreference;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        initiate(view);
        return view;
    }

    public void initiate(View view){
        sharedpreference=getActivity().getSharedPreferences("register", Context.MODE_PRIVATE);
        username=view.findViewById(R.id.username);
        password=view.findViewById(R.id.password);
        btnlogin=view.findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnLogin){
            if(!TextUtils.isEmpty(username.getText().toString())||!TextUtils.isEmpty(password.getText().toString())){
              String shareduser=sharedpreference.getString("Username","");
              String sharedpass=sharedpreference.getString("Password","");
              if(((username.getText().toString()).equals(shareduser)) && ((password.getText().toString()).equals(sharedpass))){
                  Toast.makeText(getActivity(),"You are successfully logged in",Toast.LENGTH_SHORT).show();
                  Intent intent=new Intent(this.getActivity(),Dashboard_activity.class);
                  startActivity(intent);
              }else{
                  Toast.makeText(getActivity(),"Your username and password does not match",Toast.LENGTH_SHORT).show();
              }
            }
        }
    }
}
