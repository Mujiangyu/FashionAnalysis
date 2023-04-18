package pojo;

/**
 * #Author :Sino
 * #Date   :2021/11/27 10:23
 * #Describe:
 */
public class TypeInformation {
    private String colorType;
    private String smallImageURL;
    private String ImageURL;

    public TypeInformation(String colorType, String smallImageURL, String imageURL) {
        this.colorType = colorType;
        this.smallImageURL = smallImageURL;
        ImageURL = imageURL;
    }

    public TypeInformation() {
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
