package com.onesmoke.db.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.onesmoke.base.AppApplaction;
import com.onesmoke.db.image.ImageTable;
import com.onesmoke.db.machine.EquipmentTable;
import com.onesmoke.db.product.ProductTable;
import com.onesmoke.db.systemvalue.SystemValueTable;
import com.onesmoke.db.video.Video;
import com.onesmoke.db.video.VideoTable;

/**
 */
public class MainBaseDBHelper extends BaseDBHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "onesmoke.db";
    private static Singleton<MainBaseDBHelper> sInstance = new Singleton<MainBaseDBHelper>() {
        @Override
        protected MainBaseDBHelper newInstance() {
            return new MainBaseDBHelper(AppApplaction.getmContext(), DATABASE_NAME, DATABASE_VERSION);
        }
    };


    public static MainBaseDBHelper getInstance() {
        return sInstance.getInstance();
    }

    MainBaseDBHelper(Context context, String databaseName, int version) {
        super(context, databaseName, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // MainBaseDBHelper.getInstance().onCreate(db);
        ProductTable.cursoreate(db);
        ImageTable.cursoreate(db);
        VideoTable.cursoreate(db);
        EquipmentTable.cursoreate(db);
        SystemValueTable.cursoreate(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 数据库版本更新，不用加break
        switch (oldVersion) {
            case 1:
                upgradeFrom1To2(db);
            case 2:
                upgradeFrom1To2(db);
            case 3:
                upgradeFrom1To2(db);
        }
    }

    /**
     * from 5.1 to 5.2, add News Topic
     */
    private void upgradeFrom1To2(SQLiteDatabase db) {

    }
}
