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

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MovieView {
    @BindView(R.id.textView)
    TextView movieNameTV;
    @BindView(R.id.bottom)
    Button getMovieButton;
    MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMovieButton.setOnClickListener(this);
        moviePresenter = new MoviePresenter(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bottom) {
           moviePresenter.getMovieName();
        }
    }

    @Override
    public void onGetMovieName(String movieName) {
        movieNameTV.setText(movieName);
    }
}
