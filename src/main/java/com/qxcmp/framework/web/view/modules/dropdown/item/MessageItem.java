package com.qxcmp.framework.web.view.modules.dropdown.item;

import com.qxcmp.framework.web.view.elements.message.AbstractMessage;
import lombok.Getter;

@Getter
public class MessageItem extends AbstractDropdownItem implements DropdownItem {

    private AbstractMessage message;

    public MessageItem(AbstractMessage message) {
        this.message = message;
    }

    @Override
    public String getFragmentName() {
        return "item-message";
    }
}
