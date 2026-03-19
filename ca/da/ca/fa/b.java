package ca.da.ca.fa;

import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: AppLogCache.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static final LinkedList<ca.da.ca.ia.b> a = new LinkedList<>();
    public static final LinkedList<String> b = new LinkedList<>();

    public static int a(ArrayList<ca.da.ca.ia.b> arrayList) {
        int size;
        LinkedList<ca.da.ca.ia.b> linkedList = a;
        synchronized (linkedList) {
            size = linkedList.size();
            arrayList.addAll(linkedList);
            linkedList.clear();
        }
        return size;
    }
}
