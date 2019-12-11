package com.example.projectcpe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class FunctionEditProfile extends AppCompatActivity {

    public static final String MY_PRE_PASSWORD_MEMBER1 = "com.example.projectcpe.member1";
    public static final String MY_PRE_PASSWORD_MEMBER2 = "com.example.projectcpe.member2";
    public static final String MY_PRE_PASSWORD_MEMBER3 = "com.example.projectcpe.member3";
    public static final String MY_PRE_PASSWORD_MEMBER4 = "com.example.projectcpe.member4";

    public static final String MY_PRE_AGE_MEMBER1 = "com.example.projectcpe.agemember1";
    public static final String MY_PRE_AGE_MEMBER2 = "com.example.projectcpe.agemember2";
    public static final String MY_PRE_AGE_MEMBER3 = "com.example.projectcpe.agemember3";
    public static final String MY_PRE_AGE_MEMBER4 = "com.example.projectcpe.agemember4";

    ImageView impro1, impro2, impro3, impro4;
    TextView txtpro1, txtpro2, txtpro3, txtpro4, txtage1, txtage2, txtage3, txtage4;
    ViewGroup layout1, layout2, layout3, layout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_edit_profile);

        Initia();

        SharedPreferences getMember1 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER1, MODE_PRIVATE);
        SharedPreferences getMember2 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER2, MODE_PRIVATE);
        SharedPreferences getMember3 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER3, MODE_PRIVATE);
        SharedPreferences getMember4 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER4, MODE_PRIVATE);

        SharedPreferences getAge1 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE);
        SharedPreferences getAge2 = getSharedPreferences(MY_PRE_AGE_MEMBER2, MODE_PRIVATE);
        SharedPreferences getAge3 = getSharedPreferences(MY_PRE_AGE_MEMBER3, MODE_PRIVATE);
        SharedPreferences getAge4 = getSharedPreferences(MY_PRE_AGE_MEMBER4, MODE_PRIVATE);

        /// MEMBER 1
        String getName1 = "";
        String Age1 = "";
        String name1 = getMember1.getString("Mname1", getName1);
        String aname1 = getAge1.getString("Aname1", Age1);

        Toast.makeText(getApplicationContext(), aname1,Toast.LENGTH_SHORT).show();

        /// MEMBER 2
        String getName2 = "";
        String Age2 = "";
        String name2 = getMember2.getString("Mname2", getName2);
        String aname2 = getAge2.getString("Aname2", Age2);

        /// MEMBER 3
        String getName3 = "";
        String Age3 = "";
        String name3 = getMember3.getString("Mname3", getName3);
        String aname3 = getAge3.getString("Aname3", Age3);

        /// MEMBER 4
        String getName4 = "";
        String Age4 = "";
        String name4 = getMember4.getString("Mname4", getName4);
        String aname4 = getAge4.getString("Aname4", Age4);


        txtpro1.setText(name1);
        txtpro2.setText(name2);
        txtpro3.setText(name3);
        txtpro4.setText(name4);

        txtage1.setText(" Age: "+aname1);
        txtage2.setText(" Age: "+aname2);
        txtage3.setText(" Age: "+aname3);
        txtage4.setText(" Age: "+aname4);

        layout1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) { TranformerGarbag();ChooseMember();
                return true;
            }
        });

        layout2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TranformerGarbag();
                    ChooseMember();

                return true;
            }


        });

        layout3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) { TranformerGarbag();ChooseMember();
                return true;
            }
        });

        layout4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) { TranformerGarbag();ChooseMember();
                return true;
            }
        });


        //////////////// MEMBER 1 //////////////////
        if (txtpro1 == null || txtpro1.getText().toString().isEmpty()) {
            layout1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unable));
            layout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(FunctionEditProfile.this);
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.frameline);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.addmember_dialog);
                    dialog.setCancelable(true);

                    final EditText _etName = dialog.findViewById(R.id.etname);
                    final EditText _etAge = dialog.findViewById(R.id.etage);

                    Button btSubmit = (Button)dialog.findViewById(R.id.ChooseGallary);
                    btSubmit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (_etName.getText().toString().isEmpty()) {
                                _etName.setError("Name is required");
                                _etName.requestFocus();
                                return;
                            }else{
                                SharedPreferences.Editor newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER1, MODE_PRIVATE).edit();
                                newPass.putString("Mname1", _etName.getText().toString());
                                newPass.commit();

                                SharedPreferences.Editor newAge = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                                newAge.putString("Aname1", String.valueOf(_etAge.getText()));
                                newAge.commit();
                                startActivity(new Intent(FunctionEditProfile.this, FunctionEditProfile.class));
                                finish();

                            }
                        }
                    });
                    dialog.show();
