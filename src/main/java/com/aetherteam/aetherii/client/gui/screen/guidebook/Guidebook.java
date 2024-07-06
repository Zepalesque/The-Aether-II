package com.aetherteam.aetherii.client.gui.screen.guidebook;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.client.gui.component.guidebook.GuidebookTab;
import com.aetherteam.aetherii.inventory.menu.GuidebookEquipmentMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.function.BiFunction;

public interface Guidebook {
    WidgetSprites EQUIPMENT_TAB = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/equipment_tab"), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/equipment_tab_selected"));
    WidgetSprites STATUS_TAB = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/status_tab"), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/status_tab_selected"));
    WidgetSprites DISCOVERY_TAB = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/discovery_tab"), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/discovery_tab_selected"));
    WidgetSprites JOURNAL_TAB = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/journal_tab"), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/journal_tab_selected"));
    WidgetSprites REWARDS_TAB = new WidgetSprites(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/rewards_tab"), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "guidebook/rewards_tab_selected"));
    ResourceLocation GUIDEBOOK_BACKING_LOCATION = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/gui/guidebook/guidebook_backing.png");
    ResourceLocation HEART_CONTAINER_SPRITE = ResourceLocation.withDefaultNamespace("hud/heart/container");
    ResourceLocation HEART_SPRITE = ResourceLocation.withDefaultNamespace("hud/heart/full");
    ResourceLocation ARMOR_SPRITE = ResourceLocation.withDefaultNamespace("hud/armor_full");
    int BACKING_WIDTH = 375;
    int BACKING_HEIGHT = 198;
    int PAGE_WIDTH = 176;
    int PAGE_HEIGHT = 185;

    default void initTabs(Screen screen) {
        Tab[] tabs = Tab.values();
        int tabCount = tabs.length;
        int singleTabWidth = 26;
        int singleTabHeight = 35;
        int totalWidth = (tabCount - 1) + (tabCount * singleTabWidth);
        int x = screen.width / 2 - (totalWidth / 2);
        int y = 0;
        for (Tab tab : tabs) {
            Screen screenToOpen = tab.getScreen().apply(this.getEquipmentMenu(), this.getPlayerInventory());
            GuidebookTab tabButton = new GuidebookTab(screen, screenToOpen, x, y, singleTabWidth, singleTabHeight, tab.getSprite());
            tabButton.setTooltip(Tooltip.create(screenToOpen.getTitle()));
            this.addRenderableWidget(screen, tabButton);
            x += singleTabWidth + 1;
        }
    }

    default void renderGuidebookSpread(Screen screen, GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderGuidebookBacking(screen, guiGraphics, mouseX, mouseY, partialTick);
        this.renderGuidebookLeftPage(screen, guiGraphics, mouseX, mouseY, partialTick);
        this.renderGuidebookRightPage(screen, guiGraphics, mouseX, mouseY, partialTick);
    }

    default void renderGuidebookBacking(Screen screen, GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int leftPos = (screen.width - BACKING_WIDTH) / 2;
        int topPos = (screen.height - BACKING_HEIGHT) / 2;
        guiGraphics.blit(GUIDEBOOK_BACKING_LOCATION, leftPos, topPos, 0, 0, 0, BACKING_WIDTH, BACKING_HEIGHT, BACKING_WIDTH, BACKING_HEIGHT);
    }

    default void renderGuidebookLeftPage(Screen screen, GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int leftPos = (screen.width / 2) -  PAGE_WIDTH;
        int topPos = (screen.height - BACKING_HEIGHT) / 2;
        guiGraphics.blit(this.getLeftPageTexture(), leftPos, topPos, 0, 0, 0, PAGE_WIDTH, PAGE_HEIGHT, PAGE_WIDTH, PAGE_HEIGHT);
    }

    default void renderGuidebookRightPage(Screen screen, GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        int leftPos = (screen.width / 2);
        int topPos = (screen.height - BACKING_HEIGHT) / 2;
        guiGraphics.blit(this.getRightPageTexture(), leftPos, topPos, 0, 0, 0, PAGE_WIDTH, PAGE_HEIGHT, PAGE_WIDTH, PAGE_HEIGHT);
    }

    ResourceLocation getLeftPageTexture();

    ResourceLocation getRightPageTexture();

    GuidebookEquipmentMenu getEquipmentMenu();

    Inventory getPlayerInventory();

    <T extends GuiEventListener & Renderable & NarratableEntry> T addRenderableWidget(Screen screen, T widget);

    enum Tab {
        EQUIPMENT(EQUIPMENT_TAB, (menu, inventory) -> new GuidebookEquipmentScreen(menu, inventory, Component.translatable("gui.aether_ii.guidebook.equipment.title"))),
        STATUS(STATUS_TAB, (menu, inventory) -> new GuidebookStatusScreen(menu, inventory, Component.translatable("gui.aether_ii.guidebook.status.title"))),
        DISCOVERY(DISCOVERY_TAB, (menu, inventory) -> new GuidebookDiscoveryScreen(menu, inventory, Component.translatable("gui.aether_ii.guidebook.discovery.title"))),
        JOURNAL(JOURNAL_TAB, (menu, inventory) -> new GuidebookJournalScreen(menu, inventory, Component.translatable("gui.aether_ii.guidebook.journal.title")));
//        REWARDS(REWARDS_TAB, (menu, inventory) -> new GuidebookRewardsScreen(menu, inventory, Component.translatable("gui.aether_ii.guidebook.rewards.title"))); //todo

        private final WidgetSprites sprite;
        private final BiFunction<GuidebookEquipmentMenu, Inventory, Screen> screen;

        Tab(WidgetSprites sprite, BiFunction<GuidebookEquipmentMenu, Inventory, Screen> screen) {
            this.sprite = sprite;
            this.screen = screen;
        }

        public WidgetSprites getSprite() {
            return this.sprite;
        }

        public BiFunction<GuidebookEquipmentMenu, Inventory, Screen> getScreen() {
            return this.screen;
        }
    }
}