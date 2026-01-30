package com.example.myaepp1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myaepp1.ui.home.HomeScreen
import com.example.myaepp1.ui.starter.StarterScreen
import com.example.myaepp1.ui.theory.TheoryScreen
import com.example.myaepp1.ui.theory.menu.TheoryMenuScreen
import com.example.myaepp1.ui.theory.menu.SupplementMenuScreen
import com.example.myaepp1.ui.arrays.ArraysMenuScreen
import com.example.myaepp1.ui.arrays.ArraysTheoryScreen
import com.example.myaepp1.ui.theory.menu.ExtrasMenuScreen
import com.example.myaepp1.ui.truefalse.TrueFalseScreen





@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "starter"
    ) {

        composable("starter") {
            StarterScreen(
                onStartClick = {
                    navController.navigate("home") {
                        popUpTo("starter") { inclusive = true }
                    }
                },
                onCreatorClick = {
                    navController.navigate("from_creator")
                }
            )
        }


        composable("home") {
            HomeScreen(
                onTheoryClick = { navController.navigate("theory_menu") },
                onArraysClick = { navController.navigate("arrays_menu") },
                onCreatorClick = { navController.navigate("from_creator") },
                onTrueFalseClick = { navController.navigate("true_false") }
            )

        }


        composable("arrays_menu") {
            ArraysMenuScreen(
                onItemClick = { index ->
                    navController.navigate("arrays_method/$index")
                },
                onBackClick = { navController.popBackStack() }
            )
        }


        composable("arrays_method/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull()
                ?: return@composable

            ArraysTheoryScreen(
                methodIndex = index,
                onBackClick = { navController.popBackStack() }
            )
        }



        composable("theory_menu") {
            TheoryMenuScreen(
                onChapterClick = { chapterId ->
                    if (chapterId == "supplement") {
                        navController.navigate("supplement_menu")
                    } else {
                        navController.navigate("theory_content/$chapterId")
                    }
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("supplement_menu") {
            SupplementMenuScreen(
                onItemClick = { itemId ->
                    navController.navigate("theory_content/supplement_$itemId")
                },
                onExtrasClick = {
                    navController.navigate("supplement_extras_menu")
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("supplement_extras_menu") {
            ExtrasMenuScreen(
                onExtraClick = { extraId ->

                    navController.navigate("theory_content/supplement_extras_$extraId")
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("from_creator") {
            TheoryScreen(
                title = "Από τον Δημιουργό",
                assetFileName = "from_creator.html",
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("true_false") {
            TrueFalseScreen(
                onExit = { navController.popBackStack() }
            )
        }




        composable("theory_content/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable

            val fileName = when (id) {
                "ch1" -> "chapter1.html"
                "ch2" -> "chapter2.html"
                "ch3_9" -> "chapter3_9.html"
                "ch4" -> "chapter4.html"
                "ch6" -> "chapter6.html"
                "ch10" -> "chapter10.html"
                "ch13" -> "chapter13.html"

                "supplement_data_structures" -> "supplement_data_structures.html"
                "supplement_design_techniques" -> "supplement_design_techniques.html"
                "supplement_modern_envs" -> "supplement_modern_envs.html"
                "supplement_debugging" -> "supplement_debugging.html"

                "supplement_extras_stack" -> "extras_stack.html"
                "supplement_extras_queue" -> "extras_queue.html"
                "supplement_extras_lists" -> "extras_lists.html"
                "supplement_extras_trees" -> "extras_trees.html"
                "supplement_extras_graphs" -> "extras_graphs.html"
                "supplement_extras_select" -> "extras_select.html"
                "supplement_extras_modular" -> "extras_modular.html"
                "supplement_extras_error_categories" -> "extras_error_categories.html"




                else -> "chapter1.html"
            }





            TheoryScreen(
                title = "Θεωρία",
                assetFileName = fileName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
