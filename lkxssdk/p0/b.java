package lkxssdk.p0;

import android.os.Parcelable;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    public static final ClassLoader a = String.class.getClassLoader();

    public class a implements InterfaceC0846b {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // lkxssdk.p0.b.InterfaceC0846b
        public void onParseKV(String str, Object obj) throws JSONException {
            try {
                this.a.put(str, b.a(obj));
            } catch (JSONException e) {
                throw new IllegalArgumentException("parse RequestParams to json failed", e);
            }
        }
    }

    /* renamed from: lkxssdk.p0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0846b {
        void onParseKV(String str, Object obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONArray] */
    public static Object a(Object obj) throws JSONException {
        Object jSONObject;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            jSONObject = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONObject.put(a(Array.get(obj, i)));
            }
        } else if (obj instanceof Iterable) {
            jSONObject = new JSONArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                jSONObject.put(a(it.next()));
            }
        } else {
            if (!(obj instanceof Map)) {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null || classLoader == a) {
                    return obj;
                }
                JSONObject jSONObject2 = new JSONObject();
                a(obj, cls, new a(jSONObject2));
                return jSONObject2;
            }
            jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    jSONObject.put(String.valueOf(key), a(value));
                }
            }
        }
        return jSONObject;
    }

    public static void a(Object obj, Class<?> cls, InterfaceC0846b interfaceC0846b) {
        ClassLoader classLoader;
        if (cls == null || cls == RequestParams.class || cls == Object.class || (classLoader = cls.getClassLoader()) == null || classLoader == a) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isTransient(field.getModifiers()) && !"serialVersionUID".equals(name) && field.getType() != Parcelable.Creator.class) {
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            interfaceC0846b.onParseKV(name, obj2);
                        }
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        a(obj, cls.getSuperclass(), interfaceC0846b);
    }
}
