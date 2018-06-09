package com.example.slmns.animationpro2;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {
    Constants.TransitionType type;
    String toolbarTitel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        initPage();
        initAnimation();

    }

    public void initPage(){
        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_Anim_Type);
        toolbarTitel = getIntent().getExtras().getString(Constants.Key_Titel);

        Button button = (Button) findViewById(R.id.back_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitel);

    }

    public boolean onSupportNavigateUp(){
        finishAfterTransition();
        return true;
    }

    private void initAnimation(){

        switch (type) {
            case ExplodeJava: {

                Explode enterTransition = new Explode();
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case ExplodeXML: {

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTransition);
                break;

            }
            case SlideJava: {

                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.BOTTOM);
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case SlideXML: {

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(enterTransition);
                break;

            }
            case FadeJava: {

                Fade enterTransition = new Fade();
                enterTransition.setDuration(1000);
                getWindow().setEnterTransition(enterTransition);
                break;

            }
            case FadeXmL: {

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(enterTransition);
                break;

            }
        }
    }
}
