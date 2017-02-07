package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent;
        final String username;
        final String mainMenu;

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_how_to_play);

        // Created welcome toast message displaying username entry
        intent = getIntent();
        username = intent.getStringExtra("username");
        mainMenu = intent.getStringExtra("from main menu");
        // Display toast message if not coming from the main menu
        if (!"main menu".equalsIgnoreCase(mainMenu)) {
            Toast.makeText(this, username, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickContinueToLeaderboards(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), Leaderboards.class);
        startActivity(intent);
    }

    public void onClickMainMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(intent);
    }

    public void onClickDemoLevel(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), DemoLevel.class);
        startActivity(intent);
    }
}
