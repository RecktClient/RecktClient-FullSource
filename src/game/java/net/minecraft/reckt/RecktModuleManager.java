package net.minecraft.reckt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class RecktModuleManager {

	private static final List<RecktModule> modules = new ArrayList<RecktModule>();
	private static final Map<String, RecktModule> moduleMap = new LinkedHashMap<String, RecktModule>();
	private static boolean initialized = false;

	public static void init() {
		if (initialized) return;
		initialized = true;

		// ===== PVP CATEGORY =====
		reg("CPS Counter", "PVP", "Displays your clicks per second on the HUD");
		reg("Armor Status", "PVP", "Shows your armor durability on screen");
		reg("Potion Status", "PVP", "Displays active potion effects and their durations");
		reg("Direction HUD", "PVP", "Shows compass direction you are facing");
		reg("Sprint Indicator", "PVP", "Shows when you are sprinting with a visual indicator");
		reg("Auto Sprint", "PVP", "Automatically sprints forward when moving");
		reg("Counter Strafe", "PVP", "Helps with counter-strafing display timing");
		reg("Hit Color", "PVP", "Highlights enemies red when you hit them");
		reg("Block Hit", "PVP", "Shows visual block hit feedback when attacking");
		reg("Reach Display", "PVP", "Shows your current attack reach in blocks");
		reg("Kill Counter", "PVP", "Tracks and displays your kill count");
		reg("Combo Display", "PVP", "Shows your current combo hit streak");
		reg("Damage Indicator", "PVP", "Shows damage numbers when hitting entities");
		reg("Arrow Counter", "PVP", "Shows number of arrows in your inventory");
		reg("W-Tap Helper", "PVP", "Displays optimal W-tap timing visual cue");
		reg("Enemy Health Bar", "PVP", "Renders a health bar above targeted enemies");
		reg("FoV Changer", "PVP", "Adjusts field of view for PvP (no sprint-FoV)");
		reg("Crosshair Plus", "PVP", "Custom crosshair with hit detection feedback");
		reg("Hit Box Display", "PVP", "Renders entity hitboxes for better aim");
		reg("Better Sprint", "PVP", "Sprints without holding the key down");
		reg("BPS Display", "PVP", "Shows blocks per second you are moving");
		reg("Server TPS", "PVP", "Displays server ticks per second");
		reg("Ping Display", "PVP", "Shows your current latency to the server");
		reg("Anti-AFK", "PVP", "Prevents being kicked for inactivity");
		reg("Chat Grab", "PVP", "Grabs useful info from chat automatically");
		reg("Kill Message", "PVP", "Sends a custom message when you kill someone");
		reg("Death Message", "PVP", "Displays your death cause prominently");
		reg("Chat Colors", "PVP", "Adds color support to chat messages");
		reg("Chat Notifications", "PVP", "Plays a sound when your name is mentioned");
		reg("Chat Timestamps", "PVP", "Adds timestamps to all chat messages");
		reg("Better Tab", "PVP", "Enhanced player list with health bars");
		reg("Name Highlight", "PVP", "Highlights player names in chat and world");
		reg("Net Graph", "PVP", "Shows detailed network performance graph");
		reg("Packet Loss", "PVP", "Monitors and displays packet loss percentage");
		reg("No Punch Delay", "PVP", "Removes the punch delay for faster attacks");
		reg("Better Chat", "PVP", "Improved chat rendering and history");
		reg("Auto Respawn", "PVP", "Automatically clicks respawn on death screen");
		reg("Server IP HUD", "PVP", "Displays current server IP on screen");
		reg("Item Display", "PVP", "Shows currently held item name prominently");
		reg("Food Display", "PVP", "Shows exact food level as a number");
		reg("Saturation Display", "PVP", "Shows saturation level numerically");
		reg("Key Display", "PVP", "Shows WASD and other keys you are pressing");
		reg("Clock HUD", "PVP", "Displays current real-world time");
		reg("Speed Display", "PVP", "Shows your movement speed in m/s");
		reg("Jump Counter", "PVP", "Counts jumps per second for bunny-hopping");
		reg("Fall Timer", "PVP", "Shows time in air for fall damage prediction");
		reg("Angle Display", "PVP", "Shows pitch and yaw angles");
		reg("Scope Zoom", "PVP", "Hold to zoom in like a scope");
		reg("Item Info", "PVP", "Shows item enchants and durability on HUD");
		reg("Weapon Info", "PVP", "Displays weapon details and attack speed");
		reg("Head Direction", "PVP", "Shows direction player head is looking");
		reg("Aura Detector", "PVP", "Detects suspicious player behavior patterns");
		reg("Arrow Indicator", "PVP", "Shows arrow flight path prediction");
		reg("Crit Display", "PVP", "Shows when you are in crit jump state");
		reg("Blood Effect", "PVP", "Adds blood particle effect on hits");
		reg("Win Counter", "PVP", "Tracks your win count this session");
		reg("Streak Counter", "PVP", "Shows current win/kill streak");
		reg("Player List", "PVP", "Enhanced player list with stats");
		reg("Team Indicator", "PVP", "Highlights teammates with colored outline");
		reg("Enemy Counter", "PVP", "Shows number of enemies nearby");
		reg("Boss Bar", "PVP", "Enhanced boss health bar with percentage");
		reg("Score HUD", "PVP", "Shows scoreboard score on HUD");
		reg("XP Bar", "PVP", "Shows XP as a numerical value");
		reg("Quick Join", "PVP", "Quickly rejoin last server");
		reg("Latency Display", "PVP", "Shows ping with color coding");
		reg("Hit Delay", "PVP", "Shows attack cooldown indicator");
		reg("Attack Rate", "PVP", "Displays your current attack rate");
		reg("Sensitivity Display", "PVP", "Shows mouse sensitivity setting");
		reg("Target Display", "PVP", "Shows info about your current target");
		reg("Distance Display", "PVP", "Shows distance to your target");
		reg("Angle to Target", "PVP", "Shows angle between you and target");
		reg("Wall Check", "PVP", "Notifies if target is behind a wall");
		reg("Strafe Lock", "PVP", "Locks strafe direction helper");
		reg("Momentum Display", "PVP", "Shows your current momentum vector");
		reg("Air Time Display", "PVP", "Shows how long you have been in the air");
		reg("Ground Timer", "PVP", "Shows time since last ground contact");
		reg("No Fall", "PVP", "Reduces fall damage visual effect");
		reg("Bed Status", "PVP", "Shows bed destruction status in BedWars");
		reg("Objective HUD", "PVP", "Shows game objectives on screen");
		reg("Zone Indicator", "PVP", "Shows which zone you are in");
		reg("Flag Capture", "PVP", "Shows flag capture status");
		reg("Elo Display", "PVP", "Shows estimated Elo rating");
		reg("Rank Display", "PVP", "Displays your server rank");
		reg("Alt Manager", "PVP", "Manage alt accounts easily");
		reg("Server Browser", "PVP", "Browse servers from in-game");
		reg("Mouse DPI", "PVP", "Shows effective mouse DPI");
		reg("Trajectory", "PVP", "Shows projectile trajectory prediction");
		reg("Pvp Stance", "PVP", "Optimal strafing stance indicator");
		reg("Block Aim", "PVP", "Block placement aim helper");
		reg("Sprint Jump", "PVP", "Optimizes sprint-jump timing");
		reg("Combo Timer", "PVP", "Timer for maintaining combo hits");
		reg("Player Tracker", "PVP", "Tracks nearby player positions");
		reg("Mob Tracker", "PVP", "Tracks nearby mob positions");
		reg("Armor Warning", "PVP", "Alerts when armor is low");
		reg("Chest Finder", "PVP", "Highlights nearby chests");
		reg("Trap Detector", "PVP", "Detects potential traps nearby");
		reg("Projectile Aim", "PVP", "Aim assistance for projectiles");
		reg("No Pickup Delay", "PVP", "Removes item pickup delay animation");
		reg("Weapon Switch", "PVP", "Shows optimal weapon switch timing");
		reg("Reach Extension", "PVP", "Displays max reach for current item");
		reg("Sprint Reset", "PVP", "Resets sprint state for better control");
		reg("Critical Indicator", "PVP", "Shows crit timing indicator");

		// ===== FPS CATEGORY =====
		regFPS("No Fog", "Disables all fog rendering for a major FPS boost");
		regFPS("No Clouds", "Disables cloud rendering entirely");
		regFPS("No Rain", "Disables rain particle rendering");
		regFPS("No Snow", "Disables snow particle rendering");
		regFPS("No Particles", "Disables all particle effects");
		regFPS("Reduce Particles", "Reduces particle count to minimum");
		regFPS("No Fire Overlay", "Disables the fire screen overlay");
		regFPS("No Vignette", "Disables the screen vignette effect");
		regFPS("No Pumpkin Overlay", "Disables pumpkin head overlay");
		regFPS("No Portal Overlay", "Disables the nether portal warp overlay");
		regFPS("No Nausea Effect", "Disables the nausea warp effect");
		regFPS("Fast Leaves", "Uses fast rendering for leaves");
		regFPS("No Shadows", "Disables all shadow rendering");
		regFPS("No Entity Shadows", "Disables shadow circles under entities");
		regFPS("No Enchant Glint", "Disables enchantment glint animation");
		regFPS("No Beacon Beam", "Disables beacon beam rendering");
		regFPS("Static Sky", "Disables animated sky effects");
		regFPS("No Weather Sound", "Disables rain and thunder sounds");
		regFPS("Low Render Distance", "Forces minimum render distance");
		regFPS("Smart Cull", "Smart frustum culling optimization");
		regFPS("Entity Cull", "Reduces entity render distance");
		regFPS("No Lightning Flash", "Disables screen flash from lightning");
		regFPS("No Block Crack", "Disables block breaking crack particles");
		regFPS("No Block Destroy", "Disables block break particles");
		regFPS("No Mob Spawn Particles", "Disables mob spawn smoke particles");
		regFPS("Fast Water", "Uses simplified water rendering");
		regFPS("No Lava Particles", "Disables lava pop particles");
		regFPS("No Fire Particles", "Disables fire particle effects");
		regFPS("No Smoke Particles", "Disables smoke from torches and fire");
		regFPS("No Torch Flame", "Disables torch flame particles");
		regFPS("No Potion Particles", "Disables potion effect particles");
		regFPS("No Ambient Particles", "Disables ambient environmental particles");
		regFPS("No Rain Particles", "Disables rain splash particles");
		regFPS("No Snow Particles", "Disables snow fall particles");
		regFPS("No Splash Particles", "Disables water splash particles");
		regFPS("No Explosion Particles", "Disables explosion smoke and fire");
		regFPS("No Drip Particles", "Disables water and lava drip particles");
		regFPS("No Redstone Particles", "Disables redstone dust particles");
		regFPS("No Portal Particles", "Disables nether portal particles");
		regFPS("No Item Pickup", "Disables item pickup animation");
		regFPS("Smooth FPS", "Smooths FPS for more consistent gameplay");
		regFPS("Fast Graphics", "Enables fast graphics preset");
		regFPS("Fast Rendering", "Enables optimized rendering path");
		regFPS("Static Lighting", "Disables smooth lighting (major FPS gain)");
		regFPS("No Ambient Occlusion", "Disables ambient occlusion shading");
		regFPS("No Fancy Graphics", "Forces all fancy options off");
		regFPS("Minimal HUD", "Simplifies HUD for faster rendering");
		regFPS("Optimized Chat", "Optimizes chat rendering");
		regFPS("Fast Font", "Uses fast font rendering mode");
		regFPS("No Text Shadow", "Disables text shadow for faster render");
		regFPS("No Tooltip", "Disables item tooltips");
		regFPS("No Item Glow", "Disables item rarity glow effect");
		regFPS("No Water Overlay", "Disables water screen overlay");
		regFPS("No Void Fog", "Disables void darkness effect");
		regFPS("No Cave Dark", "Disables cave darkening effect");
		regFPS("No World Border", "Hides world border rendering");
		regFPS("No Item Frame", "Simplifies item frame rendering");
		regFPS("No Painting", "Disables painting entity rendering");
		regFPS("Fast Sky", "Uses simplified sky rendering");
		regFPS("No Sun", "Disables sun rendering");
		regFPS("No Moon", "Disables moon rendering");
		regFPS("No Stars", "Disables star rendering");
		regFPS("No Horizon", "Disables horizon void fill");
		regFPS("Reduced LOD", "Reduces level of detail for distant chunks");
		regFPS("No Fancy Water", "Disables fancy water reflections");
		regFPS("No Biome Fog", "Disables biome-specific fog colors");
		regFPS("Fast Chunk Load", "Speeds up chunk loading");
		regFPS("Optimized Culling", "Optimizes occlusion culling");
		regFPS("Batch Rendering", "Batches draw calls for fewer GPU calls");
		regFPS("No Walk Bob", "Disables camera bobbing while walking");
		regFPS("No Hit Animation", "Disables screen tilt on taking damage");
		regFPS("No Swing Arm", "Simplifies arm swing rendering");
		regFPS("No Item Bob", "Disables item bobbing in hand");
		regFPS("Reduced Animations", "Reduces entity animations complexity");
		regFPS("FPS Cap", "Caps FPS to reduce CPU/GPU usage");
		regFPS("GC Optimizer", "Reduces garbage collection pauses");
		regFPS("Memory Save", "Reduces memory allocation per frame");
		regFPS("Cached Rendering", "Caches static render elements");
		regFPS("No Achievement", "Disables achievement popup rendering");
		regFPS("No Popup", "Disables all on-screen popups");
		regFPS("No Fancy Leaves", "Forces fast leaves everywhere");
		regFPS("No Depth Haze", "Disables depth-based haze effect");
		regFPS("No Distance Fog", "Disables render distance fade fog");
		regFPS("No Ground Haze", "Disables ground level haze");
		regFPS("No Sky Glow", "Disables sky glow from the sun/moon");
		regFPS("Fast Math", "Uses lookup tables for trig functions");
		regFPS("No Shimmer", "Disables gem/item shimmer effects");
		regFPS("Cached Font", "Caches font glyph data aggressively");
		regFPS("No Blind Effect", "Disables blindness potion darkness");
		regFPS("No Wither Effect", "Disables wither potion dark overlay");
		regFPS("Optimized Inventory", "Speeds up inventory screen rendering");
		regFPS("No Mob Effects", "Disables complex mob particle effects");
		regFPS("No Player Effects", "Disables player-specific particle effects");
		regFPS("Skip Useless Ticks", "Skips unnecessary client tick work");
		regFPS("Thread Priority", "Boosts render thread priority");
		regFPS("No Night Vision Tint", "Disables night vision color effect");
		regFPS("No Respawn Darkness", "Disables respawn screen darken effect");
		regFPS("Fast HUD", "Draws HUD with minimal OpenGL state changes");
		regFPS("No Depth Fog", "Disables depth-based fog in caves");
		regFPS("No Density Fog", "Disables density fog effect");

		// MUST BE LAST FPS MODULE
		reg(new RecktModule("Enable All FPS", "FPS", "Enables every FPS optimization module at once") {
			@Override
			public void onEnable() {
				for (RecktModule m : modules) {
					if (m.getCategory().equals("FPS") && m != this) {
						m.setEnabled(true);
					}
				}
			}
			@Override
			public void onDisable() {
				for (RecktModule m : modules) {
					if (m.getCategory().equals("FPS") && m != this) {
						m.setEnabled(false);
					}
				}
			}
		});

		// ===== HUD CATEGORY =====
		reg("Watermark", "HUD", "Shows RecktClient watermark on screen");
		reg("FPS Counter", "HUD", "Shows frames per second counter");
		reg("Coordinates", "HUD", "Shows XYZ coordinates on screen");
		reg("Biome Display", "HUD", "Shows the current biome name");
		reg("Light Level", "HUD", "Shows current block light level");
		reg("Entity Count", "HUD", "Shows number of loaded entities");
		reg("Chunk Count", "HUD", "Shows number of loaded chunks");
		reg("Memory Usage", "HUD", "Shows RAM usage on screen");
		reg("Day Counter", "HUD", "Shows in-game day count");
		reg("Time Display", "HUD", "Shows in-game time of day");
		reg("Weather Display", "HUD", "Shows current weather");
		reg("Dimension Display", "HUD", "Shows current dimension");
		reg("Difficulty HUD", "HUD", "Shows game difficulty");
		reg("Render Distance HUD", "HUD", "Shows current render distance");
		reg("Gamemode HUD", "HUD", "Shows current gamemode");
		reg("Effects HUD", "HUD", "Shows potion effects with icons");
		reg("Module List", "HUD", "Shows enabled modules on screen");
		reg("Tab Stats", "HUD", "Shows stats while holding tab");
		reg("Death Screen HUD", "HUD", "Enhanced death screen with cause");
		reg("Loading Screen HUD", "HUD", "Custom loading screen style");

		// ===== MISC CATEGORY =====
		reg("Fullbright", "Misc", "Maximum gamma for full visibility");
		reg("No Hurtcam", "Misc", "Disables screen shake when hurt");
		reg("Better Disconnect", "Misc", "Shows disconnect reason clearly");
		reg("No Lag Screen", "Misc", "Disables the lag/paused overlay");
		reg("Fast Debug", "Misc", "Simplifies F3 debug screen");
		reg("Custom Sky", "Misc", "Enables custom sky color options");
		reg("No Error Screen", "Misc", "Suppresses minor error screens");
		reg("Better Rendering", "Misc", "General rendering improvements");
		reg("Smooth World", "Misc", "Smooths world loading transitions");
		reg("No Cobweb Slow", "Misc", "Shows cobweb slowdown status");
		reg("Better Inventory", "Misc", "Enhanced inventory display");
		reg("Quick Settings", "Misc", "Fast access to common settings");
		reg("Smart Gamma", "Misc", "Automatically adjusts gamma");
		reg("No Screen Shake", "Misc", "Prevents any screen shake effects");
		reg("Better Disconnect", "Misc", "Shows cleaner disconnect screens");
		reg("No Credits", "Misc", "Skips end-game credits screen");
		reg("Better Pause", "Misc", "Enhanced pause menu appearance");
		reg("No Boss Bar", "Misc", "Hides the boss health bar");
		reg("Hide Scoreboard", "Misc", "Hides the sidebar scoreboard");
				// ===== PVP EXTRAS =====
		reg("Perspective", "PVP", "Hold key to change camera perspective temporarily");
		reg("Ping Range Color", "PVP", "Colors ping in tab based on quality");
		reg("Anti Blindness", "PVP", "Removes blindness overlay effect");
		reg("Sword Block Indicator", "PVP", "Visual indicator when sword blocking");
		reg("Item Animator", "PVP", "Animates item switching in hand");
		reg("Hit Flash", "PVP", "Flashes red when you take damage");
		reg("Hit Sound", "PVP", "Custom sound when landing a hit");
		reg("Kill Sound", "PVP", "Custom sound when getting a kill");
		reg("Combo Sound", "PVP", "Sounds for maintaining hit combos");
		reg("Pearl Cooldown", "PVP", "Shows ender pearl cooldown on HUD");
		reg("Sword Cooldown", "PVP", "Shows sword cooldown meter");
		reg("Bow Charge", "PVP", "Visual indicator for bow charge level");
		reg("GApple Cooldown", "PVP", "Shows golden apple cooldown timer");
		reg("Hotbar Highlight", "PVP", "Highlights key hotbar slots with border");
		reg("Stack Size HUD", "PVP", "Shows item stack counts prominently");
		reg("Drop Confirm", "PVP", "Confirms before dropping items outside inv");
		reg("Anti Drop", "PVP", "Prevents accidental item drops in PvP");
		reg("Sneak Indicator", "PVP", "Shows when you are sneaking");
		reg("No Slow Eat", "PVP", "Visual indicator for eating slow-down");
		reg("Head Rotate", "PVP", "Smooth head rotation animation toggle");
		reg("Auto Block", "PVP", "Displays auto-block input feedback");
		// ===== FPS EXTRAS =====
		regFPS("No Block Overlay", "Removes block face overlay when inside blocks");
		regFPS("No Pumpkin Overlay", "Removes pumpkin head view overlay");
		regFPS("No Fire Overlay", "Removes the fire overlay when burning");
		regFPS("No Water Overlay", "Removes the water overlay when submerged");
		regFPS("Instant Load", "Reduces world loading screen time");
		regFPS("No Chunk Border", "Disables chunk border rendering");
		regFPS("Compact Queue", "Optimizes chunk update queue ordering");
		regFPS("No Sky", "Disables sky box rendering for FPS boost");
		regFPS("No Moon", "Disables moon rendering at night");
		regFPS("No Sun", "Disables sun rendering during day");
		regFPS("Static Entities", "Reduces entity animation FPS cost");
		regFPS("No Shadow", "Disables entity drop shadows");
		regFPS("Batch Draw", "Batches OpenGL draw calls for efficiency");
		regFPS("No Beacon Beam", "Hides beacon light beam");
		regFPS("No Banner", "Disables animated banner rendering");
		regFPS("No Void Fog", "Removes void fog below y=1 for FPS");
		regFPS("Cull Backface", "Enables backface culling on terrain");
		regFPS("Reduce Resolution", "Lowers internal resolution slightly");
		regFPS("Entity Culling", "Skips rendering hidden entities");
		// ===== HUD EXTRAS =====
		reg("Session Stats", "HUD", "Shows kill/death stats for the session");
		reg("Health Numeric", "HUD", "Shows numeric health value on HUD");
		reg("Armor Numeric", "HUD", "Shows numeric armor value");
		reg("Velocity Meter", "HUD", "Shows current velocity vector");
		reg("Acceleration Meter", "HUD", "Shows rate of speed change");
		reg("Notifications", "HUD", "In-game RecktClient notification toasts");
		reg("Tablist HUD", "HUD", "Compact HUD version of the tab list");
		reg("Status Bar", "HUD", "Combined health/food/armor status bar");
		// ===== MISC EXTRAS =====
		reg("Zoom Smooth", "Misc", "Smooth zoom transition animation");
		reg("Auto Gg", "Misc", "Sends gg in chat after game ends");
		reg("Anti Spam", "Misc", "Filters repeated spam chat messages");
		reg("Tooltip Delay", "Misc", "Adjusts item tooltip show delay");
		reg("No Title Screen", "Misc", "Skips splash/title screen on startup");
		reg("No Bobbing", "Misc", "Disables view bobbing when walking");
		reg("No FOV Change", "Misc", "Locks field of view regardless of speed");
		reg("Old Animations", "Misc", "Reverts to old sword-hold animations");
		reg("Toggle Sprint", "Misc", "Toggle sprint on/off with one key press");
		reg("No Level Up Effect", "Misc", "Disables XP level-up flash effect");
		reg("Transparent Chat", "Misc", "Makes chat background semi-transparent");
		reg("Click GUI Theme", "Misc", "Sets RecktClient GUI red/white theme");
		reg("Block Overlay", "Misc", "Custom block highlight on mouse over");
		reg("No Void Fog Display", "Misc", "Removes void fog below y=1");
		reg("Speedrun Timer", "Misc", "In-game timer for speedrunning");
		reg("Custom Cape", "Misc", "Displays a custom cape on your player");
		reg("Old Hit Reg", "Misc", "Uses older hit registration logic");
		reg("No Hunger Loss Display", "Misc", "Visual indicator for hunger drain");
		reg("Held Item Name", "Misc", "Shows the name of your held item on HUD");
		reg("Smooth FPS", "Misc", "Smooths FPS counter for stability display");
		reg("No Ghost Blocks", "Misc", "Reduces ghost block desyncs visually");
		reg("Inverted Controls", "Misc", "Visualizes inverted mouse Y axis status");
		reg("Short Sword", "Misc", "Uses short sword model animation style");
		reg("Tab Name Color", "Misc", "Colors names in the tab list by ping");
		reg("Debug Info", "Misc", "Enhanced F3 debug overlay for RecktClient");
		reg("Server Brand", "Misc", "Displays server brand name on HUD");
		reg("No Sweep Attack", "Misc", "Hides sweep attack visual effect");
		reg("Low Fire", "Misc", "Lowers fire overlay for better visibility");
reg("Clean Screenshot", "Misc", "Takes screenshots without HUD");
	}

	private static void reg(String name, String category, String description) {
		reg(new RecktModule(name, category, description));
	}

	private static void regFPS(String name, String description) {
		reg(new RecktModule(name, "FPS", description) {
			@Override
			public void onEnable() {
				applyFPSSetting(getName(), true);
			}
			@Override
			public void onDisable() {
				applyFPSSetting(getName(), false);
			}
		});
	}

	private static void applyFPSSetting(String name, boolean enable) {
		try {
			GameSettings gs = Minecraft.getMinecraft().gameSettings;
			if (gs == null) return;
			switch (name) {
			case "No Fog":
				gs.fog = !enable;
				break;
			case "No Clouds":
				gs.clouds = enable ? 0 : 1;
				break;
			case "No Rain":
			case "No Snow":
			case "No Particles":
				gs.particleSetting = enable ? 2 : 0;
				break;
			case "Reduce Particles":
				gs.particleSetting = enable ? 1 : 0;
				break;
			case "Fast Leaves":
			case "No Fancy Leaves":
			case "No Fancy Graphics":
			case "Fast Graphics":
				gs.fancyGraphics = !enable;
				break;
			case "Static Lighting":
			case "No Ambient Occlusion":
				gs.ambientOcclusion = enable ? 0 : 1;
				break;
			case "Fullbright":
				gs.gammaSetting = enable ? 15.0f : 1.0f;
				break;
			default:
				break;
			}
		} catch (Exception e) {
		}
	}

	private static void reg(RecktModule module) {
		modules.add(module);
		moduleMap.put(module.getName().toLowerCase(), module);
	}

	public static List<RecktModule> getModules() {
		return modules;
	}

	public static List<RecktModule> getModulesByCategory(String category) {
		List<RecktModule> result = new ArrayList<RecktModule>();
		for (RecktModule m : modules) {
			if (m.getCategory().equals(category)) {
				result.add(m);
			}
		}
		return result;
	}

	public static RecktModule getModule(String name) {
		return moduleMap.get(name.toLowerCase());
	}

	public static boolean isEnabled(String name) {
		RecktModule m = moduleMap.get(name.toLowerCase());
		return m != null && m.isEnabled();
	}

	public static List<String> getCategories() {
		List<String> cats = new ArrayList<String>();
		for (RecktModule m : modules) {
			if (!cats.contains(m.getCategory())) {
				cats.add(m.getCategory());
			}
		}
		return cats;
	}

	public static List<RecktModule> getEnabledModules() {
		List<RecktModule> result = new ArrayList<RecktModule>();
		for (RecktModule m : modules) {
			if (m.isEnabled()) result.add(m);
		}
		return result;
	}
}
