/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.welshWorldGeneration;

import org.terasology.core.world.generator.facetProviders.*;
import org.terasology.core.world.generator.rasterizers.TreeRasterizer;
import org.terasology.engine.SimpleUri;
import org.terasology.registry.In;
import org.terasology.world.generation.BaseFacetedWorldGenerator;
import org.terasology.world.generation.WorldBuilder;
import org.terasology.world.generator.RegisterWorldGenerator;
import org.terasology.world.generator.plugin.WorldGeneratorPluginLibrary;

@RegisterWorldGenerator(id = "Wales", displayName = "Wales")
public class WalesWorldGenerator extends BaseFacetedWorldGenerator {

    public WalesWorldGenerator(SimpleUri uri) {
        super(uri);
    }

    @In
    private WorldGeneratorPluginLibrary worldGeneratorPluginLibrary;

    @Override
    protected WorldBuilder createWorld() {
        return new WorldBuilder(worldGeneratorPluginLibrary)
                .addProvider(new SeaLevelProvider(0))
                .addProvider(new SurfaceProvider())
                .addProvider(new PerlinHumidityProvider())
                .addProvider(new PerlinSurfaceTemperatureProvider())
                .addProvider(new MountainsProvider())
                 .addProvider(new BiomeProvider())
                .addRasterizer(new WalesWorldRasterizer())
                .addRasterizer(new TreeRasterizer())
                .addProvider(new DefaultTreeProvider())
                .addPlugins();
    }
}
