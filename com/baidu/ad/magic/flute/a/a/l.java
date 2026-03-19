package com.baidu.ad.magic.flute.a.a;

import android.content.Context;
import android.content.Intent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l {
    Method a;
    Method b;
    Method c;
    Class d;

    l(Context context) {
        try {
            b(context);
        } catch (Exception e) {
            throw new IllegalStateException("charset = " + Charset.defaultCharset(), e);
        }
    }

    private void b(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.c = p.a(Context.class, p.a(o.c()), null);
        Object objInvoke = this.c.invoke(context, new Object[0]);
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "");
        this.d = p.a(intent.getClass(), p.a(o.d()), null).invoke(intent, new Object[0]).getClass();
        String strA = p.a(o.a());
        Class<?> cls = objInvoke.getClass();
        Class cls2 = Integer.TYPE;
        this.a = p.a(cls, strA, new Class[]{this.d, cls2, cls2});
        this.b = p.a(objInvoke.getClass(), p.a(o.b()), new Class[]{this.d});
    }

    int a(Object obj, Object obj2) throws q {
        try {
            return ((Integer) this.b.invoke(obj, obj2)).intValue();
        } catch (Exception e) {
            throw new q("gces error");
        }
    }

    Object a(Context context) throws q {
        try {
            return this.c.invoke(context, new Object[0]);
        } catch (Exception e) {
            throw new q("gpm error");
        }
    }

    void a(Object obj, Object obj2, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a.invoke(obj, obj2, Integer.valueOf(i), 1);
    }
}