//                    Intent i = new Intent(FunctionEditProfile.this, addmember.class);
//                    i.putExtra("Num", 1);
//                    i.putExtra("m", "member1");
//                    startActivity(i);
//                    finish();

                }
            });
        } else {
            findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FunctionEditProfile.this, HomePage.class);
//                            Intent i2 = new Intent(MenageProfile.this, DispPersonal.class);
//                            i2.putExtra("NameUser", profile1.getText());
//                            i2.putExtra("Num", 1);
                    i.putExtra("NameUser", txtpro1.getText());
                    i.putExtra("Num", 1);
                    i.putExtra("Age", txtage1.getText().toString());
                    startActivity(i);
//                    finish();



                }
            });

        }

        /////////////// MEMBER 2 /////////////////
        if (txtpro2 == null || txtpro2.getText().toString().isEmpty()) {
            layout2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unable));
            layout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(FunctionEditProfile.this);
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.frameline);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.addmember_dialog);
                    dialog.setCancelable(true);




                    final Button btSubmit = dialog.findViewById(R.id.ChooseGallary);
                    final EditText _etName = dialog.findViewById(R.id.etname);
                    final EditText _etAge = dialog.findViewById(R.id.etage);
                    btSubmit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {


                            if (_etName.getText().toString().isEmpty()) {
                                _etName.setError("Name is required");
                                _etName.requestFocus();
                                return;
                            }else{
                                SharedPreferences.Editor newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER2, MODE_PRIVATE).edit();
                                newPass.putString("Mname2", _etName.getText().toString());
                                newPass.commit();

                                SharedPreferences.Editor newAge = getSharedPreferences(MY_PRE_AGE_MEMBER2, MODE_PRIVATE).edit();
                                newAge.putString("Aname2", String.valueOf(_etAge.getText()));
                                newAge.commit();

                                startActivity(new Intent(FunctionEditProfile.this, FunctionEditProfile.class));
                                finish();
                            }


                        }
                    });
                    dialog.show();
//                    Intent i = new Intent(FunctionEditProfile.this, addmember.class);
//                    i.putExtra("Num", 1);
//                    i.putExtra("m", "member1");
//                    startActivity(i);
//                    finish();

                }
            });
        } else {

            findViewById(R.id.layout2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FunctionEditProfile.this, HomePage.class);
//                            Intent i2 = new Intent(MenageProfile.this, DispPersonal.class);
//                            i2.putExtra("NameUser", profile1.getText());
//                            i2.putExtra("Num", 1);
                    i.putExtra("NameUser", txtpro2.getText());
                    i.putExtra("Num", 2);
                    i.putExtra("Age", txtage2.getText().toString());
                    startActivity(i);



                }
            });

        }

        //////////////// MEMBER 3 ///////////////////
        if (txtpro3 == null || txtpro3.getText().toString().isEmpty()) {
            layout3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unable));
            layout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(FunctionEditProfile.this);
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.frameline);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.addmember_dialog);
                    dialog.setCancelable(true);

                    final EditText _etName = dialog.findViewById(R.id.etname);
                    final EditText _etAge = dialog.findViewById(R.id.etage);

                    Button btSubmit = (Button)dialog.findViewById(R.id.ChooseGallary);
                    btSubmit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (_etName.getText().toString().isEmpty()) {
                                _etName.setError("Name is required");
                                _etName.requestFocus();
                                return;
                            }else{
                                SharedPreferences.Editor newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER3, MODE_PRIVATE).edit();
                                newPass.putString("Mname3", _etName.getText().toString());
                                newPass.commit();

                                SharedPreferences.Editor newAge = getSharedPreferences(MY_PRE_AGE_MEMBER3, MODE_PRIVATE).edit();
                                newAge.putString("Aname3", String.valueOf(_etAge.getText()));
                                newAge.commit();
                                startActivity(new Intent(FunctionEditProfile.this, FunctionEditProfile.class));
                                finish();

                            }
                        }
                    });
                    dialog.show();
