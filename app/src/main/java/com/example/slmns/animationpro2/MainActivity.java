package com.example.slmns.animationpro2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imglogo, imgprofil;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imglogo = (ImageView) findViewById(R.id.imgLogo);
        imgprofil = (ImageView) findViewById(R.id.photo);
        textView = (TextView) findViewById(R.id.tvSharedElement);
    }


    public void CheckRippleAnimation(View view) {
        startActivity(new Intent(this,RippleActivity.class));

    }

    public void sharedElementTransition(View view) {

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View,String>(imglogo,"logo_shared");
        pair[1] = new Pair<View,String>(imgprofil,"profile_pic_shared");
        pair[2] = new Pair<View,String>(textView,"share_shared");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent intent = new Intent(MainActivity.this, SharedElementActivity.class);
        startActivity(intent,options.toBundle());
    }

    public void ExplodeTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.ExplodeJava);
        intent.putExtra(Constants.Key_Titel, "Explode by Java");
        startActivity(intent, options.toBundle());

    }

    public void ExplodeTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.ExplodeXML);
        intent.putExtra(Constants.Key_Titel, "Explode by XML");
        startActivity(intent, options.toBundle());


    }

    public void SlideTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.SlideJava);
        intent.putExtra(Constants.Key_Titel, "Slide by Java");
        startActivity(intent, options.toBundle());
    }

    public void SlideTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.SlideXML);
        intent.putExtra(Constants.Key_Titel, "Slide by XML");
        startActivity(intent, options.toBundle());
    }

    public void FadeTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.FadeJava);
        intent.putExtra(Constants.Key_Titel, "Fade by Java");
        startActivity(intent, options.toBundle());
    }

    public void FadeTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_Anim_Type, Constants.TransitionType.FadeXmL);
        intent.putExtra(Constants.Key_Titel, "Fade by XML");
        startActivity(intent, options.toBundle());
    }
}
