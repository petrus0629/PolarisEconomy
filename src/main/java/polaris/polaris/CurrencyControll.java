package polaris.polaris;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurrencyControll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("은행"))
            {
                if(args[0].equalsIgnoreCase("잔고"))
                {
                    if(args.length == 3)
                    {
                        try{
                            Player tartget = Bukkit.getPlayer(args[1]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return true;
    }
}