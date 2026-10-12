package qouteall.q_misc_util.my_util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.slf4j.Logger;
import java.util.function.Consumer;
import org.slf4j.LoggerFactory;

/**
 * Minecraft 26.x serializes entities/block entities through {@link ValueInput}/{@link ValueOutput}
 * instead of raw {@link CompoundTag}. Immersive Portals still has a lot of code written against
 * {@link CompoundTag} (and exposes it in its API), so this bridges the two.
 * <p>
 * Vanilla's NBT storage always uses {@link TagValueInput}/{@link TagValueOutput}, which wrap a compound tag.
 */
public class ValueIoBridge {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValueIoBridge.class);

    /**
     * Get the compound tag backing the input. Don't modify the returned tag.
     */
    public static CompoundTag getTag(ValueInput input) {
        if (input instanceof TagValueInput tagValueInput) {
            return tagValueInput.input;
        }
        LOGGER.error("Unsupported ValueInput type {}", input.getClass().getName(), new Throwable());
        return new CompoundTag();
    }

    /**
     * Get the compound tag that the output writes into. Writing into the returned tag writes into the output.
     */
    public static CompoundTag getTag(ValueOutput output) {
        if (output instanceof TagValueOutput tagValueOutput) {
            return tagValueOutput.buildResult();
        }
        LOGGER.error("Unsupported ValueOutput type {}", output.getClass().getName(), new Throwable());
        return new CompoundTag();
    }

    /**
     * Serialize the entity (without id) into a new compound tag.
     * Replacement of the removed {@code Entity.saveWithoutId(CompoundTag)}.
     */
    public static CompoundTag saveEntity(Entity entity) {
        TagValueOutput output = TagValueOutput.createWithContext(
            ProblemReporter.DISCARDING, entity.registryAccess()
        );
        entity.saveWithoutId(output);
        return output.buildResult();
    }

    /**
     * Load the entity from the compound tag.
     * Replacement of the removed {@code Entity.load(CompoundTag)}.
     */
    public static void loadEntity(Entity entity, CompoundTag tag) {
        ValueInput input = TagValueInput.create(
            ProblemReporter.DISCARDING, entity.registryAccess(), tag
        );
        entity.load(input);
    }

    /**
     * Run the (virtual) additional-save-data writer and collect the result as a compound tag.
     */
    public static CompoundTag writeAdditional(Entity entity, Consumer<ValueOutput> writer) {
        TagValueOutput output = TagValueOutput.createWithContext(
            ProblemReporter.DISCARDING, entity.registryAccess()
        );
        writer.accept(output);
        return output.buildResult();
    }
    
    /**
     * Run the (virtual) additional-save-data reader on a compound tag.
     */
    public static void readAdditional(Entity entity, CompoundTag tag, Consumer<ValueInput> reader) {
        ValueInput input = TagValueInput.create(
            ProblemReporter.DISCARDING, entity.registryAccess(), tag
        );
        reader.accept(input);
    }
}