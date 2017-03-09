package a00961774.comp3717.bcit.ca.newwestvoyager;

import android.content.Intent;
import android.content.CursorLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import android.database.Cursor;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;

import a00961774.comp3717.bcit.ca.newwestvoyager.database.DatabaseHelper;

public class StartMenu extends AppCompatActivity {

    ArrayList <String> file = new ArrayList <> ();
    private Cursor wordsCursor;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide application title
        setContentView(R.layout.activity_start_menu);
        setupDb ();

        getLoaderManager ().initLoader (0, null, new StartMenu.WordsLoaderCallbacks());
    }

    public void setupDb () {
        helper = DatabaseHelper.getInstance (this);
        helper.openDatabaseForWriting (this);
        new AsyncTaskRunnerAdd ().execute ();
    }

    public void randomiseUsername (final View view) {
        new AsyncTaskRunnerRandomize (). execute ();
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

    private class AsyncTaskRunnerRandomize extends AsyncTask <String, Void, Void> {

        protected Void doInBackground (final String... params) {
            if (file.size () > 0) {
                Random random = new Random();

                String rUsername = "";
                int max = random.nextInt(3);
                for (int i = 0; i <= max; ++i)
                    rUsername += file.get(random.nextInt(file.size()));

                final String fullyRandomisedUsername = rUsername;

                runOnUiThread(new Runnable() {
                    public void run() {
                        ((EditText) findViewById(R.id.usernameTextField)).setText(fullyRandomisedUsername);
                    }
                });
            }
            return null;
        }

        protected void onPostExecute (Void result) {

        }
    }

    private class AsyncTaskRunnerAdd extends AsyncTask <Void, Void, Void> {

        protected Void doInBackground (final Void... params) {
            if (helper.getNumberOfWords () == 0)
                try {
                    BufferedReader reader = new BufferedReader (new InputStreamReader(getAssets ().open ("randomWords.txt")));
                    String line;
                    while ((line = reader.readLine()) != null)
                        file = new ArrayList <> (Arrays.asList ((line.toLowerCase ()).split (" ")));
                    for (String word : file)
                        helper.createWord (word);
                } catch (IOException e) {
                    Log.d ("Broken :p", "Send Help. :p");
                }
            return null;
        }

        protected void onPostExecute (Void results) {
        }
    }

    private class AsyncTaskRunnerFetch extends AsyncTask <Void, Void, Void> {

        protected Void doInBackground (final Void... params) {
            if (wordsCursor != null)
                for(wordsCursor.moveToFirst(); !wordsCursor.isAfterLast(); wordsCursor.moveToNext())
                    file.add(wordsCursor.getString(1));

            return null;
        }

        protected void onPostExecute (Void results) {
        }
    }

    private class WordsLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            return new CursorLoader (StartMenu.this, WordsContentProvider.WORDS_URI, null, null, null, null);
        }

        @Override
        public void onLoadFinished(final Loader<Cursor> loader,
                                   final Cursor         data)
        {
            wordsCursor = data;
            new AsyncTaskRunnerFetch ().execute ();
        }

        @Override
        public void onLoaderReset(final Loader<Cursor> loader) { }
    }
}