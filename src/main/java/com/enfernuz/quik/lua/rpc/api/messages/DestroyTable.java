package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.Contract;

public final class DestroyTable {

    private DestroyTable() {}

    @Value
    public static class Request {

        int tId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @Contract(pure = true)
        public static Result getInstance(final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // just in case
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
