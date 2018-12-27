package zqx.rj.com.seekingcat.common.goods.model.bean;

public class GoodsRsp {

    public static final int GOODS_ALL = -1;
    public static final int GOODS_FOUND = 1;
    public static final int GOODS_NOT_FOUND = 0;

    private int id;
    private String name;
    private String description;
    private String phone;
    private String place;
    private String goodsUrl;
    private int type;
    private Boolean follow;
    // 设置默认值是 -1
    private int state = -1;
    private String reward;
    private String originator;
    private String originatorUrl;
    private String publishTime;
    private Boolean choose = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getFollow() {
        return follow;
    }

    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getOriginatorUrl() {
        return originatorUrl;
    }

    public void setOriginatorUrl(String originatorUrl) {
        this.originatorUrl = originatorUrl;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }
}
