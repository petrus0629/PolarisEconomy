package polaris.polaris;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Polaris extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        /* Vault 플러그인 연동 구문 */
        if (!setupEconomy()) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        System.out.println(ChatColor.GREEN + "폴라리스 이코노미 실행성공");
    }
    private static Economy econ = null;

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "폴라리스 이코노미 실행종료");
    }
}
