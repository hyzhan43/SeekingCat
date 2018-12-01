package zqx.rj.com.utils;

import android.graphics.Bitmap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * author：  HyZhan
 * create：  2018/12/1 10:22
 * desc：    TODO
 */
public class UtilTools {

    // bitmap  -> file
    public static File bitmapToFile(Bitmap bm, String path, String fileName) {

        try {
            File dirFile = new File(path);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }

            File myCaptureFile = new File(path, fileName);
            BufferedOutputStream bos;

            bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
            bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);

            bos.flush();
            bos.close();

            return myCaptureFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    // file -> MultipartBody.Part
    public static MultipartBody.Part fileToMultipartBody(File file, String key) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);

        return MultipartBody.Part.createFormData(key, file.getName(), requestFile);
    }
}
