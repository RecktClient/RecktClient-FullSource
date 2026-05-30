package net.minecraft.reckt;

public class RecktModule {

	private final String name;
	private final String category;
	private final String description;
	private boolean enabled;

	public RecktModule(String name, String category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.enabled = false;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		boolean wasEnabled = this.enabled;
		this.enabled = enabled;
		if (enabled && !wasEnabled) {
			onEnable();
		} else if (!enabled && wasEnabled) {
			onDisable();
		}
	}

	public void toggle() {
		setEnabled(!enabled);
	}

	public void onEnable() {
	}

	public void onDisable() {
	}
}
