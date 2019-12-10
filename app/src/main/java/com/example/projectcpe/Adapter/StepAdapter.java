package com.example.projectcpe.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectcpe.CreateMission.FinallyCreate;
import com.example.projectcpe.R;
import com.example.projectcpe.ViewModel.Mission;
import com.example.projectcpe.ViewModel.Step;

import java.util.List;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {


    //this context we will use to inflate the layout

    protected static LinearLayout frameEdittext;
    private Context mCtx;
    private Step[] steps;
    //we are storing all the products in a list
    public static List<Step> stepList;
    private OnCustomrPictureClick onCustomrPictureClick;
    private OnCustomrPicAddClick onCustomrPicAddClick;


    public StepAdapter(Step[] steps){
        this.steps = steps;
    }


    public StepAdapter(List<Step> c, Context ctx) {
        this.stepList = c;
        this.mCtx = ctx;
        this.onCustomrPictureClick = (StepAdapter.OnCustomrPictureClick) ctx;
//        this.onCustomerItemClick = (MissionAdapter.OnCustomerItemClick) ctx;
    }

    public StepAdapter(List<Step> steps) {
        this.stepList = steps;
    }


    @NonNull
    @Override
    public StepAdapter.StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_list, parent,false);
        return new StepViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdapter.StepViewHolder stepViewHolder, int position) {
        Step step = (Step) stepList.get(position);

//        stepViewHolder.imStep.setImageResource(step.getPhoto());
        stepViewHolder.Numstep.setText(String.valueOf(position+1));

//        stepViewHolder.add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mCtx, "add",Toast.LENGTH_SHORT).show();
//
//                ((FinallyCreate)mCtx).NewText((EditText) view);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }


    public class StepViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imStep,add;
        EditText answerStep;
        TextView Numstep;
        public LinearLayout frameEdittextthis;



        private final int CAMERA_RESULT_CODE = 100;

        public StepViewHolder(@NonNull final View itemView) {
            super(itemView);

            imStep = itemView.findViewById(R.id.imStep);
            answerStep = itemView.findViewById(R.id.answerStep);
            Numstep = itemView.findViewById(R.id.numstep);
            add = itemView.findViewById(R.id.add);
            frameEdittextthis = itemView.findViewById(R.id.frameEdittext);

            imStep.setOnClickListener(this);

            frameEdittext = this.frameEdittextthis;

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    final EditText textView = new EditText(mCtx);

                    layoutParams.setMargins(0,5,0,0);
                    layoutParams.weight = 1;

                    textView.setTypeface(ResourcesCompat.getFont(mCtx, R.font.thin));
                    textView.setLayoutParams(layoutParams);
                    textView.setTextSize(16);
                    
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackgroundResource(R.drawable.bgtext);
                    textView.setHint("Put your answer");
                    textView.setMaxEms(8);



                    frameEdittextthis.addView(textView);
                }
            });




            answerStep.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    stepList.get(getAdapterPosition()).setAnswer(answerStep.getText().toString());

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }

        @Override
        public void onClick(View v) {
            onCustomrPictureClick.oncustompictureclick(getAdapterPosition(), this.imStep);

        }





    }

    public interface OnCustomrPictureClick{

        void oncustompictureclick(int pos, ImageView imageView);
    }

    public interface OnCustomrPicAddClick{

        void oncustomaddclick(int pos, LinearLayout frame);
    }



    }

