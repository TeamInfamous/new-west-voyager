package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
    }

    /*
    Function() to go back to 'Start Menu' page.
     */
    public void onClickHowToPlay(final View view) {
        this.finish();
    }
}