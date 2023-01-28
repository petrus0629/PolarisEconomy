package polaris.polaris;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurrencyControll implements CommandExecutor {

    private Economy economy = Polaris.economy;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("은행")) {
                if (args[0].equalsIgnoreCase("증액")) {
                    if (args.length == 3) {
                        try {
                            Player target = Bukkit.getPlayer(args[1]);
                            int depositAmount = Integer.parseInt(args[2]);

                            economy.depositPlayer(target, depositAmount);
                            player.sendMessage(ChatColor.GRAY + "잔액 : " + depositAmount + "원이" + target.getName() + "님의 계좌에 추가되었습니다.");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("계좌")) {
                    if (args.length == 2) {
                        try {
                            Player target = Bukkit.getPlayer(args[1]);
                            int balance = (int) economy.getBalance(target);
                            player.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.YELLOW + "님의 보유금액은 " + balance + "원 입니다.");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }
}