package works.jean.tools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ToolsScreenViewModel(
    private val repository: ToolsRepository
) : ViewModel() {

    val tools: StateFlow<List<ToolItem>> = repository.toolsFlow()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onToolEnabledChange(toolId: String, enabled: Boolean) {
        viewModelScope.launch {
            repository.setToolEnabled(toolId = toolId, enabled = enabled)
        }
    }
}
