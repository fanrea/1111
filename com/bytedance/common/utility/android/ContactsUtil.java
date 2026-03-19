package com.bytedance.common.utility.android;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.common.utility.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ContactsUtil {
    private static final Pattern S_TRIM_PATTERN = Pattern.compile("[^+0-9]");
    private static final String TAG = "ContactsUtil";

    private ContactsUtil() {
    }

    public static class PhoneContacts {
        public String contactId;
        public String contactName;
        public List<String> phoneNumbers = new ArrayList();

        public PhoneContacts() {
        }

        public PhoneContacts(String str, String str2) {
            this.contactId = str;
            this.contactName = str2;
        }

        public JSONObject toNumberJsonWithEncrypt() throws JSONException {
            if (StringUtils.isEmpty(this.contactName) || this.phoneNumbers.isEmpty() || this.phoneNumbers.size() == 0 || StringUtils.isEmpty(this.contactId)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.phoneNumbers.iterator();
                while (it.hasNext()) {
                    String strEncryptBySHA256 = StringEncryptUtils.encryptBySHA256(it.next());
                    if (!StringUtils.isEmpty(strEncryptBySHA256)) {
                        jSONArray.put(strEncryptBySHA256);
                    }
                }
                jSONObject.put("mobiles", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public JSONObject toJson() throws JSONException {
            if (StringUtils.isEmpty(this.contactName) || Lists.isEmpty(this.phoneNumbers) || StringUtils.isEmpty(this.contactId)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("contact_name", this.contactName);
                jSONObject.put("contact_id", this.contactId);
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.phoneNumbers.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("contact_number", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static String getHashedLocalMobile(TelephonyManager telephonyManager) {
        String line1Number = telephonyManager.getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
        return !TextUtils.isEmpty(filterPhoneNumber(line1Number, arrayList)) ? StringEncryptUtils.encryptBySHA256(line1Number) : "";
    }

    public static String getLocalMobile(TelephonyManager telephonyManager) {
        String line1Number = telephonyManager.getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(Pattern.compile("^(\\+86)?(1\\d{10})$"), "$2"));
        return filterPhoneNumber(line1Number, arrayList);
    }

    private static String filterPhoneNumber(String str, List<Pair<Pattern, String>> list) {
        if (list != null && list.size() != 0 && !StringUtils.isEmpty(str)) {
            String strReplaceAll = S_TRIM_PATTERN.matcher(str).replaceAll("");
            for (Pair<Pattern, String> pair : list) {
                Matcher matcher = ((Pattern) pair.first).matcher(strReplaceAll);
                if (matcher.matches()) {
                    return matcher.replaceAll((String) pair.second);
                }
            }
        }
        return null;
    }
}
