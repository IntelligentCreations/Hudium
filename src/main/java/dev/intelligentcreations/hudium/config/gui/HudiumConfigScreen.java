package dev.intelligentcreations.hudium.config.gui;

import dev.intelligentcreations.hudium.HudiumClient;
import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.SpruceTexts;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import dev.lambdaurora.spruceui.widget.container.SpruceOptionListWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class HudiumConfigScreen extends SpruceScreen {
    private final Screen parent;

    public HudiumConfigScreen(@Nullable Screen parent) {
        super(Text.translatable("config.hudium.hudium-config"));
        this.parent = parent;
    }

    private int getTextHeight() {
        return (5 + this.textRenderer.fontHeight) * 3 + 5;
    }

    @Override
    protected void init() {
        super.init();
        SpruceOptionListWidget list = HudiumClient.configScreenBase.buildOptionList(Position.of(0, 22), this.width, this.height - 35 - 22);
        HudiumClient.configScreenBase.resetConsumer = btn ->
                this.init(this.client, this.client.getWindow().getScaledWidth(), this.client.getWindow().getScaledHeight());
        this.addDrawableChild(list);
        this.addDrawableChild(new SpruceButtonWidget(Position.of(this, this.width / 2 - 75, this.height - 29), 150, 20, SpruceTexts.GUI_DONE,
                btn -> {
            HudiumClient.CONFIG.save();
            this.client.setScreen(this.parent);
        }).asVanilla());
    }

    @Override
    public void renderTitle(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
    }
}
