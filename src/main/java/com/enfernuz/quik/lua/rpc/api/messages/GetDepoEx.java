package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetDepoEx {

    private GetDepoEx() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        String secCode;
        String trdAccId;
        int limitKind;

        @Builder
        private Request(
                final @NonNull String firmId,
                final @NonNull String clientCode,
                final @NonNull String secCode,
                final @NonNull String trdAccId,
                final int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.secCode = secCode;
            this.trdAccId = trdAccId;
            this.limitKind = limitKind;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("client_code", clientCode)
                    .add("sec_code", secCode)
                    .add("trdaccid", trdAccId)
                    .add("limit_kind", limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result {

        DepoLimit depoEx;

        @JsonCreator
        public Result(@JsonProperty("depo_ex") final DepoLimit depoEx) {
            this.depoEx = depoEx;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("depo_ex", depoEx)
                    .toString();
        }
    }
}
