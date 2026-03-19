package aegon.chrome.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean recursivelyDeleteFile(File file) {
        File[] fileArrListFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                recursivelyDeleteFile(file2);
            }
        }
        boolean zDelete = file.delete();
        if (!zDelete) {
            Log.e(TAG, "Failed to delete: %s", file);
        }
        return zDelete;
    }

    public static void batchDeleteFiles(List<String> list) {
        for (String str : list) {
            if (ContentUriUtils.isContentUri(str)) {
                ContentUriUtils.delete(str);
            } else {
                File file = new File(str);
                if (file.exists()) {
                    recursivelyDeleteFile(file);
                }
            }
        }
    }

    public static boolean extractAsset(Context context, String str, File file) throws Exception {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                copyStreamToFile(inputStreamOpen, file);
                if (inputStreamOpen == null) {
                    return true;
                }
                $closeResource(null, inputStreamOpen);
                return true;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void copyStreamToFile(InputStream inputStream, File file) throws Exception {
        File file2 = new File(file.getPath() + ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            Log.i(TAG, "Writing to %s", file);
            copyStream(inputStream, fileOutputStream);
            $closeResource(null, fileOutputStream);
            if (!file2.renameTo(file)) {
                throw new IOException();
            }
        } finally {
        }
    }

    public static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Uri getUriForFile(File file) {
        Uri contentUriFromFile;
        try {
            contentUriFromFile = ContentUriUtils.getContentUriFromFile(file);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
            contentUriFromFile = null;
        }
        return contentUriFromFile == null ? Uri.fromFile(file) : contentUriFromFile;
    }

    public static String getExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1).toLowerCase(Locale.US);
    }

    public static Bitmap queryBitmapFromContentProvider(Context context, Uri uri) throws Exception {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.k);
            try {
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    Log.w(TAG, "Null ParcelFileDescriptor from uri " + uri, new Object[0]);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        $closeResource(null, parcelFileDescriptorOpenFileDescriptor);
                    }
                    return null;
                }
                FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                if (fileDescriptor == null) {
                    Log.w(TAG, "Null FileDescriptor from uri " + uri, new Object[0]);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        $closeResource(null, parcelFileDescriptorOpenFileDescriptor);
                    }
                    return null;
                }
                Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                if (bitmapDecodeFileDescriptor != null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        $closeResource(null, parcelFileDescriptorOpenFileDescriptor);
                    }
                    return bitmapDecodeFileDescriptor;
                }
                Log.w(TAG, "Failed to decode image from uri " + uri, new Object[0]);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    $closeResource(null, parcelFileDescriptorOpenFileDescriptor);
                }
                return null;
            } finally {
            }
        } catch (IOException unused) {
            Log.w(TAG, "IO exception when reading uri " + uri, new Object[0]);
            return null;
        }
    }
}
