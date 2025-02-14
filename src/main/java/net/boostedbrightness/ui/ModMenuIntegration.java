package net.boostedbrightness.ui;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.boostedbrightness.BoostedBrightness;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ModMenuOptionsScreen(parent);
    }

    public class ModMenuOptionsScreen extends GameOptionsScreen {
        private BrightnessListWidget list;

        public ModMenuOptionsScreen(Screen parent) {
            super(parent, MinecraftClient.getInstance().options, Text.translatable("options.boosted-brightness.title"));
        }
        //Find way to convert the BrightnessListWidget to this class, and the entries to SimpleOptions
        protected void initBody() {
            //this.list = new BrightnessListWidget(this.client, this.width, this.height, 32, 25);
            //this.body = new BrightnessListWidget(this.client, this.width, this.height, 32, 25);
            //this.addSelectableChild(this.list);

            /*this.addDrawableChild(ButtonWidget.builder(ScreenTexts.DONE, (button) -> {
                this.client.setScreen(this.parent);
            }).size(240, 20).position(this.width / 2 - 120, this.height - 27).build());*/
        }

        @Override
        protected void addOptions() {
        }

        /*public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            this.renderBackground(context,mouseX,mouseY,delta);
            this.list.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 5, 0xFFFFFF);
            super.render(context, mouseX, mouseY, delta);
        }*/

        public void removed() {
            BoostedBrightness.saveConfig();
            super.removed();
        }
    }
}
