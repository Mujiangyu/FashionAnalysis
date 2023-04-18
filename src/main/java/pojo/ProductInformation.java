package pojo;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 10:07
 * #Describe:
 */
public class ProductInformation implements WritableComparable {
    private String category;
    private String subcategory;
    private String name;
    private double currentPrice;
    private double rawPrice;
    private String currency;
    private double discount;
    private int likesCount;
    private boolean isNew;
    private String brand;
    private String brandURL;
    private String colorTypeOne;
    private String smallImageURLOne;
    private String ImageURLOne;
    private String colorTypeTwo;
    private String smallImageURLTwo;
    private String ImageURLTwo;
    private String modelURL;
    private long ID;

    public ProductInformation() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getRawPrice() {
        return rawPrice;
    }

    public void setRawPrice(double rawPrice) {
        this.rawPrice = rawPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandURL() {
        return brandURL;
    }

    public String getColorTypeOne() {
        return colorTypeOne;
    }

    public void setColorTypeOne(String colorTypeOne) {
        this.colorTypeOne = colorTypeOne;
    }

    public String getSmallImageURLOne() {
        return smallImageURLOne;
    }

    public void setSmallImageURLOne(String smallImageURLOne) {
        this.smallImageURLOne = smallImageURLOne;
    }

    public String getImageURLOne() {
        return ImageURLOne;
    }

    public void setImageURLOne(String imageURLOne) {
        ImageURLOne = imageURLOne;
    }

    public String getColorTypeTwo() {
        return colorTypeTwo;
    }

    public void setColorTypeTwo(String colorTypeTwo) {
        this.colorTypeTwo = colorTypeTwo;
    }

    public String getSmallImageURLTwo() {
        return smallImageURLTwo;
    }

    public void setSmallImageURLTwo(String smallImageURLTwo) {
        this.smallImageURLTwo = smallImageURLTwo;
    }

    public String getImageURLTwo() {
        return ImageURLTwo;
    }

    public void setImageURLTwo(String imageURLTwo) {
        ImageURLTwo = imageURLTwo;
    }

    public void setBrandURL(String brandURL) {
        this.brandURL = brandURL;
    }

    public String getModelURL() {
        return modelURL;
    }

    public void setModelURL(String modelURL) {
        this.modelURL = modelURL;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.category);
        out.writeUTF(this.subcategory);
        out.writeUTF(this.name);
        out.writeDouble(this.currentPrice);
        out.writeDouble(this.rawPrice);
        out.writeUTF(this.currency);
        out.writeDouble(this.discount);
        out.writeInt(likesCount);
        out.writeBoolean(isNew);
        out.writeUTF(this.brand);
        out.writeUTF(this.brandURL);
        out.writeUTF(this.colorTypeOne);
        out.writeUTF(this.smallImageURLOne);
        out.writeUTF(this.ImageURLOne);
        out.writeUTF(this.colorTypeTwo);
        out.writeUTF(this.smallImageURLTwo);
        out.writeUTF(this.ImageURLTwo);
        out.writeUTF(this.modelURL);
        out.writeLong(this.ID);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.category = in.readUTF();
        this.subcategory = in.readUTF();
        this.name = in.readUTF();
        this.currentPrice = in.readDouble();
        this.rawPrice = in.readDouble();
        this.currency = in.readUTF();
        this.discount = in.readDouble();
        this.likesCount = in.readInt();
        this.isNew = in.readBoolean();
        this.brand = in.readUTF();
        this.brandURL = in.readUTF();
        this.colorTypeOne = in.readUTF();
        this.smallImageURLOne = in.readUTF();
        this.ImageURLOne = in.readUTF();
        this.colorTypeTwo = in.readUTF();
        this.smallImageURLTwo = in.readUTF();
        this.ImageURLTwo = in.readUTF();
        this.modelURL = in.readUTF();
        this.ID = in.readLong();
    }
}
