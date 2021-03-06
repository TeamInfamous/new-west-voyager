package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_level);

        // TextView textInfo = (TextView)findViewById(R.id.levelOneInfo);
        // textInfo.setText("Name of level 1\nHigh Scores\nUser\nScore");
    }

    public void onClickMainMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(intent);
    }

    public void onClickSelectLevel2(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), SelectLevel2.class);
        startActivity(intent);
    }

    public void onClickDifficultyPage(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), DifficultyPage.class);
        startActivity(intent);
    }
}
