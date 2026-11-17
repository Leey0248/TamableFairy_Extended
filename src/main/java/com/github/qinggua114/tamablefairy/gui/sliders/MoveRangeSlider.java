package com.github.qinggua114.tamablefairy.gui.sliders;

import com.github.tartaricacid.touhoulittlemaid.entity.monster.EntityFairy;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;

public class MoveRangeSlider extends AbstractSliderButton {

    public MoveRangeSlider(int x, int y, int width, int height, Component message, double value, EntityFairy entity) {
        super(x, y, width, height, message, value);
    }

    @Override
    protected void updateMessage() {
        int range = getValue();

        this.setMessage(
                Component.translatable(
                        "slider.move_range",
                        range == 0
                                ? Component.translatable("text.disabled")
                                : String.valueOf(range)
                )
        );
    }

    public void setValue(double newValue) {
        this.value = Math.max(0, Math.min(1, newValue));
        this.updateMessage();
    }

    @Override
    protected void applyValue() {

    }

    public double getOriginalValue() {
        return this.value;
    }

    public int getValue() {
        return (int) (this.value * 32);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (!this.isMouseOver(mouseX, mouseY)) return false;
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }
}
