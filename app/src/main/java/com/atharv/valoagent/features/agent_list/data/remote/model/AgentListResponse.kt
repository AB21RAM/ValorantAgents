package com.atharv.valoagent.features.agent_list.data.remote.model


import com.google.gson.annotations.SerializedName

data class AgentListResponse(
    @SerializedName("status")
    var status: Int?, // 200
    @SerializedName("data")
    var `data`: List<Data?>?
) {
    data class Data(
        @SerializedName("uuid")
        var uuid: String?, // e370fa57-4757-3604-3648-499e1f642d3f
        @SerializedName("displayName")
        var displayName: String?, // Gekko
        @SerializedName("description")
        var description: String?, // Gekko the Angeleno leads a tight-knit crew of calamitous creatures. His buddies bound forward, scattering enemies out of the way, with Gekko chasing them down to regroup and go again.
        @SerializedName("developerName")
        var developerName: String?, // Aggrobot
        @SerializedName("characterTags")
        var characterTags: List<String?>?,
        @SerializedName("displayIcon")
        var displayIcon: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayicon.png
        @SerializedName("displayIconSmall")
        var displayIconSmall: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayiconsmall.png
        @SerializedName("bustPortrait")
        var bustPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("fullPortrait")
        var fullPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("fullPortraitV2")
        var fullPortraitV2: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("killfeedPortrait")
        var killfeedPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/killfeedportrait.png
        @SerializedName("background")
        var background: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/background.png
        @SerializedName("backgroundGradientColors")
        var backgroundGradientColors: List<String?>?,
        @SerializedName("assetPath")
        var assetPath: String?, // ShooterGame/Content/Characters/AggroBot/AggroBot_PrimaryAsset
        @SerializedName("isFullPortraitRightFacing")
        var isFullPortraitRightFacing: Boolean?, // false
        @SerializedName("isPlayableCharacter")
        var isPlayableCharacter: Boolean?, // true
        @SerializedName("isAvailableForTest")
        var isAvailableForTest: Boolean?, // false
        @SerializedName("isBaseContent")
        var isBaseContent: Boolean?, // false
        @SerializedName("role")
        var role: Role?,
        @SerializedName("recruitmentData")
        var recruitmentData: RecruitmentData?,
        @SerializedName("abilities")
        var abilities: List<Ability?>?,
        @SerializedName("voiceLine")
        var voiceLine: Any? // null
    ) {
        data class Role(
            @SerializedName("uuid")
            var uuid: String?, // 1b47567f-8f7b-444b-aae3-b0c634622d10
            @SerializedName("displayName")
            var displayName: String?, // Initiator
            @SerializedName("description")
            var description: String?, // Initiators challenge angles by setting up their team to enter contested ground and push defenders away.
            @SerializedName("displayIcon")
            var displayIcon: String?, // https://media.valorant-api.com/agents/roles/1b47567f-8f7b-444b-aae3-b0c634622d10/displayicon.png
            @SerializedName("assetPath")
            var assetPath: String? // ShooterGame/Content/Characters/_Core/Roles/Breaker_PrimaryDataAsset
        )

        data class RecruitmentData(
            @SerializedName("counterId")
            var counterId: String?, // 7ec37a1e-4526-77dd-1afd-e2ab3b624085
            @SerializedName("milestoneId")
            var milestoneId: String?, // fcca98dc-4a83-2837-9512-f88a0a08fcfd
            @SerializedName("milestoneThreshold")
            var milestoneThreshold: Int?, // 200000
            @SerializedName("useLevelVpCostOverride")
            var useLevelVpCostOverride: Boolean?, // false
            @SerializedName("levelVpCostOverride")
            var levelVpCostOverride: Int?, // 0
            @SerializedName("startDate")
            var startDate: String?, // 2023-06-27T00:00:00Z
            @SerializedName("endDate")
            var endDate: String? // 2023-07-25T21:00:00Z
        )

        data class Ability(
            @SerializedName("slot")
            var slot: String?, // Ability1
            @SerializedName("displayName")
            var displayName: String?, // Wingman
            @SerializedName("description")
            var description: String?, // EQUIP Wingman. FIRE to send Wingman forward seeking enemies. Wingman unleashes a concussive blast toward the first enemy he sees. ALT FIRE when targeting a Spike site or planted Spike to have Wingman defuse or plant the Spike. To plant, Gekko must have the Spike in his inventory. When Wingman expires he reverts into a dormant globule. INTERACT to reclaim the globule and gain another Wingman charge after a short cooldown.
            @SerializedName("displayIcon")
            var displayIcon: String? // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/abilities/ability1/displayicon.png
        )
    }
}