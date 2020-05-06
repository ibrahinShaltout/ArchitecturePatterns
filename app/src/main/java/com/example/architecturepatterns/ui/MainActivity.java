package com.example.architecturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.architecturepatterns.model.MovieModel;
import com.example.architecturepatterns.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textView)
    TextView movieNameTV;
    @BindView(R.id.bottom)
    Button getMovieButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMovieButton.setOnClickListener(this);
    }

    public MovieModel getMovieModle() {
        return new MovieModel("Fast Five", "25-12-1996", "best Movie Ever", 1);
    }

    public void getMovie() {
        movieNameTV.setText(getMovieModle().getName());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bottom) {
            getMovie();
        }
    }
}
