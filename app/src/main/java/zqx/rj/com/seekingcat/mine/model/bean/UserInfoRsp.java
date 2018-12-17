package zqx.rj.com.seekingcat.mine.model.bean;

/**
 * author：  HyZhan
 * create：  2018/12/4 16:21
 * desc：    TODO
 */
public class UserInfoRsp {

    private String nickName;
    private String avatarUrl;
    private Integer gender;
    private int publishCount;
    private int followCount;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public int getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(int publishCount) {
        this.publishCount = publishCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    @Override
    public String toString() {
        return "UserInfoRsp{" +
                "nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", publishCount=" + publishCount +
                ", followCount=" + followCount +
                '}';
    }
}
