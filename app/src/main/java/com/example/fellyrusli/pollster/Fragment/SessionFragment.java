package com.example.fellyrusli.pollster.Fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.fellyrusli.pollster.R;

/**
 * Created by fellyrusli on 10/14/2016.
 */
public class SessionFragment extends Fragment {

    TextView question;
    RadioGroup multipleChoice;
    RadioButton choiceA, choiceB, choiceC, choiceD, choiceE;
    Button submitAnswer;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.session_fragment, container, false);

        question = (TextView)view.findViewById(R.id.question);
        multipleChoice = (RadioGroup)view.findViewById(R.id.multiple_choice);
        choiceA = (RadioButton)view.findViewById(R.id.choice_a);
        choiceB = (RadioButton)view.findViewById(R.id.choice_b);
        choiceC = (RadioButton)view.findViewById(R.id.choice_c);
        choiceD = (RadioButton)view.findViewById(R.id.choice_d);
        choiceE = (RadioButton)view.findViewById(R.id.choice_e);
        submitAnswer = (Button)view.findViewById(R.id.submit_answer);

        question.setText("What is the question?");

        multipleChoice.setVisibility(View.VISIBLE);
        choiceA.setText("A is the correct answer");
        choiceB.setText("B is the correct answer");
        choiceC.setText("C is the correct answer");
        choiceD.setText("D is the correct answer");
        choiceE.setText("E is the correct answer");

        submitAnswer.setText("Submit Answer");
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("first click", "i'm here");
//                int chosenId = multipleChoice.getCheckedRadioButtonId();
//                String chosenAnswer = "";
//                switch (chosenId) {
//                    case R.id.choice_a:
//                        chosenAnswer = "a";
//                        break;
//                    case R.id.choice_b:
//                        chosenAnswer = "b";
//                        break;
//                    case R.id.choice_c:
//                        chosenAnswer = "c";
//                        break;
//                    case R.id.choice_d:
//                        chosenAnswer = "d";
//                        break;
//                    case R.id.choice_e:
//                        chosenAnswer = "e";
//                        break;
//                }

                final AlertDialog.Builder alert_box = new AlertDialog.Builder(getActivity());
//                alert_box.setMessage("Are you sure you want to submit " + chosenAnswer + " as your answer?");
                alert_box.setMessage("Are you sure you want to submit your answer?");
                alert_box.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("on second click", "i'm here");
                        AlertDialog.Builder answer_alert = new AlertDialog.Builder(getActivity());
                        answer_alert.setMessage("Your answer has been recorded.");
                        answer_alert.show();
                        dialog.dismiss();
                        multipleChoice.setClickable(false);
                        submitAnswer.setEnabled(false);
                    }
                });
                alert_box.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alert_box.create();
                alertDialog.show();
            }
        });

        return view;
    }
}
