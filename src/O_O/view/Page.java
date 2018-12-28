package O_O.view;

import java.util.HashMap;

public abstract class Page {

    private String mTitile;
    private int mPageId;

    public Page(String title, int pageId){
        mTitile = title;
        mPageId = pageId;
    }

    public abstract void show(HashMap<String, Object> context);

}
