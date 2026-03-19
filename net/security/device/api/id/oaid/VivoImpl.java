package net.security.device.api.id.oaid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.alipay.sdk.m.p0.b;
import com.alipay.sdk.m.p0.c;
import java.util.Objects;
import net.security.device.api.id.IOAID;
import net.security.device.api.id.IOAIDGetter;
import net.security.device.api.id.SystemUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class VivoImpl implements IOAID {
    private final Context context;

    public VivoImpl(Context context) {
        this.context = context;
    }

    @Override // net.security.device.api.id.IOAID
    public boolean supportOAID() {
        return SystemUtils.sysProperty(c.c, "0").equals("1");
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
            Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            if (uri != null && (contentResolver = this.context.getContentResolver()) != null && (cursorQuery = contentResolver.query(uri, null, null, null, null)) != null) {
                ((Cursor) Objects.requireNonNull(cursorQuery)).moveToFirst();
                string = cursorQuery.getString(cursorQuery.getColumnIndex(b.d));
            }
            if (string != null && string.length() > 0) {
                iOAIDGetter.onOAIDGetComplete(string);
                return;
            }
            throw new RuntimeException("OAID query failed");
        } catch (Exception e) {
            iOAIDGetter.onOAIDGetError(e);
        }
    }
}
