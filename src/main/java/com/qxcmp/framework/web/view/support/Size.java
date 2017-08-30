package com.qxcmp.framework.web.view.support;

/**
 * 大小
 *
 * @author Aaric
 */
public enum Size {
    NONE(""),
    MINI("mini"),
    TINY("tiny"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    BIG("big"),
    HUGE("huge"),
    MASSIVE("massive");

    private String className;

    Size(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}