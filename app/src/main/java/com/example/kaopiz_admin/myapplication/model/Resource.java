package com.example.kaopiz_admin.myapplication.model;

public class Resource<T> {
    public T t;
    public final State state;
    public String messageErr;

    public int errCode;

    public Resource(T t, State state, String messageErr) {
        this.t = t;
        this.state = state;
        this.messageErr = messageErr;
        errCode = 0;
    }

    public Resource(T t, State state, String messageErr, int errCode) {
        this.t = t;
        this.state = state;
        this.messageErr = messageErr;
        this.errCode = errCode;
    }

    public static <T> Resource<T> success(T t) {
        return new Resource(t, State.SUCCESS, "");
    }

    public static <T> Resource<T> loading() {
        return new Resource(null, State.LOADING, "");
    }

    public static final <T> Resource<T> error(String message) {
        return new Resource(null, State.ERROR, message);
    }

    public static final <T> Resource<T> error(String message, int errCode) {
        return new Resource(null, State.ERROR, message, errCode);
    }
}
