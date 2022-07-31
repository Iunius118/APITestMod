package com.github.iunius118.apitestmod;

import com.github.iunius118.testapimod.api.TestAPI;
import com.mojang.logging.LogUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(APITestMod.MOD_ID)
public class APITestMod {
    public static final String MOD_ID = "apitestmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public APITestMod() {
        TestAPI.registerMethod(this::testMethod);
    }

    private void testMethod(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        player.sendSystemMessage(Component.literal("Hi, ").append(player.getDisplayName()).append("!").withStyle(ChatFormatting.GOLD));
    }
}
