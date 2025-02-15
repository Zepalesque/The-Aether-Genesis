package com.aetherteam.aether_genesis.data.generators.tags;

import com.aetherteam.aether.AetherTags;
import com.aetherteam.aether_genesis.Genesis;
import com.aetherteam.aether_genesis.entity.GenesisEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GenesisEntityTagData extends EntityTypeTagsProvider {
    public GenesisEntityTagData(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper helper) {
        super(output, registries, Genesis.MODID, helper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(AetherTags.Entities.DEFLECTABLE_PROJECTILES)
                .addTag(EntityTypeTags.ARROWS)
                .add(
                        GenesisEntityTypes.TEMPEST_THUNDERBALL.get());
        this.tag(AetherTags.Entities.SWETS).add(
                GenesisEntityTypes.DARK_SWET.get()
        );
        this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(
                GenesisEntityTypes.TEMPEST.get()
        );
    }
}
