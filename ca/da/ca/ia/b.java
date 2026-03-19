package ca.da.ca.ia;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ca.da.ca.ja.r;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseData.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class b implements Cloneable {
    public static final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public long a;
    public long b;
    public long c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;

    public b() {
        a(0L);
    }

    public void a(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.b = j;
    }

    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar");
    }

    public String c() {
        return null;
    }

    public String d() {
        return ca.ca.ca.ca.a.a("sid:").append(this.d).toString();
    }

    public abstract String e();

    public final JSONObject f() {
        try {
            this.j = k.format(new Date(this.b));
            return g();
        } catch (JSONException e) {
            r.a(e);
            return null;
        }
    }

    public abstract JSONObject g() throws JSONException;

    public String toString() {
        String strE = e();
        if (!getClass().getSimpleName().equalsIgnoreCase(strE)) {
            strE = strE + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.d;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
        } else {
            strSubstring = "-";
        }
        return "{" + strE + ", " + d() + ", " + strSubstring + ", " + this.b + com.alipay.sdk.m.u.i.d;
    }

    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("tea_event_index", Long.valueOf(this.c));
        contentValues.put("nt", Integer.valueOf(this.i));
        contentValues.put("user_id", Long.valueOf(this.e));
        contentValues.put("session_id", this.d);
        contentValues.put("user_unique_id", this.f);
        contentValues.put("ssid", this.g);
        contentValues.put("ab_sdk_version", this.h);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public b m290clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e) {
            r.a(e);
            return null;
        }
    }

    public int a(Cursor cursor) {
        this.a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getLong(2);
        this.i = cursor.getInt(3);
        this.e = cursor.getLong(4);
        this.d = cursor.getString(5);
        this.f = cursor.getString(6);
        this.g = cursor.getString(7);
        this.h = cursor.getString(8);
        return 9;
    }

    public b a(JSONObject jSONObject) {
        this.b = jSONObject.optLong("local_time_ms", 0L);
        this.a = 0L;
        this.c = 0L;
        this.i = 0;
        this.e = 0L;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        return this;
    }

    public final ContentValues a(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        b(contentValues);
        return contentValues;
    }

    public final String a() {
        List<String> listB = b();
        if (listB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(e()).append("(");
        for (int i = 0; i < listB.size(); i += 2) {
            sb.append(listB.get(i)).append(" ").append(listB.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public static b a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return d.d.get(jSONObject.optString("k_cls", "")).m290clone().a(jSONObject);
        } catch (Throwable th) {
            r.a(th);
            return null;
        }
    }
}
