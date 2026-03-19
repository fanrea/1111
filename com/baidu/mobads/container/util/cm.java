package com.baidu.mobads.container.util;

import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class cm implements IOAdEvent {
    public static final String V = "message";
    public static final String W = "complete";
    public static final String X = "AdClickThru";
    public static final String Y = "AdUserClick";
    public static final String Z = "instanceInfo";
    private final String a;
    private final HashMap<String, Object> b;
    private final int c;
    private Object d;

    public cm(String str) {
        this(str, 0, (HashMap<String, Object>) new HashMap());
    }

    public cm(String str, String str2) {
        this(str, 0, str2);
    }

    public cm(String str, HashMap<String, Object> map) {
        this(str, 0, map);
    }

    public cm(String str, int i) {
        this(str, i, (HashMap<String, Object>) new HashMap());
    }

    public cm(String str, int i, HashMap<String, Object> map) {
        this.a = str;
        this.c = i;
        this.b = map;
    }

    public cm(String str, int i, String str2) {
        this(str, i, (HashMap<String, Object>) new HashMap());
        this.b.put(V, str2);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.a;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.c;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Object> getData() {
        return this.b;
    }

    public void a(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null) {
            this.b.put(Z, jVar.getUniqueId());
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.d = obj;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.d;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        try {
            return (String) this.b.get(V);
        } catch (Exception e) {
            return "";
        }
    }
}
