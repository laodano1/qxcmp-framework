package com.qxcmp.framework.web.view.elements;

import com.qxcmp.framework.web.view.QXCMPComponent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Label extends QXCMPComponent {
    public Label() {
        super("qxcmp/elements/label");
    }
}
