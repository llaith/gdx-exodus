package vendor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import exodus.Constants.WeaponType;

public class WeaponAdapter extends XmlAdapter<String, WeaponType> {

    public String marshal(WeaponType t) {
        return t.toString();
    }

    public WeaponType unmarshal(String val) {
        return WeaponType.valueOf(val);
    }
}
