
import objects.SaveGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import exodus.CombatScreen;
import exodus.Constants;
import exodus.Constants.ArmorType;
import exodus.Constants.CreatureType;
import exodus.Constants.Maps;
import exodus.Constants.Profession;
import exodus.Constants.WeaponType;
import exodus.Context;
import exodus.Exodus;
import exodus.Party;
import util.UltimaTiledMapLoader;

public class TestMain extends Game {

    Animation a1, a2, a3;
    Texture tr;

    float time = 0;
    Batch batch2;

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "test";
        cfg.width = 1024;
        cfg.height = 768;
        new LwjglApplication(new TestMain(), cfg);
    }

    @Override
    public void create() {

        try {

            Exodus ult = new Exodus();
            ult.create();

            Context context = new Context();
            SaveGame sg = new SaveGame();
            try {
                sg.read(Constants.PARTY_SAV_BASE_FILENAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Party party = new Party(sg);
            context.setParty(party);
            context.setCurrentMap(Maps.SOSARIA.getMap());
            //party.setTransport(Exodus.baseTileSet.getTileByName("ship"));

            sg.players[0].profession = Profession.FIGHTER;
            sg.players[0].health = 500;
            sg.players[0].exp = 350;
            sg.players[0].weapon = WeaponType.EXOTIC;
            sg.players[0].armor = ArmorType.EXOTIC;

            sg.players[1].profession = Profession.RANGER;
            sg.players[1].health = 500;
            sg.players[1].exp = 350;
            sg.players[1].weapon = WeaponType.EXOTIC;
            sg.players[1].armor = ArmorType.EXOTIC;

            sg.players[2].profession = Profession.WIZARD;
            sg.players[2].health = 500;
            sg.players[2].exp = 350;
            sg.players[2].intell = 75;
            sg.players[2].mana = 75;
            sg.players[2].weapon = WeaponType.EXOTIC;
            sg.players[2].armor = ArmorType.EXOTIC;

            sg.players[3].profession = Profession.CLERIC;
            sg.players[3].health = 500;
            sg.players[3].exp = 350;
            sg.players[3].wis = 75;
            sg.players[3].mana = 75;
            sg.players[3].weapon = WeaponType.EXOTIC;
            sg.players[3].armor = ArmorType.EXOTIC;

            Maps m = Maps.GRASS_CON;

            TiledMap tmap = new UltimaTiledMapLoader(m, Exodus.standardAtlas, m.getMap().getWidth(), m.getMap().getHeight(), 32, 32).load();
            CombatScreen sc = new CombatScreen(null, context, Maps.SOSARIA, m.getMap(), tmap, CreatureType.gazer, Exodus.creatures, Exodus.standardAtlas);

            setScreen(sc);

            batch2 = new SpriteBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
