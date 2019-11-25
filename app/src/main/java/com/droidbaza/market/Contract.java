package com.droidbaza.market;

import com.droidbaza.market.pojo.Category;

/**
 * Created by droidbaza on 25/11/19.
 */


public interface Contract {
    interface CategoryListener {
        void onCategoryClicked(Category category);
    }
}
