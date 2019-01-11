package devmobile.hearc.ch.notifium.logicals.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import devmobile.hearc.ch.notifium.logicals.conditions.ConditionDateEveryNDay;
import devmobile.hearc.ch.notifium.logicals.enums.ConditionType;

public class ConditionDateEveryNDaySerializer implements JsonSerializer<ConditionDateEveryNDay> {
    @Override
    public JsonElement serialize(ConditionDateEveryNDay cond, Type conditionType, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("type", ConditionType.DateEveryNDay.name());
        object.addProperty("dayOfYear", cond.getDayOfYear());
        object.addProperty("dt", cond.getDt());
        return object;
    }
}