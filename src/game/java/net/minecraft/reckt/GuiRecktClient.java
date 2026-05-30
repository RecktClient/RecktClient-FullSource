package net.minecraft.reckt;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;

public class GuiRecktClient extends GuiScreen {

	// RecktClient colors
	private static final int COLOR_RED = 0xFFCC2222;
	private static final int COLOR_RED_DARK = 0xFF881111;
	private static final int COLOR_RED_BRIGHT = 0xFFFF4444;
	private static final int COLOR_WHITE = 0xFFFFFFFF;
	private static final int COLOR_LIGHT_GRAY = 0xFFCCCCCC;
	private static final int COLOR_DARK_BG = 0xE0111111;
	private static final int COLOR_PANEL_BG = 0xE8181818;
	private static final int COLOR_MODULE_BG = 0xCC1A1A1A;
	private static final int COLOR_MODULE_ENABLED = 0xCCCC2222;
	private static final int COLOR_MODULE_HOVER = 0xCC2A2A2A;
	private static final int COLOR_HEADER = 0xFF0D0D0D;

	private String selectedCategory = "PVP";
	private List<String> categories;
	private int scrollOffset = 0;
	private int hoveredModule = -1;

	// Layout constants
	private static final int PANEL_WIDTH = 380;
	private static final int PANEL_HEIGHT = 280;
	private static final int CATEGORY_WIDTH = 90;
	private static final int HEADER_HEIGHT = 28;
	private static final int MODULE_HEIGHT = 18;
	private static final int PADDING = 6;

