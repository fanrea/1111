package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0551a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.Mg() == -3) {
            Iterator<a.InterfaceC0551a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().Mp().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0551a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().Mp().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.Mg()) {
            Iterator<a.InterfaceC0551a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().Mp().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).Mp().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0551a> listDc = h.MM().dc(messageSnapshot.getId());
            if (listDc.size() > 0) {
                a aVarMo = listDc.get(0).Mo();
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(aVarMo.Mg()), Byte.valueOf(messageSnapshot.Mg()), Integer.valueOf(listDc.size()));
                }
                if (!a(listDc, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.Mg()) + " task-count:" + listDc.size());
                    Iterator<a.InterfaceC0551a> it = listDc.iterator();
                    while (it.hasNext()) {
                        sb.append(" | ").append((int) it.next().Mo().Mg());
                    }
                    com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.Mg()));
            }
        }
    }
}
