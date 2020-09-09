package com.onesmoke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;

import com.onesmoke.db.base.BaseDBHelper;
import com.onesmoke.db.image.ImageTable;
import com.onesmoke.db.product.Product;
import com.onesmoke.db.product.ProductTable;
import com.onesmoke.db.systemvalue.SystemValueTable;
import com.onesmoke.db.video.VideoTable;

/**
 *项目主界面
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ProductDBHelper.getInstance();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductTable.ProductColumns.equipmentbase, "host");
        contentValues.put(ProductTable.ProductColumns.equipmenthost, "count");
        contentValues.put(ProductTable.ProductColumns.prematchimgurl, "time");
        contentValues.put(ProductTable.ProductColumns.prematchProductname, "path");
        ProductTable.insertItem(contentValues);

        //ProductTable.delete(ProductTable.ProductColumns._ID + " > ? ", new String[]{"5"});


        contentValues = new ContentValues();
        contentValues.put(ImageTable.ImageColumns.equipmentbase, "host");
        contentValues.put(ImageTable.ImageColumns.equipmenthost," 1");
        contentValues.put(ImageTable.ImageColumns.lackProduct, "(long)1");
        contentValues.put(ImageTable.ImageColumns.product_daysum, 1);
        ImageTable.insertItem(contentValues);



        contentValues = new ContentValues();
        contentValues.put(ImageTable.ImageColumns.equipmentbase, "host");
        contentValues.put(ImageTable.ImageColumns.equipmenthost," 1");
        contentValues.put(ImageTable.ImageColumns.lackProduct, "(long)1");
        contentValues.put(ImageTable.ImageColumns.product_daysum, 1);
        VideoTable.insertItem(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ImageTable.ImageColumns.equipmentbase, "host");
        contentValues.put(ImageTable.ImageColumns.equipmenthost," 1");
        contentValues.put(ImageTable.ImageColumns.lackProduct, "(long)1");
        contentValues.put(ImageTable.ImageColumns.product_daysum, 1);
        SystemValueTable.insertItem(contentValues);
    }
}
