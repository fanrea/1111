package com.bytedance.bdtracker;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tJ\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applog/alink/model/BaseData;", "", "()V", "initWithJson", "", "json", "Lorg/json/JSONObject;", "toJson", "toMap", "", "", "toString", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class p {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends p> T a(JSONObject jSONObject, Class<T> cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkParameterIsNotNull(cls, "clazz");
            if (jSONObject == null) {
                return null;
            }
            T tNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(tNewInstance, "clazz.getConstructor().newInstance()");
            T t = tNewInstance;
            t.a(jSONObject);
            return t;
        }
    }

    public abstract JSONObject a();

    public abstract void a(JSONObject jSONObject);

    public final Map<String, String> b() {
        HashMap map = new HashMap();
        JSONObject jSONObjectA = a();
        Iterator<String> itKeys = jSONObjectA.keys();
        Intrinsics.checkExpressionValueIsNotNull(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "key");
            map.put(next, jSONObjectA.optString(next, null));
        }
        return map;
    }

    public String toString() {
        String string = a().toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "toJson().toString()");
        return string;
    }
}
