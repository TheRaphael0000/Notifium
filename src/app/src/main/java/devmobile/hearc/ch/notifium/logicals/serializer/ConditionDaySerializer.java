package devmobile.hearc.ch.notifium.logicals.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import devmobile.hearc.ch.notifium.logicals.conditions.ConditionDateDayOfWeek;
import devmobile.hearc.ch.notifium.logicals.enums.ConditionType;

public class ConditionDaySerializer implements JsonSerializer<ConditionDateDayOfWeek> {
    @Override
    public JsonElement serialize(ConditionDateDayOfWeek cond, Type ConditionDay, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("type", ConditionType.DateDayOfWeek.name());
        object.addProperty("dayOfWeek", cond.getDayOfWeek().getValue());
        return object;
    }
}