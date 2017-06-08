package pl.drefos.electrolearn.nullators;

public class NullatorElement {
    private String name;
    private String desc1;
    private String desc2;
    private String desc3;
    private int img1;
    private int img2;
    private int img3;
    private int img4;


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDesc1() {return desc1;}
    public void setDesc1(String desc1) {this.desc1 = desc1;}

    public String getDesc2() {return desc2;}
    public void setDesc2(String desc2) {this.desc2 = desc2;}

    public String getDesc3() {return desc3;}
    public void setDesc3(String desc3) {this.desc3 = desc3;}

    public int getImg1() {return img1;}
    public void setImg1(int img1) {this.img1 = img1;}

    public int getImg2() {return img2;}
    public void setImg2(int img2) {this.img2 = img2;}

    public int getImg3() {return img3;}
    public void setImg3(int img3) {this.img3 = img3;}

    public int getImg4() {return img4;}
    public void setImg4(int img4) {this.img4 = img4;}

    public NullatorElement(String name, int img1, String desc1, int img2, String desc2, int img3, String desc3, int img4) {
        setName(name);
        setImg1(img1);
        setDesc1(desc1);
        setImg2(img2);
        setDesc2(desc2);
        setImg3(img3);
        setImg4(img4);
        setDesc3(desc3);
    }

}
