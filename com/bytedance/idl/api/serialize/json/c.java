package com.bytedance.idl.api.serialize.json;

import com.bytedance.rpc.serialize.h;
import com.google.gson.Gson;
import java.io.InputStream;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* compiled from: JsonDeserializer.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends com.bytedance.rpc.serialize.a {
    private Gson c;

    public c(Gson gson, com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) {
        super(dVar, type);
        this.c = gson;
    }

    @Override // com.bytedance.rpc.serialize.a
    protected Object a(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) throws Exception {
        InputStream inputStreamC = dVar == null ? null : dVar.c();
        if (inputStreamC == null) {
            return null;
        }
        String strA = com.bytedance.sdk.djx.proguard3.c.d.b(dVar.a()) ? h.a(dVar.a(), "UTF-8") : "UTF-8";
        if (String.class == type) {
            return com.bytedance.sdk.djx.proguard3.c.d.a(inputStreamC, strA);
        }
        if (JSONObject.class == type) {
            return new JSONObject(com.bytedance.sdk.djx.proguard3.c.d.a(inputStreamC, strA));
        }
        return this.c.fromJson(com.bytedance.sdk.djx.proguard3.c.d.a(inputStreamC, strA), type);
    }
}
