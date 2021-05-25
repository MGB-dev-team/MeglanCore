package net.meglandevs.meglancore;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.meglandevs.meglancore.Commands.*;
import net.meglandevs.meglancore.Listeners.*;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

import static net.meglandevs.meglancore.Utils.chat;

public final class Main extends JavaPlugin {

    public static String prefix = "&b&lMEGLA&3&lNSMP";


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(chat("&aPlugin Enabled"));
        getCommand("heal").setExecutor(new Heal());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("socialspy").setExecutor(new SocialSpy());
        getCommand("gamemode").setExecutor(new gamemode());
        getCommand("feed").setExecutor(new Feed());
        getCommand("god").setExecutor(new GodMode());
        getCommand("freeze").setExecutor(new freeze());
        getCommand("staffchat").setExecutor(new staffchat());
        getCommand("spawn").setExecutor(new spawn());
        getCommand("setspawn").setExecutor(new setSpawn());
        getCommand("tp").setExecutor(new tp());
        getCommand("tphere").setExecutor(new tphere());
        getCommand("fly").setExecutor(new Fly());

        getServer().getPluginManager().registerEvents(new ItemDropEvent(), this);
        getServer().getPluginManager().registerEvents(new pickUpEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        getServer().getPluginManager().registerEvents(new damageEvent(), this);
        getServer().getPluginManager().registerEvents(new HungerChange(), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new onChat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private MongoClient mongoClient;
    public MongoDatabase mongoDatabase;
    public MongoCollection<Document> serverCollection;

    public void connect() {
        MongoCredential credential = MongoCredential.createCredential("admin","MeglanSMP","aP@55word".toCharArray());
        mongoClient = new MongoClient(new ServerAddress("mongodb://admin:aP%4055word@144.91.112.9:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&ssl=false", 27017), Collections.singletonList(credential));
        mongoDatabase = mongoClient.getDatabase("MeglanSMP");
        serverCollection = mongoDatabase.getCollection("MeglanSMP");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Connected to MongoDB!");
    }
}
