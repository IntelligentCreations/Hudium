package dev.intelligentcreations.hudium.api.info.plugin.context;

import dev.intelligentcreations.hudium.HudiumClient;
import dev.intelligentcreations.hudium.config.HudiumConfig;
import dev.intelligentcreations.hudium.util.TextRendererUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class BlockInfoPluginContext implements PluginContext {
    private final MatrixStack matrices;
    private final MinecraftClient client;
    private final PlayerEntity player;
    private final float tickDelta;
    private final TextRenderer textRenderer;
    private final BlockState state;
    private final BlockPos pos;
    private final float startY;
    private int lines;

    private final HudiumConfig cfg = HudiumClient.CONFIG;

    protected BlockInfoPluginContext(MatrixStack matrices,
                                     MinecraftClient client,
                                     PlayerEntity player,
                                     float tickDelta,
                                     TextRenderer textRenderer,
                                     BlockState state,
                                     BlockPos pos,
                                     float startY) {
        this.matrices = matrices;
        this.client = client;
        this.player = player;
        this.tickDelta = tickDelta;
        this.textRenderer = textRenderer;
        this.state = state;
        this.pos = pos;
        this.startY = startY;
        this.lines = 1;
    }

    public static BlockInfoPluginContext of(MatrixStack matrices,
                                            MinecraftClient client,
                                            PlayerEntity player,
                                            float tickDelta,
                                            TextRenderer textRenderer,
                                            BlockState state,
                                            BlockPos pos,
                                            float startY) {
        return new BlockInfoPluginContext(matrices, client, player, tickDelta, textRenderer, state, pos, startY);
    }

    public MatrixStack getMatrices() {
        return matrices;
    }

    public MinecraftClient getClient() {
        return client;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public float getTickDelta() {
        return tickDelta;
    }

    public TextRenderer getTextRenderer() {
        return textRenderer;
    }

    public BlockState getState() {
        return state;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Override
    public void renderText(Text text, int color) {
        boolean hasIcon = getState().getBlock().getPickStack(getPlayer().getWorld(), getPos(), getState()) != null
                && !(getState().getBlock() instanceof FluidBlock);
        TextRendererUtil.renderText(textRenderer, matrices, text, hasIcon ? cfg.displayInfoX + 17 : cfg.displayInfoX, cfg.displayInfoY + startY + 9 * (lines - 1), color);
        lines += 1;
    }

    @Override
    public void renderText(String text, int color) {
        boolean hasIcon = getState().getBlock().getPickStack(getPlayer().getWorld(), getPos(), getState()) != null
                && !(getState().getBlock() instanceof FluidBlock);
        TextRendererUtil.renderText(textRenderer, matrices, text, hasIcon ? cfg.displayInfoX + 17 : cfg.displayInfoX, cfg.displayInfoY + startY + 9 * (lines - 1), color);
        lines += 1;
    }

    public int getLines() {
        return lines;
    }
}
