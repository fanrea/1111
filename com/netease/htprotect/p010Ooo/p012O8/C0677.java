package com.netease.htprotect.p010Ooo.p012O8;

import com.alipay.sdk.m.n.a;
import com.netease.htprotect.p010Ooo.p012O8.Oo0;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.C0681;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8oO888;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.Oo0;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.oO;
import com.netease.htprotect.p010Ooo.p017oO.p018O8oO888.o0O0O;
import java.util.List;
import kotlin.text.Typography;

/* renamed from: com.netease.htprotect.〇Ooo.〇O8.〇〇, reason: contains not printable characters */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0677 implements o0O0O {

    /* renamed from: 〇O8, reason: contains not printable characters */
    private boolean f277O8;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private int f279o0o0;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private StringBuilder f276O8oO888 = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private Oo0 f278Ooo = new Oo0();

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m759O8oO888(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f276O8oO888.append('\t');
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m760O8oO888(O8oO888 o8oO888) {
        this.f276O8oO888.append(' ');
        String strM736O8oO888 = this.f278Ooo.m736O8oO888(o8oO888.m974O8oO888());
        if (strM736O8oO888 == null) {
            strM736O8oO888 = o8oO888.m974O8oO888();
        }
        if (strM736O8oO888 != null && !strM736O8oO888.isEmpty()) {
            this.f276O8oO888.append(strM736O8oO888).append(':');
        }
        this.f276O8oO888.append(o8oO888.m980Ooo()).append(a.h).append('\"').append(o0O0O.m1050O8oO888(o8oO888.m978O8())).append('\"');
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final String m761O8oO888() {
        return this.f276O8oO888.toString();
    }

    @Override // com.netease.htprotect.p010Ooo.p012O8.o0O0O
    /* renamed from: O8〇oO8〇88 */
    public final void mo731O8oO888(Oo0 oo0) {
        this.f278Ooo.m738O8oO888(oo0);
    }

    @Override // com.netease.htprotect.p010Ooo.p012O8.o0O0O
    /* renamed from: O8〇oO8〇88 */
    public final void mo732O8oO888(O8 o8) {
        m759O8oO888(this.f279o0o0);
        this.f276O8oO888.append(o8.m996O8oO888()).append('\n');
        this.f277O8 = false;
    }

    @Override // com.netease.htprotect.p010Ooo.p012O8.o0O0O
    /* renamed from: O8〇oO8〇88 */
    public final void mo733O8oO888(O o) {
        StringBuilder sb;
        String str;
        int i = this.f279o0o0 - 1;
        this.f279o0o0 = i;
        if (this.f277O8) {
            sb = this.f276O8oO888;
            str = " />\n";
        } else {
            m759O8oO888(i);
            this.f276O8oO888.append("</");
            if (o.m988O8oO888() != null) {
                this.f276O8oO888.append(o.m988O8oO888()).append(':');
            }
            this.f276O8oO888.append(o.m990Ooo());
            sb = this.f276O8oO888;
            str = ">\n";
        }
        sb.append(str);
        this.f277O8 = false;
    }

    @Override // com.netease.htprotect.p010Ooo.p012O8.o0O0O
    /* renamed from: O8〇oO8〇88 */
    public final void mo734O8oO888(oO oOVar) {
        this.f278Ooo.m739O8oO888(oOVar);
    }

    @Override // com.netease.htprotect.p010Ooo.p012O8.o0O0O
    /* renamed from: O8〇oO8〇88 */
    public final void mo735O8oO888(C0681 c0681) {
        if (this.f277O8) {
            this.f276O8oO888.append(">\n");
        }
        int i = this.f279o0o0;
        this.f279o0o0 = i + 1;
        m759O8oO888(i);
        this.f276O8oO888.append(Typography.less);
        if (c0681.m1014O8oO888() != null) {
            String strM736O8oO888 = this.f278Ooo.m736O8oO888(c0681.m1014O8oO888());
            (strM736O8oO888 != null ? this.f276O8oO888.append(strM736O8oO888) : this.f276O8oO888.append(c0681.m1014O8oO888())).append(':');
        }
        this.f276O8oO888.append(c0681.m1018Ooo());
        List<Oo0.O8oO888> listM737O8oO888 = this.f278Ooo.m737O8oO888();
        if (!listM737O8oO888.isEmpty()) {
            for (Oo0.O8oO888 o8oO888 : listM737O8oO888) {
                this.f276O8oO888.append(" xmlns:").append(o8oO888.f261O8oO888).append("=\"").append(o8oO888.f262Ooo).append("\"");
            }
        }
        this.f277O8 = true;
        for (O8oO888 o8oO8882 : c0681.m1017O8().m1004O8oO888()) {
            this.f276O8oO888.append(' ');
            String strM736O8oO8882 = this.f278Ooo.m736O8oO888(o8oO8882.m974O8oO888());
            if (strM736O8oO8882 == null) {
                strM736O8oO8882 = o8oO8882.m974O8oO888();
            }
            if (strM736O8oO8882 != null && !strM736O8oO8882.isEmpty()) {
                this.f276O8oO888.append(strM736O8oO8882).append(':');
            }
            this.f276O8oO888.append(o8oO8882.m980Ooo()).append(a.h).append('\"').append(o0O0O.m1050O8oO888(o8oO8882.m978O8())).append('\"');
        }
    }
}
