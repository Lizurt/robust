package amo.obj;

import amo.Amo;
import amo.area.Area;

public abstract class Obj extends Amo {
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
