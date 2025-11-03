package com.raj.amphibianworld.data

class AmphibianRepository {
    suspend fun getAmphibians(): List<AmphibianModel> {
        return AmphibianApi.apiService.getAmphibians()
    }
}
