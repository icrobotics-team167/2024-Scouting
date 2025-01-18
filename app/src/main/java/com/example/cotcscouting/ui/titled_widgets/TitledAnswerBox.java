package com.example.cotcscouting.ui.titled_widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;;

public class TitledAnswerBox extends FrameLayout {

    private FrameLayout rlRootLayout;
    private TextView title;
    private EditText answer;

    private String titleText = "";
    private String answerText = "";

    public TitledAnswerBox(@NonNull Context context) {
        super(context);
    }

    public TitledAnswerBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TitledAnswerBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
