package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectLevel2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_level2);
    }

    public void onClickMainMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(intent);
    }

    public void onClickSelectLevel1(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), SelectLevel.class);
        startActivity(intent);
    }

    public void onClickSelectLevel3(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), SelectLevel3.class);
        startActivity(intent);
    }

    public void onClickDifficultyPage(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), DifficultyPage.class);
        startActivity(intent);
    }
}
