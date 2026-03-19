package lkxssdk.e;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public String a;
    public String b;
    public ArrayList<e> c;
    public int d;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.c = new ArrayList<>();
        ArrayList<e> arrayList = this.c;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<e> it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    aVar.c.add(it.next().a());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return aVar;
    }
}
