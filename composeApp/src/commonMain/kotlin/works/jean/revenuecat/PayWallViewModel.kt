package works.jean.revenuecat

import androidx.lifecycle.ViewModel
import com.revenuecat.purchases.kmp.Purchases
import com.revenuecat.purchases.kmp.models.Offering
import com.revenuecat.purchases.kmp.models.Package
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

const val COACH_ACCESS_ENTITLEMENT_ID = "Saimon-coach-pro"

sealed interface PayWallUiState {
    data object Loading : PayWallUiState

    data class Loaded(
        val offering: Offering,
    ) : PayWallUiState

    data class Error(
        val message: String,
    ) : PayWallUiState
}

class PayWallViewModel(private val onPaymentSuccess: () -> Unit) : ViewModel() {
    private val _uiState: MutableStateFlow<PayWallUiState> =
        MutableStateFlow(PayWallUiState.Loading)
    val uiState: StateFlow<PayWallUiState> = _uiState.asStateFlow()

    init {
        loadOfferings()
    }

    private fun loadOfferings() {
        _uiState.update { PayWallUiState.Loading }

        Purchases.sharedInstance.getOfferings(
            onError = { error ->
                _uiState.update { PayWallUiState.Error(error.message) }
            },
            onSuccess = { offerings ->
                val current = offerings.current
                _uiState.update {
                    if (current == null) {
                        PayWallUiState.Error("No current offering configured in RevenueCat")
                    } else {
                        PayWallUiState.Loaded(offering = current)
                    }
                }
            },
        )
    }

    fun reloadOfferings() {
        loadOfferings()
    }

    fun purchase(pkg: Package) {
        Purchases.sharedInstance.purchase(
            packageToPurchase = pkg,
            onError = { error, userCancelled ->
                _uiState.update { PayWallUiState.Error(error.message) }
            },
            onSuccess = { storeTransaction, customerInfo ->
                if (customerInfo.entitlements[COACH_ACCESS_ENTITLEMENT_ID]?.isActive == true) {
                    // Unlock that great "pro" content
                    onPaymentSuccess()
                }
            })
    }
}
