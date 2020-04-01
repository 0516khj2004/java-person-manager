package com.fastcampus.javaallinone.project3.mycontact.exception;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

@Slf4j
public class RenameNotPermittedException extends RuntimeException{
    private static final String MESSAGE = "name 변경을 허용하지 않습니다";

    public RenameNotPermittedException(){
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
