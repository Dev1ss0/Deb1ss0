package dev.isxander.debugify.test.suites;

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;

public class MC93018 implements FabricGameTest {

    @GameTest(template = EMPTY_STRUCTURE)
    public void mc93018(GameTestHelper ctx) {
        Player player = ctx.makeMockPlayer(GameType.SURVIVAL);
        player.setItemInHand(InteractionHand.MAIN_HAND, Items.BONE.getDefaultInstance());
        ctx.getLevel().addFreshEntity(player);

        Wolf wolf = ctx.spawn(EntityType.WOLF, 2, 0, 0);
        wolf.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0);

        wolf.mobInteract(player, InteractionHand.MAIN_HAND);
        ctx.succeedIf(() -> ctx.assertTrue(wolf.getInLoveTime() <= 0, "Wolf shouldn't love player"));
    }


}
