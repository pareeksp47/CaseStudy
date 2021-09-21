package com.arcelormittal.casestudy.response;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;


public class DefaultResponse<T> implements Response<T> {

    private T              content;

    private ResponseStatus status = ResponseStatus.SUCCESS;

    public DefaultResponse() {
        super();
    }

    public DefaultResponse(final T cont) {
        super();

        content = checkNotNull(cont, "Missing content");
    }

    public DefaultResponse(final T cont, final ResponseStatus stat) {
        super();

        content = checkNotNull(cont, "Missing content");
        status = checkNotNull(stat, "Missing status");
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public ResponseStatus getStatus() {
        return status;
    }

    public void setContent(final T value) {
        content = value;
    }

    public void setStatus(final ResponseStatus value) {
        status = value;
    }

    @Override
    public final String toString() {
       return MoreObjects.toStringHelper(this).add("status", status)
                .add("content", content).toString();
    }

}
