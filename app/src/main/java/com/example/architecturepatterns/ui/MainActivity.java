package com.example.architecturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.architecturepatterns.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textView)
    TextView movieNameTV;
    @BindView(R.id.bottom)
    Button getMovieButton;
    MovieViewModle movieViewModle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getMovieButton.setOnClickListener(this);

        movieViewModle = ViewModelProviders.of(this).get(MovieViewModle.class);
        movieViewModle.movieNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                movieNameTV.setText(s);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bottom) {
            movieViewModle.getMovieName();
        }
    }
}
