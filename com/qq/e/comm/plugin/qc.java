package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qc extends r4 {
    private int f;
    private int g;

    @Override // com.qq.e.comm.plugin.r4
    protected String d() {
        return "ei";
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ f5 a() {
        return super.a();
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ ja b() {
        return super.b();
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ int c() {
        return super.c();
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ JSONObject e() {
        return super.e();
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ void a(f5 f5Var) {
        super.a(f5Var);
    }

    public qc(int i) {
        super(i);
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ void a(ja jaVar) {
        super.a(jaVar);
    }

    public void d(int i) {
        this.f = i;
        a("error_code", Integer.valueOf(i));
    }

    @Override // com.qq.e.comm.plugin.r4
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public int g() {
        return this.f;
    }

    public qc(String str) {
        super(str);
    }

    public int f() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
        a("enum_code", Integer.valueOf(i));
    }

    public void b(int i) {
        if (i > 0) {
            a("adcnt", Integer.valueOf(i));
        }
    }

    public void a(zr zrVar) {
        if (zrVar != null) {
            a(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(zrVar.b()));
        }
    }
}
