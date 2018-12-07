package devmobile.hearc.ch.notifium.logicals.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import devmobile.hearc.ch.notifium.logicals.Trigger;
import devmobile.hearc.ch.notifium.logicals.conditions.ConditionBatteryLevel;
import devmobile.hearc.ch.notifium.logicals.conditions.ConditionDate;
import devmobile.hearc.ch.notifium.logicals.conditions.ConditionDay;
import devmobile.hearc.ch.notifium.logicals.conditions.ConditionHour;
import devmobile.hearc.ch.notifium.logicals.conditions.ConditionLocalisation;
import devmobile.hearc.ch.notifium.logicals.conditions.Condition_I;

public class TriggerSerializer implements JsonSerializer<Trigger> {

    @Override
    public JsonElement serialize(Trigger trigger, Type Trigger, JsonSerializationContext context) {

        ConditionLocalisationSerializer conditionLocalisationSerializer = new ConditionLocalisationSerializer();
        ConditionBatteryLevelSerializer conditionBatteryLevelSerializer = new ConditionBatteryLevelSerializer();
        ConditionDateSerializer conditionDateSerializer = new ConditionDateSerializer();
        ConditionDaySerializer conditionDaySerializer = new ConditionDaySerializer();
        ConditionHourSerializer conditionHourSerializer = new ConditionHourSerializer();

        JsonObject object = new JsonObject();

        for (int i = 0; i < trigger.size(); ++i) {
            Condition_I cond = trigger.get(0);
            switch (cond.getConditionType())
            {
                case Position:
                    object.add(Integer.toString(i), conditionLocalisationSerializer.serialize((ConditionLocalisation) cond, ConditionLocalisation.class, context));
                    break;
                case Date:
                    object.add(Integer.toString(i), conditionDateSerializer.serialize((ConditionDate) cond, ConditionDate.class, context));
                    break;
                case Day:
                    object.add(Integer.toString(i), conditionDaySerializer.serialize((ConditionDay) cond, ConditionDay.class, context));
                    break;
                case Hour:
                    object.add(Integer.toString(i), conditionHourSerializer.serialize((ConditionHour) cond, ConditionHour.class, context));
                    break;
                case Battery:
                    object.add(Integer.toString(i), conditionBatteryLevelSerializer.serialize((ConditionBatteryLevel) cond, ConditionBatteryLevel.class, context));
                    break;
            }
        }

        return object;
    }
}