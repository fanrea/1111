package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class x2 implements hj {
    @Override // com.qq.e.comm.plugin.hj
    public void a(String str, w2 w2Var, List<String> list) {
        if (str == null || w2Var == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("g");
            if (!TextUtils.isEmpty(strOptString) && !list.contains("g")) {
                w2Var.a = strOptString;
            }
            String strOptString2 = jSONObject.optString(Config.STAT_SDK_CHANNEL);
            if (!TextUtils.isEmpty(strOptString2) && !list.contains(Config.STAT_SDK_CHANNEL)) {
                w2Var.b = strOptString2;
            }
            String strOptString3 = jSONObject.optString("ec");
            if (!TextUtils.isEmpty(strOptString3) && !list.contains("ec")) {
                w2Var.c = strOptString3;
            }
            String strOptString4 = jSONObject.optString("aa");
            if (!TextUtils.isEmpty(strOptString4) && !list.contains("aa")) {
                w2Var.d = strOptString4;
            }
            String strOptString5 = jSONObject.optString("ab");
            if (!TextUtils.isEmpty(strOptString5) && !list.contains("ab")) {
                w2Var.e = strOptString5;
            }
            String strOptString6 = jSONObject.optString("ba");
            if (!TextUtils.isEmpty(strOptString6) && !list.contains("ba")) {
                w2Var.f = strOptString6;
            }
            String strOptString7 = jSONObject.optString("bb");
            if (!TextUtils.isEmpty(strOptString7) && !list.contains("bb")) {
                w2Var.g = strOptString7;
            }
            String strOptString8 = jSONObject.optString("d");
            if (!TextUtils.isEmpty(strOptString8) && !list.contains("d")) {
                w2Var.h = strOptString8;
            }
            String strOptString9 = jSONObject.optString("p");
            if (!TextUtils.isEmpty(strOptString9) && !list.contains("p")) {
                w2Var.i = strOptString9;
            }
            String strOptString10 = jSONObject.optString("f");
            if (!TextUtils.isEmpty(strOptString10) && !list.contains("f")) {
                w2Var.j = strOptString10;
            }
            String strOptString11 = jSONObject.optString("da");
            if (!TextUtils.isEmpty(strOptString11) && !list.contains("da")) {
                w2Var.k = strOptString11;
            }
            String strOptString12 = jSONObject.optString("db");
            if (!TextUtils.isEmpty(strOptString12) && !list.contains("db")) {
                w2Var.l = strOptString12;
            }
            String strOptString13 = jSONObject.optString("dx");
            if (!TextUtils.isEmpty(strOptString13) && !list.contains("dx")) {
                w2Var.m = strOptString13;
            }
            String strOptString14 = jSONObject.optString("dy");
            if (!TextUtils.isEmpty(strOptString14) && !list.contains("dy")) {
                w2Var.n = strOptString14;
            }
            String strOptString15 = jSONObject.optString("ra");
            if (!TextUtils.isEmpty(strOptString15) && !list.contains("ra")) {
                w2Var.o = strOptString15;
            }
            String strOptString16 = jSONObject.optString("rb");
            if (!TextUtils.isEmpty(strOptString16) && !list.contains("rb")) {
                w2Var.p = strOptString16;
            }
            String strOptString17 = jSONObject.optString(com.baidu.mobads.container.adrequest.g.R);
            if (!TextUtils.isEmpty(strOptString17) && !list.contains(com.baidu.mobads.container.adrequest.g.R)) {
                w2Var.q = strOptString17;
            }
            String strOptString18 = jSONObject.optString(com.baidu.mobads.container.components.command.j.s);
            if (!TextUtils.isEmpty(strOptString18) && !list.contains(com.baidu.mobads.container.components.command.j.s)) {
                w2Var.r = strOptString18;
            }
            String strOptString19 = jSONObject.optString("vs");
            if (!TextUtils.isEmpty(strOptString19) && !list.contains("vs")) {
                w2Var.s = strOptString19;
            }
            String strOptString20 = jSONObject.optString("dpn");
            if (!TextUtils.isEmpty(strOptString20) && !list.contains("dpn")) {
                w2Var.t = strOptString20;
            }
            String strOptString21 = jSONObject.optString("cr");
            if (!TextUtils.isEmpty(strOptString21) && !list.contains("cr")) {
                w2Var.u = strOptString21;
            }
            String strOptString22 = jSONObject.optString("rt");
            if (!TextUtils.isEmpty(strOptString22) && !list.contains("rt")) {
                w2Var.v = strOptString22;
            }
            String strOptString23 = jSONObject.optString("pw");
            if (!TextUtils.isEmpty(strOptString23) && !list.contains("pw")) {
                w2Var.w = strOptString23;
            }
            String strOptString24 = jSONObject.optString("ph");
            if (!TextUtils.isEmpty(strOptString24) && !list.contains("ph")) {
                w2Var.x = strOptString24;
            }
            String strOptString25 = jSONObject.optString("fg");
            if (!TextUtils.isEmpty(strOptString25) && !list.contains("fg")) {
                w2Var.y = strOptString25;
            }
            String strOptString26 = jSONObject.optString("co");
            if (!TextUtils.isEmpty(strOptString26) && !list.contains("co")) {
                w2Var.z = strOptString26;
            }
            String strOptString27 = jSONObject.optString("sl");
            if (!TextUtils.isEmpty(strOptString27) && !list.contains("sl")) {
                w2Var.A = strOptString27;
            }
            String strOptString28 = jSONObject.optString("xi");
            if (!TextUtils.isEmpty(strOptString28) && !list.contains("xi")) {
                w2Var.B = strOptString28;
            }
            String strOptString29 = jSONObject.optString("ic");
            if (!TextUtils.isEmpty(strOptString29) && !list.contains("ic")) {
                w2Var.C = strOptString29;
            }
            String strOptString30 = jSONObject.optString("uc");
            if (!TextUtils.isEmpty(strOptString30) && !list.contains("uc")) {
                w2Var.D = strOptString30;
            }
            String strOptString31 = jSONObject.optString("id");
            if (!TextUtils.isEmpty(strOptString31) && !list.contains("id")) {
                w2Var.E = strOptString31;
            }
            String strOptString32 = jSONObject.optString("sp");
            if (!TextUtils.isEmpty(strOptString32) && !list.contains("sp")) {
                w2Var.F = strOptString32;
            }
            String strOptString33 = jSONObject.optString("pk");
            if (!TextUtils.isEmpty(strOptString33) && !list.contains("pk")) {
                w2Var.G = strOptString33;
            }
            String strOptString34 = jSONObject.optString("si");
            if (!TextUtils.isEmpty(strOptString34) && !list.contains("si")) {
                w2Var.H = strOptString34;
            }
            String strOptString35 = jSONObject.optString("ch");
            if (!TextUtils.isEmpty(strOptString35) && !list.contains("ch")) {
                w2Var.I = strOptString35;
            }
            String strOptString36 = jSONObject.optString("as");
            if (!TextUtils.isEmpty(strOptString36) && !list.contains("as")) {
                w2Var.J = strOptString36;
            }
            String strOptString37 = jSONObject.optString("cpk");
            if (!TextUtils.isEmpty(strOptString37) && !list.contains("cpk")) {
                w2Var.f785K = strOptString37;
            }
            String strOptString38 = jSONObject.optString("csi");
            if (!TextUtils.isEmpty(strOptString38) && !list.contains("csi")) {
                w2Var.L = strOptString38;
            }
            String strOptString39 = jSONObject.optString("cas");
            if (!TextUtils.isEmpty(strOptString39) && !list.contains("cas")) {
                w2Var.M = strOptString39;
            }
            String strOptString40 = jSONObject.optString("xo");
            if (!TextUtils.isEmpty(strOptString40) && !list.contains("xo")) {
                w2Var.N = strOptString40;
            }
            String strOptString41 = jSONObject.optString("yo");
            if (!TextUtils.isEmpty(strOptString41) && !list.contains("yo")) {
                w2Var.O = strOptString41;
            }
            String strOptString42 = jSONObject.optString(com.kuaishou.weapon.p0.t.q);
            if (!TextUtils.isEmpty(strOptString42) && !list.contains(com.kuaishou.weapon.p0.t.q)) {
                w2Var.P = strOptString42;
            }
            String strOptString43 = jSONObject.optString(com.baidu.mobads.container.adrequest.g.z);
            if (!TextUtils.isEmpty(strOptString43) && !list.contains(com.baidu.mobads.container.adrequest.g.z)) {
                w2Var.Q = strOptString43;
            }
            String strOptString44 = jSONObject.optString("td");
            if (!TextUtils.isEmpty(strOptString44) && !list.contains("td")) {
                w2Var.R = strOptString44;
            }
            String strOptString45 = jSONObject.optString(Config.OAID);
            if (!TextUtils.isEmpty(strOptString45) && !list.contains(Config.OAID)) {
                w2Var.S = strOptString45;
            }
            String strOptString46 = jSONObject.optString("br");
            if (!TextUtils.isEmpty(strOptString46) && !list.contains("br")) {
                w2Var.T = strOptString46;
            }
            String strOptString47 = jSONObject.optString("mf");
            if (!TextUtils.isEmpty(strOptString47) && !list.contains("mf")) {
                w2Var.U = strOptString47;
            }
            String strOptString48 = jSONObject.optString("hw");
            if (!TextUtils.isEmpty(strOptString48) && !list.contains("hw")) {
                w2Var.V = strOptString48;
            }
            String strOptString49 = jSONObject.optString("tid");
            if (!TextUtils.isEmpty(strOptString49) && !list.contains("tid")) {
                w2Var.W = strOptString49;
            }
            String strOptString50 = jSONObject.optString(Config.TARGET_SDK_VERSION);
            if (!TextUtils.isEmpty(strOptString50) && !list.contains(Config.TARGET_SDK_VERSION)) {
                w2Var.X = strOptString50;
            }
            String strOptString51 = jSONObject.optString("compo");
            if (!TextUtils.isEmpty(strOptString51) && !list.contains("compo")) {
                w2Var.Y = strOptString51;
            }
            String strOptString52 = jSONObject.optString("csf");
            if (!TextUtils.isEmpty(strOptString52) && !list.contains("csf")) {
                w2Var.Z = strOptString52;
            }
            String strOptString53 = jSONObject.optString("sz");
            if (!TextUtils.isEmpty(strOptString53) && !list.contains("sz")) {
                w2Var.a0 = strOptString53;
            }
            String strOptString54 = jSONObject.optString("vp");
            if (!TextUtils.isEmpty(strOptString54) && !list.contains("vp")) {
                w2Var.b0 = strOptString54;
            }
            String strOptString55 = jSONObject.optString("x");
            if (!TextUtils.isEmpty(strOptString55) && !list.contains("x")) {
                w2Var.c0 = strOptString55;
            }
            String strOptString56 = jSONObject.optString("sg");
            if (!TextUtils.isEmpty(strOptString56) && !list.contains("sg")) {
                w2Var.d0 = strOptString56;
            }
            String strOptString57 = jSONObject.optString("sld");
            if (!TextUtils.isEmpty(strOptString57) && !list.contains("sld")) {
                w2Var.e0 = strOptString57;
            }
            String strOptString58 = jSONObject.optString("am");
            if (!TextUtils.isEmpty(strOptString58) && !list.contains("am")) {
                w2Var.f0 = strOptString58;
            }
            String strOptString59 = jSONObject.optString("nx");
            if (!TextUtils.isEmpty(strOptString59) && !list.contains("nx")) {
                w2Var.g0 = strOptString59;
            }
            String strOptString60 = jSONObject.optString("ny");
            if (!TextUtils.isEmpty(strOptString60) && !list.contains("ny")) {
                w2Var.h0 = strOptString60;
            }
            String strOptString61 = jSONObject.optString("nz");
            if (!TextUtils.isEmpty(strOptString61) && !list.contains("nz")) {
                w2Var.i0 = strOptString61;
            }
            String strOptString62 = jSONObject.optString("nt");
            if (!TextUtils.isEmpty(strOptString62) && !list.contains("nt")) {
                w2Var.j0 = strOptString62;
            }
            String strOptString63 = jSONObject.optString("ca");
            if (!TextUtils.isEmpty(strOptString63) && !list.contains("ca")) {
                w2Var.k0 = strOptString63;
            }
            String strOptString64 = jSONObject.optString("rwd");
            if (!TextUtils.isEmpty(strOptString64) && !list.contains("rwd")) {
                w2Var.l0 = strOptString64;
            }
            String strOptString65 = jSONObject.optString("media_ext");
            if (!TextUtils.isEmpty(strOptString65) && !list.contains("media_ext")) {
                w2Var.m0 = strOptString65;
            }
            String strOptString66 = jSONObject.optString("bfn");
            if (!TextUtils.isEmpty(strOptString66) && !list.contains("bfn")) {
                w2Var.n0 = strOptString66;
            }
            String strOptString67 = jSONObject.optString("bfon");
            if (!TextUtils.isEmpty(strOptString67) && !list.contains("bfon")) {
                w2Var.o0 = strOptString67;
            }
            String strOptString68 = jSONObject.optString("sm");
            if (!TextUtils.isEmpty(strOptString68) && !list.contains("sm")) {
                w2Var.p0 = strOptString68;
            }
            String strOptString69 = jSONObject.optString("in");
            if (!TextUtils.isEmpty(strOptString69) && !list.contains("in")) {
                w2Var.q0 = strOptString69;
            }
            String strOptString70 = jSONObject.optString("pcs");
            if (!TextUtils.isEmpty(strOptString70) && !list.contains("pcs")) {
                w2Var.r0 = strOptString70;
            }
            String strOptString71 = jSONObject.optString("se");
            if (!TextUtils.isEmpty(strOptString71) && !list.contains("se")) {
                w2Var.s0 = strOptString71;
            }
            String strOptString72 = jSONObject.optString("_do");
            if (!TextUtils.isEmpty(strOptString72) && !list.contains("_do")) {
                w2Var.t0 = strOptString72;
            }
            String strOptString73 = jSONObject.optString("ac");
            if (!TextUtils.isEmpty(strOptString73) && !list.contains("ac")) {
                w2Var.u0 = strOptString73;
            }
            String strOptString74 = jSONObject.optString("ot");
            if (!TextUtils.isEmpty(strOptString74) && !list.contains("ot")) {
                w2Var.v0 = strOptString74;
            }
            String strOptString75 = jSONObject.optString("dsf");
            if (!TextUtils.isEmpty(strOptString75) && !list.contains("dsf")) {
                w2Var.w0 = strOptString75;
            }
            String strOptString76 = jSONObject.optString("raa");
            if (!TextUtils.isEmpty(strOptString76) && !list.contains("raa")) {
                w2Var.x0 = strOptString76;
            }
            String strOptString77 = jSONObject.optString("rab");
            if (!TextUtils.isEmpty(strOptString77) && !list.contains("rab")) {
                w2Var.y0 = strOptString77;
            }
            String strOptString78 = jSONObject.optString("dscn");
            if (!TextUtils.isEmpty(strOptString78) && !list.contains("dscn")) {
                w2Var.z0 = strOptString78;
            }
            String strOptString79 = jSONObject.optString("usf");
            if (!TextUtils.isEmpty(strOptString79) && !list.contains("usf")) {
                w2Var.A0 = strOptString79;
            }
            String strOptString80 = jSONObject.optString("rba");
            if (!TextUtils.isEmpty(strOptString80) && !list.contains("rba")) {
                w2Var.B0 = strOptString80;
            }
            String strOptString81 = jSONObject.optString("rbb");
            if (!TextUtils.isEmpty(strOptString81) && !list.contains("rbb")) {
                w2Var.C0 = strOptString81;
            }
            String strOptString82 = jSONObject.optString("uscn");
            if (!TextUtils.isEmpty(strOptString82) && !list.contains("uscn")) {
                w2Var.D0 = strOptString82;
            }
            String strOptString83 = jSONObject.optString("fc");
            if (!TextUtils.isEmpty(strOptString83) && !list.contains("fc")) {
                w2Var.E0 = strOptString83;
            }
            String strOptString84 = jSONObject.optString("fcc");
            if (!TextUtils.isEmpty(strOptString84) && !list.contains("fcc")) {
                w2Var.F0 = strOptString84;
            }
            String strOptString85 = jSONObject.optString("inex");
            if (!TextUtils.isEmpty(strOptString85) && !list.contains("inex")) {
                w2Var.G0 = strOptString85;
            }
            String strOptString86 = jSONObject.optString("cvi");
            if (!TextUtils.isEmpty(strOptString86) && !list.contains("cvi")) {
                w2Var.H0 = strOptString86;
            }
            String strOptString87 = jSONObject.optString("uit");
            if (!TextUtils.isEmpty(strOptString87) && !list.contains("uit")) {
                w2Var.I0 = strOptString87;
            }
            String strOptString88 = jSONObject.optString("cghcl");
            if (!TextUtils.isEmpty(strOptString88) && !list.contains("cghcl")) {
                w2Var.J0 = strOptString88;
            }
            String strOptString89 = jSONObject.optString("expid");
            if (!TextUtils.isEmpty(strOptString89) && !list.contains("expid")) {
                w2Var.K0 = strOptString89;
            }
            String strOptString90 = jSONObject.optString("expvalue");
            if (!TextUtils.isEmpty(strOptString90) && !list.contains("expvalue")) {
                w2Var.L0 = strOptString90;
            }
            String strOptString91 = jSONObject.optString("tc");
            if (!TextUtils.isEmpty(strOptString91) && !list.contains("tc")) {
                w2Var.M0 = strOptString91;
            }
            String strOptString92 = jSONObject.optString("ir");
            if (!TextUtils.isEmpty(strOptString92) && !list.contains("ir")) {
                w2Var.N0 = strOptString92;
            }
            String strOptString93 = jSONObject.optString(com.baidu.mobads.container.adrequest.g.ac);
            if (!TextUtils.isEmpty(strOptString93) && !list.contains(com.baidu.mobads.container.adrequest.g.ac)) {
                w2Var.O0 = strOptString93;
            }
            String strOptString94 = jSONObject.optString("acra");
            if (TextUtils.isEmpty(strOptString94) || list.contains("acra")) {
                return;
            }
            w2Var.P0 = strOptString94;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.qq.e.comm.plugin.hj
    public String a(w2 w2Var, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i2 = i & 2;
        if (i2 > 0) {
            try {
                jSONObject.putOpt("g", String.valueOf(w2Var.a));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (i2 > 0) {
            jSONObject.putOpt(Config.STAT_SDK_CHANNEL, String.valueOf(w2Var.b));
        }
        if (i2 > 0) {
            jSONObject.putOpt("ec", String.valueOf(w2Var.c));
        }
        if (i2 > 0) {
            jSONObject.putOpt("aa", String.valueOf(w2Var.d));
        }
        if (i2 > 0) {
            jSONObject.putOpt("ab", String.valueOf(w2Var.e));
        }
        if (i2 > 0) {
            jSONObject.putOpt("ba", String.valueOf(w2Var.f));
        }
        if (i2 > 0) {
            jSONObject.putOpt("bb", String.valueOf(w2Var.g));
        }
        if (i2 > 0) {
            jSONObject.putOpt("d", String.valueOf(w2Var.h));
        }
        if (i2 > 0) {
            jSONObject.putOpt("p", String.valueOf(w2Var.i));
        }
        if (i2 > 0) {
            jSONObject.putOpt("f", String.valueOf(w2Var.j));
        }
        int i3 = i & 3;
        if (i3 > 0) {
            jSONObject.putOpt("da", String.valueOf(w2Var.k));
        }
        if (i3 > 0) {
            jSONObject.putOpt("db", String.valueOf(w2Var.l));
        }
        if (i3 > 0) {
            jSONObject.putOpt("dx", String.valueOf(w2Var.m));
        }
        if (i3 > 0) {
            jSONObject.putOpt("dy", String.valueOf(w2Var.n));
        }
        if (i3 > 0) {
            jSONObject.putOpt("ra", String.valueOf(w2Var.o));
        }
        if (i3 > 0) {
            jSONObject.putOpt("rb", String.valueOf(w2Var.p));
        }
        if (i2 > 0) {
            jSONObject.putOpt(com.baidu.mobads.container.adrequest.g.R, String.valueOf(w2Var.q));
        }
        if (i2 > 0) {
            jSONObject.putOpt(com.baidu.mobads.container.components.command.j.s, String.valueOf(w2Var.r));
        }
        if (i3 > 0) {
            jSONObject.putOpt("vs", String.valueOf(w2Var.s));
        }
        if (i3 > 0) {
            jSONObject.putOpt("dpn", String.valueOf(w2Var.t));
        }
        if (i3 > 0) {
            jSONObject.putOpt("cr", String.valueOf(w2Var.u));
        }
        if (i3 > 0) {
            jSONObject.putOpt("rt", String.valueOf(w2Var.v));
        }
        int i4 = i & 7;
        if (i4 > 0) {
            jSONObject.putOpt("pw", String.valueOf(w2Var.w));
        }
        if (i4 > 0) {
            jSONObject.putOpt("ph", String.valueOf(w2Var.x));
        }
        if (i4 > 0) {
            jSONObject.putOpt("fg", String.valueOf(w2Var.y));
        }
        if (i4 > 0) {
            jSONObject.putOpt("co", String.valueOf(w2Var.z));
        }
        if (i4 > 0) {
            jSONObject.putOpt("sl", String.valueOf(w2Var.A));
        }
        if (i4 > 0) {
            jSONObject.putOpt("xi", String.valueOf(w2Var.B));
        }
        if (i4 > 0) {
            jSONObject.putOpt("ic", String.valueOf(w2Var.C));
        }
        if (i4 > 0) {
            jSONObject.putOpt("uc", String.valueOf(w2Var.D));
        }
        if (i4 > 0) {
            jSONObject.putOpt("id", String.valueOf(w2Var.E));
        }
        if (i4 > 0) {
            jSONObject.putOpt("sp", String.valueOf(w2Var.F));
        }
        if (i4 > 0) {
            jSONObject.putOpt("pk", String.valueOf(w2Var.G));
        }
        if (i4 > 0) {
            jSONObject.putOpt("si", String.valueOf(w2Var.H));
        }
        if (i3 > 0) {
            jSONObject.putOpt("ch", String.valueOf(w2Var.I));
        }
        if (i4 > 0) {
            jSONObject.putOpt("as", String.valueOf(w2Var.J));
        }
        if (i4 > 0) {
            jSONObject.putOpt("cpk", String.valueOf(w2Var.f785K));
        }
        if (i4 > 0) {
            jSONObject.putOpt("csi", String.valueOf(w2Var.L));
        }
        if (i4 > 0) {
            jSONObject.putOpt("cas", String.valueOf(w2Var.M));
        }
        if (i3 > 0) {
            jSONObject.putOpt("xo", String.valueOf(w2Var.N));
        }
        if (i3 > 0) {
            jSONObject.putOpt("yo", String.valueOf(w2Var.O));
        }
        if (i2 > 0) {
            jSONObject.putOpt(com.kuaishou.weapon.p0.t.q, String.valueOf(w2Var.P));
        }
        if (i3 > 0) {
            jSONObject.putOpt(com.baidu.mobads.container.adrequest.g.z, String.valueOf(w2Var.Q));
        }
        if (i4 > 0) {
            jSONObject.putOpt("td", String.valueOf(w2Var.R));
        }
        if (i4 > 0) {
            jSONObject.putOpt(Config.OAID, String.valueOf(w2Var.S));
        }
        int i5 = i & 4;
        if (i5 > 0) {
            jSONObject.putOpt("br", String.valueOf(w2Var.T));
        }
        if (i5 > 0) {
            jSONObject.putOpt("mf", String.valueOf(w2Var.U));
        }
        if (i5 > 0) {
            jSONObject.putOpt("hw", String.valueOf(w2Var.V));
        }
        if (i3 > 0) {
            jSONObject.putOpt("tid", String.valueOf(w2Var.W));
        }
        if (i2 > 0) {
            jSONObject.putOpt(Config.TARGET_SDK_VERSION, String.valueOf(w2Var.X));
        }
        if (i2 > 0) {
            jSONObject.putOpt("compo", String.valueOf(w2Var.Y));
        }
        if (i2 > 0) {
            jSONObject.putOpt("csf", String.valueOf(w2Var.Z));
        }
        if (i3 > 0) {
            jSONObject.putOpt("sz", String.valueOf(w2Var.a0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("vp", String.valueOf(w2Var.b0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("x", String.valueOf(w2Var.c0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("sg", String.valueOf(w2Var.d0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("sld", String.valueOf(w2Var.e0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("am", String.valueOf(w2Var.f0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("nx", String.valueOf(w2Var.g0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("ny", String.valueOf(w2Var.h0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("nz", String.valueOf(w2Var.i0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("nt", String.valueOf(w2Var.j0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("ca", String.valueOf(w2Var.k0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("rwd", String.valueOf(w2Var.l0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("media_ext", String.valueOf(w2Var.m0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("bfn", String.valueOf(w2Var.n0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("bfon", String.valueOf(w2Var.o0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("sm", String.valueOf(w2Var.p0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("in", String.valueOf(w2Var.q0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("pcs", String.valueOf(w2Var.r0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("se", String.valueOf(w2Var.s0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("do", String.valueOf(w2Var.t0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("ac", String.valueOf(w2Var.u0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("ot", String.valueOf(w2Var.v0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("dsf", String.valueOf(w2Var.w0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("raa", String.valueOf(w2Var.x0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("rab", String.valueOf(w2Var.y0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("dscn", String.valueOf(w2Var.z0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("usf", String.valueOf(w2Var.A0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("rba", String.valueOf(w2Var.B0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("rbb", String.valueOf(w2Var.C0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("uscn", String.valueOf(w2Var.D0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("fc", String.valueOf(w2Var.E0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("fcc", String.valueOf(w2Var.F0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("inex", String.valueOf(w2Var.G0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("cvi", String.valueOf(w2Var.H0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("uit", String.valueOf(w2Var.I0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("cghcl", String.valueOf(w2Var.J0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("expid", String.valueOf(w2Var.K0));
        }
        if (i4 > 0) {
            jSONObject.putOpt("expvalue", String.valueOf(w2Var.L0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("tc", String.valueOf(w2Var.M0));
        }
        if (i3 > 0) {
            jSONObject.putOpt("ir", String.valueOf(w2Var.N0));
        }
        if (i3 > 0) {
            jSONObject.putOpt(com.baidu.mobads.container.adrequest.g.ac, String.valueOf(w2Var.O0));
        }
        if (i2 > 0) {
            jSONObject.putOpt("acra", String.valueOf(w2Var.P0));
        }
        return jSONObject.toString();
    }

    @Override // com.qq.e.comm.plugin.hj
    public w2 a(w2 w2Var, w2 w2Var2, String str) {
        if (w2Var == null || w2Var2 == null) {
            return null;
        }
        String str2 = w2Var2.a;
        if (!TextUtils.isEmpty(str2)) {
            w2Var.a = str2;
        }
        if (TextUtils.isEmpty(w2Var.a)) {
            w2Var.a = str;
        }
        String str3 = w2Var2.b;
        if (!TextUtils.isEmpty(str3)) {
            w2Var.b = str3;
        }
        if (TextUtils.isEmpty(w2Var.b)) {
            w2Var.b = str;
        }
        String str4 = w2Var2.c;
        if (!TextUtils.isEmpty(str4)) {
            w2Var.c = str4;
        }
        if (TextUtils.isEmpty(w2Var.c)) {
            w2Var.c = str;
        }
        String str5 = w2Var2.d;
        if (!TextUtils.isEmpty(str5)) {
            w2Var.d = str5;
        }
        if (TextUtils.isEmpty(w2Var.d)) {
            w2Var.d = str;
        }
        String str6 = w2Var2.e;
        if (!TextUtils.isEmpty(str6)) {
            w2Var.e = str6;
        }
        if (TextUtils.isEmpty(w2Var.e)) {
            w2Var.e = str;
        }
        String str7 = w2Var2.f;
        if (!TextUtils.isEmpty(str7)) {
            w2Var.f = str7;
        }
        if (TextUtils.isEmpty(w2Var.f)) {
            w2Var.f = str;
        }
        String str8 = w2Var2.g;
        if (!TextUtils.isEmpty(str8)) {
            w2Var.g = str8;
        }
        if (TextUtils.isEmpty(w2Var.g)) {
            w2Var.g = str;
        }
        String str9 = w2Var2.h;
        if (!TextUtils.isEmpty(str9)) {
            w2Var.h = str9;
        }
        if (TextUtils.isEmpty(w2Var.h)) {
            w2Var.h = str;
        }
        String str10 = w2Var2.i;
        if (!TextUtils.isEmpty(str10)) {
            w2Var.i = str10;
        }
        if (TextUtils.isEmpty(w2Var.i)) {
            w2Var.i = str;
        }
        String str11 = w2Var2.j;
        if (!TextUtils.isEmpty(str11)) {
            w2Var.j = str11;
        }
        if (TextUtils.isEmpty(w2Var.j)) {
            w2Var.j = str;
        }
        String str12 = w2Var2.k;
        if (!TextUtils.isEmpty(str12)) {
            w2Var.k = str12;
        }
        if (TextUtils.isEmpty(w2Var.k)) {
            w2Var.k = str;
        }
        String str13 = w2Var2.l;
        if (!TextUtils.isEmpty(str13)) {
            w2Var.l = str13;
        }
        if (TextUtils.isEmpty(w2Var.l)) {
            w2Var.l = str;
        }
        String str14 = w2Var2.m;
        if (!TextUtils.isEmpty(str14)) {
            w2Var.m = str14;
        }
        if (TextUtils.isEmpty(w2Var.m)) {
            w2Var.m = str;
        }
        String str15 = w2Var2.n;
        if (!TextUtils.isEmpty(str15)) {
            w2Var.n = str15;
        }
        if (TextUtils.isEmpty(w2Var.n)) {
            w2Var.n = str;
        }
        String str16 = w2Var2.o;
        if (!TextUtils.isEmpty(str16)) {
            w2Var.o = str16;
        }
        if (TextUtils.isEmpty(w2Var.o)) {
            w2Var.o = str;
        }
        String str17 = w2Var2.p;
        if (!TextUtils.isEmpty(str17)) {
            w2Var.p = str17;
        }
        if (TextUtils.isEmpty(w2Var.p)) {
            w2Var.p = str;
        }
        String str18 = w2Var2.q;
        if (!TextUtils.isEmpty(str18)) {
            w2Var.q = str18;
        }
        if (TextUtils.isEmpty(w2Var.q)) {
            w2Var.q = str;
        }
        String str19 = w2Var2.r;
        if (!TextUtils.isEmpty(str19)) {
            w2Var.r = str19;
        }
        if (TextUtils.isEmpty(w2Var.r)) {
            w2Var.r = str;
        }
        String str20 = w2Var2.s;
        if (!TextUtils.isEmpty(str20)) {
            w2Var.s = str20;
        }
        if (TextUtils.isEmpty(w2Var.s)) {
            w2Var.s = str;
        }
        String str21 = w2Var2.t;
        if (!TextUtils.isEmpty(str21)) {
            w2Var.t = str21;
        }
        if (TextUtils.isEmpty(w2Var.t)) {
            w2Var.t = str;
        }
        String str22 = w2Var2.u;
        if (!TextUtils.isEmpty(str22)) {
            w2Var.u = str22;
        }
        if (TextUtils.isEmpty(w2Var.u)) {
            w2Var.u = str;
        }
        String str23 = w2Var2.v;
        if (!TextUtils.isEmpty(str23)) {
            w2Var.v = str23;
        }
        if (TextUtils.isEmpty(w2Var.v)) {
            w2Var.v = str;
        }
        String str24 = w2Var2.w;
        if (!TextUtils.isEmpty(str24)) {
            w2Var.w = str24;
        }
        if (TextUtils.isEmpty(w2Var.w)) {
            w2Var.w = str;
        }
        String str25 = w2Var2.x;
        if (!TextUtils.isEmpty(str25)) {
            w2Var.x = str25;
        }
        if (TextUtils.isEmpty(w2Var.x)) {
            w2Var.x = str;
        }
        String str26 = w2Var2.y;
        if (!TextUtils.isEmpty(str26)) {
            w2Var.y = str26;
        }
        if (TextUtils.isEmpty(w2Var.y)) {
            w2Var.y = str;
        }
        String str27 = w2Var2.z;
        if (!TextUtils.isEmpty(str27)) {
            w2Var.z = str27;
        }
        if (TextUtils.isEmpty(w2Var.z)) {
            w2Var.z = str;
        }
        String str28 = w2Var2.A;
        if (!TextUtils.isEmpty(str28)) {
            w2Var.A = str28;
        }
        if (TextUtils.isEmpty(w2Var.A)) {
            w2Var.A = str;
        }
        String str29 = w2Var2.B;
        if (!TextUtils.isEmpty(str29)) {
            w2Var.B = str29;
        }
        if (TextUtils.isEmpty(w2Var.B)) {
            w2Var.B = str;
        }
        String str30 = w2Var2.C;
        if (!TextUtils.isEmpty(str30)) {
            w2Var.C = str30;
        }
        if (TextUtils.isEmpty(w2Var.C)) {
            w2Var.C = str;
        }
        String str31 = w2Var2.D;
        if (!TextUtils.isEmpty(str31)) {
            w2Var.D = str31;
        }
        if (TextUtils.isEmpty(w2Var.D)) {
            w2Var.D = str;
        }
        String str32 = w2Var2.E;
        if (!TextUtils.isEmpty(str32)) {
            w2Var.E = str32;
        }
        if (TextUtils.isEmpty(w2Var.E)) {
            w2Var.E = str;
        }
        String str33 = w2Var2.F;
        if (!TextUtils.isEmpty(str33)) {
            w2Var.F = str33;
        }
        if (TextUtils.isEmpty(w2Var.F)) {
            w2Var.F = str;
        }
        String str34 = w2Var2.G;
        if (!TextUtils.isEmpty(str34)) {
            w2Var.G = str34;
        }
        if (TextUtils.isEmpty(w2Var.G)) {
            w2Var.G = str;
        }
        String str35 = w2Var2.H;
        if (!TextUtils.isEmpty(str35)) {
            w2Var.H = str35;
        }
        if (TextUtils.isEmpty(w2Var.H)) {
            w2Var.H = str;
        }
        String str36 = w2Var2.I;
        if (!TextUtils.isEmpty(str36)) {
            w2Var.I = str36;
        }
        if (TextUtils.isEmpty(w2Var.I)) {
            w2Var.I = str;
        }
        String str37 = w2Var2.J;
        if (!TextUtils.isEmpty(str37)) {
            w2Var.J = str37;
        }
        if (TextUtils.isEmpty(w2Var.J)) {
            w2Var.J = str;
        }
        String str38 = w2Var2.f785K;
        if (!TextUtils.isEmpty(str38)) {
            w2Var.f785K = str38;
        }
        if (TextUtils.isEmpty(w2Var.f785K)) {
            w2Var.f785K = str;
        }
        String str39 = w2Var2.L;
        if (!TextUtils.isEmpty(str39)) {
            w2Var.L = str39;
        }
        if (TextUtils.isEmpty(w2Var.L)) {
            w2Var.L = str;
        }
        String str40 = w2Var2.M;
        if (!TextUtils.isEmpty(str40)) {
            w2Var.M = str40;
        }
        if (TextUtils.isEmpty(w2Var.M)) {
            w2Var.M = str;
        }
        String str41 = w2Var2.N;
        if (!TextUtils.isEmpty(str41)) {
            w2Var.N = str41;
        }
        if (TextUtils.isEmpty(w2Var.N)) {
            w2Var.N = str;
        }
        String str42 = w2Var2.O;
        if (!TextUtils.isEmpty(str42)) {
            w2Var.O = str42;
        }
        if (TextUtils.isEmpty(w2Var.O)) {
            w2Var.O = str;
        }
        String str43 = w2Var2.P;
        if (!TextUtils.isEmpty(str43)) {
            w2Var.P = str43;
        }
        if (TextUtils.isEmpty(w2Var.P)) {
            w2Var.P = str;
        }
        String str44 = w2Var2.Q;
        if (!TextUtils.isEmpty(str44)) {
            w2Var.Q = str44;
        }
        if (TextUtils.isEmpty(w2Var.Q)) {
            w2Var.Q = str;
        }
        String str45 = w2Var2.R;
        if (!TextUtils.isEmpty(str45)) {
            w2Var.R = str45;
        }
        if (TextUtils.isEmpty(w2Var.R)) {
            w2Var.R = str;
        }
        String str46 = w2Var2.S;
        if (!TextUtils.isEmpty(str46)) {
            w2Var.S = str46;
        }
        if (TextUtils.isEmpty(w2Var.S)) {
            w2Var.S = str;
        }
        String str47 = w2Var2.T;
        if (!TextUtils.isEmpty(str47)) {
            w2Var.T = str47;
        }
        if (TextUtils.isEmpty(w2Var.T)) {
            w2Var.T = str;
        }
        String str48 = w2Var2.U;
        if (!TextUtils.isEmpty(str48)) {
            w2Var.U = str48;
        }
        if (TextUtils.isEmpty(w2Var.U)) {
            w2Var.U = str;
        }
        String str49 = w2Var2.V;
        if (!TextUtils.isEmpty(str49)) {
            w2Var.V = str49;
        }
        if (TextUtils.isEmpty(w2Var.V)) {
            w2Var.V = str;
        }
        String str50 = w2Var2.W;
        if (!TextUtils.isEmpty(str50)) {
            w2Var.W = str50;
        }
        if (TextUtils.isEmpty(w2Var.W)) {
            w2Var.W = str;
        }
        String str51 = w2Var2.X;
        if (!TextUtils.isEmpty(str51)) {
            w2Var.X = str51;
        }
        if (TextUtils.isEmpty(w2Var.X)) {
            w2Var.X = str;
        }
        String str52 = w2Var2.Y;
        if (!TextUtils.isEmpty(str52)) {
            w2Var.Y = str52;
        }
        if (TextUtils.isEmpty(w2Var.Y)) {
            w2Var.Y = str;
        }
        String str53 = w2Var2.Z;
        if (!TextUtils.isEmpty(str53)) {
            w2Var.Z = str53;
        }
        if (TextUtils.isEmpty(w2Var.Z)) {
            w2Var.Z = str;
        }
        String str54 = w2Var2.a0;
        if (!TextUtils.isEmpty(str54)) {
            w2Var.a0 = str54;
        }
        if (TextUtils.isEmpty(w2Var.a0)) {
            w2Var.a0 = str;
        }
        String str55 = w2Var2.b0;
        if (!TextUtils.isEmpty(str55)) {
            w2Var.b0 = str55;
        }
        if (TextUtils.isEmpty(w2Var.b0)) {
            w2Var.b0 = str;
        }
        String str56 = w2Var2.c0;
        if (!TextUtils.isEmpty(str56)) {
            w2Var.c0 = str56;
        }
        if (TextUtils.isEmpty(w2Var.c0)) {
            w2Var.c0 = str;
        }
        String str57 = w2Var2.d0;
        if (!TextUtils.isEmpty(str57)) {
            w2Var.d0 = str57;
        }
        if (TextUtils.isEmpty(w2Var.d0)) {
            w2Var.d0 = str;
        }
        String str58 = w2Var2.e0;
        if (!TextUtils.isEmpty(str58)) {
            w2Var.e0 = str58;
        }
        if (TextUtils.isEmpty(w2Var.e0)) {
            w2Var.e0 = str;
        }
        String str59 = w2Var2.f0;
        if (!TextUtils.isEmpty(str59)) {
            w2Var.f0 = str59;
        }
        if (TextUtils.isEmpty(w2Var.f0)) {
            w2Var.f0 = str;
        }
        String str60 = w2Var2.g0;
        if (!TextUtils.isEmpty(str60)) {
            w2Var.g0 = str60;
        }
        if (TextUtils.isEmpty(w2Var.g0)) {
            w2Var.g0 = str;
        }
        String str61 = w2Var2.h0;
        if (!TextUtils.isEmpty(str61)) {
            w2Var.h0 = str61;
        }
        if (TextUtils.isEmpty(w2Var.h0)) {
            w2Var.h0 = str;
        }
        String str62 = w2Var2.i0;
        if (!TextUtils.isEmpty(str62)) {
            w2Var.i0 = str62;
        }
        if (TextUtils.isEmpty(w2Var.i0)) {
            w2Var.i0 = str;
        }
        String str63 = w2Var2.j0;
        if (!TextUtils.isEmpty(str63)) {
            w2Var.j0 = str63;
        }
        if (TextUtils.isEmpty(w2Var.j0)) {
            w2Var.j0 = str;
        }
        String str64 = w2Var2.k0;
        if (!TextUtils.isEmpty(str64)) {
            w2Var.k0 = str64;
        }
        if (TextUtils.isEmpty(w2Var.k0)) {
            w2Var.k0 = str;
        }
        String str65 = w2Var2.l0;
        if (!TextUtils.isEmpty(str65)) {
            w2Var.l0 = str65;
        }
        if (TextUtils.isEmpty(w2Var.l0)) {
            w2Var.l0 = str;
        }
        String str66 = w2Var2.m0;
        if (!TextUtils.isEmpty(str66)) {
            w2Var.m0 = str66;
        }
        if (TextUtils.isEmpty(w2Var.m0)) {
            w2Var.m0 = str;
        }
        String str67 = w2Var2.n0;
        if (!TextUtils.isEmpty(str67)) {
            w2Var.n0 = str67;
        }
        if (TextUtils.isEmpty(w2Var.n0)) {
            w2Var.n0 = str;
        }
        String str68 = w2Var2.o0;
        if (!TextUtils.isEmpty(str68)) {
            w2Var.o0 = str68;
        }
        if (TextUtils.isEmpty(w2Var.o0)) {
            w2Var.o0 = str;
        }
        String str69 = w2Var2.p0;
        if (!TextUtils.isEmpty(str69)) {
            w2Var.p0 = str69;
        }
        if (TextUtils.isEmpty(w2Var.p0)) {
            w2Var.p0 = str;
        }
        String str70 = w2Var2.q0;
        if (!TextUtils.isEmpty(str70)) {
            w2Var.q0 = str70;
        }
        if (TextUtils.isEmpty(w2Var.q0)) {
            w2Var.q0 = str;
        }
        String str71 = w2Var2.r0;
        if (!TextUtils.isEmpty(str71)) {
            w2Var.r0 = str71;
        }
        if (TextUtils.isEmpty(w2Var.r0)) {
            w2Var.r0 = str;
        }
        String str72 = w2Var2.s0;
        if (!TextUtils.isEmpty(str72)) {
            w2Var.s0 = str72;
        }
        if (TextUtils.isEmpty(w2Var.s0)) {
            w2Var.s0 = str;
        }
        String str73 = w2Var2.t0;
        if (!TextUtils.isEmpty(str73)) {
            w2Var.t0 = str73;
        }
        if (TextUtils.isEmpty(w2Var.t0)) {
            w2Var.t0 = str;
        }
        String str74 = w2Var2.u0;
        if (!TextUtils.isEmpty(str74)) {
            w2Var.u0 = str74;
        }
        if (TextUtils.isEmpty(w2Var.u0)) {
            w2Var.u0 = str;
        }
        String str75 = w2Var2.v0;
        if (!TextUtils.isEmpty(str75)) {
            w2Var.v0 = str75;
        }
        if (TextUtils.isEmpty(w2Var.v0)) {
            w2Var.v0 = str;
        }
        String str76 = w2Var2.w0;
        if (!TextUtils.isEmpty(str76)) {
            w2Var.w0 = str76;
        }
        if (TextUtils.isEmpty(w2Var.w0)) {
            w2Var.w0 = str;
        }
        String str77 = w2Var2.x0;
        if (!TextUtils.isEmpty(str77)) {
            w2Var.x0 = str77;
        }
        if (TextUtils.isEmpty(w2Var.x0)) {
            w2Var.x0 = str;
        }
        String str78 = w2Var2.y0;
        if (!TextUtils.isEmpty(str78)) {
            w2Var.y0 = str78;
        }
        if (TextUtils.isEmpty(w2Var.y0)) {
            w2Var.y0 = str;
        }
        String str79 = w2Var2.z0;
        if (!TextUtils.isEmpty(str79)) {
            w2Var.z0 = str79;
        }
        if (TextUtils.isEmpty(w2Var.z0)) {
            w2Var.z0 = str;
        }
        String str80 = w2Var2.A0;
        if (!TextUtils.isEmpty(str80)) {
            w2Var.A0 = str80;
        }
        if (TextUtils.isEmpty(w2Var.A0)) {
            w2Var.A0 = str;
        }
        String str81 = w2Var2.B0;
        if (!TextUtils.isEmpty(str81)) {
            w2Var.B0 = str81;
        }
        if (TextUtils.isEmpty(w2Var.B0)) {
            w2Var.B0 = str;
        }
        String str82 = w2Var2.C0;
        if (!TextUtils.isEmpty(str82)) {
            w2Var.C0 = str82;
        }
        if (TextUtils.isEmpty(w2Var.C0)) {
            w2Var.C0 = str;
        }
        String str83 = w2Var2.D0;
        if (!TextUtils.isEmpty(str83)) {
            w2Var.D0 = str83;
        }
        if (TextUtils.isEmpty(w2Var.D0)) {
            w2Var.D0 = str;
        }
        String str84 = w2Var2.E0;
        if (!TextUtils.isEmpty(str84)) {
            w2Var.E0 = str84;
        }
        if (TextUtils.isEmpty(w2Var.E0)) {
            w2Var.E0 = str;
        }
        String str85 = w2Var2.F0;
        if (!TextUtils.isEmpty(str85)) {
            w2Var.F0 = str85;
        }
        if (TextUtils.isEmpty(w2Var.F0)) {
            w2Var.F0 = str;
        }
        String str86 = w2Var2.G0;
        if (!TextUtils.isEmpty(str86)) {
            w2Var.G0 = str86;
        }
        if (TextUtils.isEmpty(w2Var.G0)) {
            w2Var.G0 = str;
        }
        String str87 = w2Var2.H0;
        if (!TextUtils.isEmpty(str87)) {
            w2Var.H0 = str87;
        }
        if (TextUtils.isEmpty(w2Var.H0)) {
            w2Var.H0 = str;
        }
        String str88 = w2Var2.I0;
        if (!TextUtils.isEmpty(str88)) {
            w2Var.I0 = str88;
        }
        if (TextUtils.isEmpty(w2Var.I0)) {
            w2Var.I0 = str;
        }
        String str89 = w2Var2.J0;
        if (!TextUtils.isEmpty(str89)) {
            w2Var.J0 = str89;
        }
        if (TextUtils.isEmpty(w2Var.J0)) {
            w2Var.J0 = str;
        }
        String str90 = w2Var2.K0;
        if (!TextUtils.isEmpty(str90)) {
            w2Var.K0 = str90;
        }
        if (TextUtils.isEmpty(w2Var.K0)) {
            w2Var.K0 = str;
        }
        String str91 = w2Var2.L0;
        if (!TextUtils.isEmpty(str91)) {
            w2Var.L0 = str91;
        }
        if (TextUtils.isEmpty(w2Var.L0)) {
            w2Var.L0 = str;
        }
        String str92 = w2Var2.M0;
        if (!TextUtils.isEmpty(str92)) {
            w2Var.M0 = str92;
        }
        if (TextUtils.isEmpty(w2Var.M0)) {
            w2Var.M0 = str;
        }
        String str93 = w2Var2.N0;
        if (!TextUtils.isEmpty(str93)) {
            w2Var.N0 = str93;
        }
        if (TextUtils.isEmpty(w2Var.N0)) {
            w2Var.N0 = str;
        }
        String str94 = w2Var2.O0;
        if (!TextUtils.isEmpty(str94)) {
            w2Var.O0 = str94;
        }
        if (TextUtils.isEmpty(w2Var.O0)) {
            w2Var.O0 = str;
        }
        String str95 = w2Var2.P0;
        if (!TextUtils.isEmpty(str95)) {
            w2Var.P0 = str95;
        }
        if (TextUtils.isEmpty(w2Var.P0)) {
            w2Var.P0 = str;
        }
        return w2Var;
    }
}
