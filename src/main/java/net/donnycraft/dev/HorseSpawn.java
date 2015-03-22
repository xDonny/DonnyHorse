package net.donnycraft.dev;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HorseSpawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		else
		{
			sender.sendMessage("You're not a player.");
			return true;
		}
		
		Horse horse = null;
		
		horse = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
		
		horse.setOwner(player);
		horse.setAdult();
		horse.setPassenger(player);
		horse.setAgeLock(true);
		horse.setTamed(true);
		horse.getInventory().addItem(new ItemStack(Material.SADDLE));
		
		if (args.length >= 1)
		{
			horse.setCustomName(args[0]);
			horse.setCustomNameVisible(true);
		}
		
		boolean error = false;
		
		if (args.length >= 2)
		{
			switch(args[1].toLowerCase())
			{
				case "white":
					horse.setColor(Color.WHITE);
					break;
				case "black":
					horse.setColor(Color.BLACK);
					break;
				case "brown":
					horse.setColor(Color.BROWN);
					break;
				case "dark":
					if (args.length >= 3 && args[2].toLowerCase().equals("brown"))
						horse.setColor(Color.DARK_BROWN);
					else
						error = true;
					break;
				case "darkbrown":
					horse.setColor(Color.DARK_BROWN);
					break;
				case "chestnut":
					horse.setColor(Color.CHESTNUT);
					break;
				case "gray":
					horse.setColor(Color.GRAY);
				case "creamy":
					horse.setColor(Color.CREAMY);
					break;
				default:
					error = true;
					break;
			}
		}
		if (error)
		{
			player.sendMessage("Your colour was invalid, choices include:");
			player.sendMessage("White, Black, Brown, Dark Brown, Chestnut, Gray and Creamy");
		}
		else
			player.sendMessage("Horse spawned.");
		
		return true;
	}

}
