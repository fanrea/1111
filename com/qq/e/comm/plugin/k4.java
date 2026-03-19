package com.qq.e.comm.plugin;

import com.kuaishou.socket.nano.SocketMessages;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class k4 {
    private final int a = c();
    private final List<a> b;
    private final boolean c;

    private void a(a aVar, String str, String str2, String str3, e2 e2Var) {
        pro.getVresult(SocketMessages.PayloadType.SC_LIVE_QUIZ_QUESTION_ASKED, 0, this, aVar, str, str2, str3, e2Var);
    }

    private List<a> b() {
        return (List) pro.getobjresult(351, 0, this);
    }

    final int a(StackTraceElement[] stackTraceElementArr, String str, e2 e2Var) {
        return pro.getIresult(352, 0, this, stackTraceElementArr, str, e2Var);
    }

    protected abstract String a();

    protected abstract int c();

    final boolean d() {
        return pro.getZresult(353, 0, this);
    }

    /* compiled from: A */
    private static class a {
        private final int a;
        private final Class b;
        private JSONArray c;

        static /* synthetic */ a a(JSONObject jSONObject) {
            return (a) pro.getobjresult(432, 1, jSONObject);
        }

        private boolean a(Class cls) {
            return pro.getZresult(SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION, 0, this, cls);
        }

        private static a b(JSONObject jSONObject) {
            return (a) pro.getobjresult(SocketMessages.PayloadType.SC_MIC_SEATS_MIC_FORCED_STATUS, 1, jSONObject);
        }

        static /* synthetic */ Class b(a aVar) {
            return (Class) pro.getobjresult(SocketMessages.PayloadType.SC_MIC_SEATS_APPLY_INFO, 1, aVar);
        }

        private a(int i, Class cls) {
            this.a = i;
            this.b = cls;
        }
    }

    protected k4() {
        List<a> listB = b();
        this.b = listB;
        this.c = (listB == null || listB.isEmpty()) ? false : true;
    }
}
