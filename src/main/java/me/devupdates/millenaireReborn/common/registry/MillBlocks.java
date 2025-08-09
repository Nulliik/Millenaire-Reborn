package me.devupdates.millenaireReborn.common.registry;

import me.devupdates.millenaireReborn.MillenaireReborn;
import me.devupdates.millenaireReborn.common.block.BlockRosette;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

/**
 * Registry für alle Millénaire Blocks
 */
public class MillBlocks {
    
    // Blocks werden lazy initialisiert um Registry-Probleme zu vermeiden
    public static Block NORMAN_BRICKS;
    public static Block NORMAN_COBBLESTONE;
    public static Block BYZANTINE_TILES;
    public static Block BYZANTINE_SANDSTONE_ORNAMENT;
    public static Block INDIAN_STONE_ORNAMENT;
    public static Block ROSETTE;
    
    /**
     * Erstellt Block-Settings mit korrekter Registry-Key
     */
    private static AbstractBlock.Settings createSettings(String name) {
        // Registry Key explizit setzen um "Block id not set" zu vermeiden
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, 
            Identifier.of(MillenaireReborn.MOD_ID, name));
            
        return AbstractBlock.Settings.create()
            .registryKey(key)
            .strength(2.0f, 6.0f)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool();
    }
    
    /**
     * Registriert einen Block
     */
    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, 
            Identifier.of(MillenaireReborn.MOD_ID, name), block);
    }
    
    /**
     * Initialisiert die Block-Registry
     */
    public static void init() {
        MillenaireReborn.LOGGER.info("Registering Millénaire blocks...");
        
        // Norman Blocks mit explizitem Registry Key
        NORMAN_BRICKS = register("norman_bricks",
            new Block(createSettings("norman_bricks")));
        
        NORMAN_COBBLESTONE = register("norman_cobblestone",
            new Block(createSettings("norman_cobblestone")));
        
        // Byzantine Blocks
        BYZANTINE_TILES = register("byzantine_tiles",
            new Block(createSettings("byzantine_tiles")));
        
        BYZANTINE_SANDSTONE_ORNAMENT = register("byzantine_sandstone_ornament",
            new Block(createSettings("byzantine_sandstone_ornament")
                .strength(0.8f)));
        
        // Indian Blocks
        INDIAN_STONE_ORNAMENT = register("indian_stone_ornament",
            new Block(createSettings("indian_stone_ornament")));
        
        // Decorative rosette (glass-like)
        ROSETTE = register("rosette",
            new BlockRosette(createSettings("rosette")
                .sounds(BlockSoundGroup.GLASS)
                .strength(0.3f)));
                
        MillenaireReborn.LOGGER.info("Successfully registered {} blocks", 6);
    }
}