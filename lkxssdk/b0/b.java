package lkxssdk.b0;

import aegon.chrome.net.NetError;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import lkxssdk.b0.c;
import lkxssdk.e.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class b<T, K extends c> extends RecyclerView.Adapter<K> {
    public int a;
    public List<T> b;
    public boolean c;
    public d<T> d;
    public a e;

    public interface a {
        void a(b bVar, View view, int i);
    }

    public b(int i) {
        this(i, null);
    }

    public b(int i, List<T> list) {
        this.c = true;
        this.b = list == null ? new ArrayList<>() : list;
        if (i != 0) {
            this.a = i;
        }
    }

    public b(List<T> list) {
        this(0, list);
    }

    public K a(View view) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        T tNewInstance;
        Class cls;
        Class<?> superclass = getClass();
        K k = null;
        Class cls2 = null;
        while (true) {
            if (cls2 != null || superclass == null) {
                break;
            }
            Type genericSuperclass = superclass.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
                    if (type instanceof Class) {
                        cls = (Class) type;
                        if (c.class.isAssignableFrom(cls)) {
                            cls2 = cls;
                            break;
                        }
                    } else {
                        if (type instanceof ParameterizedType) {
                            Type rawType = ((ParameterizedType) type).getRawType();
                            if (rawType instanceof Class) {
                                cls = (Class) rawType;
                                if (c.class.isAssignableFrom(cls)) {
                                    cls2 = cls;
                                    break;
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                cls2 = null;
            } else {
                cls2 = null;
            }
            superclass = superclass.getSuperclass();
        }
        if (cls2 == null) {
            k = (K) new c(view);
        } else {
            try {
                if (!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) {
                    Constructor<T> declaredConstructor = cls2.getDeclaredConstructor(View.class);
                    declaredConstructor.setAccessible(true);
                    tNewInstance = declaredConstructor.newInstance(view);
                } else {
                    Constructor<T> declaredConstructor2 = cls2.getDeclaredConstructor(getClass(), View.class);
                    declaredConstructor2.setAccessible(true);
                    tNewInstance = declaredConstructor2.newInstance(this, view);
                }
                k = (K) tNewInstance;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return k != null ? k : (K) new c(view);
    }

    public d<T> a() {
        return this.d;
    }

    public void a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.b = list;
        notifyDataSetChanged();
    }

    public abstract void a(K k, T t, int i);

    public void a(d<T> dVar) {
        this.d = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.b.size() + 0 + 0;
        this.b.size();
        return size + 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return 273;
        }
        int i2 = i + 0;
        int size = this.b.size();
        if (i2 >= size) {
            return i2 - size < 0 ? 819 : 1092;
        }
        if (this.d == null) {
            return super.getItemViewType(i2);
        }
        T t = this.b.get(i2);
        if (t != null) {
            return ((e) t).e;
        }
        return -255;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033 A[PHI: r5
  0x0033: PHI (r5v3 int) = (r5v1 int), (r5v4 int) binds: [B:21:0x0031, B:15:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
        /*
            r3 = this;
            lkxssdk.b0.c r4 = (lkxssdk.b0.c) r4
            int r0 = r4.getItemViewType()
            r1 = 0
            if (r0 == 0) goto L27
            r2 = 273(0x111, float:3.83E-43)
            if (r0 == r2) goto L3c
            r2 = 546(0x222, float:7.65E-43)
            if (r0 == r2) goto L3c
            r2 = 819(0x333, float:1.148E-42)
            if (r0 == r2) goto L3c
            r2 = 1092(0x444, float:1.53E-42)
            if (r0 == r2) goto L26
            int r5 = r5 + 0
            if (r5 < 0) goto L39
            java.util.List<T> r0 = r3.b
            int r0 = r0.size()
            if (r5 >= r0) goto L39
            goto L33
        L26:
            throw r1
        L27:
            int r5 = r5 + 0
            if (r5 < 0) goto L39
            java.util.List<T> r0 = r3.b
            int r0 = r0.size()
            if (r5 >= r0) goto L39
        L33:
            java.util.List<T> r0 = r3.b
            java.lang.Object r1 = r0.get(r5)
        L39:
            r3.a(r4, r1, r5)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.b0.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i == 273 || i == 546 || i == 819) {
            return a((View) null);
        }
        if (i == 1092) {
            LayoutInflater.from(viewGroup.getContext());
            throw null;
        }
        int i2 = this.a;
        d<T> dVar = this.d;
        if (dVar != null) {
            i2 = dVar.a.get(i, NetError.ERR_CACHE_OPEN_FAILURE);
        }
        c cVarA = a(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
        View view = cVarA.itemView;
        if (this.e == null) {
            return cVarA;
        }
        view.setOnClickListener(new lkxssdk.b0.a(this, cVarA));
        return cVarA;
    }
}
