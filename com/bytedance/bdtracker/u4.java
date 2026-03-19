package com.bytedance.bdtracker;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.IPageMeta;
import com.bytedance.applog.annotation.PageMeta;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.l0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u4 {
    public static final List<String> a;
    public static final List<String> b;
    public static final List<Class<?>> c;
    public static final List<Class<?>> d;
    public static final List<String> e;

    static {
        List<String> listSingletonList = Collections.singletonList("android.app.Activity");
        a = listSingletonList;
        b = Arrays.asList("android.app.Fragment", "androidx.fragment.app.Fragment", "android.support.v4.app.Fragment");
        c = new ArrayList();
        d = new ArrayList();
        e = Collections.singletonList("PageUtils");
        Iterator<String> it = listSingletonList.iterator();
        while (it.hasNext()) {
            Class<?> clsB = l0.b.b(it.next());
            if (clsB != null) {
                c.add(clsB);
            }
        }
        Iterator<String> it2 = b.iterator();
        while (it2.hasNext()) {
            Class<?> clsB2 = l0.b.b(it2.next());
            if (clsB2 != null) {
                d.add(clsB2);
            }
        }
    }

    public static View a(Object obj) {
        try {
            Method method = obj.getClass().getMethod("getView", new Class[0]);
            if (method == null) {
                return null;
            }
            Object objInvoke = method.invoke(obj, new Object[0]);
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Object obj) {
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).path();
            } catch (Throwable th) {
                LoggerImpl.global().error(e, "Cannot get path from IPageMeta", th, new Object[0]);
            }
        }
        if (b.a(b.c)) {
            LoggerImpl.global().info(e, "PageMeta Annotation Disable", new Object[0]);
        } else if (obj.getClass().isAnnotationPresent(PageMeta.class) && (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) != null && !TextUtils.isEmpty(pageMeta.path())) {
            return pageMeta.path();
        }
        return obj.getClass().getCanonicalName();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e2 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.u4.c(java.lang.Object):java.lang.String");
    }

    public static JSONObject d(Object obj) {
        if (!(obj instanceof IPageMeta)) {
            return null;
        }
        try {
            return ((IPageMeta) obj).pageProperties();
        } catch (Throwable th) {
            LoggerImpl.global().error(e, "Cannot get track properties from activity", th, new Object[0]);
            return null;
        }
    }
}
