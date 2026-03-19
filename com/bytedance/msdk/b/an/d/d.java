package com.bytedance.msdk.b.an.d;

import android.text.TextUtils;
import com.bytedance.msdk.b.gb.an;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.b;
import com.bytedance.msdk.gb.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private List<Integer> mk;
    private AtomicInteger b = new AtomicInteger(-1);
    private AtomicBoolean c = new AtomicBoolean();
    public final Map<Integer, Boolean> d = new HashMap();
    public final Map<Integer, Boolean> hc = new HashMap();
    private final Map<Integer, AtomicInteger> u = new HashMap();
    private final AtomicInteger an = new AtomicInteger();
    private final AtomicInteger h = new AtomicInteger();
    private final AtomicInteger gb = new AtomicInteger();
    private final List<String> tt = new CopyOnWriteArrayList();
    private final AtomicInteger tc = new AtomicInteger(-1000);

    public List<Integer> d() {
        return this.mk;
    }

    public void d(List<Integer> list) {
        this.mk = list;
    }

    public synchronized void d(int i) {
        this.b.set(i);
    }

    public synchronized int hc() {
        return this.b.get();
    }

    public synchronized boolean b() {
        return hc() > 0;
    }

    public synchronized void hc(int i) {
        if (this.tc.get() < i) {
            this.tc.set(i);
        }
        this.d.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean b(int i) {
        Boolean bool = this.d.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void c(int i) {
        this.hc.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean u(int i) {
        Boolean bool = this.hc.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void c() {
        this.c.set(true);
    }

    public synchronized boolean u() {
        return this.c.get();
    }

    public synchronized boolean an() {
        AtomicInteger atomicInteger = this.u.get(-100);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized boolean h() {
        AtomicInteger atomicInteger = this.u.get(0);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized void d(int i, int i2) {
        this.u.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    public synchronized int an(int i) {
        AtomicInteger atomicInteger = this.u.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized void h(int i) {
        this.an.set(i);
    }

    public synchronized boolean gb() {
        return this.an.get() == 0;
    }

    public synchronized void gb(int i) {
        this.h.set(i);
    }

    public synchronized boolean tt() {
        return this.h.get() == 0;
    }

    public synchronized void tt(int i) {
        this.gb.set(i);
    }

    public synchronized boolean tc() {
        return this.gb.get() == 0;
    }

    public synchronized void d(int i, String str) {
        AtomicInteger atomicInteger = this.u.get(Integer.valueOf(i));
        if (atomicInteger != null && atomicInteger.get() != 0) {
            atomicInteger.decrementAndGet();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.tt.add(str);
        if (i < -100 && this.h.get() != 0) {
            this.h.decrementAndGet();
        }
        if (i > 0 && this.gb.get() != 0) {
            this.gb.decrementAndGet();
        }
        if (this.an.get() != 0) {
            this.an.decrementAndGet();
        } else {
            b.c("TTMediationSDK", "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
        }
    }

    public synchronized void d(List<tc> list, List<tc> list2, List<tc> list3) {
        int size;
        if (list != null) {
            if (list.size() != 0) {
                List<tc> listHc = an.hc(list);
                int i = 0;
                if (j.d(listHc)) {
                    size = 0;
                } else {
                    size = listHc.size();
                    for (tc tcVar : listHc) {
                        Iterator<String> it = this.tt.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String next = it.next();
                                if (!TextUtils.isEmpty(next) && tcVar != null && next.equals(tcVar.yo())) {
                                    size--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (size < 0) {
                    size = 0;
                }
                this.gb.set(size);
                int size2 = list.size();
                if (list2 != null) {
                    size2 += list2.size();
                }
                if (list3 != null) {
                    size2 += list3.size();
                }
                for (tc tcVar2 : list) {
                    Iterator<String> it2 = this.tt.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && tcVar2 != null && next2.equals(tcVar2.yo())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (!j.d(list2)) {
                    for (tc tcVar3 : list2) {
                        Iterator<String> it3 = this.tt.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                String next3 = it3.next();
                                if (!TextUtils.isEmpty(next3) && tcVar3 != null && next3.equals(tcVar3.yo())) {
                                    size2--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!j.d(list3)) {
                    for (tc tcVar4 : list3) {
                        Iterator<String> it4 = this.tt.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                String next4 = it4.next();
                                if (!TextUtils.isEmpty(next4) && tcVar4 != null && next4.equals(tcVar4.yo())) {
                                    size2--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (size2 >= 0) {
                    i = size2;
                }
                this.an.set(i);
            }
        }
    }

    public synchronized int mk() {
        return this.tc.get();
    }

    public synchronized void mq() {
        this.b.set(-1);
        this.c.set(false);
        this.d.clear();
        this.hc.clear();
        this.u.clear();
        this.an.set(0);
        this.tt.clear();
        this.tc.set(-1000);
    }
}
