package com.kwad.tachikoma.e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private ContentResolver mContentResolver;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void a(ContentResolver contentResolver) {
        this.mContentResolver = contentResolver;
    }

    public final V8Object a(String str, V8Array v8Array, String str2, V8Array v8Array2, String str3) {
        if (this.mContentResolver == null) {
            return null;
        }
        try {
            Cursor cursorQuery = this.mContentResolver.query(Uri.parse(str), a(v8Array), str2, a(v8Array2), str3);
            V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdCursor");
            c cVar = new c(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
            cVar.setCursor(cursorQuery);
            v8ObjectProxy.setNativeObject(cVar);
            return v8ObjectProxy;
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            return null;
        }
    }

    public final String b(String str, V8Object v8Object) {
        if (this.mContentResolver == null || v8Object == null) {
            return null;
        }
        try {
            return this.mContentResolver.insert(Uri.parse(str), g(v8Object)).toString();
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            return null;
        }
    }

    public final int a(String str, String str2, V8Array v8Array) {
        if (this.mContentResolver == null) {
            return 0;
        }
        try {
            return this.mContentResolver.delete(Uri.parse(str), str2, a(v8Array));
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            return 0;
        }
    }

    public final int a(String str, V8Object v8Object, String str2, V8Array v8Array) {
        if (this.mContentResolver == null) {
            return 0;
        }
        try {
            return this.mContentResolver.update(Uri.parse(str), g(v8Object), str2, a(v8Array));
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            return 0;
        }
    }

    private static ContentValues g(V8Object v8Object) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry entry : v8Object.getAll().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                contentValues.put((String) entry.getKey(), (Boolean) value);
            } else if (value instanceof Double) {
                contentValues.put((String) entry.getKey(), (Double) value);
            } else if (value instanceof Float) {
                contentValues.put((String) entry.getKey(), (Float) value);
            } else if (value instanceof Long) {
                contentValues.put((String) entry.getKey(), (Long) value);
            } else if (value instanceof Integer) {
                contentValues.put((String) entry.getKey(), (Integer) value);
            } else if (value instanceof String) {
                contentValues.put((String) entry.getKey(), (String) value);
            } else {
                contentValues.put((String) entry.getKey(), value.toString());
            }
        }
        return contentValues;
    }

    private static String[] a(V8Array v8Array) {
        if (v8Array == null || v8Array.length() <= 0) {
            return null;
        }
        String[] strArr = new String[v8Array.length()];
        for (int i = 0; i < v8Array.length(); i++) {
            Object obj = v8Array.get(i);
            if (obj instanceof String) {
                strArr[i] = (String) obj;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }
}
