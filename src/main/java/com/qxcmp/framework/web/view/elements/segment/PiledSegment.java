package com.qxcmp.framework.web.view.elements.segment;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 堆积样式片段
 *
 * @author aaric
 * @see Segment
 */
public class PiledSegment extends AbstractSegment {
    @Override
    public String getClassContent() {
        return super.getClassContent() + " piled";
    }
}