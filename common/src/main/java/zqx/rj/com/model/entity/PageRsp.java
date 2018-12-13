package zqx.rj.com.model.entity;

import java.util.List;

/**
 * author：  HyZhan
 * create：  2018/11/27 17:55
 * desc：    TODO
 */
public class PageRsp<T> {
    private String curPage;
    private String pageCount;
    private String size;
    private String total;
    private List<T> datas;

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
