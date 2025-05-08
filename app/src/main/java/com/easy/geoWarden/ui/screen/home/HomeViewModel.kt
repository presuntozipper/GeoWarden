package com.easy.geoWarden.ui.screen.home


import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class HomeViewModel(application: Application) : AndroidViewModel(application) {

        private val _currentLocation = MutableLiveData<Location?>()
        val currentLocation: LiveData<Location?> = _currentLocation

        private val _locationPermissionGranted = MutableLiveData<Boolean>()
        val locationPermissionGranted: LiveData<Boolean> = _locationPermissionGranted

        private var fusedLocationClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(application)

        private val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult.lastLocation?.let {
                    _currentLocation.value = it
                }
            }
        }

        private fun checkLocationPermissions() {
            _locationPermissionGranted.value = ActivityCompat.checkSelfPermission(
                getApplication(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                getApplication(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        }

        @SuppressLint("MissingPermission") // A permissão é verificada antes de chamar
        fun startLocationUpdates() {
            if (_locationPermissionGranted.value == true) {
                val locationRequest =
                    LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000L) // 10 segundos
                        .setMinUpdateIntervalMillis(5000L) // 5 segundos
                        .build()

                fusedLocationClient.requestLocationUpdates(
                    locationRequest,
                    locationCallback,
                    Looper.getMainLooper()
                )
            }
        }

        fun stopLocationUpdates() {
            fusedLocationClient.removeLocationUpdates(locationCallback)
        }

        // Este método seria chamado pela UI para iniciar o processo
        fun requestCurrentLocation() {
            checkLocationPermissions()
            if (_locationPermissionGranted.value == true) {
                fetchLastLocation() // Tenta obter a última localização conhecida rapidamente
                startLocationUpdates() // Inicia atualizações contínuas se necessário
            } else {
                // A UI deve solicitar a permissão ao usuário
                // Você pode expor um evento para a UI lidar com a solicitação de permissão
            }
        }

        @SuppressLint("MissingPermission")
        private fun fetchLastLocation() {
            if (_locationPermissionGranted.value == true) {
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        _currentLocation.value = location
                    }
                    .addOnFailureListener {
                        // Tratar falha ao obter a última localização
                        _currentLocation.value = null
                    }
            }
        }

        override fun onCleared() {
            super.onCleared()
            stopLocationUpdates() // Garante que as atualizações parem quando o ViewModel for destruído
        }
    }

