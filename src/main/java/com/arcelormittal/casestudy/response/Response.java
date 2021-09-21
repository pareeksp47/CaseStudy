package com.arcelormittal.casestudy.response;

public interface Response<T> {

    public T getContent();

    public ResponseStatus getStatus();

}
