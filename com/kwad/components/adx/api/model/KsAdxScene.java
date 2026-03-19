package com.kwad.components.adx.api.model;

import android.app.Activity;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.components.d;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface KsAdxScene extends Serializable {
    int getAction();

    Activity getActivity();

    int getAdNum();

    int getAdStyle();

    String getBackUrl();

    String getComment();

    int getHeight();

    List<CtAdTemplate> getKsAdList();

    String getPromoteId();

    int getRequestCount();

    int getWidth();

    void setAction(int i);

    void setActivity(Activity activity);

    void setAdNum(int i);

    void setAdStyle(int i);

    void setBackUrl(String str);

    void setComment(String str);

    void setHeight(int i);

    void setKsAdLabel(IKsAdLabel iKsAdLabel);

    void setKsAdList(List<CtAdTemplate> list);

    void setPromoteId(String str);

    void setRequestCount(int i);

    void setWidth(int i);

    JSONObject toJson();

    public static class a {
        private KsAdxScene OP = (KsAdxScene) ((com.kwad.components.adx.api.a) d.g(com.kwad.components.adx.api.a.class)).ob().od();

        public final a k(List<CtAdTemplate> list) {
            this.OP.setKsAdList(list);
            return this;
        }

        public final a av(int i) {
            this.OP.setRequestCount(i);
            return this;
        }

        public final a aw(int i) {
            this.OP.setAdNum(i);
            return this;
        }

        public final a ax(int i) {
            this.OP.setAction(i);
            return this;
        }

        public final a ay(int i) {
            this.OP.setWidth(i);
            return this;
        }

        public final a az(int i) {
            this.OP.setHeight(i);
            return this;
        }

        public final a af(String str) {
            this.OP.setPromoteId(str);
            return this;
        }

        public final a ag(String str) {
            this.OP.setComment(str);
            return this;
        }

        public final a ah(String str) {
            this.OP.setBackUrl(str);
            return this;
        }

        public final a b(Activity activity) {
            this.OP.setActivity(activity);
            return this;
        }

        public final KsAdxScene oe() {
            return this.OP;
        }
    }
}
