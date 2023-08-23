package com.brq.kmm.features.home.domain

import com.brq.kmm.features.home.domain.MovieModel.Companion.DUMB_LIST_POPULAR


data class PopularMoviesModel(
    val page: Int?,
    val results: List<MovieModel>,
    val totalPages: Int?,
    val totalResults: Int?
) {
    companion object {

        val DUMB_RETURN_LIST = PopularMoviesModel(
            page = 1,
            results = DUMB_LIST_POPULAR,
            totalPages = 38029,
            totalResults = 760569
        )
    }
}

data class MovieModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int?>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
) {
    companion object {
        val DUMB_LIST_POPULAR = listOf(
            MovieModel(
                adult = false,
                backdropPath = "/gMJngTNfaqCSCqGD4y8lVMZXKDn.jpg",
                listOf(28, 12, 878),
                640146,
                originalLanguage = "en",
                originalTitle = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                8567.865,
                posterPath = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                releaseDate = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                false,
                6.5,
                1886
            ),
            MovieModel(
                adult = false,
                backdropPath = "/nDxJJyA5giRhXx96q1sWbOUjMBI.jpg",
                listOf(28, 35, 14),
                594767,
                originalLanguage = "en",
                originalTitle = "Shazam! Fury of the Gods",
                overview = "Billy Batson and his foster siblings, who transform into superheroes by saying \\\"Shazam!\\\", are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                4274.865,
                posterPath = "/2VK4d3mqqTc7LVZLnLPeRiPaJ71.jpg",
                releaseDate = "2023-03-15",
                title = "Shazam! Fury of the Gods",
                false,
                6.9,
                1231
            ),
            MovieModel(
                adult = false,
                backdropPath = "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg",
                listOf(878, 12, 28),
                76600,
                originalLanguage = "en",
                originalTitle = "Avatar: The Way of Water",
                overview = "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                3365.865,
                posterPath = "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                releaseDate = "2023-03-15",
                title = "Avatar: The Way of Water",
                false,
                7.7,
                7535
            ),
            MovieModel(
                adult = false,
                backdropPath = "/xwA90BwZXTh8ke3CVsQlj8EOkFr.jpg",
                listOf(
                    28,
                    12,
                    36,
                    18,
                    10752
                ),
                948713,
                originalLanguage = "en",
                originalTitle = "The Last Kingdom: Seven Kings Must Die",
                overview = "In the wake of King Edward's death, Uhtred of Bebbanburg and his comrades adventure across a fractured kingdom in the hopes of uniting England at last.",
                3119.865,
                posterPath = "/7yyFEsuaLGTPul5UkHc5BhXnQ0k.jpg",
                releaseDate = "2023-04-14",
                title = "The Last Kingdom: Seven Kings Must Die",
                false,
                7.4,
                232
            ),
            MovieModel(
                adult = false,
                backdropPath = "/gMJngTNfaqCSCqGD4y8lVMZXKDn.jpg",
                listOf(28, 12, 878),
                123,
                originalLanguage = "en",
                originalTitle = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                8567.865,
                posterPath = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                releaseDate = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                false,
                6.5,
                1886
            ),
            MovieModel(
                adult = false,
                backdropPath = "/nDxJJyA5giRhXx96q1sWbOUjMBI.jpg",
                listOf(28, 35, 14),
                594767,
                originalLanguage = "en",
                originalTitle = "Shazam! Fury of the Gods",
                overview = "Billy Batson and his foster siblings, who transform into superheroes by saying \\\"Shazam!\\\", are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                4274.865,
                posterPath = "/2VK4d3mqqTc7LVZLnLPeRiPaJ71.jpg",
                releaseDate = "2023-03-15",
                title = "Shazam! Fury of the Gods",
                false,
                6.9,
                1231
            ),
            MovieModel(
                adult = false,
                backdropPath = "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg",
                listOf(878, 12, 28),
                76600,
                originalLanguage = "en",
                originalTitle = "Avatar: The Way of Water",
                overview = "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                3365.865,
                posterPath = "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                releaseDate = "2023-03-15",
                title = "Avatar: The Way of Water",
                false,
                7.7,
                7535
            ),
            MovieModel(
                adult = false,
                backdropPath = "/xwA90BwZXTh8ke3CVsQlj8EOkFr.jpg",
                listOf(
                    28,
                    12,
                    36,
                    18,
                    10752
                ),
                948713,
                originalLanguage = "en",
                originalTitle = "The Last Kingdom: Seven Kings Must Die",
                overview = "In the wake of King Edward's death, Uhtred of Bebbanburg and his comrades adventure across a fractured kingdom in the hopes of uniting England at last.",
                3119.865,
                posterPath = "/7yyFEsuaLGTPul5UkHc5BhXnQ0k.jpg",
                releaseDate = "2023-04-14",
                title = "The Last Kingdom: Seven Kings Must Die",
                false,
                7.4,
                232
            ),
            MovieModel(
                adult = false,
                backdropPath = "/gMJngTNfaqCSCqGD4y8lVMZXKDn.jpg",
                listOf(28, 12, 878),
                23333,
                originalLanguage = "en",
                originalTitle = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                8567.865,
                posterPath = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                releaseDate = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                false,
                6.5,
                1886
            ),
            MovieModel(
                adult = false,
                backdropPath = "/nDxJJyA5giRhXx96q1sWbOUjMBI.jpg",
                listOf(28, 35, 14),
                594767,
                originalLanguage = "en",
                originalTitle = "Shazam! Fury of the Gods",
                overview = "Billy Batson and his foster siblings, who transform into superheroes by saying \\\"Shazam!\\\", are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                4274.865,
                posterPath = "/2VK4d3mqqTc7LVZLnLPeRiPaJ71.jpg",
                releaseDate = "2023-03-15",
                title = "Shazam! Fury of the Gods",
                false,
                6.9,
                1231
            ),
            MovieModel(
                adult = false,
                backdropPath = "/ovM06PdF3M8wvKb06i4sjW3xoww.jpg",
                listOf(878, 12, 28),
                76600,
                originalLanguage = "en",
                originalTitle = "Avatar: The Way of Water",
                overview = "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
                3365.865,
                posterPath = "/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
                releaseDate = "2023-03-15",
                title = "Avatar: The Way of Water",
                false,
                7.7,
                7535
            ),
            MovieModel(
                adult = false,
                backdropPath = "/xwA90BwZXTh8ke3CVsQlj8EOkFr.jpg",
                listOf(
                    28,
                    12,
                    36,
                    18,
                    10752
                ),
                948713,
                originalLanguage = "en",
                originalTitle = "The Last Kingdom: Seven Kings Must Die",
                overview = "In the wake of King Edward's death, Uhtred of Bebbanburg and his comrades adventure across a fractured kingdom in the hopes of uniting England at last.",
                3119.865,
                posterPath = "/7yyFEsuaLGTPul5UkHc5BhXnQ0k.jpg",
                releaseDate = "2023-04-14",
                title = "The Last Kingdom: Seven Kings Must Die",
                false,
                7.4,
                232
            ),
        )
    }
}