package com.example.audi_abir.smartlock;

import android.nfc.Tag;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    Switch mySwitch = null;
    TextView tvName;

    private DatabaseReference mDatabase;
    public Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("lock");


        // [END initialize_database_ref]
//mDatabase.child("lock");
        //mDatabase.setValue("yes");

        /*b=(Button) findViewById(R.id.myb);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                mDatabase.child("lock");
                mDatabase.setValue("yes");
            }
        });*/



        setContentView(R.layout.activity_main);
        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(this);

    }
    //@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // do something when check is selected
            mDatabase.child("lock").setValue("yes");
        } else {
            //do something when unchecked
            mDatabase.child("lock").setValue("no");
        }
    }
}
