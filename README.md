# Arcane Repository

Arcane Repository is a Fabric magic mod that adds a plethora of new useful magical items to the game. The main concept behind the mod is to encourage exploration by generating Artifacts and Relics of varying usefulness in preexisting structures.

Artifacts are non-wearable items with active effects that can be used by the player (like a sword), while Relics provide passive effects and can be equipped in their appropriate slot.

These items come in a few types: Petty, Lesser, Greater, Grand and Cursed, with the last being the strongest, but also adding penalties for using them.

The crafting system uses Gems, which are found in their respective ores across the dimensions. Each gem has an attribute assigned to it.

### Feedback
This mod is WIP! I will be always accepting feedback with ideas and suggestions to improve it. Post an issue with either [Feature] in the title.

### FAQ
* Q: Can you port this to X modloader:
* A: No, but anyone else can. Just submit a PR and I'll review it.
####
* Q: When are you updating to X version?
* A: When Trinkets supports it and I have the time.
####
* Q: Can you backport this to X version?
* A: No, but anyone else can. Just submit a PR and I'll review it.
####
* Q: Can I add this to a modpack?
* A: Yes, feel free to. However, I ask that you set it up for the mod to be downloaded from the Curseforge or Modrinth ecosystems, instead of providing a JAR file directly.
####

### More Info
Arcane Repository can be used with [PolyMC](https://theepicblock.github.io/PolyMc/) and [Polymer Auto Host](https://polymer.pb4.eu/latest/user/resource-pack-hosting/) a server-side mod. I'd also recommend [Polydex](https://modrinth.com/mod/polydex) and [PolydexBridge](https://modrinth.com/mod/polydex-bridge) + [EMI](https://modrinth.com/mod/emi) for extra peace of mind. These mods are **not** dependencies!

Textures are WIP. If you have a better one that's licensed under MIT, feel free to submit a pull request! The textures are stitched together using the Gradle task generateTextures. Check the folder "base" inside assets/textures (and the class TextureStitcher) to learn how it works. If you want to contribute, it saves you the pain of having to manually create hundreds of textures.

### Planned Features
1. [ ] Per-kind modifiers in relics
2. [ ] Rare unique relics
3. [ ] Ore texture rework
4. [ ] Balancing
5. [ ] Masks are displayed on the player
6. [ ] Proper crafting system

### Acknowledgment
Some ore textures were generated using [SamIsPoggers' TextureGenerator](https://github.com/SamIsPoggers/TextureGenerator)