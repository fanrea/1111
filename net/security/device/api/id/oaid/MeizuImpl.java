package net.security.device.api.id.oaid;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.alipay.sdk.m.p0.b;
import java.util.Objects;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class MeizuImpl implements IOAID {
    private final Context context;

    public MeizuImpl(Context context) {
        this.context = context;
    }

    @Override // net.security.device.api.id.IOAID
    public boolean supportOAID() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // net.security.device.api.id.IOAID
    public void doGet(IOAIDGetter iOAIDGetter) {
        ContentResolver contentResolver;
        Cursor cursorQuery;
        if (this.context == null) {
            iOAIDGetter.onOAIDGetError(new NullPointerException("OAID context is null"));
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            iOAIDGetter.onOAIDGetError(new RuntimeException("OAID unsupported system"));
            return;
        }
        String string = null;
        try {
            Uri uri = Uri.parse("content://com.meizu.flyme.openidsdk/");
            if (uri != null && (contentResolver = this.context.getContentResolver()) != null && (cursorQuery = contentResolver.query(uri, null, null, new String[]{"oaid"}, null)) != null) {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndex(b.d));
            }
            if (string == null || string.length() == 0) {
                throw new RuntimeException("OAID query failed");
            }
            iOAIDGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }
}
