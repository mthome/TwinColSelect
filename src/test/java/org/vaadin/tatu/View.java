package org.vaadin.tatu;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout {
	int newi=1000;
	VerticalLayout log = new VerticalLayout();
	
    public View() {
    	this.setSizeFull();
        TwinColSelect<String> select = new TwinColSelect<>();
//        select.setLabel("Do selection");
//        select.setRequiredIndicatorVisible(true);
//        select.setInvalid(true);
//    	select.setItems("One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten");
        Set<String> set = new HashSet<>();
        for (Integer i=1;i<101;i++) {
            set.add("Item "+i);
        }
        select.setItems(set);
        ListDataProvider<String> dp = (ListDataProvider<String>) select.getDataProvider();
        dp.setSortComparator((a, b) -> a.compareTo(b));
        select.setHeight("350px");
        select.setWidth("350px");
        select.addSelectionListener(event -> {
            log.addComponentAsFirst(new Span(("Value changed")));
            event.getValue().forEach(item -> log.addComponentAsFirst(new Span(item + " selected!")));
        });
        Button refresh = new Button("Add/Refresh");
        refresh.addClickListener(event -> {
        	dp.getItems().add("An item "+newi);
        	newi++;
        	dp.setSortComparator((a, b) -> a.compareTo(b));
            dp.refreshAll();
        });
        log.getStyle().set("overflow-y", "auto");
        log.setHeight("100px");
        add(select,refresh,log);
        setFlexGrow(1, log);
    }
}