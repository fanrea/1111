package com.lingku.xuanshang.xutils.http;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.body.FileBody;
import com.lingku.xuanshang.xutils.http.body.InputStreamBody;
import com.lingku.xuanshang.xutils.http.body.MultipartBody;
import com.lingku.xuanshang.xutils.http.body.RequestBody;
import com.lingku.xuanshang.xutils.http.body.StringBody;
import com.lingku.xuanshang.xutils.http.body.UrlEncodedBody;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lkxssdk.p0.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseParams {
    public HttpMethod b;
    public String c;
    public String d;
    public RequestBody h;
    public String a = "UTF-8";
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public final List<Header> i = new ArrayList();
    public final List<KeyValue> j = new ArrayList();
    public final List<KeyValue> k = new ArrayList();

    public static final class ArrayItem extends KeyValue {
        public ArrayItem(String str, Object obj) {
            super(str, obj);
        }
    }

    public static final class BodyItemWrapper extends KeyValue {
        public final String contentType;
        public final String fileName;

        public BodyItemWrapper(String str, Object obj, String str2, String str3) {
            super(str, obj);
            if (TextUtils.isEmpty(str2)) {
                this.contentType = MediaTypeUtils.APPLICATION_OCTET_STREAM;
            } else {
                this.contentType = str2;
            }
            this.fileName = str3;
        }
    }

    public static final class Header extends KeyValue {
        public final boolean setHeader;

        public Header(String str, String str2, boolean z) {
            super(str, str2);
            this.setHeader = z;
        }
    }

    public final String a(boolean z) throws JSONException {
        JSONObject jSONObject;
        List<KeyValue> list;
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(this.c)) {
            jSONObject = new JSONObject();
            if (this.g) {
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            }
        } else if (this.c.trim().startsWith("[")) {
            jSONArray = new JSONArray(this.c);
            if (jSONArray.length() > 0) {
                Object obj = jSONArray.get(0);
                if (!(obj instanceof JSONObject)) {
                    LogUtil.w("only contains bodyContent");
                    return jSONArray.toString();
                }
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
            }
        } else {
            jSONObject = new JSONObject(this.c);
        }
        if (z) {
            ArrayList arrayList = new ArrayList(this.j.size() + this.k.size());
            arrayList.addAll(this.j);
            arrayList.addAll(this.k);
            list = arrayList;
        } else {
            list = this.k;
        }
        a(jSONObject, list);
        return jSONArray != null ? jSONArray.toString() : jSONObject.toString();
    }

    public final synchronized void a() {
        if (this.k.isEmpty()) {
            return;
        }
        if (this.h == null && HttpMethod.permitsRequestBody(this.b)) {
            if (this.f || this.g) {
                try {
                    this.c = a(false);
                    this.k.clear();
                } catch (JSONException e) {
                    throw new IllegalArgumentException(e.getMessage(), e);
                }
            } else if (!TextUtils.isEmpty(this.c)) {
                this.j.addAll(this.k);
                this.k.clear();
            }
            return;
        }
        this.j.addAll(this.k);
        this.k.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    public final void a(JSONObject jSONObject, List<KeyValue> list) throws JSONException {
        JSONArray jSONArray;
        HashSet hashSet = new HashSet(list.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (int i = 0; i < list.size(); i++) {
            KeyValue keyValue = list.get(i);
            String str = keyValue.key;
            if (!TextUtils.isEmpty(str)) {
                if (linkedHashMap.containsKey(str)) {
                    jSONArray = (JSONArray) linkedHashMap.get(str);
                } else {
                    jSONArray = new JSONArray();
                    linkedHashMap.put(str, jSONArray);
                }
                jSONArray.put(b.a(keyValue.value));
                if (keyValue instanceof ArrayItem) {
                    hashSet.add(str);
                }
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            Object obj = (JSONArray) entry.getValue();
            if (obj.length() <= 1 && !hashSet.contains(str2)) {
                obj = obj.get(0);
            }
            jSONObject.put(str2, obj);
        }
    }

    public void addBodyParameter(String str, Object obj) {
        addBodyParameter(str, obj, null, null);
    }

    public void addBodyParameter(String str, Object obj, String str2) {
        addBodyParameter(str, obj, str2, null);
    }

    public void addBodyParameter(String str, Object obj, String str2, String str3) {
        if (TextUtils.isEmpty(str) && obj == null) {
            return;
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.k.add(new BodyItemWrapper(str, obj, str2, str3));
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.k.add(new ArrayItem(str, it.next()));
            }
            return;
        }
        int i = 0;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            while (i < length) {
                this.k.add(new ArrayItem(str, jSONArray.opt(i)));
                i++;
            }
            return;
        }
        if ((obj instanceof byte[]) || obj == null || !obj.getClass().isArray()) {
            List<KeyValue> list = this.k;
            KeyValue keyValue = new KeyValue(str, obj);
            list.add(keyValue);
        } else {
            int length2 = Array.getLength(obj);
            while (i < length2) {
                this.k.add(new ArrayItem(str, Array.get(obj, i)));
                i++;
            }
        }
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.add(new Header(str, str2, false));
    }

    public void addParameter(String str, Object obj) {
        if (HttpMethod.permitsRequestBody(this.b)) {
            addBodyParameter(str, obj, null, null);
        } else {
            addQueryStringParameter(str, obj);
        }
    }

    public void addQueryStringParameter(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.j.add(new ArrayItem(str, it.next()));
            }
            return;
        }
        int i = 0;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            while (i < length) {
                this.j.add(new ArrayItem(str, jSONArray.opt(i)));
                i++;
            }
            return;
        }
        if (obj == null || !obj.getClass().isArray()) {
            this.j.add(new KeyValue(str, obj));
            return;
        }
        int length2 = Array.getLength(obj);
        while (i < length2) {
            this.j.add(new ArrayItem(str, Array.get(obj, i)));
            i++;
        }
    }

    public void clearParams() {
        this.j.clear();
        this.k.clear();
        this.c = null;
        this.d = null;
        this.h = null;
    }

    public String getBodyContent() {
        a();
        return this.c;
    }

    public List<KeyValue> getBodyParams() {
        a();
        return new ArrayList(this.k);
    }

    public String getCharset() {
        return this.a;
    }

    public List<Header> getHeaders() {
        return new ArrayList(this.i);
    }

    public HttpMethod getMethod() {
        return this.b;
    }

    public List<KeyValue> getParams(String str) {
        ArrayList arrayList = new ArrayList();
        for (KeyValue keyValue : this.j) {
            if (str != null && str.equals(keyValue.key)) {
                arrayList.add(keyValue);
            }
        }
        for (KeyValue keyValue2 : this.k) {
            if ((str == null && keyValue2.key == null) || (str != null && str.equals(keyValue2.key))) {
                arrayList.add(keyValue2);
            }
        }
        return arrayList;
    }

    public List<KeyValue> getQueryStringParams() {
        a();
        return new ArrayList(this.j);
    }

    public RequestBody getRequestBody() {
        RequestBody urlEncodedBody;
        a();
        RequestBody requestBody = this.h;
        if (requestBody != null) {
            return requestBody;
        }
        if (!TextUtils.isEmpty(this.c)) {
            urlEncodedBody = new StringBody(this.c, this.a);
        } else if (this.e) {
            urlEncodedBody = new MultipartBody(this.k, this.a);
        } else {
            if (this.k.size() == 1) {
                KeyValue keyValue = this.k.get(0);
                String str = keyValue.key;
                Object obj = keyValue.value;
                String str2 = keyValue instanceof BodyItemWrapper ? ((BodyItemWrapper) keyValue).contentType : null;
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.d;
                }
                if (obj instanceof File) {
                    return new FileBody((File) obj, str2);
                }
                if (obj instanceof InputStream) {
                    return new InputStreamBody((InputStream) obj, str2);
                }
                if (obj instanceof byte[]) {
                    return new InputStreamBody(new ByteArrayInputStream((byte[]) obj), str2);
                }
                if (TextUtils.isEmpty(str)) {
                    StringBody stringBody = new StringBody(keyValue.getValueStrOrEmpty(), this.a);
                    stringBody.setContentType(str2);
                    return stringBody;
                }
                UrlEncodedBody urlEncodedBody2 = new UrlEncodedBody(this.k, this.a);
                urlEncodedBody2.setContentType(str2);
                return urlEncodedBody2;
            }
            urlEncodedBody = new UrlEncodedBody(this.k, this.a);
        }
        urlEncodedBody.setContentType(this.d);
        return urlEncodedBody;
    }

    public boolean isAsJsonArrayContent() {
        return this.g;
    }

    public boolean isAsJsonContent() {
        return this.f;
    }

    public boolean isMultipart() {
        return this.e;
    }

    public void removeParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = null;
            this.d = null;
        } else {
            Iterator<KeyValue> it = this.j.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().key)) {
                    it.remove();
                }
            }
        }
        Iterator<KeyValue> it2 = this.k.iterator();
        while (it2.hasNext()) {
            KeyValue next = it2.next();
            if ((str == null && next.key == null) || (str != null && str.equals(next.key))) {
                it2.remove();
            }
        }
    }

    public void setAsJsonArrayContent(boolean z) {
        this.g = z;
    }

    public void setAsJsonContent(boolean z) {
        this.f = z;
    }

    public void setBodyContent(String str) {
        this.c = str;
    }

    public void setBodyContentType(String str) {
        this.d = str;
    }

    public void setCharset(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a = str;
    }

    public void setHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Header header = new Header(str, str2, true);
        Iterator<Header> it = this.i.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().key)) {
                it.remove();
            }
        }
        this.i.add(header);
    }

    public void setMethod(HttpMethod httpMethod) {
        this.b = httpMethod;
    }

    public void setMultipart(boolean z) {
        this.e = z;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.h = requestBody;
    }

    public String toJSONString() {
        return a(true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.j.isEmpty()) {
            for (KeyValue keyValue : this.j) {
                sb.append(keyValue.key).append("=").append(keyValue.value).append(a.n);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append("<").append(this.c).append(">");
        } else if (!this.k.isEmpty()) {
            sb.append("<");
            for (KeyValue keyValue2 : this.k) {
                sb.append(keyValue2.key).append("=").append(keyValue2.value).append(a.n);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(">");
        }
        return sb.toString();
    }
}
