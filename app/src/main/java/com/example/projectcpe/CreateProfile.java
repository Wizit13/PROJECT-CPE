package com.example.projectcpe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.projectcpe.Database.REPOSITORY;

import com.example.projectcpe.Local.DATABASE;
import com.example.projectcpe.Local.DATABASEsource;

import com.example.projectcpe.ViewModel.Member;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CreateProfile extends AppCompatActivity {
Button _btSave;
EditText _etName1,_etName2,_etName4,_etName3,   _etAge1, _etAge2, _etAge3, _etAge4;

    public static final String MY_PRE_PASSWORD_MEMBER1 = "com.example.projectcpe.member1";
    public static final String MY_PRE_PASSWORD_MEMBER2 = "com.example.projectcpe.member2";
    public static final String MY_PRE_PASSWORD_MEMBER3 = "com.example.projectcpe.member3";
    public static final String MY_PRE_PASSWORD_MEMBER4 = "com.example.projectcpe.member4";

    public static final String MY_PRE_AGE_MEMBER1 = "com.example.projectcpe.agemember1";
    public static final String MY_PRE_AGE_MEMBER2 = "com.example.projectcpe.agemember2";
    public static final String MY_PRE_AGE_MEMBER3 = "com.example.projectcpe.agemember3";
    public static final String MY_PRE_AGE_MEMBER4 = "com.example.projectcpe.agemember4";



    CompositeDisposable compositeDisposable;
    private REPOSITORY repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        _btSave =  findViewById(R.id.btSave);
        _etName1 = findViewById(R.id.member1);
        _etName2 = findViewById(R.id.member2);
        _etName3 = findViewById(R.id.member3);
        _etName4 = findViewById(R.id.member4);

        _etAge1 = findViewById(R.id.etAge1);
        _etAge2 = findViewById(R.id.etAge2);
        _etAge3 = findViewById(R.id.etAge3);
        _etAge4 = findViewById(R.id.etAge4);

        ///// Initialize
        compositeDisposable = new CompositeDisposable();

        /// Database
        DATABASE adminDatabase = DATABASE.getInstance(this); //// Create Database
        repository = REPOSITORY.getInstance(DATABASEsource.getInstance(adminDatabase.dao()));

        _btSave.setOnClickListener(new View.OnClickListener() {

            String name1 = _etName1.getText().toString();
            String name2 = _etName2.getText().toString();
            String name3 = _etName3.getText().toString();
            String name4 = _etName4.getText().toString();

            String age1 = _etAge1.getText().toString();
            String age2 = _etAge2.getText().toString();
            String age3 = _etAge3.getText().toString();
            String age4 = _etAge4.getText().toString();




            @Override
            public void onClick(View v) {
                //// Add Member

                if (name1.isEmpty()){
                    Snackbar.make(_btSave, "Enter your SomeMember!", Snackbar.LENGTH_SHORT)
                            .show();
                }


                if(_etName1.getText().toString().isEmpty() || _etAge1.getText().toString().isEmpty()){
                    Snackbar.make(_etName1, "Plese enter your password for Admin !", Snackbar.LENGTH_SHORT).show();
                }else {
                    /// MEMBER1
                    SharedPreferences.Editor member1 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER1, MODE_PRIVATE).edit();
                    member1.putString("Mname1", _etName1.getText().toString());
                    member1.commit();

                    SharedPreferences.Editor age1 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                    member1.putString("Aname1",_etAge1.getText().toString()) ;
                    member1.commit();

                    /// MEMBER2
                    SharedPreferences.Editor member2 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER2, MODE_PRIVATE).edit();
                    member2.putString("Mname2", _etName2.getText().toString());
                    //member2.putInt("Mage2", Integer.parseInt(age2));
                    member2.commit();

                    SharedPreferences.Editor age2 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                    member1.putString("Aname2",_etAge2.getText().toString()) ;
                    member1.commit();

                    /// MEMBER3
                    SharedPreferences.Editor member3 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER3, MODE_PRIVATE).edit();
                    member3.putString("Mname3",_etName3.getText().toString());
                    //member3.putInt("Mage3", Integer.parseInt(age3));
                    member3.commit();

                    SharedPreferences.Editor age3 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                    member1.putString("Aname3",_etAge3.getText().toString()) ;
                    member1.commit();

                    /// MEMBER4
                    SharedPreferences.Editor member4 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER4, MODE_PRIVATE).edit();
                    member4.putString("Mname4", _etName4.getText().toString());
                   // member4.putInt("Mage4", Integer.parseInt(age4));
                    member4.commit();

                    SharedPreferences.Editor age4 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                    member1.putString("Aname4",_etAge4.getText().toString()) ;
                    member1.commit();




                    startActivity(new Intent(CreateProfile.this, FunctionEditProfile.class));
                }

//                        userList.add(user);
            }
        });


    }

//    private void loadData() {
//
//        Disposable disposable = repository.getAllMember()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Consumer<List<Admin>>() {
//                    @Override
//                    public void accept(List<Admin> users) throws Exception {
//                      //  onGetAllUserSuccess(users);
//                    }
//
//
//                } , new Consumer<Throwable>(){
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                        Toast.makeText(CreateProfile.this, ""+ throwable.getMessage(),Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//        compositeDisposable.add(disposable);
//    }

}
