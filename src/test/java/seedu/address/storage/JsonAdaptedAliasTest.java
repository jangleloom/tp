package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Alias;

public class JsonAdaptedAliasTest {

    @Test
    public void toModelType_validAlias_returnsAlias() throws Exception {
        JsonAdaptedAlias adapted = new JsonAdaptedAlias("friedDucky");
        assertEquals(new Alias("friedDucky"), adapted.toModelType());
    }

    @Test
    public void toModelType_nullAliasName_throwsIllegalValueException() {
        JsonAdaptedAlias adapted = new JsonAdaptedAlias((String) null);
        assertThrows(IllegalValueException.class,
                String.format(JsonAdaptedAlias.MISSING_FIELD_MESSAGE_FORMAT, "aliasName"),
                adapted::toModelType);
    }

    @Test
    public void toModelType_invalidAliasName_throwsIllegalValueException() {
        JsonAdaptedAlias adapted = new JsonAdaptedAlias("");
        assertThrows(IllegalValueException.class, adapted::toModelType);
    }
}
