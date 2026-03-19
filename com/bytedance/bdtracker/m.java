package com.bytedance.bdtracker;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.container.util.cm;
import com.bytedance.bdtracker.p;
import com.tkruntime.v8.V8Trace;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u0017*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/alink/model/ApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/applog/alink/model/BaseData;", "", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "data", "getData", "()Lcom/bytedance/applog/alink/model/BaseData;", V8Trace.SECTION_SET_DATA, "(Lcom/bytedance/applog/alink/model/BaseData;)V", "Lcom/bytedance/applog/alink/model/BaseData;", cm.V, "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class m<T extends p> {
    public static final a c = new a(null);
    public String a;
    public T b;

    public final T a() {
        return this.b;
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends p> m<T> a(String str, Class<T> cls) {
            Intrinsics.checkParameterIsNotNull(cls, "clazz");
            JSONObject jSONObject = new JSONObject(str);
            m<T> mVar = new m<>();
            jSONObject.optInt("code");
            mVar.a = jSONObject.optString(cm.V);
            mVar.b = (T) p.a.a(jSONObject.optJSONObject("data"), cls);
            return mVar;
        }

        public final <T extends p> m<T> a(Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "throwable");
            m<T> mVar = new m<>();
            mVar.a = th instanceof f3 ? "DDL request timeout" : th + " message:" + th.getMessage();
            return mVar;
        }
    }
}
