package com.example.architecturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.architecturepatterns.R;
import com.example.architecturepatterns.databinding.ActivityMainBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    MovieViewModle movieViewModle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewModle.getMovieName();
            }
        });
        movieViewModle = ViewModelProviders.of(this).get(MovieViewModle.class);
        movieViewModle.movieNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textView.setText(s);
            }
        });
    }
}
