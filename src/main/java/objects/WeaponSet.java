package objects;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import exodus.Constants.WeaponType;

@XmlRootElement(name = "weapons")
public class WeaponSet {

    private List<Weapon> weapons;

    @XmlElement(name = "weapon")
    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void init() {
        for (Weapon w : this.weapons) {
            WeaponType t = w.getType();
            t.setWeapon(w);
        }
    }

}
