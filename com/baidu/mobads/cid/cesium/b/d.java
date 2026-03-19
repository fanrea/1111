package com.baidu.mobads.cid.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.cid.cesium.a.e;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import com.baidu.mobstat.forbes.Config;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends com.baidu.mobads.cid.cesium.b.a {
    private Context d;
    private f e;
    private a.C0116a f;

    static final class a implements Comparable<a> {
        private static final String[] a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        private final int b;

        private a(int i) {
            this.b = i;
        }

        public static a a(byte b, boolean z) {
            int i = b & 255;
            return a(z ? i >> 4 : i & 15);
        }

        public static a a(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.b - aVar.b;
        }

        public String a() {
            return a[this.b];
        }

        public byte b() {
            return (byte) this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }
    }

    class b {
        private int b = 33;
        private a[] c = new a[this.b];
        private int d;

        public b() {
        }

        private void b(int i) {
            if (i - this.c.length > 0) {
                int length = this.c.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.c = (a[]) Arrays.copyOf(this.c, i);
            }
        }

        public int a() {
            return this.d;
        }

        public a a(int i) {
            if (i < this.d) {
                return this.c[i];
            }
            throw new IndexOutOfBoundsException("idx " + i + " size " + this.d);
        }

        public void a(a aVar) {
            b(this.d + 1);
            a[] aVarArr = this.c;
            int i = this.d;
            this.d = i + 1;
            aVarArr[i] = aVar;
        }

        public byte[] b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < this.d / 2; i++) {
                int i2 = i * 2;
                byteArrayOutputStream.write((byte) (((a(i2 + 1).b() & 255) << 4) | (a(i2).b() & 255)));
            }
            if (this.d % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(this.d - 1).b() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    static class c {
        private List<a> a = new ArrayList();

        static class a {
            private int a;
            private a b;

            public a(a aVar) {
                this.b = aVar;
            }

            public void a() {
                this.a++;
            }
        }

        c() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.a);
            Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.mobads.cid.cesium.b.d.c.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(a aVar, a aVar2) {
                    return aVar.a - aVar2.a;
                }
            });
            return arrayList;
        }

        public void a(a aVar) {
            this.a.add(new a(aVar));
        }
    }

    /* renamed from: com.baidu.mobads.cid.cesium.b.d$d, reason: collision with other inner class name */
    static class C0115d {
        byte[] a;
        byte b;
        byte[] c;

        public C0115d(byte[] bArr, byte b, byte[] bArr2) {
            this.a = bArr;
            this.b = b;
            this.c = bArr2;
        }

        public g.a a() {
            try {
                return com.baidu.mobads.cid.cesium.g.a(com.baidu.mobads.cid.cesium.d.b.a(this.a, "", true), new String(new byte[]{this.b}, "UTF-8"), this.c != null ? new String(this.c, "UTF-8") : null);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static class e {
        public int a;
        public int b;
        public int c = 16;

        e() {
        }

        public String toString() {
            return "";
        }
    }

    static class f {
        private Method a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;

        f() {
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) throws e.a {
            try {
                return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e) {
                throw new e.a(e);
            }
        }

        void a() {
            try {
                String strA = com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.d());
                Class cls = Integer.TYPE;
                this.a = com.baidu.mobads.cid.cesium.a.e.a(Context.class, strA, new Class[]{Uri.class, cls, cls, cls});
                this.b = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.c = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.f()), new Class[]{Uri.class, Integer.TYPE});
                this.d = com.baidu.mobads.cid.cesium.a.e.a(Context.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.g()), new Class[]{Uri.class, Integer.TYPE});
                this.e = com.baidu.mobads.cid.cesium.a.e.a(ContentResolver.class, com.baidu.mobads.cid.cesium.a.e.a(com.baidu.mobads.cid.cesium.a.d.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception e) {
            }
        }
    }

    class g extends a.b {
        private int b;
        private String c;
        private long d;
        private long e;
        private g.a f;

        public g(String str) {
            super(d.this.f, str);
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.c = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.d = jSONObject.getLong("last_fe_ts");
            this.f = com.baidu.mobads.cid.cesium.g.a(jSONObject.getString(Config.LAUNCH_INFO));
            this.e = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.d == j) {
                return false;
            }
            this.d = j;
            a(true);
            return true;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f)) {
                return false;
            }
            this.f = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.c)) {
                return false;
            }
            this.c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) throws JSONException {
            jSONObject.put(Config.INPUT_DEF_PKG, this.c);
            jSONObject.put("last_fe_ts", this.d);
            jSONObject.put(Config.LAUNCH_INFO, this.f.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.e);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.e == j) {
                return false;
            }
            this.e = j;
            a(true);
            return true;
        }

        public String c() {
            return this.c;
        }

        public g.a d() {
            return this.f;
        }

        public long e() {
            return this.e;
        }
    }

    public d() {
        super("upc", 9000000L);
        this.e = new f();
        this.e.a();
    }

    private a a(String str, int i, List<c.a> list, int i2, e eVar) {
        for (c.a aVar : list) {
            if (a(str, i, aVar.b, i2, eVar)) {
                aVar.a();
                return aVar.b;
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".cesium";
    }

    private String a(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i), aVar.a());
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", a(str), aVar.a());
    }

    private boolean a(String str, int i, a aVar, int i2, e eVar) throws InterruptedException {
        int iA;
        Uri uri = Uri.parse(a(str, i, aVar));
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                iA = -1;
                break;
            }
            if (eVar != null) {
                try {
                    eVar.a++;
                } catch (Throwable th) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception e2) {
                    }
                    i3++;
                }
            }
            iA = this.e.a(this.d, uri, 0, i2, 1);
            break;
        }
        if (iA == 0) {
            return true;
        }
        if (eVar != null) {
            eVar.b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i) throws InterruptedException {
        int iA;
        Uri uri = Uri.parse(a(str, aVar));
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                iA = -1;
                break;
            }
            try {
                iA = this.e.a(this.d, uri, 0, i, 1);
                break;
            } catch (Throwable th) {
                try {
                    Thread.sleep(5L);
                } catch (Exception e2) {
                }
                i2++;
            }
        }
        return iA == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01df  */
    @Override // com.baidu.mobads.cid.cesium.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mobads.cid.cesium.b.a.e a(java.lang.String r24, com.baidu.mobads.cid.cesium.b.a.d r25) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.cid.cesium.b.d.a(java.lang.String, com.baidu.mobads.cid.cesium.b.a$d):com.baidu.mobads.cid.cesium.b.a$e");
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public void a(a.c cVar) {
        this.d = this.a.a;
        this.f = this.b.a("upc");
    }
}
