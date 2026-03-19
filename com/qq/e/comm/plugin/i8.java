package com.qq.e.comm.plugin;

import com.alibaba.fastjson.parser.JSONLexer;
import com.sigmob.sdk.base.mta.PointType;
import io.netty.util.internal.StringUtil;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i8 implements rk {
    com.qq.e.lib.yoga.a a;
    private r8 b = new r8(0, 0, 0, 0);
    private boolean c;

    @Override // com.qq.e.comm.plugin.rk
    public int b() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int c() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.rk
    public float e() {
        return 0.0f;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int g() {
        return -1;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int h() {
        return -1;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int j() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int n() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int p() {
        return 0;
    }

    public com.qq.e.lib.yoga.a s() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.rk
    public int m() {
        return (int) this.a.a(d60.LEFT);
    }

    @Override // com.qq.e.comm.plugin.rk
    public int a() {
        return (int) this.a.a(d60.RIGHT);
    }

    @Override // com.qq.e.comm.plugin.rk
    public int q() {
        return (int) this.a.a(d60.TOP);
    }

    @Override // com.qq.e.comm.plugin.rk
    public int k() {
        return (int) this.a.a(d60.BOTTOM);
    }

    @Override // com.qq.e.comm.plugin.rk
    public int o() {
        return this.b.b();
    }

    @Override // com.qq.e.comm.plugin.rk
    public boolean a(r8 r8Var) {
        this.b = r8Var;
        return this.a.k();
    }

    @Override // com.qq.e.comm.plugin.rk
    public int l() {
        return this.b.a();
    }

    @Override // com.qq.e.comm.plugin.rk
    public r8 i() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.rk
    public boolean f() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.rk
    public void d() {
        this.c = false;
    }

    public void r() {
        if (this.a.k()) {
            return;
        }
        this.a.a();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.qq.e.comm.plugin.rk
    public boolean a(String str, cm cmVar) {
        com.qq.e.lib.yoga.c cVarA = com.qq.e.lib.yoga.c.a(cmVar.toString());
        if (cVarA == null) {
            return false;
        }
        str.hashCode();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 48626:
                if (str.equals(PointType.ANTI_SPAM)) {
                    c = 0;
                    break;
                }
                break;
            case 48627:
                if (str.equals(PointType.ANTI_SPAM_TOUCH)) {
                    c = 1;
                    break;
                }
                break;
            case 48628:
                if (str.equals("103")) {
                    c = 2;
                    break;
                }
                break;
            case 48629:
                if (str.equals("104")) {
                    c = 3;
                    break;
                }
                break;
            case 48630:
                if (str.equals("105")) {
                    c = 4;
                    break;
                }
                break;
            case 48631:
                if (str.equals("106")) {
                    c = 5;
                    break;
                }
                break;
            case 48632:
                if (str.equals(PointType.WIND_ACTIVE)) {
                    c = 6;
                    break;
                }
                break;
            case 48633:
                if (str.equals("108")) {
                    c = 7;
                    break;
                }
                break;
            case 48634:
                if (str.equals("109")) {
                    c = '\b';
                    break;
                }
                break;
            case 48656:
                if (str.equals("110")) {
                    c = '\t';
                    break;
                }
                break;
            case 48657:
                if (str.equals("111")) {
                    c = '\n';
                    break;
                }
                break;
            case 48658:
                if (str.equals("112")) {
                    c = 11;
                    break;
                }
                break;
            case 48659:
                if (str.equals("113")) {
                    c = '\f';
                    break;
                }
                break;
            case 48660:
                if (str.equals("114")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 48661:
                if (str.equals("115")) {
                    c = 14;
                    break;
                }
                break;
            case 48662:
                if (str.equals("116")) {
                    c = 15;
                    break;
                }
                break;
            case 48663:
                if (str.equals("117")) {
                    c = 16;
                    break;
                }
                break;
            case 48664:
                if (str.equals("118")) {
                    c = 17;
                    break;
                }
                break;
            case 48665:
                if (str.equals("119")) {
                    c = 18;
                    break;
                }
                break;
            case 48687:
                if (str.equals("120")) {
                    c = 19;
                    break;
                }
                break;
            case 48688:
                if (str.equals("121")) {
                    c = 20;
                    break;
                }
                break;
            case 48689:
                if (str.equals("122")) {
                    c = 21;
                    break;
                }
                break;
            case 48690:
                if (str.equals("123")) {
                    c = 22;
                    break;
                }
                break;
            case 48691:
                if (str.equals("124")) {
                    c = 23;
                    break;
                }
                break;
            case 48692:
                if (str.equals("125")) {
                    c = 24;
                    break;
                }
                break;
            case 48693:
                if (str.equals("126")) {
                    c = 25;
                    break;
                }
                break;
            case 48694:
                if (str.equals("127")) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case 48695:
                if (str.equals("128")) {
                    c = 27;
                    break;
                }
                break;
            case 48696:
                if (str.equals("129")) {
                    c = 28;
                    break;
                }
                break;
            case 48718:
                if (str.equals("130")) {
                    c = 29;
                    break;
                }
                break;
            case 48719:
                if (str.equals("131")) {
                    c = 30;
                    break;
                }
                break;
            case 48720:
                if (str.equals("132")) {
                    c = 31;
                    break;
                }
                break;
            case 48721:
                if (str.equals("133")) {
                    c = ' ';
                    break;
                }
                break;
            case 48722:
                if (str.equals("134")) {
                    c = '!';
                    break;
                }
                break;
            case 48723:
                if (str.equals("135")) {
                    c = '\"';
                    break;
                }
                break;
            case 48724:
                if (str.equals("136")) {
                    c = '#';
                    break;
                }
                break;
            case 48725:
                if (str.equals("137")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 48726:
                if (str.equals("138")) {
                    c = '%';
                    break;
                }
                break;
            case 48727:
                if (str.equals("139")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 48749:
                if (str.equals("140")) {
                    c = '\'';
                    break;
                }
                break;
            case 48750:
                if (str.equals("141")) {
                    c = '(';
                    break;
                }
                break;
            case 48751:
                if (str.equals("142")) {
                    c = ')';
                    break;
                }
                break;
            case 48752:
                if (str.equals("143")) {
                    c = '*';
                    break;
                }
                break;
            case 48753:
                if (str.equals("144")) {
                    c = '+';
                    break;
                }
                break;
            case 48754:
                if (str.equals("145")) {
                    c = StringUtil.COMMA;
                    break;
                }
                break;
            case 48755:
                if (str.equals("146")) {
                    c = SignatureImpl.SEP;
                    break;
                }
                break;
            case 48756:
                if (str.equals("147")) {
                    c = '.';
                    break;
                }
                break;
            case 48757:
                if (str.equals("148")) {
                    c = '/';
                    break;
                }
                break;
            case 48758:
                if (str.equals("149")) {
                    c = '0';
                    break;
                }
                break;
            case 48780:
                if (str.equals("150")) {
                    c = '1';
                    break;
                }
                break;
            case 48781:
                if (str.equals("151")) {
                    c = '2';
                    break;
                }
                break;
            case 48782:
                if (str.equals("152")) {
                    c = '3';
                    break;
                }
                break;
            case 48783:
                if (str.equals("153")) {
                    c = '4';
                    break;
                }
                break;
            case 48784:
                if (str.equals("154")) {
                    c = '5';
                    break;
                }
                break;
            case 48785:
                if (str.equals("155")) {
                    c = '6';
                    break;
                }
                break;
            case 48786:
                if (str.equals("156")) {
                    c = '7';
                    break;
                }
                break;
            case 48787:
                if (str.equals("157")) {
                    c = '8';
                    break;
                }
                break;
            case 48788:
                if (str.equals("158")) {
                    c = '9';
                    break;
                }
                break;
            case 48789:
                if (str.equals("159")) {
                    c = ':';
                    break;
                }
                break;
            case 48811:
                if (str.equals("160")) {
                    c = ';';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                q60 q60Var = cVarA.b;
                if (q60Var == q60.AUTO) {
                    this.a.m();
                    break;
                } else if (q60Var == q60.PERCENT) {
                    this.a.q(cVarA.a);
                    break;
                } else {
                    this.a.p(zu.a(cVarA.a));
                    break;
                }
            case 1:
                q60 q60Var2 = cVarA.b;
                if (q60Var2 == q60.AUTO) {
                    this.a.l();
                    break;
                } else if (q60Var2 == q60.PERCENT) {
                    this.a.g(cVarA.a);
                    break;
                } else {
                    this.a.f(zu.a(cVarA.a));
                    break;
                }
            case 2:
                if (cVarA.b == q60.PERCENT) {
                    this.a.o(cVarA.a);
                    break;
                } else {
                    this.a.n(zu.a(cVarA.a));
                    break;
                }
            case 3:
                if (cVarA.b == q60.PERCENT) {
                    this.a.k(cVarA.a);
                    break;
                } else {
                    this.a.j(zu.a(cVarA.a));
                    break;
                }
            case 4:
                if (cVarA.b == q60.PERCENT) {
                    this.a.m(cVarA.a);
                    break;
                } else {
                    this.a.l(zu.a(cVarA.a));
                    break;
                }
            case 5:
                if (cVarA.b == q60.PERCENT) {
                    this.a.i(cVarA.a);
                    break;
                } else {
                    this.a.h(zu.a(cVarA.a));
                    break;
                }
            case 6:
                q60 q60Var3 = cVarA.b;
                if (q60Var3 == q60.AUTO) {
                    this.a.b(d60.LEFT);
                    break;
                } else if (q60Var3 == q60.PERCENT) {
                    this.a.c(d60.LEFT, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.LEFT, zu.a(cVarA.a));
                    break;
                }
            case 7:
                q60 q60Var4 = cVarA.b;
                if (q60Var4 == q60.AUTO) {
                    this.a.b(d60.TOP);
                    break;
                } else if (q60Var4 == q60.PERCENT) {
                    this.a.c(d60.TOP, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.TOP, zu.a(cVarA.a));
                    break;
                }
            case '\b':
                q60 q60Var5 = cVarA.b;
                if (q60Var5 == q60.AUTO) {
                    this.a.b(d60.RIGHT);
                    break;
                } else if (q60Var5 == q60.PERCENT) {
                    this.a.c(d60.RIGHT, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.RIGHT, zu.a(cVarA.a));
                    break;
                }
            case '\t':
                q60 q60Var6 = cVarA.b;
                if (q60Var6 == q60.AUTO) {
                    this.a.b(d60.BOTTOM);
                    break;
                } else if (q60Var6 == q60.PERCENT) {
                    this.a.c(d60.BOTTOM, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.BOTTOM, zu.a(cVarA.a));
                    break;
                }
            case '\n':
                q60 q60Var7 = cVarA.b;
                if (q60Var7 == q60.AUTO) {
                    this.a.b(d60.START);
                    break;
                } else if (q60Var7 == q60.PERCENT) {
                    this.a.c(d60.START, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.START, zu.a(cVarA.a));
                    break;
                }
            case 11:
                q60 q60Var8 = cVarA.b;
                if (q60Var8 == q60.AUTO) {
                    this.a.b(d60.END);
                    break;
                } else if (q60Var8 == q60.PERCENT) {
                    this.a.c(d60.END, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.END, zu.a(cVarA.a));
                    break;
                }
            case '\f':
                q60 q60Var9 = cVarA.b;
                if (q60Var9 == q60.AUTO) {
                    this.a.b(d60.HORIZONTAL);
                    break;
                } else if (q60Var9 == q60.PERCENT) {
                    this.a.c(d60.HORIZONTAL, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.HORIZONTAL, zu.a(cVarA.a));
                    break;
                }
            case '\r':
                q60 q60Var10 = cVarA.b;
                if (q60Var10 == q60.AUTO) {
                    this.a.b(d60.VERTICAL);
                    break;
                } else if (q60Var10 == q60.PERCENT) {
                    this.a.c(d60.VERTICAL, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.VERTICAL, zu.a(cVarA.a));
                    break;
                }
            case 14:
                q60 q60Var11 = cVarA.b;
                if (q60Var11 == q60.AUTO) {
                    this.a.b(d60.ALL);
                    break;
                } else if (q60Var11 == q60.PERCENT) {
                    this.a.c(d60.ALL, cVarA.a);
                    break;
                } else {
                    this.a.b(d60.ALL, zu.a(cVarA.a));
                    break;
                }
            case 15:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.LEFT, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.LEFT, zu.a(cVarA.a));
                    break;
                }
            case 16:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.TOP, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.TOP, zu.a(cVarA.a));
                    break;
                }
            case 17:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.RIGHT, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.RIGHT, zu.a(cVarA.a));
                    break;
                }
            case 18:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.BOTTOM, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.BOTTOM, zu.a(cVarA.a));
                    break;
                }
            case 19:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.START, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.START, zu.a(cVarA.a));
                    break;
                }
            case 20:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.END, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.END, zu.a(cVarA.a));
                    break;
                }
            case 21:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.HORIZONTAL, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.HORIZONTAL, zu.a(cVarA.a));
                    break;
                }
            case 22:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.VERTICAL, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.VERTICAL, zu.a(cVarA.a));
                    break;
                }
            case 23:
                if (cVarA.b == q60.PERCENT) {
                    this.a.e(d60.ALL, cVarA.a);
                    break;
                } else {
                    this.a.d(d60.ALL, zu.a(cVarA.a));
                    break;
                }
            case 24:
                this.a.a(a60.a(Math.round(cVarA.a)));
                break;
            case 25:
                this.a.b(a60.a(Math.round(cVarA.a)));
                break;
            case 26:
                this.a.c(a60.a(Math.round(cVarA.a)));
                break;
            case 27:
                this.a.a(cVarA.a);
                break;
            case 28:
                this.a.a(b60.a(Math.round(cVarA.a)));
                break;
            case 29:
                this.a.a(c60.a(Math.round(cVarA.a)));
                break;
            case 30:
                this.a.b(cVarA.a);
                break;
            case 31:
                this.a.c(zu.a(cVarA.a));
                break;
            case ' ':
                this.a.a(e60.a(Math.round(cVarA.a)));
                break;
            case '!':
                this.a.d(cVarA.a);
                break;
            case '\"':
                this.a.e(cVarA.a);
                break;
            case '#':
                this.a.a(g60.a(Math.round(cVarA.a)));
                break;
            case '$':
                this.a.a(o60.a(Math.round(cVarA.a)));
                break;
            case '%':
                this.a.a(r60.a(Math.round(cVarA.a)));
                break;
            case '&':
                this.a.a(p60.a(Math.round(cVarA.a)));
                break;
            case '\'':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.LEFT, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.LEFT, zu.a(cVarA.a));
                    break;
                }
            case '(':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.TOP, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.TOP, zu.a(cVarA.a));
                    break;
                }
            case ')':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.RIGHT, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.RIGHT, zu.a(cVarA.a));
                    break;
                }
            case '*':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.BOTTOM, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.BOTTOM, zu.a(cVarA.a));
                    break;
                }
            case '+':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.START, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.START, zu.a(cVarA.a));
                    break;
                }
            case ',':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.END, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.END, zu.a(cVarA.a));
                    break;
                }
            case '-':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.HORIZONTAL, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.HORIZONTAL, zu.a(cVarA.a));
                    break;
                }
            case '.':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.VERTICAL, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.VERTICAL, zu.a(cVarA.a));
                    break;
                }
            case '/':
                if (cVarA.b == q60.PERCENT) {
                    this.a.g(d60.ALL, cVarA.a);
                    break;
                } else {
                    this.a.f(d60.ALL, zu.a(cVarA.a));
                    break;
                }
            case '0':
                this.a.a(d60.LEFT, zu.a(cVarA.a));
                break;
            case '1':
                this.a.a(d60.TOP, zu.a(cVarA.a));
                break;
            case '2':
                this.a.a(d60.RIGHT, zu.a(cVarA.a));
                break;
            case '3':
                this.a.a(d60.BOTTOM, zu.a(cVarA.a));
                break;
            case '4':
                this.a.a(d60.START, zu.a(cVarA.a));
                break;
            case '5':
                this.a.a(d60.END, zu.a(cVarA.a));
                break;
            case '6':
                this.a.a(d60.HORIZONTAL, zu.a(cVarA.a));
                break;
            case '7':
                this.a.a(d60.VERTICAL, zu.a(cVarA.a));
                break;
            case '8':
                this.a.a(d60.ALL, zu.a(cVarA.a));
                break;
            case '9':
                this.a.a(f60.COLUMN, zu.a(cVarA.a));
                break;
            case ':':
                this.a.a(f60.ROW, zu.a(cVarA.a));
                break;
            case ';':
                this.a.a(f60.ALL, zu.a(cVarA.a));
                break;
            default:
                return false;
        }
        this.c = true;
        this.a.a();
        return true;
    }

    public void a(com.qq.e.lib.yoga.a aVar) {
        this.a = aVar;
    }
}
