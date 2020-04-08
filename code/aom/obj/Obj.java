package aom.obj;

import aom.Aom;
import aom.area.Area;

public abstract class Obj extends Aom {
    private String name = "неопределенный объект";
    private Size size = Size.HUGE;

    public Obj(Area newLocation) {
        setLocation(newLocation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
