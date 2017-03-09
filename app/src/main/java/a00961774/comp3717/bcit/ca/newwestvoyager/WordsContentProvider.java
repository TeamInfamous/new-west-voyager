package a00961774.comp3717.bcit.ca.newwestvoyager;

/**
 * Created by Yudhvir on 2017-02-12.
 */

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import a00961774.comp3717.bcit.ca.newwestvoyager.database.DatabaseHelper;

public class WordsContentProvider
        extends ContentProvider
{
    private static final UriMatcher uriMatcher;
    private static final int WORDS_URI_INT = 1;
    public  static final Uri WORDS_URI;
    private DatabaseHelper helper;

    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI ("a00961774.comp3717.bcit.ca.newwestvoyager.database.schema", "/Words", WORDS_URI_INT);
    }

    static
    {
        WORDS_URI = Uri.parse ("content://a00961774.comp3717.bcit.ca.newwestvoyager.database.schema/Words");
    }

    @Override
    public boolean onCreate()
    {
        helper = DatabaseHelper.getInstance(getContext());
        return true;
    }

    @Override
    public Cursor query(final Uri uri,
                        final String[] projection,
                        final String selection,
                        final String[] selectionArgs,
                        final String sortOrder)
    {
        final Cursor cursor;

        switch (uriMatcher.match(uri))
        {

            case WORDS_URI_INT:
            {
                helper.openDatabaseForReading(getContext());
                cursor = helper.getWordsCursor();
                helper.close();
                break;
            }

            default:
            {
                throw new IllegalArgumentException("Unsupported URI: " + uri);
            }
        }

        return (cursor);
    }

    @Override
    public String getType(final Uri uri)
    {
        final String type;

        switch(uriMatcher.match(uri))
        {
            case WORDS_URI_INT:
                type = "vnd.android.cursor.dir/vnd.a00961774.comp3717.bcit.ca.newwestvoyager.database.schema.Words";
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        return (type);
    }

    @Override
    public int delete(final Uri uri,
                      final String selection,
                      final String[] selectionArgs)
    {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(final Uri uri,
                      final ContentValues values)
    {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(final Uri uri,
                      final ContentValues values,
                      final String selection,
                      final String[]      selectionArgs)
    {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
