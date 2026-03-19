package com.bytedance.pangle.h;

import android.os.RemoteException;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b;
import com.bytedance.pangle.c;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.tc;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b.d {
    private static volatile d d;

    public static d hc() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    @Override // com.bytedance.pangle.b
    public boolean d(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.b
    public int hc(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.bytedance.pangle.b
    public boolean d(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.b
    public void d(int i, c cVar) throws RemoteException {
        Zeus.registerPluginStateListener(new b(cVar, i));
    }

    @Override // com.bytedance.pangle.b
    public void d(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listB = tc.d().b();
        Iterator<ZeusPluginStateListener> it = listB.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof b) && ((b) next).d() == i) {
                break;
            }
        }
        if (next != null) {
            listB.remove(next);
        }
    }
}
