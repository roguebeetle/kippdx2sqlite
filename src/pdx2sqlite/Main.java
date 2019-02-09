package pdx2sqlite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] argv) throws ParseException, IOException, FileNotFoundException, SQLException, ClassNotFoundException {

        Db db = new Db();
        DbSQLite dbsql = new DbSQLite();

        db.dbFileDel();
        db.createSQLiteTables();
        db.cloneParadoxAddressDataToList();
        db.cloneAddressDataToSQLiteObjects();
        db.cloneParadoxDataToList();
        db.cloneDataListToSQLiteObjects();
        dbsql.fillNill();
        dbsql.cloneSQLiteAddressDataToList();
        dbsql.cloneSQLiteDataToList();
        dbsql.clearTable();
        dbsql.createPSQLTables();
        dbsql.cloneAddressDataToPSQLObjects();
        dbsql.cloneDataListToPSQLObjects();
        //db.selectParadoxB00001();
        //db.selectParadoxB00003();
        //dbsql.selectObjects();
    }
}