package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qq.e.comm.plugin.pk;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u6 {
    private static final String a = "u6";
    private static final ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    private static final Pattern c = Pattern.compile("(ofs_)(-?[0-9]{1,2})(_.*)");

    /* compiled from: A */
    public interface b {
        void a(int i);
    }

    public static void a(pk pkVar, String str, b bVar) {
        String strSubstring;
        Integer num = b.get(str);
        if (num != null) {
            bVar.a(num.intValue());
            return;
        }
        Matcher matcher = c.matcher(str);
        int i = 0;
        if (matcher.find()) {
            String strGroup = matcher.group(2);
            strGroup.getClass();
            String str2 = strGroup;
            i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(3);
            strGroup2.getClass();
            String str3 = strGroup2;
            strSubstring = strGroup2.substring(1);
        } else {
            strSubstring = str;
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return;
        }
        pkVar.a(strSubstring, (pk.a) new a(str, i, bVar));
    }

    /* compiled from: A */
    class a implements pk.a {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ b c;

        a(String str, int i, b bVar) {
            this.a = str;
            this.b = i;
            this.c = bVar;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.u6$a$a, reason: collision with other inner class name */
        class RunnableC0723a implements Runnable {
            final /* synthetic */ Integer a;

            RunnableC0723a(Integer num) {
                this.a = num;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a(this.a.intValue());
            }
        }

        @Override // com.qq.e.comm.plugin.pk.a
        public void a(Object obj, int i, Exception exc) {
            va.a(obj, i, exc);
            String unused = u6.a;
        }

        @Override // com.qq.e.comm.plugin.pk.a
        public void a(File file, Object obj) {
            Integer numValueOf = (Integer) u6.b.get(this.a);
            if (numValueOf != null) {
                String unused = u6.a;
            } else {
                Bitmap bitmapB = file != null ? e5.b(file, null) : null;
                if (bitmapB == null) {
                    return;
                }
                numValueOf = Integer.valueOf(lt.a(bitmapB, this.b));
                u6.b.put(this.a, numValueOf);
            }
            xo.a((Runnable) new RunnableC0723a(numValueOf));
        }
    }
}
