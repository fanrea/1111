package com.bytedance.msdk.b.d.d;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.mq;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends gb {
    public u(com.bytedance.msdk.b.b.hc.d.d.hc hcVar, Function<SparseArray<Object>, Object> function) {
        super(hcVar, function);
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8127).d(Void.class).d(8034, this).hc());
            is();
        }
    }

    private void is() {
        PluginValueSet pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(this.tc);
        if (pluginValueSetHc != null) {
            Map<String, Object> map = (Map) pluginValueSetHc.objectValue(8006, Map.class);
            String strStringValue = pluginValueSetHc.stringValue(8045);
            String strStringValue2 = pluginValueSetHc.stringValue(8046);
            String strStringValue3 = pluginValueSetHc.stringValue(8048);
            String strStringValue4 = pluginValueSetHc.stringValue(8049);
            String strStringValue5 = pluginValueSetHc.stringValue(8050);
            int iIntValue = pluginValueSetHc.intValue(8051);
            int iIntValue2 = pluginValueSetHc.intValue(8052);
            List<String> list = (List) pluginValueSetHc.objectValue(8053, List.class);
            String strStringValue6 = pluginValueSetHc.stringValue(8054);
            double dDoubleValue = pluginValueSetHc.doubleValue(8016);
            boolean zBooleanValue = pluginValueSetHc.booleanValue(8033);
            int iIntValue3 = pluginValueSetHc.intValue(8060);
            String strStringValue7 = pluginValueSetHc.stringValue(8061);
            double dDoubleValue2 = pluginValueSetHc.doubleValue(8082);
            int iIntValue4 = pluginValueSetHc.intValue(8420);
            int iIntValue5 = pluginValueSetHc.intValue(8421);
            int iIntValue6 = pluginValueSetHc.intValue(8059);
            Function function = (Function) pluginValueSetHc.objectValue(8315, Function.class);
            if (dDoubleValue > 0.0d) {
                d(dDoubleValue);
            }
            b(map);
            us(strStringValue);
            z(strStringValue2);
            vv(strStringValue3);
            zw(strStringValue5);
            yo(iIntValue2);
            rf(iIntValue);
            j(strStringValue7);
            s(strStringValue6);
            sy(iIntValue4);
            de(iIntValue5);
            c(dDoubleValue2);
            d(list);
            fs(strStringValue4);
            h(zBooleanValue);
            mk(iIntValue3);
            mq(iIntValue6);
            if (function != null) {
                com.bytedance.msdk.d.c.d.d.d dVar = new com.bytedance.msdk.d.c.d.d.d(function);
                de(dVar.b());
                v(dVar.c());
                hc(dVar.u());
                np(dVar.an());
                yi(dVar.gb());
                he(dVar.tt());
                u(dVar.h());
            }
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
        if (this.tc == null) {
            return null;
        }
        Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6072).d(Function.class).d(20033, activity).hc());
        if (!(objApply instanceof Function)) {
            return null;
        }
        final com.bytedance.sdk.openadsdk.mediation.hc.hc.an anVar = new com.bytedance.sdk.openadsdk.mediation.hc.hc.an((Function) objApply);
        return new com.bytedance.sdk.openadsdk.w.b.hc.h() { // from class: com.bytedance.msdk.b.d.d.u.1
            public boolean b() {
                return false;
            }

            public void d(String str) {
            }

            public void hc() {
            }

            public void d() {
                anVar.d();
            }

            public void d(com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
                anVar.d(new com.bytedance.msdk.d.c.d.d.hc(dVar));
            }
        };
    }

    @Override // com.bytedance.msdk.b.d.d.b
    public void d(boolean z, double d, int i, Map<String, Object> map) {
        super.d(z, d, i, map);
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(AVMDLDataLoader.KeyIsEnableSpeedReport).d(Void.class).d(8406, Boolean.valueOf(z)).d(8407, Double.valueOf(d)).d(8408, Integer.valueOf(i)).d(8075, map).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        if (this.tc != null) {
            Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6081).d(View.class).hc());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tt();
    }

    @Override // com.bytedance.msdk.hc.b
    public View tc() {
        if (this.tc != null) {
            Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(6164).d(View.class).hc());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.tc();
    }

    @Override // com.bytedance.msdk.b.d.d.gb
    public void d(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar) {
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8159).d(Void.class).d(20033, activity).d(8067, viewGroup).d(8068, list).d(8069, list2).d(8070, list3).d(8071, com.bytedance.msdk.api.c.d.h.tc.d(tcVar)).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public com.bytedance.msdk.api.c.d.h.u gb() {
        if (this.tc != null) {
            Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8320).d(Function.class).hc());
            if (objApply instanceof Function) {
                return com.bytedance.msdk.core.d.d.d((Function) objApply);
            }
        }
        return super.gb();
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean jh() {
        if (this.tc != null) {
            Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8135).d(Boolean.class).hc());
            return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
        }
        return super.jh();
    }

    @Override // com.bytedance.msdk.b.d.d.b, com.bytedance.msdk.hc.b
    public void cb() {
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8149).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.b.d.d.b, com.bytedance.msdk.hc.b
    public void w() {
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8148).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.b.d.d.b, com.bytedance.msdk.hc.b
    public void yo() {
        if (this.tc != null) {
            this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8109).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.b.d.d.b, com.bytedance.msdk.hc.b
    public Integer an() {
        if (this.tc != null) {
            Integer numD = com.bytedance.sdk.openadsdk.core.ba.d.d.d(this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8121).d(Object.class).d(20068, 1).hc()));
            if (numD != null) {
                return numD;
            }
        }
        return 1;
    }

    @Override // com.bytedance.msdk.hc.b
    public String h() {
        if (this.tc != null) {
            Object objApply = this.tc.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8228).d(String.class).hc());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.h();
    }

    public void d(View view, String str, int i) {
        if (mq() instanceof com.bytedance.msdk.api.c.d.h.an) {
            try {
                ((com.bytedance.msdk.api.c.d.h.an) mq()).d(view, str, i);
            } catch (Exception e) {
                mq.d(e);
            }
        }
    }

    public void d(float f, float f2) {
        if (mq() instanceof com.bytedance.msdk.api.c.d.h.an) {
            try {
                ((com.bytedance.msdk.api.c.d.h.an) mq()).d(f, f2);
            } catch (Exception e) {
                mq.d(e);
            }
        }
    }

    public void g() {
        d(new d() { // from class: com.bytedance.msdk.b.d.d.u.2
            @Override // com.bytedance.msdk.b.d.d.d
            public void d() {
                if (u.this.mq() != null) {
                    u.this.mq().d(null);
                }
            }
        });
    }

    public void xq() {
        hc(new d() { // from class: com.bytedance.msdk.b.d.d.u.3
            @Override // com.bytedance.msdk.b.d.d.d
            public void d() {
                if (u.this.mq() != null) {
                    u.this.mq().d();
                }
            }
        });
    }

    public void yl() {
        if (uo() != null) {
            uo().hc();
        }
    }

    public void nz() {
        if (uo() != null) {
            uo().b();
        }
    }

    public void eh() {
        if (uo() != null) {
            uo().c();
        }
    }

    public void ua() {
        if (uo() != null) {
            uo().u();
        }
    }

    public void d(com.bytedance.msdk.api.c.d.hc.d dVar) {
        if (uo() != null) {
            uo().d(new com.bytedance.msdk.api.d(49012, com.bytedance.msdk.api.d.d(49012), dVar == null ? -1 : dVar.d(), dVar == null ? "" : dVar.hc()));
        }
    }

    public void d(long j, long j2) {
        if (uo() != null) {
            uo().d(j, j2);
        }
    }

    public void sz() {
        if (k() != null) {
            k().d();
        }
    }

    public void d(long j, long j2, String str, String str2) {
        if (k() != null) {
            k().d(j, j2, -1, 1, str, str2);
        }
    }

    public void hc(long j, long j2, String str, String str2) {
        if (k() != null) {
            k().d(j, j2, str, str2);
        }
    }

    public void b(long j, long j2, String str, String str2) {
        if (k() != null) {
            k().hc(j, j2, str, str2);
        }
    }

    public void d(long j, String str, String str2) {
        if (k() != null) {
            k().d(j, str, str2);
        }
    }

    public void d(String str, String str2) {
        if (k() != null) {
            k().d(str, str2);
        }
    }

    public void bq() {
        if (rf() != null) {
            rf().d();
        }
    }

    public void ij() {
        if (rf() != null) {
            rf().hc();
        }
    }

    public void d(int i, String str) {
        if (this.tt != null) {
            this.tt.d(this, str);
        }
        if (rf() != null) {
            rf().d(i, str, false);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeRenderFail code:" + iIntValue + " msg:" + strStringValue + " view" + view);
            d(view, strStringValue, iIntValue);
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeRenderSuccess width:" + fFloatValue + " height:" + fFloatValue2);
            d(fFloatValue, fFloatValue2);
        } else if (i == 8130) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeAdClick");
            g();
        } else if (i == 8113) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeAdShow");
            xq();
        } else if (i == 8145) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoStart");
            yl();
        } else if (i == 8146) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoPause");
            nz();
        } else if (i == 8150) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoResume");
            eh();
        } else if (i == 8118) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoCompleted");
            ua();
        } else if (i == 8117) {
            int iIntValue2 = pluginValueSet.intValue(8014);
            String strStringValue2 = pluginValueSet.stringValue(8015);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoError code:" + iIntValue2 + " msg:" + strStringValue2);
            d(new com.bytedance.msdk.api.c.d.hc.d(iIntValue2, strStringValue2));
        } else if (i == 8154) {
            long jLongValue = pluginValueSet.longValue(8072);
            long jLongValue2 = pluginValueSet.longValue(8073);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeVideoError current:" + jLongValue + " duration:" + jLongValue2);
            d(jLongValue, jLongValue2);
        } else if (i == 8152) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnIdle");
            sz();
        } else if (i == 8187) {
            long jLongValue3 = pluginValueSet.longValue(8062);
            long jLongValue4 = pluginValueSet.longValue(8063);
            pluginValueSet.intValue(8064);
            pluginValueSet.intValue(8065);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadActive totalBytes:" + jLongValue3 + " curlBytes:" + jLongValue4);
            d(jLongValue3, jLongValue4, "", "");
        } else if (i == 8158) {
            long jLongValue5 = pluginValueSet.longValue(8062);
            long jLongValue6 = pluginValueSet.longValue(8063);
            String strStringValue3 = pluginValueSet.stringValue(8066);
            String strStringValue4 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadPaused totalBytes:" + jLongValue5 + " curlBytes:" + jLongValue6 + " fileName:" + strStringValue3 + " appName:" + strStringValue4);
            hc(jLongValue5, jLongValue6, strStringValue3, strStringValue4);
        } else if (i == 8157) {
            long jLongValue7 = pluginValueSet.longValue(8062);
            long jLongValue8 = pluginValueSet.longValue(8063);
            String strStringValue5 = pluginValueSet.stringValue(8066);
            String strStringValue6 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFailed totalBytes:" + jLongValue7 + " curlBytes:" + jLongValue8 + " fileName:" + strStringValue5 + " appName:" + strStringValue6);
            b(jLongValue7, jLongValue8, strStringValue5, strStringValue6);
        } else if (i == 8155) {
            long jLongValue9 = pluginValueSet.longValue(8062);
            String strStringValue7 = pluginValueSet.stringValue(8066);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFinished totalBytes:" + jLongValue9 + " fileName:" + strStringValue7 + " appName:" + strStringValue8);
            d(jLongValue9, strStringValue7, strStringValue8);
        } else if (i == 8156) {
            String strStringValue9 = pluginValueSet.stringValue(8066);
            String strStringValue10 = pluginValueSet.stringValue(8056);
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeOnDownloadFinished  fileName:" + strStringValue9 + " appName:" + strStringValue10);
            d(strStringValue9, strStringValue10);
        } else if (i == 8185) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeDislikeShow");
            bq();
        } else if (i == 8184) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeDislikeCancel");
            ij();
        } else if (i != 6085) {
            if (i == 8110) {
                boolean zTj = tj();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : isClientBiddingAd :".concat(String.valueOf(zTj)));
                return (T) Boolean.valueOf(zTj);
            }
            if (i == 8136) {
                boolean zOc = oc();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : isServerBiddingAd :".concat(String.valueOf(zOc)));
                return (T) Boolean.valueOf(zOc);
            }
            if (i == 8160) {
                boolean zMt = mt();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : isUseCustomVideo :".concat(String.valueOf(zMt)));
                return (T) Boolean.valueOf(zMt);
            }
            if (i == 8226) {
                int iHg = hg();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : getBiddingType :".concat(String.valueOf(iHg)));
                return (T) Integer.valueOf(iHg);
            }
            if (i == 8132) {
                int iIntValue3 = pluginValueSet.intValue(8038);
                String strStringValue11 = pluginValueSet.stringValue(8039);
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom feed ad : callNativeDislikeSelected postion:" + iIntValue3 + " value:" + strStringValue11);
                d(iIntValue3, strStringValue11);
            }
        }
        return (T) com.bytedance.msdk.core.cb.d.d(cls);
    }
}
