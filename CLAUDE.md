# Project Configuration Matrix

This document tracks the key dependency versions and known gotchas for the ChaoticSheep mod.

## Version Matrix

| Component | Version | Notes |
|-----------|---------|-------|
| Gradle | 9.0.0 | Configured in `gradle/wrapper/gradle-wrapper.properties` |
| NeoForge | 26.1.2.44-beta | Beta version, configured in `build.gradle` |
| foojay-resolver | 1.0.0 | For Java toolchain resolution |
| JDK | 25 | Minimum requirement, set in `build.gradle` |
| Minecraft | 1.21.1 | Derived from NeoForge version |
| Parchment | 2024.12.01 | For source code mappings |

## Building the Mod

```bash
# Clean build
./gradlew clean build

# Run development client
./gradlew runClient

# Run development server
./gradlew runServer
```

## Known Gotchas

### 1. NeoForge 26.1.2.44-beta is a Beta Version
- Stability may vary
- API changes are possible between beta releases
- If issues arise, check the [NeoForge GitHub](https://github.com/neoforged/NeoForge) for known issues

### 2. JDK 25 Compatibility
- Ensure you have JDK 25 installed: `brew install openjdk@25`
- The project uses Java 25 features if needed
- Gradle wrapper handles downloading the correct version

### 3. Gradle 9.0.0
- Requires Java 11 or higher
- May have breaking changes from previous versions
- If build fails unexpectedly, try: `./gradlew wrapper --gradle-version=9.0.0`

### 4. Parchment Mappings
- These provide human-readable method and field names
- If you get mapping errors, the Parchment version in `build.gradle` may need updating
- Check [Parchment MC](https://parchmentmc.org) for the latest version for 1.21.1

## Updating Dependencies

When bumping any version in the matrix:

1. **Gradle**: Update `gradle/wrapper/gradle-wrapper.properties` and test with `./gradlew --version`
2. **NeoForge**: Update both the plugin version in `settings.gradle` and the dependency in `build.gradle`
3. **Minecraft**: Update the `minecraft { version }` block in `build.gradle`
4. **Parchment**: Check [parchmentmc.org](https://parchmentmc.org) for the latest mappings

Always test after version bumps by running:
```bash
./gradlew clean build
./gradlew runClient
```
