package works.jean.tools

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import works.jean.tools.calendar.MeetingSchedulerTool
import works.jean.tools.email.EmailSenderTool
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
private data class ToolsEnabledMap(
    val enabled: Map<String, Boolean> = emptyMap(),
)

class ToolsRepository(
    private val dataStore: DataStore<Preferences>,
    private val json: Json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    },
) {

    companion object {
        private val ToolsEnabledMapJsonKey = stringPreferencesKey("tools_enabled_map_json")

        private fun defaultTools(): List<ToolItem> = listOf(
            MeetingSchedulerTool.TOOL_ITEM,
            EmailSenderTool.TOOL_ITEM
        )
    }

    fun toolsFlow(): Flow<List<ToolItem>> = enabledMapFlow().map { enabledMap ->
        defaultTools().map { def ->
            ToolItem(
                id = def.id,
                name = def.name,
                iconResName = def.iconResName,
                enabled = enabledMap[def.id] ?: false,
            )
        }
    }

    suspend fun setToolEnabled(toolId: String, enabled: Boolean) {
        dataStore.edit { prefs ->
            val current = decodeEnabledMap(prefs[ToolsEnabledMapJsonKey])
            val updated = current.toMutableMap().apply { put(toolId, enabled) }
            prefs[ToolsEnabledMapJsonKey] = encodeEnabledMap(updated)
        }
    }

    private fun enabledMapFlow(): Flow<Map<String, Boolean>> =
        dataStore.data.map { prefs ->
            decodeEnabledMap(prefs[ToolsEnabledMapJsonKey])
        }

    private fun decodeEnabledMap(raw: String?): Map<String, Boolean> {
        if (raw.isNullOrBlank()) return emptyMap()
        return runCatching { json.decodeFromString<ToolsEnabledMap>(raw).enabled }.getOrElse { emptyMap() }
    }

    private fun encodeEnabledMap(map: Map<String, Boolean>): String =
        json.encodeToString(ToolsEnabledMap(enabled = map))
}

data class ToolItem(
    val id: String,
    val name: String,
    val iconResName: String,
    val enabled: Boolean,
)
