package com.netease.htprotect.p010Ooo.p013Ooo;

import com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888;
import com.netease.htprotect.p010Ooo.p013Ooo.O8oO888;
import com.netease.htprotect.p010Ooo.p017oO.o0O0O;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* renamed from: com.netease.htprotect.〇Ooo.〇Ooo.〇O8, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8 {
    public final String Oo0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    public final o0o0 f307oO;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final List f303O8oO888 = new ArrayList();

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final List f305Ooo = new ArrayList();

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final List f304O8 = new ArrayList();

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    public final List f306o0o0 = new ArrayList();

    public O8(o0o0 o0o0Var, String str) throws O8oO888 {
        this.f307oO = o0o0Var;
        this.Oo0 = str;
        m787Ooo();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static O8oO888 m785O8oO888(Node node, int i) {
        O8oO888.C0678O8oO888 c0678O8oO888 = new O8oO888.C0678O8oO888(i, (byte) 0);
        NamedNodeMap attributes = node.getAttributes();
        c0678O8oO888.m769O8oO888(o0O0O.m1083O8oO888(attributes, "android:name"));
        String strM1083O8oO888 = o0O0O.m1083O8oO888(attributes, "android:exported");
        Boolean boolValueOf = strM1083O8oO888 == null ? null : Boolean.valueOf(strM1083O8oO888);
        c0678O8oO888.m770O8oO888(boolValueOf == null ? false : boolValueOf.booleanValue());
        c0678O8oO888.m772Ooo(o0O0O.m1083O8oO888(attributes, "android:process"));
        c0678O8oO888.m771O8(o0O0O.m1083O8oO888(attributes, "android:permission"));
        return new O8oO888(c0678O8oO888, (byte) 0);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private List m786O8oO888() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f303O8oO888);
        arrayList.addAll(this.f304O8);
        arrayList.addAll(this.f305Ooo);
        arrayList.addAll(this.f306o0o0);
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m787Ooo() throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888 {
        List list;
        O8oO888 o8oO888M785O8oO888;
        try {
            NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(this.Oo0.getBytes("UTF-8"))).getElementsByTagName("manifest").item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node nodeItem = childNodes.item(i);
                if (nodeItem.getNodeName().equals("application")) {
                    NodeList childNodes2 = nodeItem.getChildNodes();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node nodeItem2 = childNodes2.item(i2);
                        String nodeName = nodeItem2.getNodeName();
                        char c = 65535;
                        switch (nodeName.hashCode()) {
                            case -1655966961:
                                if (nodeName.equals("activity")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -987494927:
                                if (nodeName.equals("provider")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -808719889:
                                if (nodeName.equals("receiver")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 790287890:
                                if (nodeName.equals("activity-alias")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1984153269:
                                if (nodeName.equals("service")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            list = this.f304O8;
                            o8oO888M785O8oO888 = m785O8oO888(nodeItem2, 2);
                        } else if (c == 1 || c == 2) {
                            list = this.f303O8oO888;
                            o8oO888M785O8oO888 = m785O8oO888(nodeItem2, 1);
                        } else if (c == 3) {
                            list = this.f305Ooo;
                            o8oO888M785O8oO888 = m785O8oO888(nodeItem2, 4);
                        } else if (c == 4) {
                            list = this.f306o0o0;
                            o8oO888M785O8oO888 = m785O8oO888(nodeItem2, 3);
                        }
                        list.add(o8oO888M785O8oO888);
                    }
                }
            }
        } catch (Exception e) {
            throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("Error parsing AndroidManifest.xml", e);
        }
    }
}
