package com.joostmsoftware.startingrevamp.util;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import org.jetbrains.annotations.NotNull;

import static com.joostmsoftware.startingrevamp.StartingRevamp.GROUP;
import static com.joostmsoftware.startingrevamp.block.StartingRevampRocks.ROCK;
import static com.joostmsoftware.startingrevamp.block.StartingRevampTwigs.OAK_TWIG;
import static com.joostmsoftware.startingrevamp.item.StartingRevampToolItems.*;

public class StartingRevampDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(StartingRevampEnglishLangProvider::new);
        fabricDataGenerator.addProvider(StartingRevampModelGenerator::new);
    }

    private static class StartingRevampEnglishLangProvider extends FabricLanguageProvider {

        protected StartingRevampEnglishLangProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator, "en_us");
        }

        @Override
        public void generateTranslations(@NotNull TranslationBuilder translationBuilder) {
            translationBuilder.add(ROCK, "Rock");
            translationBuilder.add(OAK_TWIG, "Oak Twig");
            translationBuilder.add(FLINT_AXE, "Flint Axe");
            translationBuilder.add(FLINT_HOE, "Flint Hoe");
            translationBuilder.add(FLINT_PICKAXE, "Flint Pickaxe");
            translationBuilder.add(FLINT_SHOVEL, "Flint Shovel");
            translationBuilder.add(FLINT_SWORD, "Flint Sword");
            translationBuilder.add(GROUP, "Starting Revamp");
        }
    }

    private static class StartingRevampModelGenerator extends FabricModelProvider {

        public StartingRevampModelGenerator(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(@NotNull BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(ROCK);
            blockStateModelGenerator.registerSimpleCubeAll(OAK_TWIG);
        }

        @Override
        public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(FLINT_AXE, Models.GENERATED);
            itemModelGenerator.register(FLINT_HOE, Models.GENERATED);
            itemModelGenerator.register(FLINT_PICKAXE, Models.GENERATED);
            itemModelGenerator.register(FLINT_SHOVEL, Models.GENERATED);
            itemModelGenerator.register(FLINT_SWORD, Models.GENERATED);
        }
    }
}
