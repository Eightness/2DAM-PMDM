package com.albertlozano.listalbert.model

data class Videogame(
    val title: String = "",
    val company: String = "",
    var favorite: Boolean = false,
    var stock: Int = 0
) {
    companion object {
        fun getData() : List<Videogame> {
            return listOf(
                Videogame("Super Mario Bros", "Nintendo", false),
                Videogame("The Legend of Zelda: Breath of the Wild", "Nintendo", false),
                Videogame("Minecraft", "Mojang", false),
                Videogame("Fortnite", "Epic Games", false),
                Videogame("Grand Theft Auto V", "Rockstar Games", false),
                Videogame("FIFA 22", "EA Sports", false),
                Videogame("Overwatch", "Blizzard Entertainment", false),
                Videogame("Cyberpunk 2077", "CD Projekt", false),
                Videogame("Assassin's Creed Valhalla", "Ubisoft", false),
                Videogame("Red Dead Redemption 2", "Rockstar Games", false),
                Videogame("Spider-Man: Miles Morales", "Insomniac Games", false),
                Videogame("God of War", "Santa Monica Studio", false),
                Videogame("The Witcher 3: Wild Hunt", "CD Projekt", false),
                Videogame("League of Legends", "Riot Games", false),
                Videogame("Super Smash Bros. Ultimate", "Nintendo", false),
                Videogame("Persona 5", "Atlus", false),
                Videogame("Destiny 2", "Bungie", false),
                Videogame("Hollow Knight", "Team Cherry", false),
                Videogame("Nier: Automata", "PlatinumGames", false),
                Videogame("Resident Evil Village", "Capcom", false)
            )
        }
    }
}
