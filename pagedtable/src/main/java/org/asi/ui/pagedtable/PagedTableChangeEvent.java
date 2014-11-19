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

import com.vaadin.ui.Table;
import java.io.Serializable;

/**
 *
 * @author Abhiram
 * @param <T>
 */
public class PagedTableChangeEvent<T extends Table> implements Serializable {
    private final T table;

    public PagedTableChangeEvent(T table) {
        this.table = table;
    }

    public T getTable() {
        return table;
    }

    public int getCurrentPage() {
        if(table instanceof PagedTable){
            return ((PagedTable)table).getCurrentPage();
        }else if(table instanceof PagedTreeTable){
            return ((PagedTreeTable)table).getCurrentPage();
        }
        return 0;
    }

    public int getTotalAmountOfPages() {
        if(table instanceof PagedTable){
            return ((PagedTable)table).getTotalAmountOfPages();
        }else if(table instanceof PagedTreeTable){
            return ((PagedTreeTable)table).getTotalAmountOfPages();
        }
        return 0;
    }
}

