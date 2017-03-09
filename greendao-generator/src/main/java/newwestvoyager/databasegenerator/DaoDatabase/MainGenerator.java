package newwestvoyager.databasegenerator.DaoDatabase;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {
    public static void main (String args[]) throws Exception {

        final Schema schema = new Schema (1, "a00961774.comp3717.bcit.ca.newwestvoyager.database.schema");

        Entity words        = schema.addEntity ("Words");

        words.addIdProperty   ();

        words.addStringProperty ("word").notNull ();

        new DaoGenerator ().generateAll (schema, "./app/src/main/java");
    }
}