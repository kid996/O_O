package O_O.view.timeline;

import O_O.view.Page;

import java.util.HashMap;

public class BrowseContentsPage extends Page {
    public BrowseContentsPage(String title, int pageId) {
        super(title, pageId);
    }

    @Override
    public void show(HashMap<String, Object> context) {
        String contents = (String)context.get("contents");
        String[] contentList = contents.split("\t");
        for(String content : contentList){
            System.out.println(content);
        }
    }
}