//                    Intent i = new Intent(FunctionEditProfile.this, addmember.class);
//                    i.putExtra("Num", 1);
//                    i.putExtra("m", "member1");
//                    startActivity(i);
//                    finish();

                }
            });
        } else {

            findViewById(R.id.layout3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FunctionEditProfile.this, HomePage.class);
//                            Intent i2 = new Intent(MenageProfile.this, DispPersonal.class);
//                            i2.putExtra("NameUser", profile1.getText());
//                            i2.putExtra("Num", 1);
                    i.putExtra("NameUser", txtpro3.getText());
                    i.putExtra("Num", 3);
                    i.putExtra("Age", txtage3.getText().toString());
                    startActivity(i);


                }
            });

        }
        //////////////// MEMBER 4 ///////////////////
        if (txtpro4 == null || txtpro4.getText().toString().isEmpty()) {
            layout4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.unable));
            layout4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Dialog dialog = new Dialog(FunctionEditProfile.this);
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.frameline);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.addmember_dialog);
                    dialog.setCancelable(true);

                    final EditText _etName = dialog.findViewById(R.id.etname);
                    final EditText _etAge = dialog.findViewById(R.id.etage);

                    Button btSubmit = (Button)dialog.findViewById(R.id.ChooseGallary);
                    btSubmit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (_etName.getText().toString().isEmpty()) {
                                _etName.setError("Name is required");
                                _etName.requestFocus();
                                return;
                            }else{
                                SharedPreferences.Editor newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER4, MODE_PRIVATE).edit();
                                newPass.putString("Mname4", _etName.getText().toString());
                                newPass.commit();

                                SharedPreferences.Editor newAge = getSharedPreferences(MY_PRE_AGE_MEMBER4, MODE_PRIVATE).edit();
                                newAge.putString("Aname4", String.valueOf(_etAge.getText()));
                                newAge.commit();
                                startActivity(new Intent(FunctionEditProfile.this, FunctionEditProfile.class));
                                finish();

                            }
                        }
                    });
                    dialog.show();
