package dev.intelligentcreations.hudium.plugin.info;

import dev.intelligentcreations.hudium.HudiumClient;
import dev.intelligentcreations.hudium.api.info.plugin.EntityInfoPlugin;
import dev.intelligentcreations.hudium.api.info.plugin.context.EntityInfoPluginContext;
import net.minecraft.entity.LivingEntity;

public class EntityHealthPlugin implements EntityInfoPlugin {
    @Override
    public void addInfo(EntityInfoPluginContext context) {
        if (context.getTarget() instanceof LivingEntity livingEntity) {
            switch (HudiumClient.CONFIG.floatAndDoubleShowMode) {
                case ACCURATE -> context.renderText("\u2665 " + livingEntity.getHealth() + "/" + livingEntity.getMaxHealth(), 16733525);
                case SEMI_ACCURATE -> context.renderText("\u2665 " + Math.round(livingEntity.getHealth() * 10) / 10 + "/" + Math.round(livingEntity.getMaxHealth() * 10) / 10, 16733525);
                case INTEGER -> context.renderText("\u2665 " + Math.round(livingEntity.getHealth()) + "/" + Math.round(livingEntity.getMaxHealth()), 16733525);
            }
        }
    }
}
