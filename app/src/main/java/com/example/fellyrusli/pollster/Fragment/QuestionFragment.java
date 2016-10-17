package com.example.fellyrusli.pollster.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fellyrusli.pollster.R;

/**
 * Created by fellyrusli on 10/15/2016.
 */
public class QuestionFragment extends Fragment {
    EditText question;
    Button submitQuestion;
    TextView toggleInstruction;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.question_fragment, container, false);

        question = (EditText) view.findViewById(R.id.student_question);
        submitQuestion = (Button) view.findViewById(R.id.submit_question);
        toggleInstruction = (TextView) view.findViewById(R.id.toggle_instruction);

        toggleInstruction.setText("Toggle this switch to let your \n instructor know that you're lost.");

        return view;
    }
}
