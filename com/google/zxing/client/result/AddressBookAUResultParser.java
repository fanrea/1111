package com.google.zxing.client.result;

import com.baidu.mobads.container.adrequest.b;
import com.google.zxing.Result;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class AddressBookAUResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (!massagedText.contains(TkBundleInfo.BUNDLE_CACHE_MEMORY) || !massagedText.contains("\r\n")) {
            return null;
        }
        String strMatchSinglePrefixedField = matchSinglePrefixedField("NAME1:", massagedText, StringUtil.CARRIAGE_RETURN, true);
        String strMatchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", massagedText, StringUtil.CARRIAGE_RETURN, true);
        String[] strArrMatchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        String[] strArrMatchMultipleValuePrefix2 = matchMultipleValuePrefix(b.InterfaceC0119b.g, 3, massagedText, true);
        String strMatchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", massagedText, StringUtil.CARRIAGE_RETURN, false);
        String strMatchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", massagedText, StringUtil.CARRIAGE_RETURN, true);
        return new AddressBookParsedResult(maybeWrap(strMatchSinglePrefixedField), null, strMatchSinglePrefixedField2, strArrMatchMultipleValuePrefix, null, strArrMatchMultipleValuePrefix2, null, null, strMatchSinglePrefixedField3, strMatchSinglePrefixedField4 != null ? new String[]{strMatchSinglePrefixedField4} : null, null, null, null, null, null, null);
    }

    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String strMatchSinglePrefixedField = matchSinglePrefixedField(str + i2 + ':', str2, StringUtil.CARRIAGE_RETURN, z);
            if (strMatchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(strMatchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
