package edu.ucne.proyectofinalaplicada2.presentation.pagos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.proyectofinalaplicada2.data.remote.Resource
import edu.ucne.proyectofinalaplicada2.data.remote.dto.PagosDTO
import edu.ucne.proyectofinalaplicada2.data.repository.PagosRepository
import edu.ucne.proyectofinalaplicada2.data.repository.TarjetaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class PagosViewModel @Inject constructor(
    private val repository: PagosRepository,
    private val tarjetarepository: TarjetaRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(PagosUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadTarjetas()
    }

    private fun loadTarjetas() {
        viewModelScope.launch {
            tarjetarepository.getTarjetas().collect { result ->
                when (result) {
                    is Resource.Loading -> _uiState.update { it.copy(isLoading = true) }
                    is Resource.Success -> _uiState.update {
                        it.copy(
                            isLoading = false
                        )
                    }

                    is Resource.Error -> _uiState.update {
                        it.copy(
                            errorMessge = result.message ?: "Error al cargar tarjetas",
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun onUiEvent(event: PagosUIEvent){
        when(event){
            PagosUIEvent.Save -> saveTarjeta()
            is PagosUIEvent.IsRefreshingChanged ->  {
                _uiState.update {
                    it.copy(isRefreshing = event.isRefreshing)
                }
            }
            PagosUIEvent.Refresh -> loadTarjetas()
        }
    }

    private fun saveTarjeta(){
        viewModelScope.launch {
            if(_uiState.value.id == null) {
                _uiState.value.toEntity()?.let { repository.addPago(it) }
            }

        }
    }

    fun PagosUiState.toEntity() = id?.let {
        PagosDTO(
        pagoId = it,
        pedidoId = pedidoId,
        tarjetaId = tarjetaId,
        fechaPago = fechaPago,
        monto = monto
    )
    }
}