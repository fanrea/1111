package com.bykv.vk.component.ttvideo;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface INetworkClient {
    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);

    public static class Result {
        public final String body;
        public final int code;
        public final Exception e;
        public final String header;
        public final JSONObject response;

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.e = builder.e;
            this.code = builder.code;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static class Builder {
            String body;
            int code;
            Exception e;
            String header;
            JSONObject response;

            private Builder() {
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setException(Exception exc) {
                this.e = exc;
                return this;
            }

            public Builder setCode(int i) {
                this.code = i;
                return this;
            }

            public Result build() {
                return new Result(this);
            }
        }
    }
}
