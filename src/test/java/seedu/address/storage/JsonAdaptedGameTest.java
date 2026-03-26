package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.game.Game;
import seedu.address.model.person.Alias;

public class JsonAdaptedGameTest {

    @Test
    public void toModelType_validGame_returnsGame() throws Exception {
        Game game = new Game("Minecraft");
        JsonAdaptedGame adapted = new JsonAdaptedGame(game);
        assertEquals(game, adapted.toModelType());
    }

    @Test
    public void toModelType_validGameWithAliases_returnsGame() throws Exception {
        Set<Alias> aliases = new HashSet<>();
        aliases.add(new Alias("CraftyMiner"));
        Game game = new Game("Minecraft", aliases);
        JsonAdaptedGame adapted = new JsonAdaptedGame(game);
        assertEquals(game, adapted.toModelType());
    }

    @Test
    public void toModelType_nullGameName_throwsIllegalValueException() {
        List<JsonAdaptedAlias> emptyAliases = new ArrayList<>();
        JsonAdaptedGame adapted = new JsonAdaptedGame(null, emptyAliases);
        assertThrows(IllegalValueException.class,
                String.format(JsonAdaptedGame.MISSING_FIELD_MESSAGE_FORMAT, "gameName"),
                adapted::toModelType);
    }

    @Test
    public void toModelType_invalidGameName_throwsIllegalValueException() {
        List<JsonAdaptedAlias> emptyAliases = new ArrayList<>();
        JsonAdaptedGame adapted = new JsonAdaptedGame("", emptyAliases);
        assertThrows(IllegalValueException.class, adapted::toModelType);
    }

    @Test
    public void toModelType_nullAliasName_throwsIllegalValueException() {
        List<JsonAdaptedAlias> aliases = new ArrayList<>();
        aliases.add(new JsonAdaptedAlias((String) null));
        JsonAdaptedGame adapted = new JsonAdaptedGame("Minecraft", aliases);
        assertThrows(IllegalValueException.class, adapted::toModelType);
    }

    @Test
    public void toModelType_nullAliasesList_returnsGame() throws Exception {
        JsonAdaptedGame adapted = new JsonAdaptedGame("Valorant", null);
        assertEquals(new Game("Valorant"), adapted.toModelType());
    }
}
