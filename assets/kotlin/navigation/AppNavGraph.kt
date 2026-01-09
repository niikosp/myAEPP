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
                }
            )
        }

        composable("home") {
            HomeScreen(
                onTheoryClick = {
                    navController.navigate("theory_menu")
                },
                onArraysClick = {
                    navController.navigate("arrays_menu")
                }
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
                onBackClick = { navController.popBackStack() }
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

                else -> "chapter1.html"
            }



            TheoryScreen(
                assetFileName = fileName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

