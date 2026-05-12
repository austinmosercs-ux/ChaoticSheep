# ChaoticSheep

A Minecraft mod that adds chaos to your world! When you kill a sheep, there's a **1% chance** that a wither will spawn.

## Requirements

- **JDK 25** or later (installed via `brew install openjdk@25` on macOS)
- **Gradle 9.0.0** (automatically managed by gradle wrapper)
- **NeoForge 26.1.2.44-beta**

## Building

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd ChaoticSheep
   ```

2. Build the mod:
   ```bash
   ./gradlew build
   ```

3. The built JAR will be located in `build/libs/`

## Running in Development

1. Run the Minecraft development server:
   ```bash
   ./gradlew runServer
   ```

2. Run the Minecraft development client:
   ```bash
   ./gradlew runClient
   ```

## Installation

Copy the built JAR from `build/libs/` into your Minecraft mods folder (usually `~/.minecraft/mods/`).

## How It Works

- When a sheep dies in the world, the mod checks if it should spawn a wither
- There's a 1% chance (`0.01f`) that the wither will spawn
- The wither spawns 3 blocks above the sheep's death location
- The wither will then proceed to cause chaos as withers do!

## Mod Details

- **Mod ID**: `chaoticsheep`
- **Version**: 1.0.0
- **Minecraft Version**: 1.21.1
- **NeoForge Version**: 26.1.2.44-beta