//                    Intent i = new Intent(FunctionEditProfile.this, addmember.class);
//                    i.putExtra("Num", 1);
//                    i.putExtra("m", "member1");
//                    startActivity(i);
//                    finish();

                }
            });
        } else {

            findViewById(R.id.layout4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FunctionEditProfile.this, HomePage.class);
//                            Intent i2 = new Intent(MenageProfile.this, DispPersonal.class);
//                            i2.putExtra("NameUser", profile1.getText());
//                            i2.putExtra("Num", 1);
                    i.putExtra("NameUser", txtpro4.getText());
                    i.putExtra("Num", 4);
                    i.putExtra("Age", txtage4.getText().toString());
                    startActivity(i);



                }
            });

        }
    }

    private void ChooseMember() {
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Askconfirm("member1");
            }


        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Askconfirm("member2");
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Askconfirm("member3");
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Askconfirm("member4");
            }
        });
    }

    private void Askconfirm(final String member) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {


                switch (choice) {
                    case DialogInterface.BUTTON_POSITIVE:
                        SharedPreferences.Editor newPass;
                        SharedPreferences.Editor newAge;
                        Map<String, Object> childUpdates = new HashMap<>();
                        switch (member) {
                            case "member1" :
                                newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER1, MODE_PRIVATE).edit();
                                newPass.putString("Mname1", null);
                                newPass.commit();

                                newAge = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE).edit();
                                newAge.putString("Aname1", null);
                                newAge.commit();

                                break;
                            case "member2" :
                                newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER2, MODE_PRIVATE).edit();
                                newPass.putString("Mname2", null);
                                newPass.commit();

                                newAge = getSharedPreferences(MY_PRE_AGE_MEMBER2, MODE_PRIVATE).edit();
                                newAge.putString("Aname2", null);
                                newAge.commit();

                                break;
                            case "member3" :
                                newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER3, MODE_PRIVATE).edit();
                                newPass.putString("Mname3", null);
                                newPass.commit();

                                newAge = getSharedPreferences(MY_PRE_AGE_MEMBER3, MODE_PRIVATE).edit();
                                newAge.putString("Aname3", null);
                                newAge.commit();

                                break;
                            case "member4" :
                                newPass = getSharedPreferences(MY_PRE_PASSWORD_MEMBER4, MODE_PRIVATE).edit();
                                newPass.putString("Mname4", null);
                                newPass.commit();

                                newAge = getSharedPreferences(MY_PRE_AGE_MEMBER4, MODE_PRIVATE).edit();
                                newAge.putString("Aname4", null);
                                newAge.commit();

                                break;

                        }


                        ReResult();

                        startActivity(new Intent(FunctionEditProfile.this, FunctionEditProfile.class));
                        finish();

                        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        ReResult();

                        break;

                }


            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete this member")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ReResult();
                    }
                }).show();
    }

    private void ReResult() {
        impro1.setImageResource(R.drawable.user1);
        impro2.setImageResource(R.drawable.user2);
        impro3.setImageResource(R.drawable.user3);
        impro4.setImageResource(R.drawable.user4);

    }

    private void TranformerGarbag() {
        if (txtpro1 == null || txtpro1.getText().toString().isEmpty()){

        }else{impro1.setImageResource(R.drawable.delete);
        }

        if (txtpro2 == null || txtpro2.getText().toString().isEmpty()){

        }else{impro2.setImageResource(R.drawable.delete);}

        if (txtpro3 == null || txtpro3.getText().toString().isEmpty()){

        }else{impro3.setImageResource(R.drawable.delete);}

        if (txtpro4 == null || txtpro4.getText().toString().isEmpty()){

        }else{impro4.setImageResource(R.drawable.delete);}



    }


    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences getMember1 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER1, MODE_PRIVATE);
        SharedPreferences getMember2 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER2, MODE_PRIVATE);
        SharedPreferences getMember3 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER3, MODE_PRIVATE);
        SharedPreferences getMember4 = getSharedPreferences(MY_PRE_PASSWORD_MEMBER4, MODE_PRIVATE);

        SharedPreferences getAge1 = getSharedPreferences(MY_PRE_AGE_MEMBER1, MODE_PRIVATE);
        SharedPreferences getAge2 = getSharedPreferences(MY_PRE_AGE_MEMBER2, MODE_PRIVATE);
        SharedPreferences getAge3 = getSharedPreferences(MY_PRE_AGE_MEMBER3, MODE_PRIVATE);
        SharedPreferences getAge4 = getSharedPreferences(MY_PRE_AGE_MEMBER4, MODE_PRIVATE);



        /// MEMBER 1
        String getName1 = "";
        String Age1 = "";
        String name1 = getMember1.getString("Mname1", getName1);
        String age1 = getAge1.getString("Aname1", Age1);

        /// MEMBER 2
        String getName2 = "";
        String Age2 = "";
        String name2 = getMember2.getString("Mname2", getName2);
        String age2 = getAge2.getString("Aname2", Age2);

        /// MEMBER 3
        String getName3 = "";
        String Age3 = "";
        String name3 = getMember3.getString("Mname3", getName3);
        String age3 = getAge3.getString("Aname3", Age3);

        /// MEMBER 4
        String getName4 = "";
        String Age4 = "";
        String name4 = getMember4.getString("Mname4", getName4);
        String age4 = getAge4.getString("Aname4", Age3);


        txtpro1.setText(name1);
        txtpro2.setText(name2);
        txtpro3.setText(name3);
        txtpro4.setText(name4);

        txtage1.setText(age1);
        txtage2.setText(age2);
        txtage3.setText(age3);
        txtage4.setText(age4);


    }

    private void Initia() {

        impro1 = findViewById(R.id.imUser1);
        impro2 = findViewById(R.id.imUser2);
        impro3 = findViewById(R.id.imUser3);
        impro4 = findViewById(R.id.imUser4);

        txtpro1 = findViewById(R.id.profile1);
        txtpro2 = findViewById(R.id.profile2);
        txtpro3 = findViewById(R.id.profile3);
        txtpro4 = findViewById(R.id.profile4);

        txtage1 = findViewById(R.id.age1);
        txtage2 = findViewById(R.id.age2);
        txtage3 = findViewById(R.id.age3);
        txtage4 = findViewById(R.id.age4);


        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);




    }
}
