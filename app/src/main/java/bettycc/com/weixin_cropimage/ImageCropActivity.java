package bettycc.com.weixin_cropimage;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bettycc.cropimage.library.CropView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class ImageCropActivity extends ActionBarActivity {

    private CropView mCropView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);
        mCropView = (CropView) findViewById(R.id.crop);

        Uri data = getIntent().getData();

        InputStream is = null;
        Bitmap bitmap1 = null;
        try {
            is = getContentResolver().openInputStream(data);
            bitmap1 = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
        }

        mCropView.setImageBitmap(bitmap1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_clip) {
            Bitmap bitmap = mCropView.getCropedBitmap();
            Uri uri = (Uri) getIntent().getParcelableExtra(MediaStore.EXTRA_OUTPUT);
            writeBitmapToFile(bitmap, new File(uri.getPath()));
            setResult(RESULT_OK, getIntent());
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void writeBitmapToFile(Bitmap bitmap, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
