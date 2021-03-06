package com.qxcmp.framework.web.view.components.mall;

import com.qxcmp.framework.web.view.AbstractComponent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartOrderActionBar extends AbstractComponent {

    private double totalPrice;

    public ShoppingCartOrderActionBar(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String getFragmentFile() {
        return "qxcmp/components/mall/shopping-cart";
    }

    @Override
    public String getFragmentName() {
        return "action-bar";
    }
}
