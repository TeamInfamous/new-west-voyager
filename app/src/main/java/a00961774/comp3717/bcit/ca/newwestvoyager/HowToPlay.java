package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent;
        final String username;

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_how_to_play);

        // Created welcome toast message displaying username entry
        intent = getIntent();
        username = intent.getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_LONG).show();
    }

    /*
    Function to go back to 'Start Menu' page.
     */
    public void onClickStartMenu(final View view) {
        this.finish();
    }

    /*
    Function to navigate to 'Leaderboards' page from 'How to Play' page.
     */
    public void onClickContinueToLeaderboards(final View view) {
        final Intent intent;

        intent = new Intent(getApplicationContext(), Leaderboards.class);
        startActivity(intent);
    }

    public void onClickPlay (final View view) {
        final Intent intent;

        intent = new Intent (getApplicationContext (), Game.class);
        startActivity (intent);
    }
}
