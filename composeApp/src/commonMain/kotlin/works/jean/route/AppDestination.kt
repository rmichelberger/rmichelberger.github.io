package works.jean.route

import jeanworks.composeapp.generated.resources.Res
import jeanworks.composeapp.generated.resources.coach
import jeanworks.composeapp.generated.resources.profile
import jeanworks.composeapp.generated.resources.tools
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

sealed class AppDestination(
    val route: String,
    val label: String,
    val icon: DrawableResource,
) {
    data object Coaches : AppDestination(
        route = "coaches",
        label = "Coaches",
        icon = Res.drawable.coach
    )

    data object Tools : AppDestination(
        route = "tools",
        label = "Tools",
        icon = Res.drawable.tools
    )

    data object Profile : AppDestination(
        route = "profile",
        label = "Profile",
        icon = Res.drawable.profile
    )
}

@Serializable
data class CoachRoute(val coachName: String)