package asha.dshm.asha2.Recycler;

/**
 * Created by Akshara on 11-05-2018.
 */

public class ActivityDetails {
    int name;
    int id;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    int image;
    ActivityDetails(int n, int i, int img)
    {
        name=n;
        id=i;
        image=img;
    }
    ActivityDetails(int n, int i)
    {
        name=n;
        id=i;
    }
}
