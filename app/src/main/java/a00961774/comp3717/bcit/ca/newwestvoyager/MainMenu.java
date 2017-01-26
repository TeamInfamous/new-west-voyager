package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_menu);
    }

    public void onClick_mainMenuToStartMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), StartMenu.class);
        startActivity(intent);
    }

    public void onClick_mainMenuToHowToPlay(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), HowToPlay.class);
        startActivity(intent);
    }

    public void onClick_mainMenuToLeaderboards(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), Leaderboards.class);
        startActivity(intent);
    }

    public void onClick_mainMenuToSelectLevel(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), SelectLevel.class);
        startActivity(intent);
    }
}