	public GuiRecktClient() {
		RecktModuleManager.init();
		this.categories = RecktModuleManager.getCategories();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void initGui() {
		scrollOffset = 0;
		hoveredModule = -1;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int panelX = (this.width - PANEL_WIDTH) / 2;
		int panelY = (this.height - PANEL_HEIGHT) / 2;

		// Draw dark background overlay
		drawRect(0, 0, this.width, this.height, 0x88000000);

		// Main panel shadow
		drawRect(panelX + 3, panelY + 3, panelX + PANEL_WIDTH + 3, panelY + PANEL_HEIGHT + 3, 0x66000000);

		// Main panel background
		drawRect(panelX, panelY, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT, COLOR_PANEL_BG);

		// Header bar
		drawRect(panelX, panelY, panelX + PANEL_WIDTH, panelY + HEADER_HEIGHT, COLOR_HEADER);

		// Red accent line under header
		drawRect(panelX, panelY + HEADER_HEIGHT - 2, panelX + PANEL_WIDTH, panelY + HEADER_HEIGHT, COLOR_RED);

		// Title
		String title = "\u00a7cReckt\u00a7fClient";
		drawString(this.fontRendererObj, title, panelX + PADDING + 2, panelY + 9, COLOR_WHITE);

		// Version
		String version = "\u00a77v1.0 \u00a78| \u00a77wasd.isgoose";
		drawString(this.fontRendererObj, version, panelX + 75, panelY + 9, -1);

		// Close hint
		String closeHint = "\u00a78[ESC / RShift to close]";
		int closeW = this.fontRendererObj.getStringWidth(closeHint);
		drawString(this.fontRendererObj, closeHint, panelX + PANEL_WIDTH - closeW - PADDING, panelY + 9, -1);

		// Category sidebar background
		drawRect(panelX, panelY + HEADER_HEIGHT, panelX + CATEGORY_WIDTH, panelY + PANEL_HEIGHT, COLOR_DARK_BG);

		// Right side divider
		drawRect(panelX + CATEGORY_WIDTH, panelY + HEADER_HEIGHT, panelX + CATEGORY_WIDTH + 1, panelY + PANEL_HEIGHT, COLOR_RED_DARK);

		// Draw categories
		int catY = panelY + HEADER_HEIGHT + PADDING;
		for (String cat : categories) {
			boolean selected = cat.equals(selectedCategory);
			int catColor = selected ? COLOR_RED : COLOR_MODULE_BG;
			int textColor = selected ? COLOR_WHITE : COLOR_LIGHT_GRAY;

			// Category bg
			drawRect(panelX + 2, catY - 1, panelX + CATEGORY_WIDTH - 2, catY + 14, catColor);

			// Category name
			if (selected) {
				// Draw left accent bar
				drawRect(panelX + 2, catY - 1, panelX + 4, catY + 14, COLOR_RED_BRIGHT);
			}

			drawString(this.fontRendererObj, cat, panelX + 8, catY + 3, textColor);

			// Count enabled modules in category
			int enabledCount = 0;
			for (RecktModule m : RecktModuleManager.getModulesByCategory(cat)) {
				if (m.isEnabled()) enabledCount++;
			}
			if (enabledCount > 0) {
				String countStr = "\u00a7c" + enabledCount;
				int cw = this.fontRendererObj.getStringWidth(countStr);
				drawString(this.fontRendererObj, countStr, panelX + CATEGORY_WIDTH - cw - 5, catY + 3, -1);
			}

			catY += 17;
		}

		// Draw modules for selected category
		List<RecktModule> mods = RecktModuleManager.getModulesByCategory(selectedCategory);
		int moduleAreaX = panelX + CATEGORY_WIDTH + 2;
		int moduleAreaY = panelY + HEADER_HEIGHT + 2;
		int moduleAreaW = PANEL_WIDTH - CATEGORY_WIDTH - 4;
		int visibleModules = (PANEL_HEIGHT - HEADER_HEIGHT - 4) / MODULE_HEIGHT;

		// Clamp scroll
		int maxScroll = Math.max(0, mods.size() - visibleModules);
		scrollOffset = Math.max(0, Math.min(scrollOffset, maxScroll));

		hoveredModule = -1;
		int modIdx = scrollOffset;
		int drawY = moduleAreaY;
		int drawnCount = 0;

		while (modIdx < mods.size() && drawnCount < visibleModules + 1) {
			RecktModule mod = mods.get(modIdx);
			boolean enabled = mod.isEnabled();

			int modY = drawY;
			int modYEnd = modY + MODULE_HEIGHT - 1;

			boolean hovered = mouseX >= moduleAreaX && mouseX < moduleAreaX + moduleAreaW
					&& mouseY >= modY && mouseY < modYEnd;

			if (hovered) {
				hoveredModule = modIdx;
			}

			// Module background
			int bgColor = enabled ? COLOR_MODULE_ENABLED : (hovered ? COLOR_MODULE_HOVER : COLOR_MODULE_BG);
			drawRect(moduleAreaX, modY, moduleAreaX + moduleAreaW, modYEnd, bgColor);

			if (enabled) {
				// Left red bar for enabled modules
				drawRect(moduleAreaX, modY, moduleAreaX + 2, modYEnd, COLOR_RED_BRIGHT);
			}

			// Module name
			String nameStr = (enabled ? "\u00a7f" : "\u00a77") + mod.getName();
			drawString(this.fontRendererObj, nameStr, moduleAreaX + 5, modY + 4, -1);

			// Enabled indicator
			if (enabled) {
				String onStr = "\u00a7cON";
				int onW = this.fontRendererObj.getStringWidth(onStr);
				drawString(this.fontRendererObj, onStr, moduleAreaX + moduleAreaW - onW - 4, modY + 4, -1);
			}

			drawY += MODULE_HEIGHT;
			modIdx++;
			drawnCount++;
		}

		// Scrollbar
		if (mods.size() > visibleModules) {
			int sbX = moduleAreaX + moduleAreaW - 3;
			int sbH = PANEL_HEIGHT - HEADER_HEIGHT - 4;
			int sbThumbH = Math.max(16, sbH * visibleModules / mods.size());
			int sbThumbY = moduleAreaY + (sbH - sbThumbH) * scrollOffset / Math.max(1, maxScroll);
			drawRect(sbX, moduleAreaY, sbX + 2, moduleAreaY + sbH, 0x44FFFFFF);
			drawRect(sbX, sbThumbY, sbX + 2, sbThumbY + sbThumbH, COLOR_RED);
		}

		// Bottom bar
		drawRect(panelX, panelY + PANEL_HEIGHT - 16, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT, COLOR_HEADER);
		drawRect(panelX, panelY + PANEL_HEIGHT - 16, panelX + PANEL_WIDTH, panelY + PANEL_HEIGHT - 15, COLOR_RED_DARK);

		// Bottom status text
		String totalMods = "\u00a77Total Modules: \u00a7c" + RecktModuleManager.getModules().size()
				+ " \u00a78| \u00a77Enabled: \u00a7c" + RecktModuleManager.getEnabledModules().size();
		drawString(this.fontRendererObj, totalMods, panelX + PADDING, panelY + PANEL_HEIGHT - 12, -1);

		// Tooltip for hovered module
		if (hoveredModule >= 0 && hoveredModule < mods.size()) {
			RecktModule hm = mods.get(hoveredModule);
			String desc = "\u00a78" + hm.getDescription();
			int descW = this.fontRendererObj.getStringWidth(desc) + 4;
			int tipX = mouseX + 8;
			int tipY = mouseY - 12;
			if (tipX + descW > this.width - 5) tipX = mouseX - descW - 4;
			drawRect(tipX - 2, tipY - 2, tipX + descW, tipY + 11, 0xEE111111);
			drawRect(tipX - 2, tipY - 2, tipX - 1, tipY + 11, COLOR_RED);
			drawString(this.fontRendererObj, desc, tipX, tipY, -1);
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		int panelX = (this.width - PANEL_WIDTH) / 2;
		int panelY = (this.height - PANEL_HEIGHT) / 2;

		// Check category clicks
		int catY = panelY + HEADER_HEIGHT + PADDING;
		for (String cat : categories) {
			if (mouseX >= panelX + 2 && mouseX < panelX + CATEGORY_WIDTH - 2
					&& mouseY >= catY - 1 && mouseY < catY + 14) {
				selectedCategory = cat;
				scrollOffset = 0;
				return;
			}
			catY += 17;
		}

		// Check module clicks
		List<RecktModule> mods = RecktModuleManager.getModulesByCategory(selectedCategory);
		int moduleAreaX = panelX + CATEGORY_WIDTH + 2;
		int moduleAreaY = panelY + HEADER_HEIGHT + 2;
		int moduleAreaW = PANEL_WIDTH - CATEGORY_WIDTH - 4;
		int visibleModules = (PANEL_HEIGHT - HEADER_HEIGHT - 4) / MODULE_HEIGHT;

		if (mouseX >= moduleAreaX && mouseX < moduleAreaX + moduleAreaW) {
			int relY = mouseY - moduleAreaY;
			int clickedIdx = relY / MODULE_HEIGHT + scrollOffset;
			if (clickedIdx >= 0 && clickedIdx < mods.size()) {
				mods.get(clickedIdx).toggle();
				return;
			}
		}
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();
		try {
			int wheel = net.lax1dude.eaglercraft.v1_8.Mouse.getDWheel();
			if (wheel != 0) {
				scrollOffset -= wheel / 120;
				List<RecktModule> mods = RecktModuleManager.getModulesByCategory(selectedCategory);
				int visibleModules = (PANEL_HEIGHT - HEADER_HEIGHT - 4) / MODULE_HEIGHT;
				int maxScroll = Math.max(0, mods.size() - visibleModules);
				scrollOffset = Math.max(0, Math.min(scrollOffset, maxScroll));
			}
		} catch (Exception e) {
		}
	}

	@Override
	protected void keyTyped(char parChar1, int keyCode) {
		// Close on ESC (1) or Right Shift (54)
		if (keyCode == 1 || keyCode == 54) {
			this.mc.displayGuiScreen(null);
		}
	}
}
