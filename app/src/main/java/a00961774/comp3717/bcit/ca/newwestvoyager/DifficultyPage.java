package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.os.Build.VERSION_CODES.M;

public class DifficultyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_difficulty_page);
    }

    public void onClickMainMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(intent);
    }

    public void onClickGamePage(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), Game.class);
        startActivity(intent);
    }
}
