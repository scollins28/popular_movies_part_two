package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by scoll on 27/02/2018.
 */

public class Film implements Parcelable {

    //Private Strings of all movie variables
    private String mMovieName;
    private String mMovieReleaseDate;
    private int mMovieRating;
    private String mMovieSummary;
    private String mFilmImageUrl;
    private String mMovieID;
    private String mYoutubeOne = "test";
    private String mYoutubeTwo = "test";
    private String mMovieReview = "Default";
    private String mAuthorOne;
    private String mReviewOne;
    private String mAuthorTwo;
    private String mReviewTwo;

    //Basic constructor requiring all the variables of the movie.
    Film (String movieName, String movieReleaseDate, int movieRating, String movieSummary, String filmUrl, String movieID, String youtubeOne,
          String youtubeTwo, String authorOne, String reviewOne, String authorTwo, String reviewTwo){
        mMovieName = movieName;
        mMovieReleaseDate = movieReleaseDate;
        mMovieRating = movieRating;
        mMovieSummary = movieSummary;
        mFilmImageUrl = filmUrl;
        mMovieID = movieID;
        mYoutubeOne = youtubeOne;
        mYoutubeTwo = youtubeTwo;
        mAuthorOne = authorOne;
        mAuthorTwo = authorTwo;
        mReviewOne = reviewOne;
        mReviewTwo = reviewTwo;
    }

    protected Film(Parcel in) {
        mMovieName = in.readString();
        mMovieReleaseDate = in.readString();
        mMovieRating = in.readInt();
        mMovieSummary = in.readString();
        mFilmImageUrl = in.readString();
        mMovieID = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film( in );
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    //Function to retrieve the movie name
    public String getMovieName (){
        return mMovieName;
    }

    //Function to retrieve the movie release date
    public String getmMovieReleaseDate (){
        return mMovieReleaseDate;
    }

    //Function to retrieve the movie rating
    public int getMovieRating (){return mMovieRating;}

    //Function to retrieve the movie summary
    public String getMovieSummary (){
        return mMovieSummary;
    }

    //Function to retrieve the movie summary
    public String getMovieImageUrl (){
        return mFilmImageUrl;
    }

    //Function to retrieve the movie ID
    public String getMovieID () {return  mMovieID;}

    //Function to retrieve the movie Reviews
    public String getMovieReview () {return  mMovieReview;}

    //Function to retrieve the movie YoutubeOne
    public String getMovieYoutubeOne () {return  mYoutubeOne;}

    //Function to retrieve the movie YoutubeTwo
    public String getMovieYoutubeTwo() {return  mYoutubeTwo;}

    public String getMovieAuthorOne() {return  mAuthorOne;}

    public String getAuthorTwo() {return  mAuthorTwo;}

    public String getReviewOne() {return  mReviewOne;}

    public String getReviewTwo() {return  mReviewTwo;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( mMovieName );
        dest.writeString( mMovieReleaseDate );
        dest.writeInt( mMovieRating );
        dest.writeString( mMovieSummary );
        dest.writeString( mFilmImageUrl );
        dest.writeString (mMovieID);
    }

    public String findYoutubeIdQueryBuilder (){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(R.string.findYoutubeIdQueryBuilderPartOne);
        stringBuilder.append(mMovieID);
        stringBuilder.append(R.string.findYoutubeIdQueryBuilderPartTwo);
        stringBuilder.append((BuildConfig.API_KEY).toString());
        return stringBuilder.toString();
        }

}
