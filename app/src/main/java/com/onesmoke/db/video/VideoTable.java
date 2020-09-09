package com.onesmoke.db.video;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.TextUtils;

import com.onesmoke.db.base.MainBaseDBHelper;

import java.util.ArrayList;

/**
 * 数据库处理
 * 对各个数据库的处理
 */
public class VideoTable {
    public static final int MAX_SIZE_PREFETCH_LIST = 10;

    private static final String TABLE_NAME = "video";

    public static class VideoColumns implements BaseColumns {
        /**
         * sort default
         */
        public static final String DEFAULT_SORT_ORDER = "_id DESC";
        public static final String product_name = "productname";
        public static final String product_daysum = "productdaysum";
        public static final String product_total = "producttotal";
        public static final String product_id = "productid";
        public static final String product_createdTime = "productcreatedtime";
        public static final String product_imgUrl = "productimgurl";
        public static final String equipmentbase = "equipmentbase";
        public static final String equipmenthost = "equipmenthost";
        public static final String prematchimgurl = "prematchImgurl";
        public static final String prematchProductname = "prematchproductname";
        public static final String productMess = "productmess";
        public static final String lackProduct = "lackProduct";
        public static final String shelfState = "shelfState";
    }

    public static void cursoreate(SQLiteDatabase sqlitedatabase) {
        if (sqlitedatabase == null) {
            return;
        }
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + VideoColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VideoColumns.product_name + " TEXT,"
                + VideoColumns.product_daysum + " TEXT,"
                + VideoColumns.product_total + " TEXT,"
                + VideoColumns.product_id + " INTEGER ,"
                + VideoColumns.product_createdTime + " Long ,"
                + VideoColumns.product_imgUrl + " TEXT,"
                + VideoColumns.equipmentbase + " TEXT,"
                + VideoColumns.equipmenthost + " TEXT,"
                + VideoColumns.prematchimgurl + " TEXT,"
                + VideoColumns.prematchProductname + " TEXT,"
                + VideoColumns.productMess + " TEXT,"
                + VideoColumns.lackProduct + " TEXT,"
                + VideoColumns.shelfState + " TEXT"
                + ");");
    }


    public static void insertItem(ContentValues values) {

        MainBaseDBHelper.getInstance().insert(TABLE_NAME, values);
    }

    public static String queryBestReplaceID(int path) {

        Cursor cursor = null;
        try {
            cursor = MainBaseDBHelper.getInstance().query(TABLE_NAME, new String[]{VideoColumns._ID},
                    VideoColumns.shelfState + " = ?", new String[]{Integer.toString(path)},
                    VideoColumns.shelfState + " ASC, " + VideoColumns.shelfState + " ASC");
            if (cursor != null && cursor.getCount() < 10) {
                return null;
            } else if (cursor != null && cursor.moveToFirst() && cursor.getCount() >= 20) {
                return Long.toString(cursor.getLong(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
        return null;
    }

    public static void updateItem(ContentValues values, String selection,
                                  String[] selectionArgs) {

        MainBaseDBHelper.getInstance().update(TABLE_NAME, values, selection, selectionArgs);
    }

    public static void delete() {

        MainBaseDBHelper.getInstance().delete(TABLE_NAME, null, null);
    }

    public static String[] queryGetSameExists(String host, int path) {

        Cursor cursor = null;
        try {
            cursor = MainBaseDBHelper.getInstance().query(TABLE_NAME, new String[]{
                    VideoColumns._ID,
                    VideoColumns.shelfState}, VideoColumns.shelfState + " = ? AND "
                    + VideoColumns.shelfState + " = ? ", new String[]{host, Integer.toString(path)}, null);
            if (cursor != null && cursor.moveToFirst()) {
                return new String[]{Long.toString(cursor.getLong(0)), Integer.toString(cursor.getInt(1))};
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
        return null;
    }

    public static boolean queryIsSameExists(String host, int path) {

        Cursor cursor = null;
        try {
            cursor = MainBaseDBHelper.getInstance().query(TABLE_NAME, null, VideoColumns.shelfState + " = ? AND "
                    + VideoColumns.shelfState + " = ? ", new String[]{host, Integer.toString(path)}, null);
            if (cursor != null && cursor.moveToFirst()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
        return false;
    }

    public static ArrayList<String> queryList(int path) {

        Cursor cursor = null;
        ArrayList<String> prefetchList = new ArrayList<String>();
        try {
            cursor = MainBaseDBHelper.getInstance().query(TABLE_NAME,
                    new String[]{VideoColumns.shelfState}, VideoColumns.shelfState + " = ?",
                    new String[]{Integer.toString(path)}, VideoColumns.shelfState + " DESC, "
                            + VideoColumns.shelfState + " DESC");
            if (cursor != null && cursor.moveToFirst()) {
                int num = 0;
                do {
                    String hostname = cursor.getString(0);
                    if (!TextUtils.isEmpty(hostname)) {
                        prefetchList.add(hostname);
                    }
                    num++;
                } while (cursor != null && cursor.moveToNext() && num < MAX_SIZE_PREFETCH_LIST);
            }
        } catch (Throwable e) {
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
        return prefetchList;
    }

}
