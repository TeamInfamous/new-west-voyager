package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Random;

public class StartMenu extends AppCompatActivity {

    ArrayList <String> file = new ArrayList <String> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide application title
        setContentView(R.layout.activity_start_menu);
    }

    private void dictionary () {
        try {
            BufferedReader reader = new BufferedReader (new InputStreamReader(getAssets ().open ("randomWords.txt")));
            String line;
            while ((line = reader.readLine()) != null)
                file = new ArrayList <String> (Arrays.asList ((line.toLowerCase ()).split (" ")));
        } catch (Exception e) {
            Log.d ("Broken :p", "Send Help. :p");
        }
    }

    public void randomiseUsername (final View view) {
        Random random   = new Random ();
        if (file.size () == 0)
            dictionary ();

        String   rUsername = "";
        int max = random.nextInt (3);

        String[] arr = file.toArray (new String [0]);

        for (int i = 0; i <= max; i++)
            rUsername += arr [random.nextInt (arr.length)];

        ((EditText)findViewById (R.id.usernameTextField)).setText (rUsername);

    }

    public void onClick_startMenuToHowToPlay (View view) {

        EditText usernameEntry = (EditText) findViewById(R.id.usernameTextField);

        if (usernameEntry.getText ().toString () == null || usernameEntry.getText ().toString ().isEmpty() ||
                usernameEntry.getText ().toString ().length () == 0)
            (Toast.makeText (this, "Username field empty!", Toast.LENGTH_SHORT)).show ();
        else {
            final Intent intent            = new Intent(getApplicationContext(), HowToPlay.class);

            String welcomeUsernameToastMsg = "Welcome " + usernameEntry.getText().toString() + "!";
            intent.putExtra("username", welcomeUsernameToastMsg);
            startActivity (intent);
        }
    }
}
