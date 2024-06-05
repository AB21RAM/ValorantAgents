
import com.atharv.valoagent.features.agent_list.remote.api.ApiService
import com.atharv.valoagent.features.agent_list.remote.model.AgentListResponse
import com.atharv.valoagent.features.agent_list.domain.repository.AgentRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class AgentRemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService
)  : AgentRemoteRepository {
    override suspend fun getAgentList(): Response<AgentListResponse> {
        return apiService.getAgentList()
    }
}