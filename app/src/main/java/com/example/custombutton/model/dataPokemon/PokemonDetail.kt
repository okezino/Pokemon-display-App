package com.example.custombutton.model.dataPokemon

data class PokemonData(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)

data class Form(
    val name: String,
    val url: String
)

data class GameIndice(
    val game_index: Int,
    val version: Version
)

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)

data class Species(
    val name: String,
    val url: String
)

data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any


)

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatX
)

data class Type(
    val slot: Int,
    val type: TypeX
)

data class AbilityX(
    val name: String,
    val url: String
)

data class Version(
    val name: String,
    val url: String
)

data class MoveX(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class DreamWorld(
    val front_default: String,
    val front_female: Any
)

data class OfficialArtwork(
    val front_default: String
)

data class GenerationI(
    val red_blue: RedBlue,
    val yellow: Yellow
)

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)

data class RedBlue(
    val back_default: String,
    val back_gray: String,
    val front_default: String,
    val front_gray: String
)

data class Yellow(
    val back_default: String,
    val back_gray: String,
    val front_default: String,
    val front_gray: String
)

data class Crystal(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)

data class Gold(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)

data class Silver(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)

data class Emerald(
    val front_default: String,
    val front_shiny: String
)

data class FireredLeafgreen(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)

data class RubySapphire(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)

data class DiamondPearl(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class HeartgoldSoulsilver(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class Platinum(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class BlackWhite(
    val animated: Animated,
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class Animated(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class OmegarubyAlphasapphire(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class XY(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class Icons(
    val front_default: String,
    val front_female: Any
)

data class UltraSunUltraMoon(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)

data class IconsX(
    val front_default: String,
    val front_female: Any
)

data class StatX(
    val name: String,
    val url: String
)

data class TypeX(
    val name: String,
    val url: String
)