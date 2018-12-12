package zqx.rj.com.seekingcat.common.search.model.db;

import org.litepal.crud.LitePalSupport;

/**
 * author:  HyZhan
 * create:  2018/12/12 17:35
 * desc:    TODO
 */
public class Record extends LitePalSupport {

    private int id;

    private String record;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
