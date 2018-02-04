package com.enfernuz.quik.lua.rpc.api.security;

import org.zeromq.ZMQ;

public interface AuthContext {

    ZMQ.Socket.Mechanism getAuthMechanism();

    PlainCredentials getPlainCredentials();

    CurveCredentials getCurveCredentials();

    static AuthContext none() {
        return new SimpleAuthContext();
    }
}
