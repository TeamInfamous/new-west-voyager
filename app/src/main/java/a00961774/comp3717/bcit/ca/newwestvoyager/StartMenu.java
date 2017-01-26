package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start_menu);
    }

    public void onClick_startMenuToHowToPlay(View view) {
        final Intent intent;
        EditText usernameEntry;
        String welcomeUsernameToastMsg;

        usernameEntry = (EditText)findViewById(R.id.usernameTextField);
        intent = new Intent(getApplicationContext(), HowToPlay.class);

        welcomeUsernameToastMsg = "Welcome " + usernameEntry.getText().toString() + "!";
        intent.putExtra("username", welcomeUsernameToastMsg);
        startActivity(intent);
    }
}
