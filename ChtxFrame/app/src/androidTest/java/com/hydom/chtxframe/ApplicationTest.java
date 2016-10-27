package com.hydom.chtxframe;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.SparseArray;

import com.hydom.chtxframe.utils.L;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test() {
        SparseArray list = new SparseArray();
        L.e("data..." + list.get(0));
        list.put(2, "asdsa");
        L.e("data..sdas...." + list.get(0));
        L.e("data..sdas...." + list.get(2));
    }
}