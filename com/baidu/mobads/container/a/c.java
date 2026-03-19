package com.baidu.mobads.container.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bq;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = "onNativeFail";
    private static final String b = "onNativeLoad";
    private static final String c = "build";
    private static final String d = "makeRequest";
    private static int o = 20000;
    private static final String p = c.class.getSimpleName();
    private Object e;
    private InterfaceC0118c f;
    private e g;
    private Context h;
    private String i;
    private String j;
    private InterfaceC0118c k;
    private b m;
    private boolean n = false;
    private bq q = bq.a();
    private Handler l = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.mobads.container.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0118c {
        void a(String str);

        void a(List<d> list);
    }

    public c(Context context, String str, String str2, InterfaceC0118c interfaceC0118c) {
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.f = interfaceC0118c;
        this.h = context;
        this.i = str;
        this.j = str2;
        this.k = interfaceC0118c;
        this.m = new b(context);
    }

    private boolean b(e eVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            this.q.a(p, "makeRequestAfterDexLoaded START");
            Class<?> cls = Class.forName(com.baidu.mobads.container.a.b.a);
            Class<?> cls2 = Class.forName(com.baidu.mobads.container.a.b.b);
            Object objNewInstance = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            Class<?> cls3 = Class.forName(com.baidu.mobads.container.a.b.d);
            Method declaredMethod = cls2.getDeclaredMethod(c, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(objNewInstance, new Object[0]);
            if (this.e == null) {
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod(d, cls3);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this.e, objInvoke);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void a(e eVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.g = eVar;
        this.l.postDelayed(this.m, o);
        c(this.g);
    }

    private void c(e eVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.l.removeCallbacks(this.m);
        a();
        b(eVar);
    }

    private void a() throws ClassNotFoundException {
        try {
            this.q.a(p, "initFeedAdInstance START");
            com.baidu.mobads.container.a.b.a(this.h, com.baidu.mobads.container.a.b.a, this.i);
            this.e = Class.forName(com.baidu.mobads.container.a.b.a).getDeclaredConstructor(Context.class, String.class, Class.forName(com.baidu.mobads.container.a.b.c)).newInstance(this.h, this.j, b());
            this.q.a(p, "initFeedAdInstance finish");
        } catch (Exception e) {
            this.q.a(p, "initFeedAdInstance exception");
        }
        this.q.a(p, "initFeedAdInstance END");
    }

    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            Object obj3;
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (objArr != null && objArr.length > 0) {
                obj2 = objArr[0];
            } else {
                obj2 = null;
            }
            if (name.equals(c.a)) {
                if (objArr != null && objArr.length > 0) {
                    obj3 = objArr[0];
                } else {
                    obj3 = "remote callback adfail";
                }
                c.this.a(obj3.toString());
            } else if (name.equals(c.b) && obj2 != null) {
                LinkedList linkedList = new LinkedList();
                Iterator it = ((List) obj2).iterator();
                while (it.hasNext()) {
                    linkedList.add(new d(it.next()));
                }
                if (c.this.f != null) {
                    c.this.f.a(linkedList);
                }
            }
            return null;
        }
    }

    private Object b() throws ClassNotFoundException {
        try {
            if (this.f == null) {
                return null;
            }
            Class<?> cls = Class.forName(com.baidu.mobads.container.a.b.c);
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a());
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!this.n && this.f != null) {
            this.n = true;
            this.f.a(str);
        }
    }

    class b implements Runnable {
        private Context b;

        public b(Context context) {
            this.b = context.getApplicationContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a("get-claLoader-timeout");
        }
    }
}
