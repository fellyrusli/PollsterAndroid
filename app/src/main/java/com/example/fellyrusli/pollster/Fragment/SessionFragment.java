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

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.entity.StringEntityHC4;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by fellyrusli on 10/14/2016.
 */
public class SessionFragment extends Fragment {

    TextView question;
    RadioGroup multipleChoice;
    RadioButton choiceA, choiceB, choiceC, choiceD, choiceE;
    Button submitAnswer;
    String answer;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.session_fragment, container, false);

        question = (TextView)view.findViewById(R.id.question);
        question.setVisibility(View.INVISIBLE);
        multipleChoice = (RadioGroup)view.findViewById(R.id.multiple_choice);
        multipleChoice.setVisibility(View.INVISIBLE);
        choiceA = (RadioButton)view.findViewById(R.id.choice_a);
        choiceA.setVisibility(View.INVISIBLE);
        choiceB = (RadioButton)view.findViewById(R.id.choice_b);
        choiceB.setVisibility(View.INVISIBLE);
        choiceC = (RadioButton)view.findViewById(R.id.choice_c);
        choiceC.setVisibility(View.INVISIBLE);
        choiceD = (RadioButton)view.findViewById(R.id.choice_d);
        choiceD.setVisibility(View.INVISIBLE);
        choiceE = (RadioButton)view.findViewById(R.id.choice_e);
        choiceE.setVisibility(View.INVISIBLE);
        submitAnswer = (Button)view.findViewById(R.id.submit_answer);
        submitAnswer.setVisibility(View.INVISIBLE);

        return view;
    }

    public void setQuestion (String data) {
        if (data.equals("No Questions avalible")) {
            question.setText(data);
            question.setVisibility(View.VISIBLE);
        } else {
            question.setText("What is the question?");
            question.setVisibility(View.VISIBLE);

            multipleChoice.setVisibility(View.VISIBLE);
            choiceA.setText("A is the correct answer");
            choiceA.setVisibility(View.VISIBLE);
            if (choiceA.isSelected()) {
                answer = choiceA.getText().toString();
            }
            choiceB.setText("B is the correct answer");
            choiceB.setVisibility(View.VISIBLE);
            if (choiceB.isSelected()) {
                answer = choiceB.getText().toString();
            }
            choiceC.setText("C is the correct answer");
            choiceC.setVisibility(View.VISIBLE);
            if (choiceC.isSelected()) {
                answer = choiceC.getText().toString();
            }

            choiceD.setText("D is the correct answer");
            choiceD.setVisibility(View.VISIBLE);
            if (choiceD.isSelected()) {
                answer = choiceD.getText().toString();
            }

            choiceE.setText("E is the correct answer");
            choiceE.setVisibility(View.VISIBLE);
            if (choiceE.isSelected()) {
                answer = choiceE.getText().toString();
            }

            submitAnswer.setText("Submit Answer");
            submitAnswer.setVisibility(View.VISIBLE);
            submitAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("first click", "i'm here");

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

                            //                        JSONObject jsonObject = new JSONObject();
                            //                        try {
                            //                            jsonObject.put("student_id", "10");
                            //                            jsonObject.put("question_id", "");
                            //                            jsonObject.put("question_type", "");
                            //                            jsonObject.put("answer_data", answer);
                            //                            jsonObject.put("class_id", "");
                            //                        } catch (JSONException e) {
                            //                            e.printStackTrace();
                            //                        }
                            //
                            //                        //double for max score
                            //                        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                            //                        HttpPostHC4 httpPostHC4 = new HttpPostHC4("https://api.pollster.com/answerquestion");
                            //httpClient.execute(httpPostHC4);
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
        }
    }
}
