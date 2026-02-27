package works.jean.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import works.jean.tools.calendar.MeetingSchedulerTool
import works.jean.tools.email.EmailSenderTool
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import jeanworks.composeapp.generated.resources.Res
import jeanworks.composeapp.generated.resources.calendar_add
import jeanworks.composeapp.generated.resources.mail_out
import jeanworks.composeapp.generated.resources.star_shine

@Composable
fun ToolsScreen(
    repository: ToolsRepository,
) {
    val viewModel: ToolsScreenViewModel =
        viewModel { ToolsScreenViewModel(repository = repository) }
    val tools by viewModel.tools.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Tools",
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(4.dp))

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 220.dp),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                items = tools,
                key = { it.id },
            ) { item ->
                ToolCard(
                    item = item,
                    onEnabledChange = { enabled ->
                        viewModel.onToolEnabledChange(toolId = item.id, enabled = enabled)
                    },
                )
            }
        }
    }
}

@Composable
private fun ToolCard(
    item: ToolItem,
    onEnabledChange: (Boolean) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(iconForName(item.iconResName)),
                contentDescription = item.name,
                tint = MaterialTheme.colorScheme.primary,
            )

            Text(
                modifier = Modifier.weight(1f),
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
            )

            Switch(
                checked = item.enabled,
                onCheckedChange = onEnabledChange,
            )
        }
    }
}

private fun iconForName(name: String): DrawableResource = when (name) {
    MeetingSchedulerTool.TOOL_ITEM.iconResName -> Res.drawable.calendar_add
    EmailSenderTool.TOOL_ITEM.iconResName -> Res.drawable.mail_out
    else -> Res.drawable.star_shine
}
