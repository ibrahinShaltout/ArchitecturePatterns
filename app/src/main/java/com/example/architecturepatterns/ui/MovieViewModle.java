package com.example.architecturepatterns.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architecturepatterns.model.MovieModel;

public class MovieViewModle extends ViewModel {

    MutableLiveData movieNameMutableLiveData = new MutableLiveData();

    private MovieModel getMovieModle() {
        return new MovieModel("Fast Five", "25-12-1996", "best Movie Ever", 1);
    }


    public void getMovieName() {
        String movieName = getMovieModle().getName();
        movieNameMutableLiveData.setValue(movieName);
    }

}
