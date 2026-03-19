package aegon.chrome.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = new Object();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface FileProviderUtil {
        Uri getContentUriFromFile(File file);
    }

    private ContentUriUtils() {
    }

    public static void setFileProviderUtil(FileProviderUtil fileProviderUtil) {
        synchronized (sLock) {
            sFileProviderUtil = fileProviderUtil;
        }
    }

    public static Uri getContentUriFromFile(File file) {
        synchronized (sLock) {
            FileProviderUtil fileProviderUtil = sFileProviderUtil;
            if (fileProviderUtil == null) {
                return null;
            }
            return fileProviderUtil.getContentUriFromFile(file);
        }
    }

    public static int openContentUriForRead(String str) throws IOException {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }

    public static boolean contentUriExists(String str) throws IOException {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        boolean z = assetFileDescriptor != null;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
        return z;
    }

    public static String getMimeType(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri uri = Uri.parse(str);
        if (isVirtualDocument(uri)) {
            String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
            if (streamTypes == null || streamTypes.length <= 0) {
                return null;
            }
            return streamTypes[0];
        }
        return contentResolver.getType(uri);
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String str) throws IOException {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri uri = Uri.parse(str);
        try {
            if (isVirtualDocument(uri)) {
                String[] streamTypes = contentResolver.getStreamTypes(uri, "*/*");
                if (streamTypes != null && streamTypes.length > 0) {
                    AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, streamTypes[0], null);
                    if (assetFileDescriptorOpenTypedAssetFileDescriptor == null || assetFileDescriptorOpenTypedAssetFileDescriptor.getStartOffset() == 0) {
                        return assetFileDescriptorOpenTypedAssetFileDescriptor;
                    }
                    try {
                        assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                    throw new SecurityException("Cannot open files with non-zero offset type.");
                }
            } else {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, t.k);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    return new AssetFileDescriptor(parcelFileDescriptorOpenFileDescriptor, 0L, -1L);
                }
            }
        } catch (FileNotFoundException e) {
            android.util.Log.w(TAG, "Cannot find content uri: " + str, e);
        } catch (SecurityException e2) {
            android.util.Log.w(TAG, "Cannot open content uri: " + str, e2);
        } catch (Exception e3) {
            android.util.Log.w(TAG, "Unknown content uri: " + str, e3);
        }
        return null;
    }

    public static String getDisplayName(Uri uri, Context context, String str) throws Exception {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex(str);
                        if (columnIndex == -1) {
                            if (cursorQuery != null) {
                                $closeResource(null, cursorQuery);
                            }
                            return "";
                        }
                        String string = cursorQuery.getString(columnIndex);
                        if (hasVirtualFlag(cursorQuery) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                            string = string + "." + extensionFromMimeType;
                        }
                        if (cursorQuery != null) {
                            $closeResource(null, cursorQuery);
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                $closeResource(null, cursorQuery);
            }
        } catch (NullPointerException unused) {
        }
        return "";
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

    public static String maybeGetDisplayName(String str) {
        try {
            String displayName = getDisplayName(Uri.parse(str), ContextUtils.getApplicationContext(), "_display_name");
            if (TextUtils.isEmpty(displayName)) {
                return null;
            }
            return displayName;
        } catch (Exception e) {
            android.util.Log.w(TAG, "Cannot open content uri: " + str, e);
            return null;
        }
    }

    private static boolean isVirtualDocument(Uri uri) throws Exception {
        if (Build.VERSION.SDK_INT < 19 || uri == null || !DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), uri)) {
            return false;
        }
        try {
            Cursor cursorQuery = ContextUtils.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        boolean zHasVirtualFlag = hasVirtualFlag(cursorQuery);
                        if (cursorQuery != null) {
                            $closeResource(null, cursorQuery);
                        }
                        return zHasVirtualFlag;
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                $closeResource(null, cursorQuery);
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    private static boolean hasVirtualFlag(Cursor cursor) {
        int columnIndex;
        return Build.VERSION.SDK_INT >= 24 && (columnIndex = cursor.getColumnIndex("flags")) >= 0 && (cursor.getLong(columnIndex) & 512) != 0;
    }

    public static boolean isContentUri(String str) {
        Uri uri;
        return (str == null || (uri = Uri.parse(str)) == null || !"content".equals(uri.getScheme())) ? false : true;
    }

    public static boolean delete(String str) {
        return ContextUtils.getApplicationContext().getContentResolver().delete(Uri.parse(str), null, null) > 0;
    }
}
