package com.baidu.mobads.container.e;

import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.bridge.JavascriptHelper;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ag implements JavascriptHelper.a {
    final /* synthetic */ l a;

    ag(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.container.bridge.JavascriptHelper.a
    public void a(String str) {
        HashMap<String, Object> shouBaiLpFlag = this.a.getShouBaiLpFlag(this.a.mAdContainerCxt, this.a.mAdInstanceInfo);
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        shouBaiLpFlag.put("t_url", str);
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(this.a.mAdInstanceInfo);
        xAdInstanceInfoExt.setActionType(1);
        new com.baidu.mobads.container.components.k.c(this.a).a((com.baidu.mobads.container.k) this.a, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, shouBaiLpFlag);
        this.a.a(xAdInstanceInfoExt);
    }

    @Override // com.baidu.mobads.container.bridge.JavascriptHelper.a
    public void b(String str) {
        HashMap<String, Object> shouBaiLpFlag = this.a.getShouBaiLpFlag(this.a.mAdContainerCxt, this.a.mAdInstanceInfo);
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(this.a.mAdInstanceInfo);
        xAdInstanceInfoExt.setAppOpenStrs(str);
        xAdInstanceInfoExt.setActionType(512);
        new com.baidu.mobads.container.components.k.c(this.a).a((com.baidu.mobads.container.k) this.a, (com.baidu.mobads.container.adrequest.j) xAdInstanceInfoExt, (Boolean) true, shouBaiLpFlag);
        this.a.a(xAdInstanceInfoExt);
    }

    @Override // com.baidu.mobads.container.bridge.JavascriptHelper.a
    public void a(String str, String str2) {
    }
}
