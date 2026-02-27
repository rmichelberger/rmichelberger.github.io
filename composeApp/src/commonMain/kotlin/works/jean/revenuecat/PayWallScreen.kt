package works.jean.revenuecat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.revenuecat.purchases.kmp.models.Package

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayWallScreen(
    onPaymentSuccess: () -> Unit,
    viewModel: PayWallViewModel = viewModel { PayWallViewModel(onPaymentSuccess = onPaymentSuccess) },
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "To use this coach, you need to purchase Pro subscription.",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            text = "Choose a plan",
            style = MaterialTheme.typography.titleLarge,
        )

        when (val state = uiState) {
            PayWallUiState.Loading -> {
                CircularProgressIndicator()
            }

            is PayWallUiState.Error -> {
                Text(
                    text = state.message,
                    color = MaterialTheme.colorScheme.error,
                )

                Button(onClick = viewModel::reloadOfferings){
                    Text(text = "Retry")
                }
            }

            is PayWallUiState.Loaded -> Payments(
                packages = state.offering.availablePackages,
                onBuyClick = { viewModel.purchase(it) })

        }
    }
}

@Composable
private fun Payments(
    packages: List<Package>, onBuyClick: (Package) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(packages) { pkg ->
            PackageCard(
                pkg = pkg,
                onBuyClick = { onBuyClick(pkg) },
            )
        }
    }
}

@Composable
private fun PackageCard(
    pkg: Package,
    onBuyClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = pkg.storeProduct.title,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = pkg.storeProduct.price.formatted,
                style = MaterialTheme.typography.bodyMedium,
            )
            Button(onClick = onBuyClick) {
                Text("Buy")
            }
        }
    }
}
