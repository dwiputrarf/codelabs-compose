package com.kodekita.codelabs.ui.view.screen.home

data class HomeViewState(
    val username: String = "",
    val password: String = "",
    val isWrongPasswordExceeded: Boolean = false,
    val isShowLimitWrongPasswordBottomSheet: Boolean = false,
    val isUsernameValid: Boolean = false,
    val isPasswordValid: Boolean = false,
    val isLoginFailed: Boolean = false,
    val availableAt: Long = 0,
    val token: String = "",
//    val resultLogin: ResultState<LoginDataEntity> = ResultState.Idle(),
//    val resultStateFCM: ResultState<ResultEntity> = ResultState.Idle(),
//    val resultSelectedService: ResultState<ServiceEntity> = ResultState.Idle(),
    val message: String = "",
//    val resultGetUserWarehouse: ResultState<PagingEntity<UserWarehouseEntity>> = ResultState.Idle(),
//    val resultLogout: ResultState<String> = ResultState.Idle(),
//    val selectedService: ServiceEntity = ServiceEntity("", "", "", false, "", 0),
    val isOtpEnabled: Boolean = true,
//    val resultLoginOtp: ResultState<LoginOtpEntity> = ResultState.Idle(),
)