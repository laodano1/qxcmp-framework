package com.qxcmp.framework.web.controller;

import com.qxcmp.framework.web.QXCMPController;
import com.qxcmp.framework.web.view.QXCMPComponent;
import com.qxcmp.framework.web.view.containers.Col;
import com.qxcmp.framework.web.view.containers.Grid;
import com.qxcmp.framework.web.view.containers.Row;
import com.qxcmp.framework.web.view.containers.Segment;
import com.qxcmp.framework.web.view.elements.Header;
import com.qxcmp.framework.web.view.elements.Icon;
import com.qxcmp.framework.web.view.elements.Image;
import com.qxcmp.framework.web.view.elements.button.*;
import com.qxcmp.framework.web.view.elements.divider.HorizontalDivider;
import com.qxcmp.framework.web.view.elements.label.Label;
import com.qxcmp.framework.web.view.elements.label.Labels;
import com.qxcmp.framework.web.view.modules.dropdown.ButtonDropdown;
import com.qxcmp.framework.web.view.modules.dropdown.MenuDropdown;
import com.qxcmp.framework.web.view.modules.dropdown.item.*;
import com.qxcmp.framework.web.view.support.Alignment;
import com.qxcmp.framework.web.view.support.AnchorTarget;
import com.qxcmp.framework.web.view.support.Color;
import com.qxcmp.framework.web.view.support.Wide;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class LoginPageController extends QXCMPController {

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return page(() -> {
            Grid grid = nextComponent(Grid.class);
            grid.setContainer(true);
            grid.setStackable(true);

            Col headerCol = nextComponent(Col.class);
            headerCol.getComponents().add(createHeaderSegment());

            Col labelCol = nextComponent(Col.class);
            labelCol.setGeneralWide(Wide.EIGHT);
            labelCol.getComponents().add(createLabelSegment());

            Col buttonCol = nextComponent(Col.class);
            buttonCol.setGeneralWide(Wide.EIGHT);
            buttonCol.getComponents().add(createButtonSegment());

            Col dropdownCol = nextComponent(Col.class);
            dropdownCol.setGeneralWide(Wide.SIXTEEN);
            dropdownCol.getComponents().add(createDropdownSegment());

            Row headerRow = nextComponent(Row.class);
            headerRow.getColumns().add(headerCol);

            Row contentRow = nextComponent(Row.class);
            contentRow.getColumns().add(labelCol);
            contentRow.getColumns().add(buttonCol);

            Row dropdownRow = nextComponent(Row.class);
            dropdownRow.getColumns().add(dropdownCol);

            grid.getComponents().add(headerRow);
            grid.getComponents().add(contentRow);
            grid.getComponents().add(dropdownRow);
            return grid;
        });
    }

    private Segment createHeaderSegment() {
        Segment headerSegment = nextComponent(Segment.class);
        Header header = nextComponent(Header.class);
        Image image = nextComponent(Image.class);
        image.setSource(qxcmpConfiguration.getLogo());
        image.setUrl("/");
        image.setUrlTarget(AnchorTarget.BLANK.getValue());
        header.setIconHeader(true);
        header.setTitle(qxcmpConfiguration.getTitle());
        header.setAlignment(Alignment.CENTER);
        header.setImage(image);
        headerSegment.getComponents().add(header);
        return headerSegment;
    }

    private Segment createLoginForm() {
        Segment segment = nextComponent(Segment.class);
        segment.getComponents().add(new QXCMPComponent("qxcmp/components/login") {
        });
        return segment;
    }

    private Segment createLabelSegment() {
        Segment segment = nextComponent(Segment.class);
        Header header = nextComponent(Header.class);
        header.setTitle("标签测试");
        segment.getComponents().add(header);

        Labels labels = nextComponent(Labels.class);
        for (int i = 0; i < 5; i++) {
            Label label = nextComponent(Label.class, "标签文本", "/admin");
            label.setColor(randomColor());
            labels.getLabels().add(label);
        }
        segment.getComponents().add(labels);

        HorizontalDivider horizontalDivider = nextComponent(HorizontalDivider.class, "水平分隔符");
        horizontalDivider.setSection(true);
        segment.getComponents().add(horizontalDivider);

        labels = nextComponent(Labels.class);
        labels.setTag(true);
        for (int i = 0; i < 5; i++) {
            Label label = nextComponent(Label.class, "标签文本", "/admin");
            label.setColor(randomColor());
            labels.getLabels().add(label);
        }
        segment.getComponents().add(labels);
        Header dividerHeader = nextComponent(Header.class);
        dividerHeader.setTitle("高级分隔符标题");
        dividerHeader.setSubTitle("子标题");
        dividerHeader.setIcon(nextComponent(Icon.class, "cloud"));
        segment.getComponents().add(nextComponent(HorizontalDivider.class, dividerHeader));

        labels = nextComponent(Labels.class);
        labels.setCircular(true);
        for (int i = 0; i < 5; i++) {
            Label label = nextComponent(Label.class, String.valueOf(i), "/admin");
            label.setColor(randomColor());
            labels.getLabels().add(label);
        }
        segment.getComponents().add(labels);

        return segment;
    }

    private Segment createButtonSegment() {
        Segment segment = nextComponent(Segment.class);
        Header header = nextComponent(Header.class);
        header.setTitle("按钮测试");
        segment.getComponents().add(header);

        Button button = nextComponent(Button.class);
        button.setText("测试按钮");
        button.setColor(randomColor());
        segment.getComponents().add(button);

        AnimatedButton animatedButton = nextComponent(AnimatedButton.class);
        animatedButton.setColor(randomColor());
        animatedButton.setVisibleText("下载");
        animatedButton.setHiddenText("点击下载");
        segment.getComponents().add(animatedButton);

        animatedButton = nextComponent(AnimatedButton.class);
        animatedButton.setColor(randomColor());
        animatedButton.setVisibleText("下载");
        Icon icon = nextComponent(Icon.class);
        icon.setIcon("download");
        animatedButton.setHiddenIcon(icon);
        animatedButton.setAnimatedType(AnimatedButton.AnimatedType.VERTICAL);
        segment.getComponents().add(animatedButton);

        animatedButton = nextComponent(AnimatedButton.class);
        animatedButton.setColor(randomColor());
        animatedButton.setHiddenText("下载");
        icon = nextComponent(Icon.class);
        icon.setIcon("download");
        animatedButton.setVisibleIcon(icon);
        animatedButton.setAnimatedType(AnimatedButton.AnimatedType.FADE);
        segment.getComponents().add(animatedButton);

        animatedButton = nextComponent(AnimatedButton.class);
        animatedButton.setColor(randomColor());
        animatedButton.setVisibleText("下载");
        icon = nextComponent(Icon.class);
        icon.setIcon("download");
        animatedButton.setVisibleIcon(icon);
        animatedButton.setHiddenText("隐藏内容");
        animatedButton.setAnimatedType(AnimatedButton.AnimatedType.FADE);
        segment.getComponents().add(animatedButton);

        animatedButton = nextComponent(AnimatedButton.class);
        animatedButton.setColor(randomColor());
        animatedButton.setVisibleText("可见内容");
        icon = nextComponent(Icon.class);
        icon.setIcon("download");
        animatedButton.setHiddenIcon(icon);
        animatedButton.setHiddenText("隐藏内容");
        animatedButton.setAnimatedType(AnimatedButton.AnimatedType.FADE);
        segment.getComponents().add(animatedButton);

        IconButton iconButton = nextComponent(IconButton.class, "download");
        iconButton.setColor(randomColor());
        segment.getComponents().add(iconButton);

        LabeledButton labeledButton = nextComponent(LabeledButton.class, "按钮文本", "标签文本");
        labeledButton.setColor(randomColor());
        segment.getComponents().add(labeledButton);

        labeledButton = nextComponent(LabeledButton.class, "按钮文本", "标签文本");
        labeledButton.setLeft(true);
        labeledButton.setColor(randomColor());
        segment.getComponents().add(labeledButton);

        LabeledIconButton labeledIconButton = nextComponent(LabeledIconButton.class, "按钮文本", "user");
        labeledIconButton.setBasic(true);
        labeledIconButton.setColor(randomColor());
        segment.getComponents().add(labeledIconButton);

        labeledIconButton = nextComponent(LabeledIconButton.class, "按钮文本", "user");
        labeledIconButton.setRightIcon(true);
        labeledIconButton.setColor(randomColor());
        segment.getComponents().add(labeledIconButton);

        return segment;
    }

    private Segment createDropdownSegment() {
        Segment segment = nextComponent(Segment.class);

        DividerDropdownItem dividerDropdownItem = nextComponent(DividerDropdownItem.class);

        HeaderDropdownItem dHeader1 = nextComponent(HeaderDropdownItem.class);
        dHeader1.setText("选项组一");
        HeaderDropdownItem dHeader2 = nextComponent(HeaderDropdownItem.class);
        dHeader2.setText("选项组二");

        InputDropdownItem inputDropdownItem = nextComponent(InputDropdownItem.class);
        inputDropdownItem.setPlaceholder("搜索选项");

        IconDropdownItem iconDropdownItem = nextComponent(IconDropdownItem.class);
        iconDropdownItem.setIcon("user");
        iconDropdownItem.setText("图标选项");
        iconDropdownItem.setDescription("=");

        ImageDropdownItem imageDropdownItem = nextComponent(ImageDropdownItem.class);
        imageDropdownItem.setImage(qxcmpConfiguration.getLogo());
        imageDropdownItem.setAvatar(true);
        imageDropdownItem.setText("图片选项");
        imageDropdownItem.setDescription("=");

        LabelDropdownItem labelDropdownItem = nextComponent(LabelDropdownItem.class);
        labelDropdownItem.setText("标签选项");
        labelDropdownItem.setDescription("=");

        MenuDropdown menuDropdown = nextComponent(MenuDropdown.class);
        menuDropdown.setText("文件");
        menuDropdown.setPointing(true);

        menuDropdown.getItems().add(dHeader1);
        menuDropdown.getItems().add(dividerDropdownItem);
        menuDropdown.getItems().add(inputDropdownItem);
        menuDropdown.getItems().add(dHeader2);
        menuDropdown.getItems().add(dividerDropdownItem);
        menuDropdown.getItems().add(iconDropdownItem);
        menuDropdown.getItems().add(imageDropdownItem);
        menuDropdown.getItems().add(labelDropdownItem);

        ButtonDropdown buttonDropdown = nextComponent(ButtonDropdown.class);
        buttonDropdown.setText("立即下载资源");
        buttonDropdown.setIcon("download");
        buttonDropdown.setColor(randomColor());
        buttonDropdown.setPointing(true);

        inputDropdownItem.setRightIcon(true);

        buttonDropdown.getItems().add(dHeader1);
        buttonDropdown.getItems().add(dividerDropdownItem);
        buttonDropdown.getItems().add(inputDropdownItem);
        buttonDropdown.getItems().add(dHeader2);
        buttonDropdown.getItems().add(dividerDropdownItem);
        buttonDropdown.getItems().add(iconDropdownItem);
        buttonDropdown.getItems().add(imageDropdownItem);
        buttonDropdown.getItems().add(labelDropdownItem);

        segment.getComponents().add(menuDropdown);
        segment.getComponents().add(buttonDropdown);

        return segment;
    }

    private Color randomColor() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }
}
