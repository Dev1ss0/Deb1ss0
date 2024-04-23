package dev.isxander.debugify.mixins.basic.mc89146;

import dev.isxander.debugify.fixes.BugFix;
import dev.isxander.debugify.fixes.FixCategory;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@BugFix(id = "MC-89146", category = FixCategory.BASIC, env = BugFix.Env.SERVER)
@Mixin(ChunkAccess.class)
public class ChunkAccessMixin {
    @Shadow @Final @Mutable
    protected Map<BlockPos, BlockEntity> blockEntities = new Object2ObjectLinkedOpenHashMap<>();
}
