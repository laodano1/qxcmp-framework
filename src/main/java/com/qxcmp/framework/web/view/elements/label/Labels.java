package com.qxcmp.framework.web.view.elements.label;

import com.google.common.collect.Lists;
import com.qxcmp.framework.web.view.support.Color;
import com.qxcmp.framework.web.view.support.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Labels extends AbstractLabel {

    /**
     * 标签组大小
     */
    private Size size = Size.NONE;

    /**
     * 标签组颜色
     */
    private Color color = Color.NONE;

    /**
     * 附属标签组
     */
    private boolean tag;

    /**
     * 圆形标签组
     */
    private boolean circular;

    /**
     * 标签列表
     */
    private List<Label> labels = Lists.newArrayList();

    @Override
    public String getFragmentName() {
        return "labels";
    }

    @Override
    public String getClassName() {
        final StringBuilder stringBuilder = new StringBuilder("ui labels");

        stringBuilder.append(size.toString());

        stringBuilder.append(color.toString());

        if (tag) {
            stringBuilder.append(" tag");
        }

        if (circular) {
            stringBuilder.append(" circular");
        }

        return stringBuilder.toString();
    }
}
