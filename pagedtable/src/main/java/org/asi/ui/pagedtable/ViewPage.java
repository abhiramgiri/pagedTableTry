/*
 * Copyright 2014 Abhiram.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asi.ui.pagedtable;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.asi.ui.container.TreeContainer;

/**
 *
 * @author Abhiram
 */
@SuppressWarnings("serial")
public class ViewPage extends VerticalLayout implements View {

    public static final String NAME = "";
    final VerticalLayout layout = new VerticalLayout();
    TreeContainer<MyTableDTO> availableProductsBean = new TreeContainer<MyTableDTO>(MyTableDTO.class);
    BeanItemContainer<MyTableDTO> selectedProductBean = new BeanItemContainer<MyTableDTO>(MyTableDTO.class);
     Object[] viscol = {"projectionType", "allocationType",
        "frequency"};
     String[] vishead = {"projectionType", "allocationType",
        "frequency"};
    
    public ViewPage() {
        layout.setMargin(true);
        layout.setSpacing(true);
        addComponent(layout);
        setSizeFull();
        loadData();
        
        
        
        final PagedTreeTable<TreeContainer> pagedTreeTable = buildPagedTreeTable();
        layout.addComponent(pagedTreeTable);
        layout.addComponent(pagedTreeTable.createControls(new PagedControlConfig()));
        PagedTable<IndexedContainer> pagedTable = buildPagedTable();
        layout.addComponent(pagedTable);
        layout.addComponent(pagedTable.createControls(new PagedControlConfig()));
        
    }
    private void loadData() {
        for (int i = 0; i < 48; i++) {
            MyTableDTO ob = new MyTableDTO();
            ob.setAllocationType(""+i);
           selectedProductBean.addBean(ob);
            if (i == 1) {
                ob.setProjectionType("I m parent");
                
                
                MyTableDTO oc = new MyTableDTO();
              
                oc.setProjectionType("I m 1st child");
                
                MyTableDTO oe = new MyTableDTO();
               
                oe.setProjectionType("I m 2nd child");

                MyTableDTO od = new MyTableDTO();
               
               
                
                availableProductsBean.addBean(ob);
                availableProductsBean.setChildrenAllowed(ob, true);
                availableProductsBean.addBean(oc);
                availableProductsBean.setParent(oc, ob);
                availableProductsBean.addBean(oe);
                availableProductsBean.setParent(oe, ob);
                availableProductsBean.setChildrenAllowed(oe, false);
                availableProductsBean.setChildrenAllowed(oc, true);
                availableProductsBean.addBean(od);
                availableProductsBean.setParent(od, oc);
            } else {
               
                availableProductsBean.addBean(ob);
                availableProductsBean.setChildrenAllowed(ob, false);
            }
        }
        
         
    }
    private PagedTreeTable<TreeContainer> buildPagedTreeTable() {
        final PagedTreeTable<TreeContainer> treeTable = new PagedTreeTable<TreeContainer>();
        treeTable.setCaption("PagedTreeTable");
        treeTable.setWidth("100%");

        treeTable.setSelectable(true);
        treeTable.setImmediate(true);
        treeTable.setMultiSelect(true);


        treeTable.setColumnReorderingAllowed(true);
        treeTable.setRowHeaderMode(Table.RowHeaderMode.INDEX);
        treeTable.setContainerDataSource(availableProductsBean);

        treeTable.setVisibleColumns(viscol);
        treeTable.setColumnHeaders(vishead);
        
        return treeTable;
    }
    private PagedTable<IndexedContainer> buildPagedTable() {
        final PagedTable<IndexedContainer> table = new PagedTable<IndexedContainer>();
        table.setCaption("PagedTable");
        table.setWidth("100%");


        table.setSelectable(true);
        table.setImmediate(true);
        table.setMultiSelect(true);

        table.setRowHeaderMode(Table.RowHeaderMode.INDEX);

        table.setColumnReorderingAllowed(true);

        table.setContainerDataSource(selectedProductBean);

        table.setVisibleColumns(viscol);
        table.setColumnHeaders(vishead);
        
        return table;
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
