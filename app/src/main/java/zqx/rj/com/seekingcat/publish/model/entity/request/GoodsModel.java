package zqx.rj.com.seekingcat.publish.model.entity.request;

import java.io.File;

/**
 * author：  HyZhan
 * create：  2018/11/30 19:10
 * desc：    TODO
 */
public class GoodsModel {

    public static final int LOSE_GOODS = 1;
    public static final int SEEK_GOODS = 2;

    private String name;
    private String description;
    private String phone;
    private String place;
    private Integer type;
    private String reward;
    private File imageFile;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", type=" + type +
                ", reward='" + reward + '\'' +
                ", imageFile=" + imageFile +
                '}';
    }
}
