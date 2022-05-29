package qc.bdeb.randomontreal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BucketListElementHandler extends DataBaseHelper{
    public BucketListElementHandler(Context context) {
        super(context);
    }

    //CRUD

    public boolean create(BucketListElement bucketListElement) {

        ContentValues values = new ContentValues();

        values.put("title", bucketListElement.getTitle());
        values.put("description", bucketListElement.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean isSuccessfull = db.insert("BucketListTable ", null, values) > 0;
        db.close();
        return isSuccessfull;
    }

    public ArrayList<BucketListElement> readBucketList() {
        ArrayList<BucketListElement> bucketListElementsList = new ArrayList<>();

        String sqlQuery = "SELECT * FROM BucketListTable ORDER BY id ASC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String description= cursor.getString(2);
                BucketListElement bucketListElement= new BucketListElement(id,title, description);
//                bucketListElement.setId(id);
                bucketListElementsList.add(bucketListElement);
            } while (cursor.moveToNext());

            cursor.close();
            db.close();
        }
        return bucketListElementsList;
    }
    public BucketListElement readOneBucketListElement(int id) {
        BucketListElement bucketListElement = null;
        String sqlQuery = "SELECT * FROM BucketListTable  WHERE id=" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            int elementId = cursor.getInt(0);
            String title = cursor.getString(1);
            String description= cursor.getString(2);

            bucketListElement= new BucketListElement(elementId,title, description);

        }
        cursor.close();
        db.close();
        return bucketListElement;
    }
    public boolean update(BucketListElement bucketListElement) {

        ContentValues values = new ContentValues();
        values.put("title", bucketListElement.getTitle());
        values.put("description", bucketListElement.getDescription());
        SQLiteDatabase db = this.getWritableDatabase();
        boolean isSuccessfull = db.update("BucketListTable", values, "id='" + bucketListElement.getId() + "'", null) > 0;
        db.close();
        return isSuccessfull;
    }

    public boolean delete(int id) {
        boolean isDeleted;
        SQLiteDatabase db = this.getWritableDatabase();
        isDeleted = db.delete("BucketListTable", "id='" + id + "'", null) > 0;
        db.close();
        return isDeleted;
    }





}//End of the class
