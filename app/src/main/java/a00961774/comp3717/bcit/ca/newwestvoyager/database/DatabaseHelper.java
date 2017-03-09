package a00961774.comp3717.bcit.ca.newwestvoyager.database;

/**
 * Created by Yudhvir on 2017-02-11.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import a00961774.comp3717.bcit.ca.newwestvoyager.database.schema.DaoMaster;
import a00961774.comp3717.bcit.ca.newwestvoyager.database.schema.DaoSession;
import a00961774.comp3717.bcit.ca.newwestvoyager.database.schema.Words;
import a00961774.comp3717.bcit.ca.newwestvoyager.database.schema.WordsDao;

public class DatabaseHelper
{
    private final static String TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper          instance;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private WordsDao   wordsDao;
    private        DaoMaster.DevOpenHelper helper;

    private DatabaseHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static DatabaseHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseHelper(context);
        }

        return (instance);
    }

    public static DatabaseHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private void openDatabase()
    {
        daoMaster  = new DaoMaster (db);
        daoSession = daoMaster.newSession ();
        wordsDao   = daoSession.getWordsDao ();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                "NewWestVoyager.db",
                null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                "NewWestVoyager.db",
                null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public Words getWordByObjectName(final String nm)
    {
        final List<Words> words;
        final Words       word;

        words = wordsDao.queryBuilder().where(WordsDao.Properties.Word.eq(nm)).limit(1).list();

        if(words.isEmpty())
        {
            word = null;
        }
        else
        {
            word = words.get(0);
        }

        return (word);
    }

    public Words createWord (final String name) {
        if (getWordByObjectName (name) != null)
            return null;

        final Words data;

        data = new Words (null, name);

        wordsDao.insertOrReplace (data);

        return data;
    }

    public Words getWordFromCursor (final Cursor cursor)
    {
        final Words word;

        word = wordsDao.readEntity(cursor,
                0);

        return (word);
    }

    public List<Words> getWords()
    {
        return (wordsDao.loadAll());
    }

    public Cursor getWordsCursor ()
    {
        final Cursor cursor;

        cursor = db.query(wordsDao.getTablename(),
                wordsDao.getAllColumns(),
                null,
                null,
                null,
                null,
                null);

        return (cursor);
    }
    public static void upgrade(final Database db,
                               final int      oldVersion,
                               final int      newVersion)
    {
    }

    public void deleteAll () {
        db.execSQL("delete from "+ "Words");
    }

    public long getNumberOfWords () { return (wordsDao.count ()); }
}
