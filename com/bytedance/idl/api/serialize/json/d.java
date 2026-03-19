package com.bytedance.idl.api.serialize.json;

import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.serialize.h;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.JSONObject;

/* compiled from: JsonSerializer.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.rpc.serialize.b {
    private Gson a;

    public d(Gson gson, Object obj, SerializeType serializeType) {
        super(obj, serializeType);
        this.a = gson;
    }

    @Override // com.bytedance.rpc.serialize.b
    public byte[] a(Object obj, String str) throws Exception {
        String strA = com.bytedance.sdk.djx.proguard3.c.d.b(str) ? h.a(str, "UTF-8") : "UTF-8";
        if ((obj instanceof JSONObject) || (obj instanceof JsonElement)) {
            return obj.toString().getBytes(strA);
        }
        return this.a.toJson(obj).getBytes(strA);
    }
}
