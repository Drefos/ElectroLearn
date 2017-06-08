package pl.drefos.electrolearn.dictionary;

/**
 * Created by Maciek on 2017-05-13.
 */

public class DictionaryElement {
    private String name;
    private String description;
    private String description2;
    private String description3;
    private int image;
    private int image2;
    private int image3;
    private int image4;

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

    public String getDescription2() {return description2;}
    public void setDescription2(String description2) { this.description2 = description2; }

    public String getDescription3() {return description3;}
    public void setDescription3(String description3) { this.description3 = description3; }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public int getImage2() {
        return image2;
    }
    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }
    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public int getImage4() { return image4; }
    public void setImage4(int image4) { this.image4 = image4; }


    public DictionaryElement(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public DictionaryElement(String name, String description, int image) {
        this(name, description);
        setImage(image);
    }

    public DictionaryElement(String name, String description, int image, int image2) {
        this(name, description, image);
        setImage2(image2);
    }

    public DictionaryElement(String name, String description, int image, String description2) {
        this(name, description, image);
        setDescription2(description2);
    }

    public DictionaryElement(String name, String description, int image, int image2, String description2) {
        this(name, description, image, image2);
        setDescription2(description2);
    }

    public DictionaryElement(String name, String description, int image, int image2, String description2, String description3) {
        this(name, description, image, image2, description2);
        setDescription3(description3);
    }

    public DictionaryElement(String name, String description, int image, String description2, int image3) {
        this(name, description, image, description2);
        setImage3(image3);
    }

    public DictionaryElement(String name, String description, int image, int image2, int image3, String description3) {
        this(name, description, image, image2);
        setImage3(image3);
        setDescription3(description3);
    }

    public DictionaryElement(String name, int image, String description, int image2, String description2, int image3, String description3, int image4) {
        this(name, description, image, image2, description2, description3);
        setImage3(image3);
        setImage4(image4);
    }
}
