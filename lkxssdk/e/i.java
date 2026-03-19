package lkxssdk.e;

import android.text.TextUtils;
import com.lingku.xuanshang.core.data.model.PicItem;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class i {
    public static i a;
    public long b;
    public int c;
    public int f;
    public int g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public ArrayList<String> p;
    public HashMap<String, PicItem> q;
    public ArrayList<Integer> r;
    public int e = 3;
    public int d = 1;
    public ArrayList<String> n = new ArrayList<>();
    public HashMap<String, PicItem> o = new HashMap<>();

    public static i b() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    public int a() {
        return this.e;
    }

    public void a(String str) {
        if (this.n.contains(str)) {
            return;
        }
        this.n.add(str);
    }

    public void a(String str, long j, long j2) {
        if (!this.n.contains(str)) {
            this.n.add(str);
        }
        if (this.o.containsKey(str)) {
            return;
        }
        PicItem picItem = new PicItem();
        picItem.path = str;
        picItem.dateAdd = j;
        picItem.dateModify = j2;
        this.o.put(str, picItem);
    }

    public String b(String str) {
        return String.valueOf(this.n.indexOf(str) + 1);
    }

    public PicItem c(String str) {
        HashMap<String, PicItem> map;
        PicItem picItem = (TextUtils.isEmpty(str) || (map = this.o) == null) ? null : map.get(str);
        if (picItem != null) {
            return picItem;
        }
        PicItem picItem2 = new PicItem();
        picItem2.path = str;
        picItem2.dateAdd = System.currentTimeMillis() / 1000;
        picItem2.dateModify = System.currentTimeMillis() / 1000;
        return picItem2;
    }

    public boolean d(String str) {
        return this.n.indexOf(str) > -1;
    }
}
