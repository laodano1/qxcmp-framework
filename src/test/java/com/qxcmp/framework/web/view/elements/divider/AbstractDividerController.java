package com.qxcmp.framework.web.view.elements.divider;

import com.qxcmp.framework.web.QXCMPController;
import com.qxcmp.framework.web.view.elements.header.ContentHeader;
import com.qxcmp.framework.web.view.support.Size;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test/elements/divider")
public class AbstractDividerController extends QXCMPController {

    @GetMapping("/1")
    public ModelAndView testPage1() {
        return page(Divider::new);
    }

    @GetMapping("/2")
    public ModelAndView testPage2() {
        return page(() -> new HorizontalDivider("text"));
    }

    @GetMapping("/3")
    public ModelAndView testPage3() {
        return page(() -> new HorizontalDivider(new ContentHeader("text", Size.SMALL)));
    }

}
