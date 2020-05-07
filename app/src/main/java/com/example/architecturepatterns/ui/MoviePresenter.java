package com.example.architecturepatterns.ui;

import com.example.architecturepatterns.model.MovieModel;

public class MoviePresenter {
    MovieView view;

    public MoviePresenter(MovieView view) {
        this.view = view;
    }

    public MovieModel getMovieModle() {
        return new MovieModel("Fast Five", "25-12-1996", "best Movie Ever", 1);
    }

    public void getMovieName() {
        view.onGetMovieName(getMovieModle().getName());
    }
}
