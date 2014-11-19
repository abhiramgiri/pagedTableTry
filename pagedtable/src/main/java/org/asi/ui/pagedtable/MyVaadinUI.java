package org.asi.ui.pagedtable;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "org.asi.ui.pagedtable.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

     Navigator navigator;
    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this, this);
        navigator.addView(ViewPage.NAME, new ViewPage());
    }

}
