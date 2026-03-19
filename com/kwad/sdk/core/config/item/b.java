package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<T> {
    private T bAv;
    private T bAw;
    private String mKey;

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void g(JSONObject jSONObject);

    public b(String str, T t) {
        this(str, t, t);
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.bAw = t;
        this.bAv = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    public T getValue() {
        return this.bAw;
    }

    public final T Zh() {
        return this.bAv;
    }

    public void setValue(T t) {
        this.bAw = t;
    }

    public static String eO(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.encodeKsSdk(str) : str;
    }

    public static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) ? str : com.kwad.sdk.core.a.c.decodeKsSdk(str);
    }
}
